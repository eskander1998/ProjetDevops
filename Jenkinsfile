pipeline {
    agent any

    stages {

       stage('check out git'){       
            steps{
                echo 'Pulling...';
                git branch: 'ahmed',
                url : 'https://github.com/eskander1998/ProjetDevops'
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
