def jobName = 'nodejs-docker-pipeline'
def repo = 'https://github.com/sandjaie/nodejs-docker-demo.git'

pipelineJob("${jobName}") {
    // triggers {
    //     scm('H/5 * * * *')
    // }
    // description("Pipeline for $repo")
    cpsScm {
        scm {
            git {
                remote { url(repo) }
                branches('master')
                scriptPath('jenkins-pipeline/Jenkinsfile')
                extensions { 
                    //required as otherwise it may try to tag the repo, which you may not want
                }
            }
        }
    }
}