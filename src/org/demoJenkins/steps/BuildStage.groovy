package org.demoJenkins.steps
import org.demoJenkins.common.ContextRegistry

class BuildStage extends BaseStage{

    @Override
    void runStage() {
        def context = ContextRegistry.getContext()
        def script = context.getSteps()

        // Simulate build step
        script.sh 'echo "Building the project..."'
    }
}
