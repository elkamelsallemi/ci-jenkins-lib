package org.demoJenkins

import org.demoJenkins.common.DefaultContext
import org.demoJenkins.steps.BuildStage
import org.demoJenkins.steps.DeployStage
import org.demoJenkins.steps.TestStage
import org.demoJenkins.common.ContextRegistry
class PipelineLauncher implements Serializable {

    def script  // Pipeline script (context)

    // Constructor to initialize the pipeline launcher with the Jenkins script
    PipelineLauncher(def script) {
        this.script = script
    }

    // Executes the entire pipeline by running each stage
    def run() {
        // Register the pipeline context using the ContextRegistry
        ContextRegistry.registerContext(new DefaultContext(script))

        // Initialize and run each stage
        def buildStage = new BuildStage()
        def testStage = new TestStage()
        def deployStage = new DeployStage()

        buildStage.execute('Build Stage')
        testStage.execute('Test Stage')
        deployStage.execute('Deploy Stage')
    }
}