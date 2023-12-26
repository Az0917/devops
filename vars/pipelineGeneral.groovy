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
        }
    }
    
}
