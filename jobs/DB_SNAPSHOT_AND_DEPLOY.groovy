import utilities.Version
import utilities.DbUtils

// Super-Job qui lance un snapshot et un déploiement de l'application
def job = freeStyleJob('DB_SNAPSHOT_AND_DEPLOY') {
    description('Ce job réalise un snapshot et un déploiement sur un serveur.')

//    Définir les paramètres du Job
    parameters {
        stringParam('branch', 'master', 'Branche à utiliser pour effectuer le snapshot')
        stringParam('branchAnsible', 'master', 'Branche Ansible à utiliser pour effectuer le déploiement')
        stringParam('dbVersion', '1.0.0-SNAPSHOT', 'Version de l\'application.')
        booleanParam('debug', true, 'Exécuter le job en mode Debug.')
        choiceParam('environment', ['dev', 'qualif', 'prod'], 'Environnement cible de déploiement.')
        choiceParam('repository', ['snapshots', 'releases'], 'Repository (Snapshots/Releases) sur lequel seront téléchargés des livrables')
    }

//    Définir le JDK par défaut

    steps {
        downstreamParameterized {
            trigger('DB_SNAPSHOT_BRANCH') {
                block {
                    buildStepFailure('FAILURE')
                    failure('FAILURE')
                    unstable('UNSTABLE')
                }
                parameters {
                    currentBuild()
                    predefinedProp('branch', '$branch')
                }
            }
        }
//        Ce 2eme job sera exécuté si et seulement si le 1er job s'est déroulé avec succès
        downstreamParameterized {
            trigger('DB_DEPLOIEMENT') {
                block {
                    buildStepFailure('FAILURE')
                    failure('FAILURE')
                    unstable('UNSTABLE')
                }
                parameters {
                    currentBuild()
                    predefinedProp('debug', 'true')
                    predefinedProp('environment', '$environment')
                    predefinedProp('repository', '$repository')
                    predefinedProp('branch', '$branchAnsible')
                    predefinedProp('dbVersion', '$dbVersion')
                    predefinedProp('installComplete', 'true')
                }
            }
        }

    }
    //    TODO Envoyer un mail de notification à la fin du release
}
DbUtils.defaultWrappersPolicy(job)
DbUtils.defaultLogRotatorPolicy(job)

// À activer avec parcimonie. Il arrive parfois qu'on ait besoin de regarder les fichiers du workspace pour comprendre une erreur; un echec.
// DbUtils.defaultPublishers(job)