pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
    }

    stages {
        stage('Build') {
            steps {

                git branch: 'AymenJELJLI', credentialsId: 'mygithub', url: 'https://github.com/nouhamejri/GesFormation.git'

                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }

            post {

                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }

            post {

                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Sonar') {
            steps {
                bat 'mvn sonar:sonar'
            }
        }

        stage('Deploy') {
            steps {
                bat 'mvn deploy'
            }
        }

        stage('Docker compose') {
            steps {
                bat 'docker-compose down'
                bat 'docker-compose up -d'
            }
        }
    }

    post {
            always {
                mail body: 'Done', subject: 'Jenkins Pipeline', to: 'aymen.jeljli@esprit.tn'
            }
            failure {
                mail body: 'Error', subject: 'Jenkins Pipeline', to: 'aymen.jeljli@esprit.tn'
            }
     }
}
