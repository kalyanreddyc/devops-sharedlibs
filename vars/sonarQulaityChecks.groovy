// def call() {
//     if (env.BUILD_TYPE != 'RELEASE') {
//         // Integrate with SonarQube
//         sh "mvn sonar:sonar -Dsonar.qualitygate.wait=true"
//     }
// }
// Assuming you have 'script' passed into your library function
def call(script) {
    script.withSonarQubeEnv('Your_SonarQube_Environment_Name') {
        // Only perform SonarQube analysis for non-release builds
        if (script.env.BUILD_TYPE != 'RELEASE') {
            // Execute Maven SonarQube analysis and wait for the Quality Gate
            script.sh "mvn clean verify sonar:sonar -Dsonar.qualitygate.wait=true"
        }
    }
}

