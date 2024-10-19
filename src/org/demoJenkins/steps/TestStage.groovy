package org.demoJenkins.steps

class TestStage {
    def script

    TestStage(script) {
        this.script = script
    }

    def run() {
        script.stage('Test') {
            script.echo 'Running Test Stage...'
            // Add test commands (e.g., JUnit, integration tests)
            script.sh 'echo "Running unit tests..."'
        }
    }
}

