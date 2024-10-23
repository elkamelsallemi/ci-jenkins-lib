import org.demoJenkins.common.ContextRegistry
import org.demoJenkins.common.IJenkinsSteps
import org.demoJenkins.dto.InputDTO
import org.demoJenkins.template.PipelineTemplate

def runPipelineTemplate(steps, InputDTO inputDTO){
    ContextRegistry.registerDefaultContext(steps)
    IJenkinsSteps stepExecutor = ContextRegistry.getContext().getStepExecutor()
    return new PipelineTemplate(stepExecutor).run(inputDTO)
}
