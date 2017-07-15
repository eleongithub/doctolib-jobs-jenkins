
// Job de création d'une version de release stable de l'application et upload des livrables sur le repository Nexus
def job = mavenJob('DB_RELEASE'){

//  Vider le repertoire de travail avant de lancer un nouveau build
    wrappers {
        colorizeOutput()
        preBuildCleanup()
    }

    //    Définir le JDK par défaut

    // Description du job.
    description('Ce job permet de créer une version release stable de l\'application doctolib')


//    Définir les paramètres du Job
    parameters {
        stringParam('branch', 'master', 'Branche à utiliser pour effectuer la release')
//        TODO - à integrer liste dynamique des branches. Example : http://www.nachum234.com/automation/jenkins/dynamically-list-git-branches-in-jenkins-parameter/
//        TODO - https://jenkinsci.github.io/job-dsl-plugin/#method/javaposse.jobdsl.dsl.helpers.BuildParametersContext.activeChoiceReactiveParam
        stringParam('releaseVersion', '', 'Version de release à produire.') // TODO - How to make this string param validating input ?
        stringParam('developmentVersion', '', 'Version de developpement à initialiser après le release') // TODO - How to make this string param validating input ?


    }

//    Récupérer sur Git la branche à utiliser pour faire le snapshot
    scm {
        git {
            remote {
                url('https://github.com/eleongithub/doctolib.git')
            }
            branch('${branch}')
            extensions{
                localBranch('${branch}')
            }
        }
    }
//    Liste des goals pour réaliser la release
    goals('release:clean release:prepare release:perform clean -Darguments="-DskipTests"')
    mavenInstallation('Maven 3.3.9')
//    steps {
//        maven {
//            goals('release:clean release:prepare release:perform clean -Darguments="-DskipTests"')
//            mavenInstallation('Maven 3.3.9')
//        }

//        maven {
//            goals('release:prepare -Darguments="-DskipTests"')
//            mavenInstallation('Maven 3.3.9')
//        }
//
//        maven {
//            goals('release:perform -Darguments="-DskipTests"')
//            mavenInstallation('Maven 3.3.9')
//        }
//        maven {
//            goals('clean')
//            mavenInstallation('Maven 3.3.9')
//        }
//    }

}