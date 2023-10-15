package backupSystem_StudentRecords.algorithm;

import backupSystem_StudentRecords.projectmanager.ProjectManager;

public class BinarySearchTree {
    public NodeImpl root ;
    public BinarySearchTree(){ 
        root = null; 
    }

    public BinarySearchTree(int b_NumberIn, String nameIn) { 
        root = new NodeImpl(b_NumberIn, nameIn); 
    }

    public NodeImpl insert(int b_NumberIn, String nameIn){
        NodePair pair = new NodePair() ;
        pair = insertRec(root, b_NumberIn, nameIn);
        root = pair.a ;
        return pair.b ;
    }

    public NodePair insertRec(NodeImpl rootNode, int b_NumberIn, String nameIn)
    {
        NodePair pair = new NodePair() ;
        if (rootNode == null) {
            rootNode = new NodeImpl(b_NumberIn, nameIn);
            pair.a = rootNode ;
            pair.b = rootNode ;
            return pair;
        }
 
        else if (b_NumberIn < rootNode.b_Number){
            pair = insertRec(rootNode.left, b_NumberIn, nameIn);
            rootNode.left = pair.a;
            pair.a = rootNode ;
        }    
            
        else if (b_NumberIn > rootNode.b_Number){
            pair = insertRec(rootNode.right, b_NumberIn, nameIn);
            rootNode.right = pair.a;
            pair.a = rootNode ;
        }
        
        return pair;
    }

    public void update(int updateValueIn){
        updateinorder(root,updateValueIn);
    }

    public void updateinorder(NodeImpl root,int updateValueIn)
    {
        if (root != null) {
            updateinorder(root.left,updateValueIn);
            root.b_Number = root.b_Number+updateValueIn ;
            SubjectInterface subject = root ;
            subject.notifyAllListeners();
            updateinorder(root.right,updateValueIn);
        }
    }

    public void callinorder(){
        inorder1(root);
        if((ProjectManager.results.length() > 0)  && ProjectManager.results.charAt(ProjectManager.results.length()-1) == ',') {
            ProjectManager.results.deleteCharAt(ProjectManager.results.length() - 1);
        }
    }

    public void inorder1(NodeImpl root)
    {
        if (root != null) {
            inorder1(root.left);
            ProjectManager.results.append(" "+root.b_Number + ":" + root.name + ",") ;
            inorder1(root.right);
        }
    }

    public int Sum(){
        return CalcSum(root) ;
    }

    public int CalcSum(NodeImpl root){
        int k = 0 ;
        if (root != null) {
            k = root.b_Number ;
            k += CalcSum(root.left);
            k += CalcSum(root.right);
        }
        return k ;
    }

}
