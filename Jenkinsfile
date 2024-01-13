node {
    // some block
    git branch: 'develop', url: 'https://github.com/SpotMe-Mondayvile/spotme.git'

sh '''
cd spotme-web
npm install
npm run build
tar -czvf meact-archive.tar.gz build
cd ..'''

archiveArtifacts artifacts: 'spotme-web/spotme-web-archive.tar.gz*', followSymlinks: false
archiveArtifacts artifacts: 'spotme-rest/build/libs/spotme-rest-*-SNAPSHOT.jar', followSymlinks: false

// sh '''docker image ls'''
}
