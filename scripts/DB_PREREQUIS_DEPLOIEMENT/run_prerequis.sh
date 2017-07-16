# On utilise set +x pour ne pas afficher les commandes sur la console
set +x
echo "==== Begin Pre-Requis tasks on environment ${environment} ===="
echo "Name of the current directory"
pwd
echo "List of files in the current directory"
ls -lrt

# Debug options

debug_option=""
if [ "${debug}" == "true" ]; then
    debug_option="-vvvv"
fi

echo "-- Ansible version --"
ansible --version
echo "---------------------"
echo $vaultPassword > vault_passwprd.txt
ansible-playbook --vault-password-file vault_passwprd.txt -i inventory/${environment}/hosts.yml -e "env=${environment}" prerequis.yml ${debug_option}
rm vault_passwprd.txt

echo "==== End Pre-Requis tasks on environment ${environment} ===="
