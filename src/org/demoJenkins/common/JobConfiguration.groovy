package org.demoJenkins.common

class JobConfiguration implements Serializable {

    static void configure(def script) {
        // Configure job properties
        script.properties([
                // Set the build discarder to keep only the last 5 builds or builds from the last 30 days
                script.buildDiscarder(script.logRotator(numToKeepStr: '5', daysToKeepStr: '30')),

                // Disable concurrent builds
                script.disableConcurrentBuilds(),

                // Define the job parameters
                script.parameters([
                        script.string(name: 'BRANCH', defaultValue: 'main', description: 'Git branch to build'),
                        script.choice(name: 'DEPLOY_ENV', choices: ['dev', 'staging', 'production'], description: 'Environment to deploy'),
                        script.booleanParam(name: 'SKIP_TESTS', defaultValue: false, description: 'Skip the test execution'),
                        script.booleanParam(name: 'TEST', defaultValue: false, description: 'test execution')
                ]),

                // Add a cron trigger to run the job at 2 AM every day
                script.pipelineTriggers([
                        script.cron('H 2 * * *')
                ])
        ])
    }
}
