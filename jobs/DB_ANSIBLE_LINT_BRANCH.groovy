import utilities.DbUtils
// Job de contrôle du code Ansible
def job = freeStyleJob('DB_ANSIBLE_LINT_BRANCH'){

    // Description du job.
    description('Ce job permet de contrôler la qualité du code Ansible de déploiement.')


//  Définir les paramètres du Job
    parameters {
        stringParam('branch', 'master', 'Branche Ansible à contrôler.')
//        TODO - à integrer liste dynamique des branches. Example : http://www.nachum234.com/automation/jenkins/dynamically-list-git-branches-in-jenkins-parameter/
//        TODO - https://jenkinsci.github.io/job-dsl-plugin/#method/javaposse.jobdsl.dsl.helpers.BuildParametersContext.activeChoiceReactiveParam
    }

//  Récupérer sur Git la branche à utiliser pour faire le contrôle de code
    scm {
        git {
            remote {
                url('https://github.com/eleongithub/doctolib-jobs-jenkins.git')
            }
            branch('${branch}')
        }
    }

    steps {
        shell(readFileFromWorkspace('scripts/DB_ANSIBLE_LINT_BRANCH/ansible_lint.sh'))
    }
}
DbUtils.defaultWrappersPolicy(job)
DbUtils.defaultLogRotatorPolicy(job)