package org.demoJenkins.steps

import org.demoJenkins.common.IJenkinsSteps
import org.demoJenkins.common.ContextRegistry


abstract class BaseStage implements Serializable {

    // Abstract method that must be implemented by each specific stage
    abstract void runStage()

    // Executes the stage logic with error handling and logging
    void execute(String stageName) {
        def context = ContextRegistry.getContext()  // Get context from ContextRegistry
        IJenkinsSteps steps = context as IJenkinsSteps  // Cast to IJenkinsSteps interface

//        def script = context.getSteps()  // Get Jenkins steps (e.g., 'sh', 'echo', 'stage')

        steps.stage(stageName) {
            try {
                steps.echo "Starting ${stageName}..."
                runStage()  // Call the stage-specific logic
                steps.echo "${stageName} completed."
            } catch (Exception e) {
                steps.echo "${stageName} failed with error: ${e.message}"
                steps.sh("exit 1")  // Handle the error appropriately
            }
        }
    }
}
