// vars/buildandPublish.groovy
def call(String phase = 'verify') {
    if (phase == 'deploy') {
        if (env.BUILD_TYPE == 'RELEASE') {
            // Set the version to a release version (removing -SNAPSHOT)
            sh "mvn versions:set -DnewVersion=\$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout | sed 's/-SNAPSHOT//')"
            sh "mvn clean deploy -Prelease"
        } else if (env.BUILD_TYPE == 'SNAPSHOT') {
            sh "mvn clean deploy -Psnapshot"
        }
    } else {
        mvn("clean verify")
    }
}

def mvn(String command) {
    sh "mvn ${command}"
}

//**********working-script*******///
// vars/buildandPublish.groovy
// def call(String phase = 'verify') {
//     if (phase == 'deploy' && (env.BUILD_TYPE == 'SNAPSHOT' || env.BUILD_TYPE == 'RELEASE')) {
//         mvn("clean deploy")
//     } else {
//         mvn("clean verify") // Default action is to build and verify
//     }
// }

// def mvn(String command) {
//     if (env.BUILD_TYPE == 'SNAPSHOT') {
//         sh "mvn ${command} -Psnapshot"
//     } else if (env.BUILD_TYPE == 'RELEASE') {
//         sh "mvn ${command} -Prelease"
//     } else {
//         sh "mvn ${command}"
//     }
// }

//***previous-script***//
// def call() {
//     if (env.BUILD_TYPE == 'SNAPSHOT' || env.BUILD_TYPE == 'RELEASE') {
//         mvn "clean deploy"
//     } else {
//         mvn "clean verify"
//     }
// }
