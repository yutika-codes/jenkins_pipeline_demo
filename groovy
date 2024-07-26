pipeline {
    
    stages {
        stage('Clean workspace and Navigate to the folder'){
            steps{
                cleanWs()
                bat 'copy C:\\\\Users\\\\Lenovo\\\\Desktop\\\\Vishvaja "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Pipeline Java  Code"'
            }
        }
        stage('Build') {
            steps {
                bat 'javac Pattern.java'
            }
        }
        stage('Jar') {
            steps {
                bat 'jar cfe myJar.jar Pattern Pattern.class'
            }
        }
        stage('Run') {
            steps {
                bat 'java -jar myJar.jar'
            }
        }
        stage('Artifact'){
            steps{
                archiveArtifacts artifacts: '*.jar', followSymlinks: false
            }
        }
    }
}
