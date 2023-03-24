#!/bin/bash
max_iteration=10
for i in $(seq 1 $max_iteration)
do
    /opt/mssql-tools/bin/sqlcmd -S database -U SA -P 'Many2One!' -d master -i /opt/init-database/init-database.sql >& /dev/null
    result=$?
    if [[ $result -eq 0 ]]
    then
        echo "Database setup successful"
        break
    else
        echo "Database setup failed in iteration $i/$max_iteration"
        sleep 1
    fi
done
if [[ $result -ne 0 ]]
then
    echo "Database setup failed"
fi
