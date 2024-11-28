pipeline {
    agent any

    stages {
        stage("GetProject"){
            steps{
                git 'https://github.com/Quazbickie/ryan_petitions.git'
            }
        }
        stage("Build"){
            steps{
                sh "mvn clean:clean"
                sh "mvn dependency:copy-dependencies"
                sh "mvn compiler:compile"
            }
        }
        stage("Package"){
            steps{
                sh 'mvn package'
            }
        }
        stage("Archive"){
            steps{
                archiveArtifacts allowEmptyArchive: true,
                artifacts: '*/ryan_petitions.war'
            }
        }
        stage("Docker"){
            steps{
                sh 'docker build -f Dockerfile -t myapp . '
                sh 'docker rm -f "myapp_container_test" || true'
                sh 'docker run --name "myapp_container_test" -p 9091:8080 --detach myapp:latest'
            }
        }

    }
}