node {
    // some block
    git branch: env.BRANCH_NAME, url: 'git@github.com:SpotMe-Mondayvile/spotme.git'

sh '''
cd spotme-web
npm install
npm run build
tar -czvf spotme-web-archive.tar.gz build
cd ..'''

def projectVersion = sh script: "mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate \
                                 -Dexpression=project.version -q -DforceStdout", returnStdout: true
archiveArtifacts artifacts: 'spotme-web/spotme-web-archive.tar.gz*', followSymlinks: false
archiveArtifacts artifacts: "spotme-rest/build/libs/spotme-rest-$projectVersion.jar", followSymlinks: false

// sh '''docker image ls'''
}
