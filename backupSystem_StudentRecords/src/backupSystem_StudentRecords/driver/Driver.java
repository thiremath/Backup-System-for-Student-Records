package backupSystem_StudentRecords.driver;

import backupSystem_StudentRecords.projectmanager.ProjectManager;
import backupSystem_StudentRecords.utils.ExceptionHandler;

public class Driver {
    public static void main(String[] args) {
        
        if (args.length != 5) {
            String errorMessage = "Error: Incorrect number of arguments. Program accepts 4 arguments.";
            ExceptionHandler.handleException(null, errorMessage);
        }
        ProjectManager projectManager = new ProjectManager(args[0], args[1], args[2],args[3],args[4]);
        projectManager.run();
    }
}
