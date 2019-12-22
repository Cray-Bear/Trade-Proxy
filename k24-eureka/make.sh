#!/bin/bash

echo "执行部署"
PROJECT_PWD=`pwd`
echo "$PWD"

#PID
PROJECT_PID=`ps -x | grep "java" | grep 'k24-dot-eureka'  | awk '{print $1}'`

if [ -n "$PROJECT_PID" ];
    then
        echo ${PROJECT_PID}
        kill -9 ${PROJECT_PID}
fi

mvn clean >> log.log 2>&1
mvn package -Dmaven.test.skip=true >> log.log 2>&1
cd target/
java -Xms128m -Xmx256m -jar k24-dot-eureka-0.0.1-SNAPSHOT.jar >> log.log 2>&1 &
cd -

echo '已部署。'
