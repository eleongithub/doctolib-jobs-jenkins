# On utilise set +x pour ne pas afficher les commandes sur la console
set +x
echo "Hello World !! We begin deployment of application doctolib !!"
echo "Name of the current diurectory"
pwd
echo "List of files in the current directory"
ls -lrt
echo "variables values"

echo "Mode debug : ${debug}"
echo "environnement cible : ${environment}"
echo "Repository choisi : ${repository}"
echo "Version de l'application à déployer : ${dbVersion}"
echo "Instalation complète : ${installComplete}"
echo "Instalation du firewall avec iptables : ${iptables}"
echo "Instalation du jdk : ${jdk}"
echo "Instalation postgres : ${postgres}"
echo "Instalation postgres_instance : ${postgres_instance}"
echo "Instalation springboot : ${springboot}"
echo "Mot de passe vault : ${vaultPassword}"

echo "Current user"
whoami