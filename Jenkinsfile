pipeline {
    agent any
    stages{
            stage('Checkout GIT'){
                steps {
                    echo 'Pulling...';
                        git branch: 'fourat',
                        url : 'https://github.com/eskander1998/ProjetDevops.git';
                }
            }
           
        
           
            
            }
            
            stage('Test unitaire') {
            steps {
                    sh "mvn test"
            }
            }
           
            
    }
       
    }
