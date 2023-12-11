def call(){
    pipeline{

        agent any

        stages{
            stage('Test'){
                steps{
                    sh 'echo prueba'
                }
            }
        }
    }
    
}