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
            stage('Docker compose') {
            steps {
                sh 'docker-compose up -d' 
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

		 stage('Test unitaire') {
            steps {
                    sh 'mvn test'
            }
            }
            
            
            
            
            
            stage('SonarQube analysis 1') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=fourat'
            }
            }
            
              
            
            stage('Package') {
            steps {
                sh 'mvn -DskipTests clean package' 
            }
            }
            
            
        
        
		    stage('Publish to Nexus Repository Manager') {
            steps {
                script {
					nexusArtifactUploader artifacts: [[artifactId: 'ProjetDevops', classifier: '', file: 'target/ProjetDevops-1.0.jar', type: 'jar']], credentialsId: 'NEXUS_CRED', groupId: 'com.esprit.examen', nexusUrl: '192.168.1.135:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '1.0.0-SNAPSHOT'
				}
            }
           		
            }
            
           	stage('Build image') {
           	steps {
       		 sh "docker build -t fourat8/image ."
       		}
       		}
    		
 			stage('Push image') {
 			steps {
 			           	 withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	 sh "docker push fourat8/image"
        	}
        	}
        	}
        	stage('Cleaning up') {
 			steps {
 			           	 withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
 			
        	 sh "docker rmi -f fourat8/image"
        	}
        	}
        	}
    		 
    		 
           
            
    }
       
    }