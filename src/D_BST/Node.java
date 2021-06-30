package D_BST;

public class Node<Key extends Comparable<Key>, Value> {
	private Key key;
	private Value value;
	private Node leftChild, rightChild;
	
	public Node(Key newKey, Value value) {
		this.key = newKey;
		this.setValue(value);
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
} 
