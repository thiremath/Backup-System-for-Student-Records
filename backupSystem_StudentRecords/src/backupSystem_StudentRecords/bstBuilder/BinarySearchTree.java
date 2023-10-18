package backupSystem_StudentRecords.bstBuilder;

import backupSystem_StudentRecords.projectmanager.ProjectManager;
import backupSystem_StudentRecords.utils.NodePair;

public class BinarySearchTree {
    public NodeImpl root ;
    public BinarySearchTree(){ 
        root = null; 
    }

    public BinarySearchTree(int b_NumberIn, String nameIn) { 
        root = new NodeImpl(b_NumberIn, nameIn); 
    }

    public NodeImpl bstInsert(int b_NumberIn, String nameIn){
        NodePair pair = new NodePair() ;
        pair = insertNode(root, b_NumberIn, nameIn);
        root = pair.rootNode ;
        return pair.anotherNode ;
    }

    public NodePair insertNode(NodeImpl rootNode, int b_NumberIn, String nameIn)
    {
        NodePair pair = new NodePair() ;
        if (rootNode == null) {
            rootNode = new NodeImpl(b_NumberIn, nameIn);
            pair.rootNode = rootNode ;
            pair.anotherNode = rootNode ;
            return pair;
        }
 
        else if (b_NumberIn <= rootNode.b_Number){
            pair = insertNode(rootNode.left, b_NumberIn, nameIn);
            rootNode.left = pair.rootNode;
            pair.rootNode = rootNode ;
        }    
            
        else if (b_NumberIn > rootNode.b_Number){
            pair = insertNode(rootNode.right, b_NumberIn, nameIn);
            rootNode.right = pair.rootNode;
            pair.rootNode = rootNode ;
        }
        
        return pair;
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
