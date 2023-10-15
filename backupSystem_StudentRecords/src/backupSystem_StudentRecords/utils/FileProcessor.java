package backupSystem_StudentRecords.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor implements FileProcessorInterface{

    public static String InputFile; 
    String OutputFile;
    String errorLogFile; 
    int Debug_Level;
    int Update_Value;
    public Boolean isfileParsed = false;
    File x ;
    Scanner s ;
    Pair pair = new Pair() ;


    public FileProcessor(String InputFileIn, String OutputFileIn, String errorLogFileIn, int Debug_LevelIn, int Update_ValueIn){
        InputFile = InputFileIn ;
        OutputFile = OutputFileIn ;
        errorLogFile = errorLogFileIn ;
        Debug_Level = Debug_LevelIn ;
        Update_Value = Update_ValueIn ;

        try{
            File myobj = new File(InputFile) ;
            Scanner myReader = new Scanner(myobj);
            if(!myReader.hasNextLine()){
                isfileParsed = true ;
            }
            x = myobj ;
            s = myReader ;
        }
        catch(FileNotFoundException e){
            System.out.println("Unable to read the courseInfo file.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public Pair readLine() {
            String[] arraStrings = new String[2];
            String data = s.nextLine();
            data = data.replace(";","") ;
            arraStrings = data.split(":",2) ;
            try{
                pair.b_Number = Integer.parseInt(arraStrings[0]) ;
            }
            catch(NumberFormatException e){
                ExceptionHandler.handleException(e,"") ;            
            }
            pair.Name = arraStrings[1] ;
            if(!s.hasNextLine()){
                isfileParsed = true ;
                s.close();
            }
            return pair ;
    }
    
}
