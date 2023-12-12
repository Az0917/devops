def call(Map param){
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