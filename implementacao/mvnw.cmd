@REM ----------------------------------------------------------------------------
@REM Maven Wrapper Startup script for Windows (safe for spaces)
@REM ----------------------------------------------------------------------------
@echo off
setlocal

set "DIRNAME=%~dp0"
if "%DIRNAME%"=="" set "DIRNAME=."
set "MAVEN_PROJECTBASEDIR=%DIRNAME%"
set "WRAPPER_JAR=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
set "WRAPPER_PROPERTIES=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.properties"
set "WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain"

REM ---- localizar java (JAVA_HOME ou PATH) ----
set "JAVA_EXE="
if defined JAVA_HOME (
  set "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
  if exist "%JAVA_EXE%" goto haveJava
)
where java >NUL 2>&1
if %ERRORLEVEL% EQU 0 (
  for /f "delims=" %%J in ('where java') do set "JAVA_EXE=%%~fJ"
) else (
  echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
  goto error
)

:haveJava
if not exist "%WRAPPER_JAR%" (
  echo ERROR: Maven wrapper JAR not found at "%WRAPPER_JAR%"
  goto error
)

REM ---- executar wrapper (com -cp, aspas e -Dmaven.multiModuleProjectDirectory) ----
"%JAVA_EXE%" ^
  -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" ^
  -cp "%WRAPPER_JAR%" ^
  %WRAPPER_LAUNCHER% %*
set "CODE=%ERRORLEVEL%"
endlocal & exit /b %CODE%

:error
endlocal & exit /b 1
