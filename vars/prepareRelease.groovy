// vars/prepareRelease.groovy
def call() {
    echo "Preparing release..."
    // Remove the -SNAPSHOT from the version, commit, and tag the release
    sh "mvn versions:set -DremoveSnapshot"
    sh "git commit -am 'Prepare release version'"
    sh "git tag \$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)"
    sh "git push --tags"
}
