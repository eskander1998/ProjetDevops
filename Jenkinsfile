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

   stage ('Test MOKITO'){
            steps {
                echo 'Testing ...';
                sh 'mvn test -Dtest="ProduitServiceImplMock"'
            }
        }
    stage ('Test JUINT'){
            steps {
                echo 'Testing ...';
                sh 'mvn test -Dtest="ProduitServiceImplMock"'
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
        
       
        
       
       stage('Build Docker image Backend') {
            steps {
                sh 'docker build -t goro1809/projetdevopsbackend . '
                 
            }
        }
        stage('Login Dockerhub') {

			steps {
			sh 'docker login -u "username" -p "password"'
			}
			}
        stage('Push image Backend to Dockerhub') {
            steps {
                sh 'docker push goro1809/projetdevopsbackend'
                 
            }
        }
        
        
         stage('Docker compose front/back/sql') {
            steps {
                sh 'docker-compose up -d'
                 
            }
        }

    }
}
