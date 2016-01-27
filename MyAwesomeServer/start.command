#!/bin/sh
cd "$( dirname "$0" )"
exec java -Xmx1G -Xms1G -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -jar ./spigot-1.8.8.jar