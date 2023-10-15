package backupSystem_StudentRecords.results;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import backupSystem_StudentRecords.utils.ExceptionHandler;

public class Results implements ResultsInterface {
    StringBuilder results ;
    public Results(StringBuilder resultIn){
        results = resultIn ;
    }

    @Override
    public void writeToConsole(String strIn) {
        try{
        String errorLogPath = System.getProperty("user.dir")+"/"+"errorLog.txt" ;
        File file = new File(errorLogPath) ;
        FileWriter fileWriter = new FileWriter(file,true) ;
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) ;
        bufferedWriter.write(strIn);
        bufferedWriter.write("\n") ;
        bufferedWriter.close();
        }
        catch(Exception eIn){
            ExceptionHandler.handleException(eIn, "");
        }
    }

    @Override
    public void writetoFile(String OutputFileIn) {
        try{
            File file = new File(OutputFileIn) ;
            FileWriter fileWriter = new FileWriter(file) ;
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) ;
            String s = String.valueOf(results) ;
            bufferedWriter.write(s);
            bufferedWriter.close();
        }
        catch(Exception eIn){
            ExceptionHandler.handleException(eIn, "");
        }
    }

}