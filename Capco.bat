@echo off 
echo JAVA_HOME is %JAVA_HOME%
set arg1=%1
echo ****Answer****
java -cp ./sudoku-1.0-SNAPSHOT.jar com.capco.test.Sudoku %arg1%