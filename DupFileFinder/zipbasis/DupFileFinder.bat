@echo off

setlocal

set APP_JAR=DupFileFinder-0.1.0-SNAPSHOT.jar

rem start /B javaw --module-path lib --add-modules java.prefs,javafx.base,javafx.graphics,javafx.controls,javafx.fxml -jar %APP_JAR%
rem java --module-path lib --add-modules java.desktop,java.logging,javafx.base,javafx.graphics,javafx.controls,javafx.fxml,util -jar %APP_JAR%
start /B javaw --module-path lib -jar %APP_JAR%

endlocal