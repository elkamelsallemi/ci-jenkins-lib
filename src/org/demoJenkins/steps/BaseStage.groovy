package org.demoJenkins.steps

abstract class BaseStage implements Serializable {

    // Abstract method that must be implemented by each specific stage
    abstract void runStage()

    // Executes the stage logic with error handling and logging
    void execute(String stageName) {
        def context = ContextRegistry.getContext()  // Get context from ContextRegistry
        def script = context.getSteps()  // Get Jenkins steps (e.g., 'sh', 'echo', 'stage')

        script.stage(stageName) {
            try {
                script.echo "Starting ${stageName}..."
                runStage()  // Call the stage-specific logic
                script.echo "${stageName} completed."
            } catch (Exception e) {
                script.echo "${stageName} failed with error: ${e.message}"
                script.currentBuild.result = 'FAILURE'
                throw e
            }
        }
    }
}
