pipeline {
    agent any

    stages {
        stage('Testing maven') {
            steps {
                sh "mvn -version"
            }
        }

        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                 
            }
        }
	
	stage('MVN INSTALL') {
            steps {
                sh 'mvn install'
                 
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
