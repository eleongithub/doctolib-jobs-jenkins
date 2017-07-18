jdk
=========

Installation du Java Development Kit (JDK).

Requirements
------------

None.

Role Variables
--------------

jdk_java_version: 1.8.0_73
jdk_home: "/opt/jdk{{ jdk_java_version }}"
jdk_tarball_name_32: jdk-8u73-linux-i586.tar.gz
jdk_tarball_name_64: jdk-8u73-linux-x64.tar.gz
jdk_os_32: 32
jdk_os_64: 64
jdk_32_url: "{{ nexus_public_repository }}/com/oracle/jdk/{{ jdk_java_version }}/jdk-{{ jdk_java_version }}-{{ jdk_os_32 }}.tar.gz"
jdk_64_url: "{{ nexus_public_repository }}/com/oracle/jdk/{{ jdk_java_version }}/jdk-{{ jdk_java_version }}-{{ jdk_os_64 }}.tar.gz"


| Nom	        | Default Value  | Description|
| ------------- |:-------------:|-----------:|
|jdk_java_version|1.8.0_73|Version du JDK à installer.|
|jdk_home|/opt/jdk_1.8.0_73||Répertoire où est installé le JDK.|
|jdk_tarball_name_32|jdk-8u73-linux-i586.tar.gz|Archive `.gz` du JDK pour les machines 32 bits.|
|jdk_tarball_name_64|jdk-8u73-linux-x64.tar.gz|Archive `.gz` du JDK pour les machines 64 bits.|
|os_32|32|Architecture machine 32 bits.|
|os_64|64|Architecture machine 64 bits.|
|jdk_32_url|-|URL pour télécharger sur un repository Nexus le JDK pour une machine 32 bits.|
|jdk_64_url|-|URL pour télécharger sur un repository Nexus le JDK pour une machine 64 bits.|


Dependencies
------------

None.

Example Playbook
----------------

- hosts: servers
  roles:
     - { role: jdk }

License
-------

BSD

Author Information
------------------

Created in 2016 by Eric LEGBA.