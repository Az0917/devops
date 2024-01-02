package org.devops
def call(){
  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub'){
    docker.image("daz2023/nodejsapp:latest").push()
  }
}
