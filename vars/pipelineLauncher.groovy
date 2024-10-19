// vars/pipelineLauncher.groovy

import org.demoJenkins.steps.BuildStage
import org.demoJenkins.steps.TestStage
import org.demoJenkins.steps.DeployStage

def call() {
    node {
        try {
            // Initialize each stage with the pipeline context (this)
            def buildStage = new BuildStage(this)
            def testStage = new TestStage(this)
            def deployStage = new DeployStage(this)

            // Execute the stages
            buildStage.run()
            testStage.run()
            deployStage.run()

        } catch (Exception e) {
            currentBuild.result = 'FAILURE'
            echo "Pipeline failed: ${e.message}"
            throw e
        } finally {
            echo 'Pipeline completed.'
        }
    }
}

