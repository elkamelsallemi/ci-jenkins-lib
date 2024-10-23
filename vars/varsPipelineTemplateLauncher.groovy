import org.demoJenkins.common.ContextRegistry
import org.demoJenkins.common.IJenkinsSteps
import org.demoJenkins.dto.InputDTO
import org.demoJenkins.template.PipelineTemplate

// Global InputDTO instance
InputDTO inputDTO = new InputDTO()

// Function to set values in the InputDTO instance
def setInputDTOValues(Map params) {
    inputDTO.name = params.name ?: 'defaultName'
    inputDTO.gitUrl = params.gitUrl ?: 'defaultUrl'
    inputDTO.extraParam = params.extraParam ?: 'defaultExtraParam'
}

def getInputDTO() {
    return inputDTO
}

def runPipelineTemplate(steps){
    ContextRegistry.registerDefaultContext(steps)
    IJenkinsSteps stepExecutor = ContextRegistry.getContext().getStepExecutor()
    return new PipelineTemplate(stepExecutor).run(inputDTO)
}
