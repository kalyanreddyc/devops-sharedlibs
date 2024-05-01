def call(String branchName) {
    if (branchName.startsWith('dev')) {
        echo "Building Maven snapshot for branch: $branchName"
        // Add Maven snapshot build and publish logic here
        sh 'mvn clean package'
    } else if (branchName.startsWith('release')) {
        echo "Building Maven release for branch: $branchName"
        // Add Maven release build and publish logic here
        sh 'mvn clean package'
    } else {
        error "Unsupported branch type: $branchName"
    }
}
