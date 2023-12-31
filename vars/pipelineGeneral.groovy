def call(Map param){
    pipeline{

        agent any

        tools{
            nodejs 'NodeJS'
        }
        stages{

            stage('Clean Workspace'){
                steps{
                    script{
                        def clean = new org.devops.lbClean()
                        clean.clean()
                    }
                }
            }

            stage('Checkout'){
                steps{
                    script{
                        def repo = new org.devops.lbBuild()
                        repo.checkGit(scmUrl:param.scmUrl)
                        repo.install()
                        repo.build()
                    }
                }
            }
            stage('Test NodeJSApp'){
                steps{
                    script{
                        def repo = new org.devops.lbBuild()
                        repo.test()
                    }
                }
            }
            stage('Sonar'){
                steps{
                    script{
                        def ana = new org.devops.lbSonar()
                        ana.analisisSonar()
                    }
                }
            }
            stage('Develop stages'){
                when{
                    expression{
                        return env.GIT_BRANCH == 'origin/develop'
                    }
                    }
                stages{
                    stage('Build Docker Image'){
                        steps{
                            script{
                                def dockerImage = new org.devops.lb_buildimagen()
                                dockerImage()
                            }
                        }
                    }
                    stage('Publish Docker Image'){
                        steps{
                            script{
                                def publishImage = new org.devops.lb_publicardockerhub()
                                publishImage()
                            }
                        }
                    }
                    stage('Deploy nodeJsApp'){
                        steps{
                            script{
                                def deployImage = new org.devops.lb_deploydocker()
                                deployImage()
                            }
                        }
                    }
                }
            }
        }
    }
}
