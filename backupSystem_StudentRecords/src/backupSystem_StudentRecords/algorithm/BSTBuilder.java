package backupSystem_StudentRecords.algorithm;

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
    StringBuilder s ;
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
            Pair pair = fp.readLine();
            b_Number = pair.b_Number ;
            name = pair.Name ;
            SubjectInterface subject = main_BST.insert(b_Number,name);
            ObserverInterface object_1 = backup_1.insert(b_Number,name);
            ObserverInterface object_2 = backup_2.insert(b_Number,name);
            ObserverInterface object_3 = backup_3.insert(b_Number,name);
            Filter filterAll = new Filter(fAllImpl,null) ;
            Filter filterPrime = new Filter(null,fPrimeImpl) ;
            subject.registerObserver(object_1,filterAll);
            subject.registerObserver(object_2,filterAll);
            subject.registerObserver(object_3,filterPrime);

        }
    }

    public void updateTree(int updateValue){
        main_BST.update(updateValue) ;
    }

    public void printTrees(){
        System.out.println("Inorder Traversal");
        System.out.print("BST: ");
        main_BST.callinorder();
        System.out.print("\n");
        System.out.print("Backup-1: ");
        backup_1.callinorder();
        System.out.print("\n");
        System.out.print("Backup-2: ");
        backup_2.callinorder();
        System.out.print("\n");
        System.out.print("Backup-3: ");
        backup_3.callinorder();
        System.out.println("\n");
    }

    public void printSum(){
        s = new StringBuilder() ;
        String main_BST_Sum = Integer.toString(main_BST.Sum()) ;
        s.append("BST: "+ main_BST_Sum+"\n") ;
        String backup_1_sum = Integer.toString(backup_1.Sum()) ;
        s.append("Backup-1: "+ backup_1_sum+"\n") ;
        String backup_2_sum = Integer.toString(backup_2.Sum()) ;
        s.append("Backup-2: "+backup_2_sum+"\n") ;
        String backup_3_sum = Integer.toString(backup_3.Sum()) ;
        s.append("Backup-3: "+backup_3_sum) ;
        System.out.println(s);
    }
    
}
