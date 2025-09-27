pipeline {
    agent any // The main pipeline runs on the default Jenkins agent

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Docker Image') {
            // For this stage, switch to an agent that has Docker tools
            agent {
                docker { image 'docker:24.0' }
            }
            steps {
                // Jenkins will now run these commands inside the docker:24.0 container
                dir('api') {
                    echo 'Building the Docker image...'
                    sh 'docker build -t communityconnect-api .'
                }
            }
        }
    }
}