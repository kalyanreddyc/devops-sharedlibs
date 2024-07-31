def call() {
    echo "Preparing release..."

    // Update Maven project version to remove the -SNAPSHOT suffix
    sh "mvn versions:set -DremoveSnapshot"

    // Check if there are any changes to commit
    def hasChanges = sh(script: "git status --porcelain", returnStdout: true).trim()
    if (hasChanges) {
        // If changes are detected, commit them
        sh "git commit -am 'Prepare release version'"

        // Tag the release with the new version number
        def newVersion = sh(script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true).trim()
        sh "git tag ${newVersion}"

        // Push tags to the remote repository
        sh "git push --tags"
    } else {
        echo "No changes to commit, skipping commit and tag."
    }
}

// // vars/prepareRelease.groovy
// def call() {
//     echo "Preparing release..."
//     // Remove the -SNAPSHOT from the version, commit, and tag the release
//     sh "mvn versions:set -DremoveSnapshot"
//     sh "git commit -am 'Prepare release version'"
//     sh "git tag \$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)"
//     sh "git push --tags"
// }
