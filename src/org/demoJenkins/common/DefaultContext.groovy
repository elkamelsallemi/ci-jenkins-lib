package org.demoJenkins.common

class DefaultContext implements IJenkinsContext, Serializable{

    private  _steps

    // Constructor to initialize the context with the Jenkins steps
    DefaultContext(steps) {
        this._steps = steps
    }


    @Override
    IJenkinsSteps getStepExecutor(){
        return new StepsExecutor(this._steps)
    }
}
