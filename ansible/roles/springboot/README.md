springboot
=========

Install Spring Boot application.

Requirements
------------

None.

Role Variables
--------------

| Name	        | Default Value	| Description|
| ------------- |:-------------:| ----------:|
|springboot_user|springboot|Spring Boot user.|
|springboot_group|springboot|Spring Boot group.|
|springboot_main_directory|/opt/springboot|Spring Boot main directory|
|springboot_conf_directory|/opt/springboot/conf|Configuration directory.|
|springboot_logs_directory|/opt/springboot/logs|Logs directory.|
|springboot_nexus_url|-|Nexus API URL where download Spring Boot application.|
|springboot_apps_repository|-|Maven - Spring Boot application Nexus Repository.|
|springboot_apps_groupid|-|Maven - Spring Boot application Group Id.|
|springboot_apps_artifactid|-|Maven - Spring Boot application Artifact Id.|
|springboot_apps_version|-|Maven - Spring Boot application version.|
|springboot_apps_package|jar|Maven - Spring Boot application type package.|
|springboot_apps_conf_files|-|Spring Boot application - List of configurations file.|
|springboot_port|9000|Spring Boot application web port.|
|springboot_iptables_enabled|False|If `True`, open `spring_boot_port` by iptables.|
|springboot_network_interface|eth0|Netwaork interface where iptables rule will be apply.|

Dependencies
------------
None.

Example Playbook
----------------

    - hosts: servers
      roles:
         - { role: springboot }

License
-------

BSD

Author Information
------------------

Eric LEGBA.