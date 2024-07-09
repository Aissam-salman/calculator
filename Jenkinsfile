pipeline {
    agent any

    environment {
        AWS_ACCESS_KEY_ID = credentials('aws-access-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('aws-secret-access-key')
        S3_BUCKET = 'calculatorjenkins'  // Remplacez par le nom de votre bucket S3
        ARTIFACT_PATH = './target/calculator2-0.0.1-SNAPSHOT.jar'
        REGION = "eu-west-3"

        EC2_USER = 'ubuntu'
        EC2_HOST = '35.180.131.217'

        REMOTE_PATH = '/home/ubuntu/'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git branch: 'main', url:'https://github.com/Aissam-salman/calculator.git', credentialsId: '405'

            }
        }

        stage('Build') {
            steps {
                // Build the Spring Boot application
                sh './mvnw clean install'
            }
        }

        stage('Test') {
            steps {
                // Run the tests
                sh './mvnw test'
            }
        }

        stage('Package') {
            steps {
                // Package the application
                sh './mvnw package'
            }
        }

        stage('Deploy to EC2') {
            steps {
                sshagent(['my-ssh-key']) {
                    sh """
                    scp -o StrictHostKeyChecking=no ${ARTIFACT_PATH} ${EC2_USER}@${EC2_HOST}:${REMOTE_PATH}
                    ssh -o StrictHostKeyChecking=no ${EC2_USER}@${EC2_HOST} 'systemctl restart springboot.service'
                    """
                }
            }
        }




    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}