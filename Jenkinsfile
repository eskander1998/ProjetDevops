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
		echo 'Testing ...';
                sh 'mvn test -Dtest="StockServiceImplTest"'
                 
            }
        }

        stage('Testing from git') {
            steps {
                sh "git --version"
            }
        }

		stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        
        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
                  
            }
        }
        stage('Build Docker Image Backend') {
            steps {
                sh 'docker build -t goro1809/projetdevops-backend . '
                 
            }
        }
        stage('Login Dockerhub') {

			steps {
			sh 'docker login -u goro1809 -p Amin2004Ahmed1999'
			}
			}
        stage('Push Backend Image To Dockerhub') {
            steps {
                sh 'docker push goro1809/projetdevops-backend'
                 
            }
        }



    }
}
