package BT;

public class BtNode<T> {
	public T data;
	public BtNode<T> left;
	public BtNode<T> right;
	
	public BtNode(T data) {
		this.data = data;
		left = right = null;
	}
	
}
