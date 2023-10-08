package projectName.utils;

// import java.io.File;
// import java.io.FileNotFoundException;
//import java.util.ArrayList;
// import java.util.Scanner;

public class FileProcessor implements FileProcessorInterface{

    public static String InputFile; 
    String OutputFile;
    String errorLogFile; 
    int Debug_Level;
    int Update_Value;

    public FileProcessor(String InputFileIn, String OutputFileIn, String errorLogFileIn, int Debug_LevelIn, int Update_ValueIn){
        InputFile = InputFileIn ;
        OutputFile = OutputFileIn ;
        errorLogFile = errorLogFileIn ;
        Debug_Level = Debug_LevelIn ;
        Update_Value = Update_ValueIn ;
    }

    @Override
    public void readFile(String FilePathIn) {
        // String[] arraStrings ;
        // try {
        //     File myObj = new File(FilePathIn);
        //     Scanner myReader = new Scanner(myObj);
        //     if(myReader.hasNextLine()){
        //         String data = myReader.nextLine();
        //         data = data.replace(";","") ;
        //         arraStrings = data.split(":",2) ;
        //     }
            
        // } catch (FileNotFoundException e) {
        //     System.out.println("Unable to read the courseInfo file.");
        //     e.printStackTrace();
        //     System.exit(0);
        //   }
    }
    
}
