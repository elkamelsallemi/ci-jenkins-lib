package org.demoJenkins.steps

class BuildStage {
    def script

    BuildStage(script) {
        this.script = script
    }

    def run() {
        script.stage('Build') {
            script.echo 'Running Build Stage...'
            // Add build commands (e.g., Maven or Gradle build)
            script.sh 'echo "Building the project..."'
        }
    }
}
