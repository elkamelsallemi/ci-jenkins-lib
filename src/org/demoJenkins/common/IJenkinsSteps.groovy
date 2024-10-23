package org.demoJenkins.common

interface IJenkinsSteps {

    def getRawStep()

    def sh(String script)

    def echo (String message)

    def stage(String name, Closure body)

    /**
    * https://www.jenkins.io/doc/pipeline/steps/workflow-cps/#parallel-execute-in-parallel

    parallel firstBranch: {
        // do something
    }, secondBranch: {
        // do something else
    },
    failFast: true|false
    */

    void parallel(Map namesToClosures)

}