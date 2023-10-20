package backupSystem_StudentRecords.bstBuilder;

import backupSystem_StudentRecords.projectmanager.ProjectManager;
import backupSystem_StudentRecords.utils.FileProcessor;
import backupSystem_StudentRecords.utils.Pair;

public class BSTBuilder {
    private BinarySearchTree main_BST ;
    private BinarySearchTree backup_1 ;
    private BinarySearchTree backup_2 ;
    private BinarySearchTree backup_3 ;
    int b_Number ;
    String name ;
    String InputFile;
    FilterAllImpl fAllImpl = new FilterAllImpl() ;
    FilterPrimeImpl fPrimeImpl = new FilterPrimeImpl() ;
    public BSTBuilder(){
        main_BST = new BinarySearchTree() ;
        backup_1 = new BinarySearchTree() ;
        backup_2 = new BinarySearchTree() ;
        backup_3 = new BinarySearchTree() ;
        InputFile = FileProcessor.InputFile ;
    }

    public void insert(){
        FileProcessor fp = ProjectManager.inputFileProcessor ;
        while(!fp.isfileParsed){
            Pair pair = fp.readLine();
            if(pair != null){
                b_Number = pair.b_Number ;
                name = pair.Name ;
                NodeImpl anotherMainNode = new NodeImpl(b_Number,name) ;
                NodeImpl anotherBackup1Node = new NodeImpl(b_Number,name) ;
                NodeImpl anotherBackup2Node = new NodeImpl(b_Number,name) ;
                NodeImpl anotherBackup3Node = new NodeImpl(b_Number,name) ;

                main_BST.bstInsert(anotherMainNode);
                backup_1.bstInsert(anotherBackup1Node);
                backup_2.bstInsert(anotherBackup2Node);
                backup_3.bstInsert(anotherBackup3Node);

                anotherMainNode.registerObserver(anotherBackup1Node,fAllImpl);
                anotherMainNode.registerObserver(anotherBackup2Node,fAllImpl);
                anotherMainNode.registerObserver(anotherBackup3Node,fPrimeImpl);
            }
        }
    }

    public void update(int updateValue){
        main_BST.bstUpdate(updateValue) ;
    }

    public void inorder(){
        writeToResults("BST: ");
        main_BST.bstInorder();
        writeToResults("\nBackup-1: ");
        backup_1.bstInorder();
        writeToResults("\nBackup-2: ");
        backup_2.bstInorder();
        writeToResults("\nBackup-3: ");
        backup_3.bstInorder();
        writeToResults("\n\n");
    }

    public void sum(){
        String main_BST_Sum = Integer.toString(main_BST.bstSum()) ;
        writeToResults("BST: "+ main_BST_Sum+"\n") ;
        String backup_1_sum = Integer.toString(backup_1.bstSum()) ;
        writeToResults("Backup-1: "+ backup_1_sum+"\n") ;
        String backup_2_sum = Integer.toString(backup_2.bstSum()) ;
        writeToResults("Backup-2: "+backup_2_sum+"\n") ;
        String backup_3_sum = Integer.toString(backup_3.bstSum()) ;
        writeToResults("Backup-3: "+backup_3_sum) ;
    }

    public void writeToResults(String sIn){
        ProjectManager.results.append(sIn);
    }
    
}
