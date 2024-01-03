package org.devops
def call (){
  withEnv(["USER=daz2023","REPO=nodejsapp","BUILD_ID=latest"]){
    sh 'docker compose up -d'
  }
}

