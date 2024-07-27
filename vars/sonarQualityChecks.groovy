def call(WorkflowScript script) {
    script.withSonarQubeEnv('sonar') {
        if (script.env.BUILD_TYPE != 'RELEASE') {
            script.sh("mvn clean verify sonar:sonar -Dsonar.qualitygate.wait=true")
        }
    }
}
//script.withSonarQubeEnv('Your_SonarQube_Environment_Name') : This is the name you've given your SonarQube configuration in Jenkins's global configuration. Replace it with the actual identifier you have configured.
// def call() {
//     if (env.BUILD_TYPE != 'RELEASE') {
//         // Integrate with SonarQube
//         sh "mvn sonar:sonar -Dsonar.qualitygate.wait=true"
//     }
// }
//***********//
// Assuming you have 'script' passed into your library function
// def call(script) {
//     script.withSonarQubeEnv('Your_SonarQube_Environment_Name') {
//         // Only perform SonarQube analysis for non-release builds
//         if (script.env.BUILD_TYPE != 'RELEASE') {
//             // Execute Maven SonarQube analysis and wait for the Quality Gate
//             script.sh "mvn clean verify sonar:sonar -Dsonar.qualitygate.wait=true"
//         }
//     }
// }
//**********//
// Include proper imports if needed
// import org.jenkinsci.plugins.workflow.steps.StepContext

// def call(StepContext context) {
//     context.withSonarQubeEnv('Your_SonarQube_Environment_Name') {
//         // Only perform SonarQube analysis for non-release builds
//         if (context.env.BUILD_TYPE != 'RELEASE') {
//             // Execute Maven SonarQube analysis and wait for the Quality Gate
//             context.sh "mvn clean verify sonar:sonar -Dsonar.qualitygate.wait=true"
            
//             // Now wait for the Quality Gate result and handle accordingly
//             def qg = context.waitForQualityGate()
//             if (qg.status != 'OK') {
//                 context.error "Quality Gate failed: ${qg.status}"
//             }
//         }
//     }
// }
