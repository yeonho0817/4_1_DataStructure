package D_Calculator_BinaryTree;

public class TreeNode<E> {
		
	private E item;
	private TreeNode<E> leftChild;
	private TreeNode<E> rightChild;
	
	public TreeNode(E item, TreeNode<E> leftChild, TreeNode<E> rightChild) {
		this.item = item;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public TreeNode<E> getRightChild() {
		return rightChild;
	}

	public TreeNode<E> setRightChild(TreeNode<E> rightChild) {
		this.rightChild = rightChild;
		return rightChild;
	}

	public TreeNode<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}



		
}
