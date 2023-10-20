package backupSystem_StudentRecords.bstBuilder;

import backupSystem_StudentRecords.projectmanager.ProjectManager;

public class BinarySearchTree {
    public NodeImpl root ;
    public BinarySearchTree(){ 
        root = null; 
    }

    public BinarySearchTree(int b_NumberIn, String nameIn) { 
        root = new NodeImpl(b_NumberIn, nameIn); 
    }

    public void bstInsert(NodeImpl anotherNodeIn){
        root = insertNode(root, anotherNodeIn);
    }

    public NodeImpl insertNode(NodeImpl rootNodeIn, NodeImpl anotherNodeIn)
    {
        if (rootNodeIn == null) {
            return anotherNodeIn;
        }
 
        else if (anotherNodeIn.b_Number <= rootNodeIn.b_Number){
            rootNodeIn.left = insertNode(rootNodeIn.left, anotherNodeIn);
        }    
            
        else if (anotherNodeIn.b_Number > rootNodeIn.b_Number){
            rootNodeIn.right = insertNode(rootNodeIn.right, anotherNodeIn);
        }

        return rootNodeIn;
    }

    public void bstUpdate(int updateValueIn){
        updateInorder(root,updateValueIn);
    }

    public void updateInorder(NodeImpl root,int updateValueIn)
    {
        if (root != null) {
            updateInorder(root.left,updateValueIn);
            root.updateNode(updateValueIn) ;
            SubjectInterface subject = root ;
            subject.notifyAllObservers();
            updateInorder(root.right,updateValueIn);
        }
    }

    public void bstInorder(){
        inorder(root);
        if((ProjectManager.results.length() > 0)  && ProjectManager.results.charAt(ProjectManager.results.length()-1) == ',') {
            ProjectManager.results.deleteCharAt(ProjectManager.results.length() - 1);
        }
    }

    public void inorder(NodeImpl root)
    {
        if (root != null) {
            inorder(root.left);
            writeToResults(" "+root.b_Number + ":" + root.name + ",") ;
            inorder(root.right);
        }
    }

    public int bstSum(){
        return calcSum(root) ;
    }

    public int calcSum(NodeImpl root){
        int sum = 0 ;
        if (root != null) {
            sum = root.b_Number ;
            sum += calcSum(root.left);
            sum += calcSum(root.right);
        }
        return sum ;
    }

    public void writeToResults(String sIn){
        ProjectManager.results.append(sIn);
    }

}
