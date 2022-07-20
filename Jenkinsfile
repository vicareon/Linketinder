pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                withGradle{
                    sh './gradlew test'
                }
            }
        }

        stage('Post') {
            success {
                slackSend "Build deployed successfully - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
            }
        }
    }
}