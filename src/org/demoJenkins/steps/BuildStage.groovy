package org.demoJenkins.steps
import org.demoJenkins.common.ContextRegistry
import org.demoJenkins.common.IJenkinsSteps

class BuildStage extends BaseStage{

    @Override
    void runStage() {
        def steps = ContextRegistry.getContext() as IJenkinsSteps
        steps.sh 'echo "Building the project..."'  // Simulated build step
    }
}
