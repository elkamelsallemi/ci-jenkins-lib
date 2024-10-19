package org.demoJenkins.steps

class DeployStage {

    @Override
    void runStage() {
        def context = ContextRegistry.getContext()
        def script = context.getSteps()

        // Simulate deploy step
        script.sh 'echo "Deploying the project..."'
    }
}
