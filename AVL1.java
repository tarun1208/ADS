class AVLNode
{
    int key;
    int height;
    AVLNode left, right;

    AVLNode(int key)
    {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}

class AVLTree 
{
    public static int height(AVLNode node) 
    {
        if (node == null)
        {
            return -1;
        } else
        {
            return node.height;
        }
    }

    public static AVLNode RotateWithLeftChild(AVLNode k2)// LL Rotation
    {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    public static AVLNode RotateWithRightChild(AVLNode k1)// RR Rotation
    { 
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        return k2;
    }
-
    public static AVLNode DoubleRotationWithLeftChild(AVLNode k3)// LR Rotation
    {
        k3.left = RotateWithRightChild(k3.left);
        return RotateWithLeftChild(k3);
    }

    public static AVLNode DoubleRotationWithRightChild(AVLNode k3)// RL Rotation
    { 
        k3.right = RotateWithLeftChild(k3.right);
        return RotateWithRightChild(k3);
    }

    public static AVLNode insert(int key, AVLNode node) 
    {
        if (node == null)
        {
            return new AVLNode(key);
        }

        if (key < node.key)
        {
            node.left = insert(key, node.left);
            if (height(node.left) - height(node.right) == 2)
            {
                if (key < node.left.key)
                {
                    node=RotateWithLeftChild(node);
                } else
                {
                    node=DoubleRotationWithLeftChild(node);
                }
            }
        } 
        else if (key > node.key)
        {
            node.right = insert(key, node.right);
            if (height(node.right) - height(node.left) == 2)
            {
                if (key > node.right.key)
                {
                    node=RotateWithRightChild(node);
                } else
                {
                    node =DoubleRotationWithRightChild(node);
                }
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public static AVLNode findMin(AVLNode node)
    {
        if (node == null || node.left == null)
        {
            return node;
        }

        return findMin(node.left); 
    }
    public static AVLNode delete(int key, AVLNode node)
    {
      if (node == null)
      {
        return null;
      }
      if (key < node.key)
      {
        node.left = delete(key, node.left);
      }
      else if(key > node.key)
      {
        node.right = delete(key, node.right);
      }
      else
      {
        if(node.left != null && node.right != null)
        {
           AVLNode minNode = findMin(node.right);
           node.key = minNode.key;
           node.right = delete(minNode.key, node.right);
        }
        else
        {
           node=(node.left!=null)?node.left:node.right;
        }
      }
      if (node != null)
      {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
       
        if (height(node.left) - height(node.right) == 2)
        {
          if (height(node.left.left) >= height(node.left.right))
          {
            node=RotateWithLeftChild(node);
          }
          else
          {
            node=DoubleRotationWithLeftChild(node);
          }
        }
        else if (height(node.right) - height(node.left) == 2)
        {
          if (height(node.right.right) >= height(node.right.left))
          {
            node=RotateWithRightChild(node);
          }
          else
          {
            node=DoubleRotationWithRightChild(node);
          }
      }
     }
  return node;
   }    
    public static void inorder(AVLNode node)
    {
        if (node!=null)
        {
            inorder(node.left);          
            System.out.print(node.key + " "); 
            inorder(node.right);         
        }
    }
    public static void preorder(AVLNode node)
    {
        if(node!=null)
        {
            System.out.print(node.key+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    public static void postorder(AVLNode node)
    {
        if(node!=null)
        {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key+" ");
        }
    }

    public static void main(String[] args)
    {
        int a[] = {13, 24, 28, 30};
        AVLNode root = null; 
        for (int i=0;i<a.length;i++)
        {
            root = insert(a[i], root); 
        }
        System.out.println("Inorder:");
        inorder(root);
        System.out.println();
        System.out.println("Preorder:");
        preorder(root);
        System.out.println();
        System.out.println("Postorder:");
        postorder(root);
        System.out.println();
        root=delete(13,root);
        System.out.println("After Deletion: ");
        inorder(root);    
    }
}
