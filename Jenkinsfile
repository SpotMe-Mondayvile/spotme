def s_branch = env.BRANCH_NAME as String
s_branch = s_branch.replaceAll("/","_")

pipeline {
    agent any
    stages{
        stage("Clean Up"){
            steps{
                deleteDir()
                script{sh """ docker image prune -a"""}
            }
        }
        stage("Clone repo"){
            steps{
                checkout scm
            }
        }
        stage("Load Environment"){
           steps{
            dir("spotme-rest"){
               sh ''' cp $JENKINS_HOME/env_files/spotme_rest_env .env '''
               sh ''' cp $JENKINS_HOME/app_properties/spotme_rest_app_props ./src/main/resources/application.properties '''
             }
            dir("spotme-web"){

            }
           }
        }
        stage("Build"){
            steps{
               dir("spotme-rest/"){
                sh ''' mvn clean install -ntp -Dmaven.test.skip '''
               }
               dir("spotme-web/"){
                sh '''
                npm install
                npm install @ionic/cli
                npm install axios
                ionic build
                tar -czvf spotme-web-archive.tar.gz dist
                '''
               }
            }
        }
        stage("Test"){
            steps{
               dir("spotme-rest/"){
                sh ''' echo "Fake Test" '''
               }
               dir("spotme-web/"){
               sh ''' echo "Fake Test" '''
              }
            }
        }
        stage("Store Artifacts"){
            steps{
               archiveArtifacts artifacts: 'spotme-web/spotme-web-archive.tar.gz*', followSymlinks: false
               archiveArtifacts artifacts: 'spotme-rest/target/*.jar', followSymlinks: false
            }
        }
        stage("Build Container Images"){
            steps(){
                dir("spotme-rest/"){
                sh """ docker build -t spotme-rest:${s_branch} . """
                }
                dir("spotme-web/"){
                sh """ docker build -t spotme-web:${s_branch} . """
                }
            }
        }
        stage("Deploy") {
            steps {
                script{
                    if(env.BRANCH_NAME=="develop"){
                        dir("spotme-web/") {
                            script {
                                try {
                                    sh """docker run -p 3000:3000 -p 5000:50000 -d spotme-web:${s_branch}"""
                                } catch (e) {
                                    println e
                                    sh '''echo "Was not able to start web service, might be running already"'''
                                }
                            }
                        }
                        dir("spotme-rest/") {
                            script{
                                try {
                                    sh """docker run -p 8080:8080 -p 3001:3000 -p 50001:50000 -d spotme-rest:${s_branch}"""
                                } catch (e) {
                                    println e
                                    sh '''echo "Was not able to start rest service, might be running already"'''
                                }
                            }
                        }
                    }
            }

            }

        }


    }
}

// node {
//     // some block
//     git branch: env.BRANCH_NAME, url: 'git@github.com:SpotMe-Mondayvile/spotme.git'
//
// sh '''
// cd spotme-web
// npm install
// npm install -g serve
// npm run build
// tar -czvf spotme-web-archive.tar.gz build
// serve -s build
// cd ..'''
//
// sh '''
// cd spotme-rest
// mvn package -ntp -Dmaven.test.skip
// '''
//
// def projectVersion = sh script: "cd spotme-rest && mvn -q -Dexec.executable=echo -Dexec.args='\${project.version}' --non-recursive exec:exec", returnStdout: true
//
// sh'''cd ..'''
// archiveArtifacts artifacts: 'spotme-web/spotme-web-archive.tar.gz*', followSymlinks: false
// archiveArtifacts artifacts: 'spotme-rest/target/*.jar', followSymlinks: false
//
// // sh '''docker image ls'''
// }
