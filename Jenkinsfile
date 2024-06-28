node {
    // some block
    git branch: env.BRANCH_NAME, url: 'git@github.com:SpotMe-Mondayvile/spotme.git'

sh '''
cd spotme-web
npm install
npm run build
tar -czvf spotme-web-archive.tar.gz build
cd ..'''

sh '''
cd spotme-rest
mvn package -ntp -Dmaven.test.skip
'''

def projectVersion = sh script: "mvn -q -Dexec.executable=echo -Dexec.args='\${project.version}' --non-recursive exec:exec", returnStdout: true

sh'''cd ..'''
archiveArtifacts artifacts: 'spotme-web/spotme-web-archive.tar.gz*', followSymlinks: false
archiveArtifacts artifacts: "spotme-rest/target/spotme-rest-${projectVersion}.jar", followSymlinks: false

// sh '''docker image ls'''
}
