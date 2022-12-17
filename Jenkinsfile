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
           
            stage('Testing maven') {
            steps {
                sh """mvn -version"""
                 
            }
            }
            
            stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                 
            }
            }
            stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
                 
            }
            }
			
			stage('SonarQube analysis 1') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=fourat'
            }
            }
       	  
		
            
                      
       		stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
                  
            }
        	}
            
           
            
            stage('Build image') {
           	steps {
       		 sh "docker build -t fourat8/projetdevops-backend ."
       		}
       		}
    		
 			stage('Push image') {
 			steps {
 			           	 withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	 sh "docker push fourat8/projetdevops-backend"
        	}
        	}
        	}
        	
        	
        	stage('Docker compose') {
            steps {
                sh 'docker-compose up -d' 
            }
            }
            
       	    stage('Test unitaire') {
            steps {
                    sh 'mvn --batch-mode test'
            }
            }
       	    
        
        	
    		
    		
    		 
           
            
    }
       
    }