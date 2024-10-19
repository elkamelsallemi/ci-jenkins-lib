package org.demoJenkins.common

class DefaultContext implements Serializable{
    private def steps  // Jenkins steps, typically the 'script' or 'this' from Jenkinsfile

    // Constructor to initialize the context with the Jenkins steps
    DefaultContext(def steps) {
        this.steps = steps
    }

    // Provides access to the stored Jenkins steps
    def getSteps() {
        return steps
    }
}
