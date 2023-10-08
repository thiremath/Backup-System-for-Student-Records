run:
	ant -buildfile projectName/src/build.xml clean
	ant -buildfile projectName/src/build.xml all
	ant -buildfile projectName/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Dagr2=errorLog.txt -Darg3=2 -Darg4=1
	ant -buildfile projectName/src/build.xml clean