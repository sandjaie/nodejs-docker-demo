def jobName = 'nodejs_docker_pipeline'
def repo = 'https://github.com/sandjaie/nodejs-docker-demo.git'

pipelineJob("${jobName}") {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("${repo}")
                    }
                    branches('master')
                    extensions { 
                        //required as otherwise it may try to tag the repo, which you may not want
                    }
                }
            }
        scriptPath('jenkins-pipeline/Jenkinsfile')
    }
    triggers {
        scm('H/5 * * * *')
    }
    description("Pipeline for ${repo}")
    }
}