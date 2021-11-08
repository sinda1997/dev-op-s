pipeline{
    agent any
    environment {
        PATH = "$PATH:C:/Users/user/Desktop/apache-maven-3.8.1/bin"
    }
    stages{
       stage('GetCode'){
            steps{
                git 'https://github.com/sinda1997/dev-op-s.git'
            }
            }
    	stage('Scan') {
    		steps {
    			WithSonarQubeEnv(installationName: 'sql') {
    				sh './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
    				}
    				}
    				}
       				}
}}