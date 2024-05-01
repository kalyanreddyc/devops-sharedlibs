// vars/checkoutFromGitHub.groovy
def call(Map config = [:]) {
    // Validate required parameters
    if (!config.repository) {
        error 'Missing required parameter: repository'
    }

    if (!config.credentialsId) {
        error 'Missing required parameter: credentialsId'
    }

    // Set default branch if not specified
    if (!config.branch) {
        config.branch = 'master' // Default to 'master' if not specified
    }
    // Print the branch name
    echo "Checking out branch: ${config.branch} from repository: ${config.repository}"
    
    //echo "Checking out ${config.branch} from ${config.repository}"

    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${config.branch}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            credentialsId: config.credentialsId,
            url: config.repository
        ]]
    ])
}
