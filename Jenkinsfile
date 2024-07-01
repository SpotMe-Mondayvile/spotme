pipeline {
    agent any
    stages{
        stage("Clean Up"){
            steps{
                deleteDir()
            }
        }
        stage("Clone repo"){
            steps{
                git branch: env.BRANCH_NAME, url: 'git@github.com:SpotMe-Mondayvile/spotme.git'
            }
        }
        stage("Build"){
            steps{
               dir("spotme-rest/"){
                sh ''' mvn package -ntp -Dmaven.test.skip '''
               }
               dir("spotme-web/"){
                sh '''
                npm install
                npm install -g serve
                npm run build
                tar -czvf spotme-web-archive.tar.gz build
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
        stage("Deploy"){
            steps{
              dir("spotme-web/"){
                   sh ''' serve -s build'''
                  }
               dir("spotme-rest/"){
                sh ''' java -jar target/spotme-rest-0.0.1-SNAPSHOT.jar '''
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
