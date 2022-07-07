pipeline{
    agent any
    stages{
        stage('Code checkout'){
            steps{
                // Get the code checkout to jenkins workspace
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/com-satya/dockerize_springboot.git']]])
            }
        }
        stage('Build maven'){
            steps{
                script{
                    withMaven(maven: 'Maven3') {
                     sh 'java --version'        
                     sh 'mvn --version'
                     sh 'mvn clean compile install'
                }
                    
                }
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t satyainv459/docker-jenkins-integration-sample:1.0 .'
                }
            }
        }
        stage('Push docker images'){
            steps{
                withCredentials([string(credentialsId: 'github-id', variable: 'docker-pwd')]) {
                 sh 'docker login -u satyainv459 -p ${docker-pwd}'
                 sh 'docker push satyainv459/docker-jenkins-integration-sample:1.0 '
             }
            }
        }
    }
}
