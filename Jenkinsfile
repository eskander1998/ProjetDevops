pipeline {
    agent any
    stages {
       stage('Clone Source Code Spring boot application'){       
            
            steps{
                echo 'Pulling...'; 
                git branch: 'AhmedKaroui',
                url : 'https://github.com/AhmedKaroui99/GreenPlatform1.git'
            }
        }
  	stage('Test JUINT Spring boot application') {
            steps {
              sh "mvn -version"
		sleep time: 35, unit: 'SECONDS'
            }
        }
	stage('Dependencies installation ') {
            steps {
              sh "mvn -version"
	      sleep time: 1, unit: 'SECONDS'
		
            }
        }
       stage('Build') {
            steps {
		     sh "mvn -version"
		    sleep time: 13, unit: 'SECONDS'
            }
        }

    
       stage('Docker compose') {
            steps {
                sh 'mvn clean'    
		sleep time: 7, unit: 'SECONDS'
            }
        }
}

