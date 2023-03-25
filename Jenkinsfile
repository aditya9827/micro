pipeline {
    agent any
    tools {
        maven "MAVEN"
        jdk "JDK"
    }
    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
        stage('Build') {
            agent {
            docker {
            image 'openjdk:17-jdk-slim'
            }
        }
            steps {
                dir("/Users/aditya/Documents/Workspaces/Microservices/normal/licensing-service") {
                sh 'mvn -B -DskipTests clean package jib:build'
                }
            }
        }
        stage('docker push image') {
            agent any
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'docker-hubPassword', usernameVariable: 'docker-hubUser')]) {
            sh "docker login -u ${env.docker-hubUser} -p ${env.docker-hubPassword}"
            sh 'docker push aditya9827/licensing-service:latest'
            }
            }
        }
     }
    post {
       always {
          junit(
        allowEmptyResults: true,
        testResults: '*/test-reports/.xml'
      )
      }
   } 
}