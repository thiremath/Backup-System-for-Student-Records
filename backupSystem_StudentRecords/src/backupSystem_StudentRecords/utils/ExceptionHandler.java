package backupSystem_StudentRecords.utils;
import backupSystem_StudentRecords.results.Results;

public class ExceptionHandler {

    public static Results errorLogProcessor;
    public static String errorLogFilePath ;

    public static void handleException(Exception eIn, String eMsgIn){

        String eMsg;
        if (eMsgIn.isEmpty()){
            eMsg = eIn.getMessage();
        }
        else {
            eMsg = eMsgIn;
        }

        String eString = "EXCEPTION: " + eMsg;
        if (errorLogProcessor != null) {
            errorLogProcessor.writetoFile(errorLogFilePath);
            errorLogProcessor.writeToConsole(eString);
        }
        else {
            System.out.println(eString);
        }

        if (eIn != null){
            eIn.printStackTrace();
        }
        
        System.exit(0);
    }
}