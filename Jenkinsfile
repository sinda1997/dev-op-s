pipeline {
		agent any 
	stages{
		stage('checkout GIT') {
		steps {
				
				echo 'Pulling...';
				git branch: 'master', url: 'https://github.com/sinda1997/dev-op-s.git'
				
				}
}

		stage("Test, Build, Sonar") {
		steps {
		
				bat "mvn package sonar:sonar"
				
				}
		}
		
}
}