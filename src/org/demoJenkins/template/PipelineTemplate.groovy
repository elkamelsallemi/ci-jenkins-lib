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
            stage('build stage') {
                String version='0.0.dev1g824dc41d'
                String PATH='pkg_meta.py'
                this._steps.echo('stage build Environment')
                this._steps.sh("rm pkg_meta.py")
                this._steps.sh '''echo "__version__ = '0.0.1'" > pkg_meta.py'''
                this._steps.sh("cat ${PATH}")
                this._steps.sh("sed -i 's/__version__ = .*/__version__ = \"${version}\"/' ${PATH}")
                this._steps.sh("cat ${PATH}")
            }
        }catch (e) {
            throw e
        }
    }

}
