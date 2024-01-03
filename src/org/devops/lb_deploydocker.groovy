package org.devops
def call (){
    def repoName = 'nodejsapp'
    def user = 'daz2023'
    withEnv(["USER=${user}","REPO=${repoName}","BUILD_ID=${env.BUILD_ID}"]) {
        sh 'docker-compose up -d'
    }
}
