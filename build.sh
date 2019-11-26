#!/usr/bin/env bash
cd `dirname $0`
currentDir=`pwd`

#mvn install

cd plt-bas
mvn install

cd ../plt-api
mvn install

cd ../plt-admin
#更新版本信息
sed -i 's/app.version=\([^.]*\).*/app.version=\1.'$(date +%g.%m%d.%H%M)'/g' src/main/resources/config.properties

mvn clean package



