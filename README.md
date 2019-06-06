# jee6-training

Required:
- Mysql server 5.1 (pwd: Titkos123)
    - Databases:
        - iqjb2a
        - iqjb2b
        - iqjblogger
- Glassfish 4

IDE:
- Netbeans 8.2
- MysqlWorkbench

Add JNDI resources to Glassfish from commandline:
c:\glassfish4\bin>asadmin add-resources "C:\Training\jee6-training\server1\server1-ejb\src\main\resources\META-INF\backup\glassfish-resources.xml"

https://gitlab.com/avincze73/iqjb-20190603