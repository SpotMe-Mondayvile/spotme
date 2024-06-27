node {
    // some block
    git branch: '${BRANCH}', url: 'git@github.com:SpotMe-Mondayvile/spotme.git'

sh '''
cd spotme-web
npm install
npm run build
tar -czvf spotme-web-archive.tar.gz build
cd ..'''
def projectVersion = sh script: "gradle getVersion()", returnStdout: true
archiveArtifacts artifacts: 'spotme-web/spotme-web-archive.tar.gz*', followSymlinks: false
archiveArtifacts artifacts: "spotme-rest/build/libs/spotme-rest-$projectVersion.jar", followSymlinks: false

// sh '''docker image ls'''
}
