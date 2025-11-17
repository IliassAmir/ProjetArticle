pipeline {
    agent any

    tools {
        maven 'Maven 3.9.0'
        jdk 'Java 17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/IliassAmir/ProjetJava.git'
            }
        }

        stage('Build') {
            steps {
                // Compile le projet avec Maven sur Windows
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps {
                // Lancer les tests unitaires
                bat 'mvn test'
            }
            post {
                always {
                    // Publier les résultats JUnit
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo 'Build et tests réussis ✅'
        }
        failure {
            echo 'Échec du build ou des tests ❌'
        }
    }
}
