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
                String version = '0.0.dev1g824dc41d'
                String PATH = 'pkg_meta.py'

// Step 1: Remove existing file if it exists
                this._steps.sh("rm -f ${PATH}")

// Step 2: Create the file with the initial version
                this._steps.sh("echo '__version__ = \"0.0.1\"' > ${PATH}")

// Step 3: Use sed to update the version in the file
                this._steps.sh("sed -ri 's/(^\\s*__version__\\s*=\\s*')[^']*(.*)/\\1\\'${version}'/' ${PATH}")

// Step 4: Display the content of the file to verify
                this._steps.sh("cat ${PATH}")
            }
        }catch (e) {
            throw e
        }
    }

}
