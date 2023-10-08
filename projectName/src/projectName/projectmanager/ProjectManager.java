package projectName.projectmanager;

//import projectName.algorithm.Algorithm;
import projectName.algorithm.BSTBuilder;
//import projectName.results.Results;
import projectName.utils.ExceptionHandler;
import projectName.utils.FileProcessor;

public class ProjectManager implements ProjectManagerInterface{
    private FileProcessor inputFileProcessor ;
    String InputFile ;
    String OutputFile ;
    String errorLogFile ;
    int Debug_Level ;
    int Update_Value ;

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
    }

    @Override
    public void run() {
        //Algorithm algorithm = new Algorithm(inputFileProcessor) ;
        //algorithm.Compute() ;
        //Results results = new Results(algorithm.result) ;
        //results.writetoFile(OutputFile);
        BSTBuilder bst = new BSTBuilder() ;
        bst.insertNodes() ;
        bst.printTrees();
        System.out.println("**** Update_Value and print tree ****");
        bst.updateTree(Update_Value) ;
        bst.printTrees();
    }
}
