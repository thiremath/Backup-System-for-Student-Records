package backupSystem_StudentRecords.projectmanager;

import backupSystem_StudentRecords.bstBuilder.BSTBuilder;
import backupSystem_StudentRecords.results.Results;
import backupSystem_StudentRecords.utils.ExceptionHandler;
import backupSystem_StudentRecords.utils.FileProcessor;

public class ProjectManager implements ProjectManagerInterface{
    public static FileProcessor inputFileProcessor ;
    String InputFile ;
    String OutputFile ;
    String errorLogFile ;
    int Debug_Level ;
    int Update_Value ;
    public static StringBuilder results = new StringBuilder() ;

    public ProjectManager(String InputFileIn, String OutputFileIn, String errorLogFileIn, String Debug_LevelIn, String Update_ValueIn){
        InputFile = System.getProperty("user.dir")+"/"+InputFileIn ;
        OutputFile = System.getProperty("user.dir")+"/"+OutputFileIn ;
        errorLogFile = System.getProperty("user.dir")+"/"+errorLogFileIn ;
        
        ExceptionHandler.errorLogFilePath = errorLogFile ;
        try{
            Debug_Level = Integer.parseInt(Debug_LevelIn) ;
            Update_Value = Integer.parseInt(Update_ValueIn) ;
        }
        catch(NumberFormatException e){
            ExceptionHandler.handleException(e,"") ;
        }

        inputFileProcessor = new FileProcessor(InputFile, OutputFile, errorLogFile, Debug_Level, Update_Value) ;

        Results.deleteFile(OutputFile) ;
        Results.deleteFile(errorLogFile) ;
    }

    public void writeToResults(String sIn){
        results.append(sIn) ;
    }

    @Override
    public void run() {
        BSTBuilder bstBuilder = new BSTBuilder() ;
        Results res = new Results() ;

        bstBuilder.insert() ;
        writeToResults("Inorder Traversal\n");
        bstBuilder.inorder();
        
        writeToResults("Sum of all the B-Numbers in each tree\n");
        bstBuilder.sum();

        bstBuilder.update(Update_Value) ;
        writeToResults("\n\nSum of all the B-Numbers after increment\n");
        bstBuilder.sum();

        res.writetoFile(OutputFile,results);
        System.out.println(results);
    }
}
