pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Navigate into the backend project folder
                    dir('api') {
                        echo 'Building the Docker image...'
                        // Run the docker build command
                        sh 'docker build -t communityconnect-api .'
                    }
                }
            }
        }
    }
}