import org.demoJenkins.common.ContextRegistry
import org.demoJenkins.common.IJenkinsSteps
import org.demoJenkins.dto.InputDTO
import org.demoJenkins.template.PipelineTemplate


def setInputDTOValues(Map params) {

    InputDTO inputDTO = new InputDTO()

    inputDTO.name = params.name ?: 'defaultName'
    inputDTO.gitUrl = params.gitUrl ?: 'defaultUrl'
    inputDTO.extraParam = params.extraParam ?: 'defaultExtraParam'

    return inputDTO
}

def runPipelineTemplate(steps, InputDTO inputDTO){
    ContextRegistry.registerDefaultContext(steps)
    IJenkinsSteps stepExecutor = ContextRegistry.getContext().getStepExecutor()
    return new PipelineTemplate(stepExecutor).run(inputDTO)
}
