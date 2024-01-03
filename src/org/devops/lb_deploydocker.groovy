package org.devops
def call (){
      withEnv(["repoName=daz2023","BUILD_ID=latest"]) {
        sh 'docker-compose up -d'
    }
}
