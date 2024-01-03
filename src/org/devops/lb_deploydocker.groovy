package org.devops
def call (){
      withEnv(["user=daz2023","repoName=nedejsapp","BUILD_ID=latest"]) {
        sh 'docker compose up -d'
    }
}
