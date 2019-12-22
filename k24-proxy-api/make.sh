#!/bin/bash

echo "执行部署"

PROJECT_PWD=`pwd`
echo "$PWD"
mvn clean >> log.log 2>&1
mvn install -Dmaven.test.skip=true >> log.log 2>&1

echo '已部署。'
