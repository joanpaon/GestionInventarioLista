@echo off
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=CP1252 -Dsun.stdout.encoding=CP850 -Dsun.stderr.encoding=CP850 -Dconsole.encoding=CP850
cd dist
java -jar 01-GestionInventario.jar JAPO-Omicron-0