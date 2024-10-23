package org.demoJenkins.steps

import org.demoJenkins.common.IJenkinsSteps

abstract class BaseStage implements Serializable {

    protected IJenkinsSteps _steps

    BaseStage(){}

    BaseStage(IJenkinsSteps steps){
        this._steps = steps
    }

    def stage(String name, Closure body ){
        return _steps.stage(name,body)
    }

    def echo(String message){
        return _steps.echo(message)
    }

    void parallel(Map namesToClosures){
        this._steps.parallel(namesToClosures)
    }

}
