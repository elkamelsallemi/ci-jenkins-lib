package org.demoJenkins.steps

class DeployStage {

    def script

    DeployStage(script) {
        this.script = script
    }

    def run() {
        script.stage('Deploy') {
            script.echo 'Running Deploy Stage...'
            // Add deployment commands (e.g., SCP, Docker, etc.)
            script.sh 'echo "Deploying the application..."'
        }
    }
}
