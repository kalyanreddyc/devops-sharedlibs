def call() {
    // Get the branch name from the environment
    def branchName = env.BRANCH_NAME

    // Check the branch name and perform actions accordingly
    if (branchName.startsWith("dev")) {
        buildAndPublishSnapshot()
    } else if (branchName.startsWith("release")) {
        buildAndPublishRelease()
    } else {
        // Default action for 'feature' and any other branches
        buildPackageOnly()
    }
}

def buildAndPublishSnapshot() {
    // Maven command for building a snapshot
    sh 'mvn clean deploy -DskipTests -Psnapshot' // Adjust parameters as needed

    // Publish to Nexus Snapshot Repository
    // Additional steps or script commands for publishing to Nexus
}

def buildPackageOnly() {
    // Maven command for clean package
    sh 'mvn clean package -DskipTests' // Adjust parameters as needed
}

def buildAndPublishRelease() {
    // Maven command for building a release
    sh 'mvn clean deploy -DskipTests -Prelease' // Adjust parameters as needed

    // Publish to Nexus Release Repository
    // Additional steps or script commands for publishing to Nexus
}
