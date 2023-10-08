package projectName.algorithm;

public class BinarySearchTree {
    public Node root ;
    public BinarySearchTree(){ 
        root = null; 
    }

    public BinarySearchTree(int b_NumberIn, String nameIn) { 
        root = new Node(b_NumberIn, nameIn); 
    }

    public Node insert(int b_NumberIn, String nameIn){
        pair p1 = new pair() ;
        p1 = insertRec(root, b_NumberIn, nameIn);
        root = p1.a ;
        return p1.b ;
    }

    public pair insertRec(Node rootNode, int b_NumberIn, String nameIn)
    {
        pair p2 = new pair() ;
        //p.a = p.b = root ;
        // If the tree is empty,
        // return a new node
        if (rootNode == null) {
            rootNode = new Node(b_NumberIn, nameIn);
            p2.a = rootNode ;
            p2.b = rootNode ;
            return p2;
        }
 
        // Otherwise, recur down the tree
        else if (b_NumberIn < rootNode.b_Number){
            p2 = insertRec(rootNode.left, b_NumberIn, nameIn);
            rootNode.left = p2.a;
            p2.a = rootNode ;
        }    
            
        else if (b_NumberIn > rootNode.b_Number){
            p2 = insertRec(rootNode.right, b_NumberIn, nameIn);
            rootNode.right = p2.a;
            p2.a = rootNode ;
        }
        // Return the (unchanged) node pointer
        return p2;
    }

    public void update(int updateValueIn){
        updateinorder(root,updateValueIn);
    }

    public void updateinorder(Node root,int updateValueIn)
    {
        if (root != null) {
            updateinorder(root.left,updateValueIn);
            root.b_Number = root.b_Number+updateValueIn ;
            root.notifyAllListeners();
            updateinorder(root.right,updateValueIn);
        }
    }

    public void callinorder(){
        inorder1(root);
    }

    public void inorder1(Node root)
    {
        if (root != null) {
            inorder1(root.left);
            System.out.print(root.b_Number + " " + root.name + "\n");
            inorder1(root.right);
        }
    }

}
