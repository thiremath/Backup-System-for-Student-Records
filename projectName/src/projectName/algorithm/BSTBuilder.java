package projectName.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import projectName.utils.ExceptionHandler;
import projectName.utils.FileProcessor;

public class BSTBuilder {
    private BinarySearchTree main_BST ;
    private BinarySearchTree backup_1 ;
    private BinarySearchTree backup_2 ;
    private BinarySearchTree backup_3 ;
    int b_Number ;
    String InputFile;
    FilterAllImpl fAll = new FilterAllImpl() ;
    FilterPrimeImpl fP = new FilterPrimeImpl() ;
    public BSTBuilder(){
        main_BST = new BinarySearchTree() ;
        backup_1 = new BinarySearchTree() ;
        backup_2 = new BinarySearchTree() ;
        backup_3 = new BinarySearchTree() ;
        InputFile = FileProcessor.InputFile ;
    }

    public void insertNodes(){
        String[] arraStrings ;
        try {
            File myObj = new File(InputFile);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                data = data.replace(";","") ;
                arraStrings = data.split(":",2) ;
                
                try{
                b_Number = Integer.parseInt(arraStrings[0]) ;
                }
                catch(NumberFormatException e){
                ExceptionHandler.handleException(e,"") ;
                }

                Node insertedmainNode = main_BST.insert(b_Number, arraStrings[1]);
                Node insertedbackup1Node = backup_1.insert(b_Number, arraStrings[1]);
                Node insertedbackup2Node = backup_2.insert(b_Number, arraStrings[1]);
                Node insertedbackup3Node = backup_3.insert(b_Number, arraStrings[1]);
                Filter f1 = new Filter(fAll,null) ;
                Filter f2 = new Filter(null,fP) ;
                insertedmainNode.registerObserver(insertedbackup1Node,f1);
                insertedmainNode.registerObserver(insertedbackup2Node,f1);
                insertedmainNode.registerObserver(insertedbackup3Node,f2);
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read the courseInfo file.");
            e.printStackTrace();
            System.exit(0);
          }

    }

    public void updateTree(int updateValue){
        main_BST.update(updateValue) ;
    }

    public void printTrees(){
        System.out.println("-----Main Tree-----");
        main_BST.callinorder();
        System.out.println("-----b1 Tree-----");
        backup_1.callinorder();
        System.out.println("-----b2 Tree-----");
        backup_2.callinorder();
        System.out.println("-----b3 Tree-----");
        backup_3.callinorder();
    }
    
}
