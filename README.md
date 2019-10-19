# Escola
# Configuração do JAAS e Data Source
Repositório dos projetos utilizados como exemplo na disciplina de Desenvolvimento de Aplicações Web II no curso técnico integrado em informática do IFPB Campus Esperança.

- NÃO implante a aplicação ainda antes de realizar todas essas configurações;
- Certifique-se que o Wildfly está executando;
- As configurações serão feitas via linha de comando. Para isso, acessem a pasta "<WILDFLY_HOME>\bin" e executem o seguinte comando: **jboss-cli.bat**



Ou no Linux: **./jboss-cli.sh**

- Execute os seguintes comandos: connect

-   No Windows:
____
module add --name=org.postgres --resources=C:\Users\Aluno\.m2\repository\org\postgresql\postgresql\9.4.1212\postgresql-9.4.1212.jar --dependencies=javax.api,javax.transaction.api
____

-   Ou no Linux: 
_____
module add --name=org.postgres --resources=/home/arthurmts/.m2/repository/org/postgresql/postgresql/9.4.1212/postgresql-9.4.1212.jar --dependencies=javax.api,javax.transaction.api
_____



- A partir daqui os comandos funcionam para os dois sistemas: 
____
/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres", driver-module-name="org.postgres", driver-class-name="org.postgresql.Driver")
____

____
/subsystem=datasources/data-source=PostgreSQLPool:add(driver-name="postgres", jndi-name="java:/escolaDS", connection-url="jdbc:postgresql://localhost:5432/Escola", user-name="postgres", password="postgres")
____


____
/subsystem=security/security-domain=escolaJdbcRealm/:add(cache-type=default)
____

____
/subsystem=security/security-domain=escolaJdbcRealm/authentication=classic:add(login-modules=[{code=Database, flag=Required, module-options={ \
    dsJndiName="java:/escolaDS", \
    principalsQuery="select senha from professor where login = ?", \
    rolesQuery="select 'PROF', 'Roles' from professor where login = ?", \
    hashAlgorithm="SHA-256", \
    hashEncoding="base64" \
}}])
____

____
reload
____

____
quit
____
