pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // This step checks out the code from your GitHub repository
                checkout scm
            }
        }
        stage('Verify Connection') {
            steps {
                script {
                    echo 'SUCCESS: Jenkins is connected and can read the Jenkinsfile!'
                }
            }
        }
    }
}