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
            parallel firstBranch: {
                stage('Init Environment') {
                    echo('stage Init Environment')
                    echo(inputDTO.name)
                }
                stage('test stage') {
                    echo('stage test Environment')
                    echo(inputDTO.gitUrl)

                }
            }, secondBranch: {
                echo('stage test Environment')
            }

            stage('build stage') {
                echo('stage build Environment')
            }
        }catch (e) {
            throw e
        }
    }

}
