package org.demoJenkins.steps
import org.demoJenkins.common.ContextRegistry
class DeployStage extends BaseStage {

    @Override
    void runStage() {
        def context = ContextRegistry.getContext()
        def script = context.getSteps()

        // Simulate deploy step
        script.sh 'echo "Deploying the project..."'
    }
}
