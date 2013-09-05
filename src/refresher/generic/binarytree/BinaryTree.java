package refresher.generic.binarytree;

public class BinaryTree
{
   TreeNode rootNode;

	public BinaryTree()
	{
	   rootNode = null;
	}

	public void addNode(int key, String name)
	{
	   TreeNode newNode = new TreeNode(key, name);
	   
	   if (rootNode == null)
	   {
	      rootNode = newNode;
	   }
	   else
	   {
	      TreeNode focusNode = rootNode;
	      TreeNode parent;
	      
	      while (true)
	      {
	         parent = focusNode;
	         
	         if (key < focusNode.key)
	         {
	            // Try left side.
	            focusNode = focusNode.leftNode;
	            
	            if (focusNode == null)
	            {
	               parent.leftNode = newNode;
	               return;
	            }
	         }
	         else
	         {
	            // Try right side.
	            focusNode = focusNode.rightNode;
	            
	            if (focusNode == null)
	            {
	               parent.rightNode = newNode;
	               return;
	            }
	         }
	      }
	   }
   }

   public void inOrderTraversal(TreeNode focusNode)
   {
	   if (focusNode != null)
	   {
	      inOrderTraversal(focusNode.leftNode);
	      System.out.println(focusNode);
	      inOrderTraversal(focusNode.rightNode);
	   }
	}
   
   public void preOrderTraversal(TreeNode focusNode)
   {
      if (focusNode != null)
      {
         System.out.println(focusNode);
         preOrderTraversal(focusNode.leftNode);
         preOrderTraversal(focusNode.rightNode);
      }
   }
   
   public void postOrderTraversal(TreeNode focusNode)
   {
      if (focusNode != null)
      {
         preOrderTraversal(focusNode.leftNode);
         preOrderTraversal(focusNode.rightNode);
         System.out.println(focusNode);
      }
   }
   
   public TreeNode search(int key)
   {
      TreeNode focusNode = rootNode;
      
      while (focusNode.key != key)
      {
         if (key < focusNode.key)
         {
            focusNode = focusNode.leftNode;
         }
         else
         {
            focusNode = focusNode.rightNode;
         }
         
         if (focusNode == null)
         {
            return null;
         }
      }
      
      return focusNode;
   }
   
   public boolean removeNode(int key)
   {
      TreeNode focusNode = rootNode;
      TreeNode parent = rootNode;
      
      boolean isLeftChild = true;
      
      while (focusNode.key != key)
      {
         parent = focusNode;
         
         if (key < focusNode.key)
         {
            isLeftChild = true;
            focusNode = focusNode.leftNode;
         }
         else
         {
            isLeftChild = false;
            focusNode = focusNode.rightNode;
         }
         
         if (focusNode == null)
         {
            return false;
         }
      }
      
      if (focusNode.leftNode == null && focusNode.rightNode == null)
      {
         if (focusNode == rootNode)
         {
            rootNode = null;
         }
         else if (isLeftChild)
         {
            parent.leftNode = null;
         }
         else
         {
            parent.rightNode = null;
         }
      }
      else if (focusNode.rightNode == null)
      {
         if (focusNode == rootNode)
         {
            rootNode = focusNode.leftNode;
         }
         else if (isLeftChild)
         {
            parent.leftNode = focusNode.leftNode;
         }
         else
         {
            parent.rightNode = focusNode.rightNode;
         }
      }
      else if (focusNode.leftNode == null)
      {
         if (focusNode == rootNode)
         {
            rootNode = focusNode.rightNode;
         }
         else if (isLeftChild)
         {
            parent.leftNode = focusNode.rightNode;
         }
         else
         {
            parent.rightNode = focusNode.leftNode;
         }
      }
      else
      {
         TreeNode replacement = getReplacementNode(focusNode);
         
         if (focusNode == rootNode)
         {
            rootNode = replacement;
         }
         else if (isLeftChild)
         {
            parent.leftNode = replacement;
         }
         else
         {
            parent.rightNode = replacement;
         }
         
         replacement.leftNode = focusNode.leftNode;
      }
      
      return true;
   }
   
   private TreeNode getReplacementNode(TreeNode replaceNode)
   {
      TreeNode replacementParent = replaceNode;
      TreeNode replacement = replaceNode;
      TreeNode focusNode = replaceNode.rightNode;
      
      while (focusNode != null)
      {
         replacementParent = replacement;
         replacement = focusNode;
         focusNode = focusNode.leftNode;
      }
      
      if (replacement != replaceNode.rightNode)
      {
         replacementParent.leftNode = replacement.rightNode;
         replacement.rightNode = replaceNode.rightNode;
      }
      
      return replacement;
   }
   
   /**
    * @param args
    */
   public static void main(String[] args)
   {
      BinaryTree tree = new BinaryTree();
      tree.addNode(50, "Boss");
      tree.addNode(25, "Vice President");
      tree.addNode(30, "Office Manager");
      tree.addNode(15, "Secretary");
      tree.addNode(75, "Sales Manager");
      tree.addNode(85, "Salesman Level 1");
      
      System.out.println("InOrder Traversal");
      tree.inOrderTraversal(tree.rootNode);
      System.out.println("-----------------");
      
      System.out.println("\nPreOrder Traversal");
      tree.preOrderTraversal(tree.rootNode);
      System.out.println("-----------------");
      
      System.out.println("\nPostOrder Traversal");
      tree.postOrderTraversal(tree.rootNode);
      System.out.println("-----------------");
      
      System.out.println("\nPerforming a search for 30");
      System.out.println(tree.search(30));
      System.out.println("-----------------");
      
      System.out.println("\nRemoving the key 25");
      System.out.println(tree.removeNode(25));
      tree.inOrderTraversal(tree.rootNode);
   }
}
