package org.demoJenkins.common

class StepsExecutor implements IJenkinsSteps, Serializable {

    protected _steps

    StepsExecutor(steps){
        this._steps = steps
    }



    @Override
    def getRawStep() {
        return this._steps
    }

    @Override
    def sh(String script) {
        return this._steps.sh(script: script)
    }

    @Override
    def echo(String message) {
        return this._steps.echo(message)
    }

    @Override
    def stage(String name, Closure body) {
        return this._steps.stage(name,body)
    }
}
