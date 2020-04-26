package BT;

public class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode(T data){
		this.data=data;
		left=right=null;
	}
}
