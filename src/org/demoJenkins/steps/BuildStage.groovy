package org.demoJenkins.steps

class BuildStage extends BaseStage{

    @Override
    void runStage() {
        def context = ContextRegistry.getContext()
        def script = context.getSteps()

        // Simulate build step
        script.sh 'echo "Building the project..."'
    }
}
