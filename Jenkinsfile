pipeline {
    agent any
// built up with code from various labs throughout the semester
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
                artifacts: '**/ryan_petitions*.war'
            }
        }
        stage("Manual Deployment"){
           /* asking developer if they want to proceed with deployment */
            steps {
                input "Would you like to deploy the application?"
            }
        }
        stage("Docker"){
            // Run the package in a container exposed on the 9090 port
            steps{
                sh 'docker build -f Dockerfile -t myapp . '
                sh 'docker rm -f "myapp_container_test" || true'
                sh 'docker run --name "myapp_container_test" -p 9090:8080 --detach myapp:latest'
            }
            post {
                success {
                    echo "App Deployed"
                }
                failure {
                    echo "FAILED"
                }
            }
        }

    }
}