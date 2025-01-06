import java.util.*;
class node{
    int key;
    node left, right;
    node (int key){
        this.key=key;
        left=right=null;
    }
}
class BST{
    static node insert(node root, int key){
        if(root==null)
            return(new node(key));
        if(root.key==key)
            return root;
        if(key>root.key)
            root.right=insert(root.right, key);
        else
            root.left=insert(root.left, key);
    return root;
    }
    
    static void inorder(node root){
        if(root!= null){
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }
    
    static void preorder(node root){
        if(root!=null){
            preorder(root.right);
            System.out.println(root.key);
            
        }
    }
    
    static void postorder(node root){
        if(root!= null){
            postorder(root.left);
            System.out.println(root.key);
        }
    }
    
    static node delnode(node root, int key) {
        if (root == null) {
            return null;
        }
    
        if (key < root.key) {
            root.left = delnode(root.left, key);
        } 
        else if (key > root.key) {
            root.right = delnode(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            node succ = getSuccessor(root);
            root.key = succ.key;
            root.right = delnode(root.right, succ.key);
        }
        return root;
    }

    static node getSuccessor(node root) {
        node current = root.right;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    
    public static void main(String[] args) {
        node root = new node(10);
        root.left = new node(5);
        root.right = new node(15);
        root.right.left = new node(12);
        root.right.right = new node(18);

        int x = 15;
        root = delnode(root, x);
        inorder(root);
    }
}
