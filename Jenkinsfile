pipeline {
    agent any

    stages {
        stage('Testing maven') {
            steps {
                sh "mvn -version"
            }
        }

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

        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
                 
            }
        }

	stage('MVN TEST') {
            steps {
                sh 'mvn test'
                 
            }
        }

        stage('Testing from git') {
            steps {
                sh "git --version"
            }
        }



    }
}
