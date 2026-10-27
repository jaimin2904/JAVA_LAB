@echo off
if exist sources.txt del sources.txt
if not exist out mkdir out
for /r src\main\java %%f in (*.java) do echo %%f>>sources.txt
javac --release 17 -d out @sources.txt
if errorlevel 1 exit /b 1
java -cp out com.minibank.MiniBank
