node {
    // some block
    git branch: env.BRANCH_NAME, url: 'git@github.com:SpotMe-Mondayvile/spotme.git'

sh '''
cd spotme-web
npm install
npm run build
tar -czvf spotme-web-archive.tar.gz build
cd ..'''

def projectVersion = sh script: """grep -oPm1 "(?<=<version>)[^<]+" "spotme-rest/pom.xml""", returnStdout: true
archiveArtifacts artifacts: 'spotme-web/spotme-web-archive.tar.gz*', followSymlinks: false
archiveArtifacts artifacts: "spotme-rest/build/libs/spotme-rest-$projectVersion.jar", followSymlinks: false

// sh '''docker image ls'''
}
