package org.demoJenkins.template

import org.demoJenkins.common.IJenkinsSteps
import org.demoJenkins.steps.BaseStage

class PipelineTemplate extends BaseStage implements Serializable{

    PipelineTemplate(IJenkinsSteps jenkinsSteps){
        super(jenkinsSteps)
    }

    def run(){
        this.triggerFlow()
    }

    void triggerFlow(){
        try {
            stage('Init Environment') {
                this._steps.echo('stage Init Environment')
            }
            stage('test stage') {
                this._steps.echo('stage test Environment')
            }
            stage('build stage') {
                this._steps.echo('stage build Environment')
            }
        }catch (e) {
            throw e
        }
    }

}
