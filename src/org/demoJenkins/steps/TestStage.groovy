package org.demoJenkins.steps

class TestStage {

    @Override
    void runStage() {
        def context = ContextRegistry.getContext()
        def script = context.getSteps()

        // Simulate test step
        script.sh 'echo "Running tests..."'
    }

}