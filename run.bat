@echo off
cd /d D:\automation\Parabank.demo
echo Running Maven Tests.....
"D:\apache-maven-3.9.11\bin\mvn.cmd" clean test
pause