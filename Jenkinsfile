pipeline {
    agent {
        label 'master-label'
    }

    stages {
        stage('Checkout') {
            steps {
                dir(env.CASC_REPO) {
                    checkout scm
                }
            }
        }
    }
}
