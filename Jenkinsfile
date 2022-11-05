pipeline {
    agent any

    stages {
        stage('Testing maven') {
            steps {
                sh "mvn -version"
            }
        }

      
	
	stage('MVN CLEAN INSTALL') {
            steps {
                sh 'mvn clean install'
                 
            }
        }

        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
                 
            }
        }


        stage('Testing from git') {
            steps {
                sh "git --version"
            }
        }
    }
}
