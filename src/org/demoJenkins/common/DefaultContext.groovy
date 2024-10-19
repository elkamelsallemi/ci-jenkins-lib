package org.demoJenkins.common

class DefaultContext implements IJenkinsSteps, Serializable{
    private def steps  // Jenkins steps, typically the 'script' or 'this' from Jenkinsfile

    // Constructor to initialize the context with the Jenkins steps
    DefaultContext(def steps) {
        this.steps = steps
    }

    // Provides access to the stored Jenkins steps
    def getSteps() {
        return steps
    }

    @Override
    void sh(String script) {
        steps.sh(script)  // Use Jenkins 'sh' step
    }

    @Override
    void echo(String message) {
        steps.echo(message)  // Use Jenkins 'echo' step
    }

    @Override
    void stage(String name, Closure body) {
        steps.stage(name, body)  // Use Jenkins 'stage' step
    }
}
