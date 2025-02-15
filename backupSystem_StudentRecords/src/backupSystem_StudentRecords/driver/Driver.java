package backupSystem_StudentRecords.driver;

import backupSystem_StudentRecords.projectmanager.ProjectManager;
import backupSystem_StudentRecords.utils.ExceptionHandler;

/**
 * The Driver class is the entry point for the backupSystem_StudentRecords application.
 * It validates the command-line arguments and initializes the ProjectManager to run the program.
 */
public class Driver {
    /**
     * The main method of the application.
     * It checks the number of arguments before initializing the ProjectManager.
     */
    public static void main(String[] args) {
        if (args.length != 5) {
            // If the number of arguments is not equal to 5, display an error message.
            String errorMessage = "Error: Incorrect number of arguments. Program accepts 5 arguments.";
            ExceptionHandler.handleException(null, errorMessage);
        } else if (args[0].equals("") || args[1].equals("") || args[2].equals("") || args[3].equals("") || args[4].equals("")) {
            // If any of the arguments is empty, display an error message.
            String errorMessage = "Empty Arguments!";
            ExceptionHandler.handleException(null, errorMessage);
        }

        // Create a new ProjectManager instance with the provided arguments and run the program.
        ProjectManager projectManager = new ProjectManager(args[0], args[1], args[2], args[3], args[4]);
        projectManager.run();
    }
}
