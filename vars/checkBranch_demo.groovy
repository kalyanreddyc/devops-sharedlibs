// vars/checkBranch_demo.groovy
def call() {
    def branchName = env.BRANCH_NAME ?: 'dev'  // Sets default to 'dev' if BRANCH_NAME is not set
    if (branchName.startsWith('dev')) {
        env.BUILD_TYPE = 'SNAPSHOT'
    } else if (branchName.startsWith('release')) {
        env.BUILD_TYPE = 'RELEASE'
    } else {
        env.BUILD_TYPE = 'BUILD_ONLY'
    }
    echo "Branch: ${branchName}, Build Type: ${env.BUILD_TYPE}"
    return branchName // Make sure this is actually returning the branch name
}
