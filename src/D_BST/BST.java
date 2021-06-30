package D_BST;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	public BST()
	{
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void insertNode(Key newKey, Value newValue)
	{
		if (root == null)
			root = new Node(newKey, newValue);
		else
			insertNode(root, newKey, newValue);
	}
	
	public Node insertNode(Node node, Key newKey, Value newValue)
	{
		if (node==null)
			return new Node(newKey, newValue);
		
		int compare = node.getKey().compareTo(newKey);
		
		if (compare > 0)
			node.setLeftChild( insertNode(node.getLeftChild(), newKey, newValue) );
		else if (compare < 0)
			node.setRightChild( insertNode(node.getRightChild(), newKey, newValue));
		else
			node.setValue(newValue);
		
		return node;
	}
	
	public int height(Node node)
	{
		if (node == null)
			return 0;
		else
			return (1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
	}
	
}

