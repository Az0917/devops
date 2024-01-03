package org.devops
def call (){
  {
    script{
      sh 'docker compose up -d'
    }
  }
}
