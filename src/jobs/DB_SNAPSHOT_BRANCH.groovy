def job = mavenJob('DB_SNAPSHOT_BRANCH'){

//  Vider le repertoire de travail avant de lancer le build maven
    wrappers {
        preBuildCleanup()
    }

    //    Définir le JDK par défaut

    // Description du job.
    description('Ce job permet de lancer un snapshot de lapplication doctolib')


//    Définir les paramètres du Job
    parameters {
        stringParam('branch', 'master', 'Branche à utiliser pour effectuer le snapshot')
        // TODO - à integrer plus tard !!
//        http://www.nachum234.com/automation/jenkins/dynamically-list-git-branches-in-jenkins-parameter/
//        activeChoiceReactiveParam('CHOICE-1') {
//            description('Allows user choose from multiple choices')
//            filterable()
//            choiceType('SINGLE_SELECT')
//            groovyScript {
//                script('tags = []\n' +
//                        'text = "get_git_branches.sh https://user:pass@bitbucket.org/project/repo_name.git".execute().text\n' +
//                        'text.eachLine { tags.push(it) }\n' +
//                        'return tags')
//            }
//            referencedParameter('BOOLEAN-PARAM-1')
//            referencedParameter('BOOLEAN-PARAM-2')
//        }
    }

//    Récupérer sur Git la branche à utiliser pour faire le snapshot
    scm {
        git {
            remote {
                url('https://github.com/eleongithub/doctolib.git')
            }
            branch('${branch}')
        }
    }

    goals('clean deploy')
    properties skipTests: true

}