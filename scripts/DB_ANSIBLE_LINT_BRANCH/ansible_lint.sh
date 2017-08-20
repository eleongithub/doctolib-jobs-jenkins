#!/bin/bash
# On utilise set +x pour ne pas afficher les commandes sur la console
set +x
set -e
echo "####################################"
echo "=========== Ansible-lint - Contrôle du code ansible écrit sur la branche $branch======="
echo "####################################"

export ANSIBLE_FORCE_COLOR="true"
export ANSIBLE_HOST_KEY_CHECKING="False"
export ANSIBLE_KEEP_REMOTE_FILES=1

echo -n "Current directory : ";pwd
echo -n "Current user : "; whoami
cd ansible

ansible-lint playbook.yml

echo "=========== Ansible-lint - Fin de contrôle ======="