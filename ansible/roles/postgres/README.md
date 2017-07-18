postgres
=========

Le rôle postgres installe le serveur de base de données PostgreSQL et gère des configurations via les fichiers pg_hba.conf et postgresql.conf.

Role Variables
--------------

| Name	        | Default Value	| Description|
| ------------- |:-------------:| ----------:|
|postgres_version|9.4|Version de PostgreSQL à installer.|
|postgres_listen_addresses|*|Liste des adresses IP qui peuvent interroger la base de données.|
|postgres_server_pkg|postgresql-9.4|Nom du package du serveur PostgreSQL.|
|postgres_client_pkg|postgresql-client-9.4|Nom du package du client PSQL.|
|postgres_conf_files|postgresql.conf & pg_hba.conf|Liste des fichiers de configurations à déployer.|
|postgres_port|5432|Port d'écoute de la base de données.|
|postgres_iptables_enabled|True|Si `True`, ouverture du port `postgres_port` via iptables.|
|postgres_goss_enabled|False|Enable goss to check Postgres after installation|
|postgres_network_interface|eth0|Interface réseau sur lequel les règles Iptables seront appliquées.|

Dependencies
------------

None.

Example Playbook
----------------

- hosts: servers
  roles:
     - { role: postgres }

License
-------

BSD

Author Information
------------------

Eric LEGBA.