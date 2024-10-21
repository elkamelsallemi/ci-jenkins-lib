package org.demoJenkins.common

interface IJenkinsSteps {

    def getRawStep()

    def sh(String script)

    def echo (String message)

    def stage(String name, Closure body)

}