package D_Calculator_BinaryTree;

public class BinaryTree<E> {
		
	private TreeNode<E> root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public void setRoot(TreeNode<E> newRoot)
	{
		root = newRoot;
	}
	public TreeNode<E> getRoot()
	{
		return root;
	}
	public boolean isEmpty()
	{
		return root==null;
	}
	
	public int height(TreeNode<E> node)
	{
		if (node == null)
			return 0;
		else
			return (1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
	}
}
