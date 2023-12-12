package org.devops
def checkGit(Map param){
    git branch: "feature", url: "${param.scmUrl}"
}

def install(){
    sh "npm install"
}
def build (){
    sh "npm run build"
}