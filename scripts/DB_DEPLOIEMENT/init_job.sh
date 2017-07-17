# On utilise set +x pour ne pas afficher les commandes sur la console
set +x
echo "Hello World !! We begin deployment of application doctolib !!"
echo "Name of the current diurectory"
pwd
echo "List of files in the current directory"
ls -lrt
echo "variables values"

echo "environnement cible : ${environment}"
echo "Repository choisi : ${repository}"
echo "Version de l'application à déployer : ${dbVersion}"
echo "Instalation complète : ${installComplete}"
echo "Instalation du firewall avec iptables : ${iptables}"

echo "Current user"
whoami