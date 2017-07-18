sudo_users
=========

sudo_users configures technical user for deployment

Requirements
------------

None.

Role Variables
--------------


| Name	        | Default Value	| Description|
| ------------- |:-------------:| ----------:|
|user_name|deploy|Technical account for deployment.|
|user_comment|Technical user for deployment|Comment on creation account|
|user_password|*****|User's password|
|user_public_ssh_key|******|SSH public key.|

More informations about variables [here.](https://github.com/eleongithub/ansible/blob/it_1/projects/roles/sudo_users/defaults/main.yml)

Dependencies
------------

None.

Example Playbook
----------------

Install sudo_users
```yaml
- hosts: servers
  roles:
    - { role: sudo_users }
    - { role: sudo_users, user_name: "deploy_user", user_password: "******", user_public_ssh_key: "ssh-rsa AAAAB3NzaC1*********" }
```

License
-------

BSD

Author Information
------------------

Eric LEGBA.