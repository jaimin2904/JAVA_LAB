@echo off
if not exist out mkdir out
if exist sources.txt del sources.txt
for /r src\main\java %%f in (*.java) do echo %%f>>sources.txt
javac --release 17 -d out @sources.txt
if errorlevel 1 exit /b 1
if not exist manifest.mf echo Main-Class: com.minibank.MiniBank>manifest.mf
jar cfm MiniBank.jar manifest.mf -C out .
echo Created MiniBank.jar
