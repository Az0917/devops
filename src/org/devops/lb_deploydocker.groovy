package org.devops
def call (){
  withEnv(["USER=daz2023","REPONAME=nodejsapp","BUILD_ID=latest"]){
    sh 'docker compose up -d'
  }
}

