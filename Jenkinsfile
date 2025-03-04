pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {
                echo '===========Git Checkout [START]==========='

                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/duckervp/lyric-be']])

                echo '===========Git Checkout [DONE]==========='
            }
        }

        stage('Maven Build') {
            steps {
                echo '===========Maven Build [START]==========='

                sh 'mvn clean package -DskipTests'

                echo '===========Maven Build [DONE]==========='
            }
        }

        stage('Docker Build') {
            steps {
                echo '===========Docker Build [START]==========='

                sh 'docker -v'

                withCredentials([string(credentialsId: 'dockerhub_psw', variable: 'dockerhub_psw')]) {
                    sh 'docker login -u duckervn -p ${dockerhub_psw}'

                    sh 'docker build -t duckervn/lyric-be .'

                    sh 'docker push duckervn/lyric-be'
                }

                echo '===========Docker Build [DONE]==========='
            }
        }

        stage('Docker Deploy') {
            steps {
                echo '===========Docker Deploy [START]==========='

                sh 'docker compose up -d'

                echo '===========Docker Deploy [DONE]==========='
            }
        }
    }
}
