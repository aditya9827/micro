pipeline{

    agent any
    tools {
        maven "MAVEN"
        jdk "JDK"
    }

    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub-aditya')
        }

    stages {

        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }

        stage('Login') {

            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }

        stage('build'){

            steps{
                dir("/Users/aditya/Documents/Workspaces/Microservices/normal/licensing-service") {
                sh 'mvn -B -DskipTests clean package com.google.cloud.tools:jib-maven-plugin:3.3.1:build'
                }

            }
        }

        

        
    }

    post {
        always {
            sh 'docker logout'
        }
    }

}