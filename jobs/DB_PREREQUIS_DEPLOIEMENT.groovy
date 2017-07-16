import utilities.DbUtils

// Job pré-requis pour déplpoyer l'application sur un environnement (Dev, Recette, Pré-production, Production)
def job = freeStyleJob('DB_PREREQUIS_DEPLOIEMENT'){

    // Description du job.
    description('Ce job permet de créer les pré-requis avant de  déployer une version de l\'application sur un environnement (Dev, qualif, Prod)')

    environmentVariables {
        env('vaultPassword', 'test')
    }

//    Définir les paramètres du Job
    parameters {
        stringParam('branch', 'master', 'Branche Ansible à utiliser pour effectuer le pre-requis')
        choiceParam('environment', ['dev', 'qualif', 'prod'], 'Environnement cible de déploiement')
        nonStoredPasswordParam('vaultPassword', 'Password to decrypt vault variables')
        booleanParam('debug', true, 'Exécuter le job en mode Debug')
    }

    //    Récupérer sur Git la branche Ansible à utiliser pour faire les pre-requis
    scm {
        git {
            remote {
                url('https://github.com/eleongithub/doctolib-ansible.git')
            }
            branch('${branch}')
        }
    }

    steps {
        shell(readFileFromWorkspace('scripts/DB_PREREQUIS_DEPLOIEMENT/run_prerequis.sh'))
    }
}
DbUtils.defaultWrappersPolicy(job)
DbUtils.defaultLogRotatorPolicy(job)
