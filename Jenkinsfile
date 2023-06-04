pipeline {
    agent any

    tools {
        // Nombre dado a la instalación de Maven en "Tools configuration"
        maven "maven default"
    }

    stages {
        stage('Git fetch') { 
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/jme418/ej2exahmisjun22.git', branch: 'main', credentialsId: 'private_projects_jme418'
            }
        }
        stage('Compile, Test, Package') { 
            steps {
                // When necessary, use '-f path-to/pom.xml' to give the path to pom.xml
                // Run goal 'package'. It includes compile, test and package.
                sh "mvn -f pom.xml clean package" 
            }
            post { 
                // Record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts '**/target/*.jar'
                    jacoco( 
                        execPattern: '**/target/jacoco.exec',
                        classPattern: '**/target/classes',
                        sourcePattern: '**/src/',
                        exclusionPattern: '**/test/'
                    )
                    publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
                }
            }
        }
        stage ('Analysis') {
            steps {
	            // Warnings next generation plugin required
	            sh "mvn -f pom.xml site"
            }
            post {
                success {
                    recordIssues enabledForFailure: true, tool: checkStyle()
                    recordIssues enabledForFailure: true, tool: spotBugs()
                }
            }
        }
    }
}
