package tree;

import java.util.ArrayList;

public class treeNode<T> {
	public T data;
	public ArrayList<treeNode<T>> childs;
	
	public treeNode(T data) {
		this.data = data;
		childs = new ArrayList<>();
	}

}
