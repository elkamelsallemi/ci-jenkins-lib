package org.demoJenkins.steps
import org.demoJenkins.common.ContextRegistry
import org.demoJenkins.common.IJenkinsSteps

class DeployStage extends BaseStage {

    @Override
    void runStage() {
        def steps = ContextRegistry.getContext() as IJenkinsSteps
        steps.sh 'echo "Running tests..."'  // Simulated test step
    }
}
