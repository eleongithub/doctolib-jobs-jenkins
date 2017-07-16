# On utilise set +x pour ne pas afficher les commandes sur la console
set +x
set -e
export ANSIBLE_FORCE_COLOR="true"
export ANSIBLE_HOST_KEY_CHECKING="False"
export ANSIBLE_KEEP_REMOTE_FILES=1

echo "==== Begin Pre-Requis tasks on environment ${environment} ===="
echo "Current directory"
pwd

# Debug options
debug_option=""
if [ "${debug}" == "true" ]; then
    debug_option="-vvvv"
fi

echo "-- Ansible version --"
ansible --version
echo "---------------------"

if [ -n "${vaultPassword}" ]; then
    vaultPwd="${vaultPassword}"
else
    vaultPwd="test"
fi

echo ${vaultPwd} > vault_passwprd.txt
ansible-playbook --vault-password-file vault_passwprd.txt -i inventory/${environment}/hosts.yml -e "env=${environment}" prerequis.yml ${debug_option}
rm vault_passwprd.txt

echo "==== End Pre-Requis tasks on environment ${environment} ===="
