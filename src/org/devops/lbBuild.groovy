package org.devops
def checkGit(Map param){
    git branch:'develop', url: "${param.scmUrl}"
}

def install(){
    sh "npm install"
}
def build (){
    sh "npm run build"
}
def test(){
    sh "npm test"
}
