import utilities.DbUtils

// Job de déplpoiement de l'application sur un environnement cible (Dev, Recette, Pré-production, Production)
def job = freeStyleJob('DB_DEPLOIEMENT'){

    //    Définir le JDK par défaut

    // Description du job.
    description('Ce job permet de déployer une version (Snapshot ou Release) de l\'application sur un environnement cible (Dev, Recette, Pré-production, Production)')


//    Définir les paramètres du Job
    parameters {
        choiceParam('environment', ['Dev(default)', 'Recette', 'Intmoa'], 'Environnement cible de déploiement')
        choiceParam('repository', ['Snapshots(default)', 'Releases'], 'Repository des livrables')
        stringParam('dbVersion', '', 'Version à déployer.')
        booleanParam('installComplete', false, 'Installation complete des roles du playbook')
        booleanParam('firewall', false, 'Installation du firewall')
    }

    steps {
        shell(readFileFromWorkspace('scripts/DB_DEPLOIEMENT/init_job.sh'))
    }
//    TODO Envoyer un mail de notification à la fin du release
}
DbUtils.defaultWrappersPolicy(job)
DbUtils.defaultLogRotatorPolicy(job)
