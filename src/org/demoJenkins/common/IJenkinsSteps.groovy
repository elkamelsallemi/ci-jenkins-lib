package org.demoJenkins.common

interface IJenkinsSteps {

    // Method signatures for common Jenkins steps
    void sh(String script)
    void echo(String message)
    void stage(String name, Closure body)

}