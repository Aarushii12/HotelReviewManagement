pipeline {

    agent any

     tools { 
      maven 'MAVEN' 
      jdk 'JDK 1.8' 
    }
  
    stages {

        stage("Git Checkout"){
            steps {
                git branch: 'main', url: 'https://github.com/ADITYA310802/HotelReviewManagement.git'
            }
        }

        stage("Unit Testing"){
            steps {
                sh 'mvn test'
            }
        }

        stage("Integration Testing"){
            steps {
                sh 'mvn verify -DskipUnitTests'
            }
        }

        stage("Build"){
            steps {
                sh 'mvn clean install'
            }
        }
        
        
       
 

        
          stage('SonarQube analysis') {
//    def scannerHome = tool 'SonarScanner 4.0';
        steps{
        withSonarQubeEnv('SonarQube') { 
        // If you have configured more than one global server connection, you can specify its name
//      sh "${scannerHome}/bin/sonar-scanner"
//              sh "${scannerHome}/bin/sonar-scanner \
//                             -Dsonar.projectKey=hotel_management\
//                             -Dsonar.projectName=hotel_managemant \
//                             -Dsonar.projectVersion='1.0' \
//                             -Dsonar.sources=src \
//                             -Dsonar.java.binaries=target \
//                             -Dsonar.host.url=http://localhost:9000 \
//                             -Dsonar.login=token12"
        sh "mvn sonar:sonar"
    }
        }
    
    
          }
            stage('Deploy with Ansible') {
            steps {
                script {
                    // Execute Ansible playbook
                    docker.image('ansible/ansible:latest').inside {
                        ansiblePlaybook playbook: '/ansible/playbook.yml'
                    }
                }
            }
        }
}}
