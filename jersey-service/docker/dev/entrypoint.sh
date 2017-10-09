#!/bin/bash

while ! nc -q 1 database 3306 </dev/null; do sleep 3; done
# while ! nc -q 1 db-solr 8983 </dev/null; do sleep 3; done

echo ""
echo "------------------------------"
echo "----- Database connected -----"
echo "------------------------------"
echo ""

sudo chown www-data:www-data -R /var/www/html/app/tmp
sudo chown www-data:www-data -R /var/www/html/app/webroot/files

echo ""
echo "--------------------------------"
echo " Virtual Marchine ready to work "
echo "--------------------------------"
echo ""

exec "$@"
