package org.demoJenkins.steps
import org.demoJenkins.common.ContextRegistry

class TestStage extends BaseStage{

    @Override
    void runStage() {
        def context = ContextRegistry.getContext()
        def script = context.getSteps()

        // Simulate test step
        script.sh 'echo "Running tests..."'
    }

}