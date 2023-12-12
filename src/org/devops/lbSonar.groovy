package org.devops

def analisisSonar(){
    def scannerHome = tool 'sonnar'
    withSonarQubeEnv('sonnar') {
        sh "${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=NodeJSApp \
            -Dsonar.projectName=NodeJSApp \
            -Dsonar.sources=./ \
            -Dsonar.javascript.lcov.reportPaths=./coverage/locov.info "
    }
}