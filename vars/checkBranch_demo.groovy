def call() {
    def branchName = env.BRANCH_NAME ?: 'master' // Default to 'main' if BRANCH_NAME is not set
    if (branchName.startsWith('dev')) {
        env.BUILD_TYPE = 'SNAPSHOT'
    } else if (branchName.startsWith('release')) {
        env.BUILD_TYPE = 'RELEASE'
    } else {
        env.BUILD_TYPE = 'BUILD_ONLY'
    }
    echo "Branch: ${branchName}, Build Type: ${env.BUILD_TYPE}"
}