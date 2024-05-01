def call(String branchName) {
    if (branchName ==~ /dev-.*/) {
        // For 'dev' branches, perform a snapshot build
        sh 'mvn clean install -DskipTests'
    } else if (branchName ==~ /release-.*/) {
        // For 'release' branches, use the release plugin
        sh 'mvn release:prepare release:perform -DskipTests'
    } else {
        // For other branches, you can decide what needs to be done
        sh 'mvn clean install -DskipTests' // or any other appropriate command
    }
}
