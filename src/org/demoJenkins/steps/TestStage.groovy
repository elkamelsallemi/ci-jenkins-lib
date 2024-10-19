package org.demoJenkins.steps
import org.demoJenkins.common.ContextRegistry
import org.demoJenkins.common.IJenkinsSteps

class TestStage extends BaseStage{

    @Override
    void runStage() {
        def steps = ContextRegistry.getContext() as IJenkinsSteps
        steps.sh 'echo "Deploying the project..."'  // Simulated deploy step
    }

}