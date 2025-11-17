pipeline {
    agent any

    tools {
        maven 'Maven 3.9.0'
        jdk 'Java 17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code depuis GitHub
                git branch: 'main', url: 'https://github.com/IliassAmir/ProjetJava.git'
            }
        }

        stage('Build') {
            steps {
                // Compile le projet avec Maven sur Windows
                bat """
                set JAVA_HOME=C:\\Users\\ilias\\.jenkins\\tools\\hudson.model.JDK\\Java_17
                set PATH=%JAVA_HOME%\\bin;%PATH%
                mvn clean install -DskipTests
                """
            }
        }

        stage('Unit Tests') {
            steps {
                // Lancer les tests unitaires
                bat """
                set JAVA_HOME=C:\\Users\\ilias\\.jenkins\\tools\\hudson.model.JDK\\Java_17
                set PATH=%JAVA_HOME%\\bin;%PATH%
                mvn test
                """
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
