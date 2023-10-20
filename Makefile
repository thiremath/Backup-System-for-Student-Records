run:
	ant -buildfile backupSystem_StudentRecords/src/build.xml clean
	ant -buildfile backupSystem_StudentRecords/src/build.xml all
	ant -buildfile backupSystem_StudentRecords/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=2 -Darg4=1
	ant -buildfile backupSystem_StudentRecords/src/build.xml clean