package org.devops
def buildDockerImage(){
    def dockerImage = docker.build("daz2023/nodeJSApp")
}
