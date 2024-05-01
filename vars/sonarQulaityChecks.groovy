def call() {
    if (env.BUILD_TYPE != 'RELEASE') {
        // Integrate with SonarQube
        sh "mvn sonar:sonar"
    }
}