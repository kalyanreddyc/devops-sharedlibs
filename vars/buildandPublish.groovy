def call() {
    if (env.BUILD_TYPE == 'SNAPSHOT' || env.BUILD_TYPE == 'RELEASE') {
        mvn "clean deploy"
    } else {
        mvn "clean verify"
    }
}

def mvn(String command) {
    if (env.BUILD_TYPE == 'SNAPSHOT') {
        sh "mvn ${command} -Psnapshot"
    } else if (env.BUILD_TYPE == 'RELEASE') {
        sh "mvn ${command} -Prelease"
    } else {
        sh "mvn ${command}"
    }
}