package org.devops
def call(){
    def dockerImage = docker.build("daz2023/nodeJSApp")
}
