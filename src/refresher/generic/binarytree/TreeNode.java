package refresher.generic.binarytree;

public class TreeNode
{
   int key;
   String name;
	public TreeNode leftNode, rightNode;

   public TreeNode(int key, String name)
   {
      this.key = key;
      this.name = name;
      this.leftNode = null;
      this.rightNode = null;
   }
	    
   @Override
	public String toString()
	{
	   return name + " has a key " + key;
	}
}
