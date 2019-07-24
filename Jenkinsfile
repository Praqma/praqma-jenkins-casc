pipeline {
    agent {
        label 'master-label'
    }

    stages {
        stage('Checkout') {
            dir(env.CASC_REPO) {
                steps {
                    checkout scm
                }
            }
        }
    }
}
