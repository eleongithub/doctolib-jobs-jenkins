import utilities.DbUtils

// Job de déplpoiement de l'application sur un environnement cible (Dev, Recette, Pré-production, Production)
def job = freeStyleJob('DB_DEPLOIEMENT'){

    //    Définir le JDK par défaut

    // Description du job.
    description('Ce job permet de déployer une version (Snapshot ou Release) de l\'application sur un environnement cible (Dev, Recette, Pré-production, Production)')

    environmentVariables(vaultPassword: 'test')

//    Définir les paramètres du Job
    parameters {
        booleanParam('debug', true, 'Exécuter le job en mode Debug.')
        choiceParam('environment', ['dev', 'qualif', 'prod'], 'Environnement cible de déploiement.')
        choiceParam('repository', ['snapshots', 'releases'], 'Repository (Snapshots/Releases) sur lequel seront téléchargés des livrables')
        stringParam('branch', 'master', 'Branche à utiliser pour effectuer le deploiement')
        stringParam('dbVersion', '', 'Version de l\'application à déployer.')
        booleanParam('installComplete', false, 'Installation complete des rôles du playbook.')
        booleanParam('firewall', false, 'Installation du firewall iptables.')
        booleanParam('jdk', false, 'Installation du JDK 1.8.')
        booleanParam('postgres', false, 'Installation du serveur PostgreSQL.')
        booleanParam('postgres_instance', false, 'Installation de(s) instance(s) de base de données.')
        booleanParam('springboot', false, 'Installation de springboot.')
//        nonStoredPasswordParam('vaultPassword', 'Mot de passe pour décrypter les variables sécurisées avec Ansible-vault.')
    }

    //    Récupérer sur Git la branche à utiliser pour faire le deploiement
    scm {
        git {
            remote {
                url('https://github.com/eleongithub/doctolib-jobs-jenkins.git')
            }
            branch('${branch}')
            extensions{
                localBranch('${branch}')
            }
        }
    }

    steps {
        shell(readFileFromWorkspace('scripts/DB_DEPLOIEMENT/db_deploy.sh'))
    }
//    TODO Envoyer un mail de notification à la fin du release
}
DbUtils.defaultWrappersPolicy(job)
DbUtils.defaultLogRotatorPolicy(job)

// À activer avec parcimonie. Il arrive parfois qu'on ait besoin de regarder le fichiers du workspace pour comprendre une erreur; un echec.
// DbUtils.defaultPublishers(job)
