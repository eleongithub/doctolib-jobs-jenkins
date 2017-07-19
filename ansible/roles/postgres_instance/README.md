postgres_instance
=========

postgres_instance adds users, databases and schemas to PostgreSQL.

Requirements
------------

None.

Role Variables
--------------

| Name	        | Default Value	| Description|
| ------------- |:-------------:| ----------:|
|postgres_instance_version|9.4| PostgreSQL version|
|postgres_instance_conf_dir|/etc/postgresql/9.4/main|Directory of configuration file|
|postgres_instance_pg_hba_conf_file|/etc/postgresql/9.4/main/pg_hba.conf|Authorization/Connexion config file|
|dbs|-|List of users, databases and schemas.|
|vault_db_apps_password|-|Database password stored by ansible-vault (Look at password-{{env}}.yml).|
|vault_db_apps1_password|-|Database password stored by ansible-vault (Look at password-{{env}}.yml).|

More informations about variables [here.](https://github.com/eleongithub/ansible/blob/it_1/projects/roles/postgres_instance/defaults/main.yml)


Dependencies
------------

None.

Example Playbook
----------------

Install postgres_instance
```yaml
- hosts: servers
  roles:
    - { role: postgres_instance }
```

License
-------

BSD

Author Information
------------------

Eric LEGBA.