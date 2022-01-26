FROM store/oracle/database-enterprise:12.2.0.1-slim

RUN echo "sqlplus / as sysdba 2>&1 <<EOF" >> /home/oracle/setup/configDB.sh
RUN echo "create tablespace \$DBUSER DATAFILE 'data_01.dat' SIZE 20M AUTOEXTEND ON ONLINE;" >> /home/oracle/setup/configDB.sh
RUN echo "alter session set \"_ORACLE_SCRIPT\"=TRUE;" >> /home/oracle/setup/configDB.sh
RUN echo "create user \$DBUSER IDENTIFIED BY \$DBPASSWORD DEFAULT TABLESPACE \$DBUSER quota unlimited ON \$DBUSER TEMPORARY TABLESPACE temp quota unlimited ON system PROFILE default;" >> /home/oracle/setup/configDB.sh
RUN echo "grant connect, resource, create any context to \$DBUSER;" >> /home/oracle/setup/configDB.sh
RUN echo "alter user \$DBUSER quota unlimited on \$DBUSER;" >> /home/oracle/setup/configDB.sh
RUN echo "exit;" >> /home/oracle/setup/configDB.sh
RUN echo "EOF" >> /home/oracle/setup/configDB.sh
