@echo off 
echo JAVA_HOME is %JAVA_HOME%
echo SCALA_HOME is %SCALA_HOME%
set arg1=%1
echo ****Answer****
scala -cp ./target/sudoku-1.0-SNAPSHOT.jar com.test.App %arg1%