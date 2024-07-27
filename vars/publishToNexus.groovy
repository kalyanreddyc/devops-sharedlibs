def call() {
    echo "Publishing artifacts to Nexus repository..."
    try {
        // Execute Maven deploy to publish the artifact to Nexus
        sh "mvn deploy"
        echo "Artifacts published successfully to Nexus."
    } catch (Exception e) {
        echo "Failed to publish artifacts to Nexus: ${e.getMessage()}"
        throw e // Re-throw the exception to fail the build if deployment fails
    }
}
