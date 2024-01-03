package org.devops
def call (){
      withEnv(["user=daz2023","repoName=nodejsapp","BUILD_ID=latest"]) {   
            sh 'echo USER'
            sh 'docker compose up -d'
    }
}
