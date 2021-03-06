pipeline {
		agent any
    environment {
       PATH = "$PATH:C:/Users/jouin/Downloads/Nouveau dossier (7)/apache-maven-3.8.1/bin"
    
       
    }
	stages{
	
	stage('GetCode'){
            steps{
                git 'https://github.com/sinda1997/dev-op-s.git'
            }
         }
	 stage('SonarQube analysis') {
       steps{
        withSonarQubeEnv('SonarQube') { 
        bat "mvn -Dmaven.test.failure.ignore=true clean install" 
       bat "mvn sonar:sonar"
    }
      }
   }
   stage('Build Maven') {
            steps{
              git branch: 'master', credentialsId: 'NEXUS_CRED', url: 'https://github.com/sinda1997/dev-op-s.git'
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
                
            }
        }  
        stage("Publish to Nexus Repository Manager") {

            steps {

                script {

                    pom = readMavenPom file: "pom.xml";

                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");

                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"

                    artifactPath = filesByGlob[0].path;

                    artifactExists = fileExists artifactPath;

                    if(artifactExists) {

                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";

                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            
                            protocol: 'http',

                            nexusUrl: 'localhost:8081/',

                            groupId: 'pom.tn.esprit.spring',

                            version: 'pom.1.0',

                            repository: 'maven-central-repository',

                            credentialsId: 'NEXUS_CRED',

                            artifacts: [

                                [artifactId: 'pom.Timesheet-spring-boot-core-data-jpa-mvc-REST-1',

                                classifier: '',

                                file: artifactPath,

                                type: pom.packaging],

                                [artifactId: 'pom.Timesheet-spring-boot-core-data-jpa-mvc-REST-1',

                                classifier: '',

                                file: "pom.xml",

                                type: "pom"]

                            ]

                        );

                    } else {

                        error "*** File: ${artifactPath}, could not be found";

                    }

                }

            }
            }
            stage('Build Docker Image') {

			steps {
				bat 'docker build -t sinda25/timesheet:latest .'
			}
		}

		stage('Push') {

			steps {
			    bat'docker login -u "sinda25" -p "sinda1997" docker.io '
			    bat 'docker push sinda25/timesheet:latest'
			}
			
		}
		stage('Cleaning up'){
			steps{
			    bat'docker login -u "sinda25" -p "sinda1997" docker.io '
				bat "docker rmi sinda25/timesheet:latest" 
			}
		}
        }
        
        }