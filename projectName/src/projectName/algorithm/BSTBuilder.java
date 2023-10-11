package projectName.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import projectName.projectmanager.ProjectManager;
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
        FileProcessor fp = ProjectManager.inputFileProcessor ;
        while(!fp.isfileParsed){

            String[] arraStrings = fp.readLine();
            b_Number = Integer.parseInt(arraStrings[0]) ;
            NodeImpl insertedmainNode = main_BST.insert(b_Number, arraStrings[1]);
            NodeImpl insertedbackup1Node = backup_1.insert(b_Number, arraStrings[1]);
            NodeImpl insertedbackup2Node = backup_2.insert(b_Number, arraStrings[1]);
            NodeImpl insertedbackup3Node = backup_3.insert(b_Number, arraStrings[1]);
            Filter f1 = new Filter(fAll,null) ;
            Filter f2 = new Filter(null,fP) ;
            insertedmainNode.registerObserver(insertedbackup1Node,f1);
            insertedmainNode.registerObserver(insertedbackup2Node,f1);
            insertedmainNode.registerObserver(insertedbackup3Node,f2);

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

    public void printSum(){
        int main_BST_Sum = main_BST.Sum() ;
        System.out.println("Main tree Sum "+ main_BST_Sum);
        int backup_1_sum = backup_1.Sum() ;
        System.out.println("b1 Tree Sum "+ backup_1_sum);
        int backup_2_sum = backup_2.Sum() ;
        System.out.println("b2 Tree Sum "+backup_2_sum);
        int backup_3_sum = backup_3.Sum() ;
        System.out.println("b3 Tree Sum "+backup_3_sum);
    }
    
}
