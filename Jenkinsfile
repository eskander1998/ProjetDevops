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
            
            
            
            
            

            
              
            
            stage('Package') {
            steps {
                sh 'mvn -DskipTests clean package' 
            }
            }
        
        
		    stage('Publish to Nexus Repository Manager') {
            steps {
                script {
					nexusArtifactUploader artifacts: [[artifactId: 'ProjetDevops', classifier: '', file: 'target/ProjetDevops-1.0.jar', type: 'jar']], credentialsId: 'NEXUS_CRED', groupId: 'com.esprit.examen', nexusUrl: '192.168.1.110:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '1.0.0-SNAPSHOT'
				}
            }
           
            
            }
            
            stage('test') {
            steps {
                    sh " mvn test"
            }
            }
           
            
    }
       
    }
