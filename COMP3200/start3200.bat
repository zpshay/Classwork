@echo off

rem    COMP 3200 Students
rem    ----------------
rem    You'll need to make one change to this file in order to use JFlex
rem    and CUP.  Define the JFLEX_CUP_HOME environment variable below to
rem    be the base directory in which you extracted the JFlex_CUP.zip
rem    archive.
rem
rem    For example, if you extracted the Zip to the folder C:\JFlex_CUP,
rem    you'd want to change the line below to this:
rem
set JFLEX_CUP_HOME=C:\Users\Zachary\Documents\School\COMP3200\


set JFLEX_CUP_HOME=C:\Users\Zachary\Documents\School\COMP3200\


rem    You should be able to leave the rest of this file alone.

set JFLEX_HOME=%JFLEX_CUP_HOME%\JFlex

set CLASSPATH=%JFLEX_CUP_HOME%\Java_cup\;%CLASSPATH%
set PATH=%JFLEX_HOME%\bin\;%PATH%
