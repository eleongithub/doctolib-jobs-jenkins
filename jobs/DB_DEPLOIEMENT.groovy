import utilities.DbUtils

// Job de déplpoiement de l'application sur un environnement cible (Dev, Recette, Pré-production, Production)
def job = freeStyleJob('DB_DEPLOIEMENT'){

    //    Définir le JDK par défaut

    // Description du job.
    description('Ce job permet de déployer une version (Snapshot ou Release) de l\'application sur un environnement cible (Dev, Recette, Pré-production, Production)')


//    Définir les paramètres du Job
    parameters {
        choiceParam('environment', ['dev', 'qualif', 'prod'], 'Environnement cible de déploiement')
        choiceParam('repository', ['snapshots', 'releases'], 'Repository des livrables')
        stringParam('dbVersion', '', 'Version à déployer.')
        booleanParam('installComplete', false, 'Installation complete des rôles du playbook')
        booleanParam('iptables', false, 'Installation du firewall iptables')
        booleanParam('jdk', false, 'Installation du JDK 1.8')
        booleanParam('postgres', false, 'Installation du serveur PostgreSQL')
        booleanParam('postgres_instance', false, 'Installation de(s) instance(s) de base de données')
        booleanParam('springboot', false, 'Installation de springboot')
        nonStoredPasswordParam('vaultPassword', 'Password to decrypt vault variables')
        booleanParam('debug', true, 'Exécuter le job en mode Debug')
    }

    steps {
        shell(readFileFromWorkspace('scripts/DB_DEPLOIEMENT/init_job.sh'))
    }
//    TODO Envoyer un mail de notification à la fin du release
}
DbUtils.defaultWrappersPolicy(job)
DbUtils.defaultLogRotatorPolicy(job)
