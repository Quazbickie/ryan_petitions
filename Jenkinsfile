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

    }
}