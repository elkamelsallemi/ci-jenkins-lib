package org.demoJenkins.template

import org.demoJenkins.common.IJenkinsSteps
import org.demoJenkins.dto.InputDTO
import org.demoJenkins.steps.BaseStage

class PipelineTemplate extends BaseStage implements Serializable{

    PipelineTemplate(IJenkinsSteps jenkinsSteps){
        super(jenkinsSteps)
    }

    def run(InputDTO inputDTO){
        this.triggerFlow(inputDTO)
    }

    void triggerFlow(InputDTO inputDTO){
        try {
            stage('Init Environment') {
                this._steps.echo('stage Init Environment')
                this._steps.echo(inputDTO.name)
            }
            stage('test stage') {
                this._steps.echo('stage test Environment')
                this._steps.echo(inputDTO.gitUrl)
            }
            stage('build stage') {
                this._steps.echo('stage build Environment')
            }
        }catch (e) {
            throw e
        }
    }

}
