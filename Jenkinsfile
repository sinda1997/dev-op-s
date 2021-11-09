pipeline {
		agent any
    environment {
       PATH = "$PATH:C:/Users/user/Desktop/apache-maven-3.8.1/bin"
    
       
    }
    tools
    {
    	maven "MAVEN_HOME"
    }
	 stages{
       stage('GetCode'){
            steps{
				git 'https://github.com/sinda1997/dev-op-s.git'
				
				}
}
		stage('build') {
			steps {
				// run maven on windows agent, use 
				bat "mvn -Dmaven.test.failure.ignore=true clean package"
				}
		post {
			success {
				junit '**/target/surefire-reports/TEST-*.xml'
				archiveArtifacts 'target/*.jar'
				}
		
}}}}