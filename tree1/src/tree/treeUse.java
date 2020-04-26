package tree;

import java.util.Scanner;

public class treeUse {
	public static int NumberOfNodes(treeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int count = 1;
		for(int i=0;i<root.childs.size();i++) {
			count+=NumberOfNodes(root.childs.get(i));
		}
		return count;
		
		
		
	} 
	private static void print(treeNode<Integer> root) {
		System.out.println();	
		System.out.print(root.data + " : ");
		for(int i = 0 ; i< root.childs.size();i++) {
			System.out.print(root.childs.get(i).data + " ,");
		}
		for(int i = 0 ; i< root.childs.size();i++) {
				print(root.childs.get(i));
		}
	}
	public static treeNode<Integer> takeInputLL(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root Element");
		int data = s.nextInt();
		treeNode<Integer> root = new treeNode<>(data);
		QueueUse<treeNode<Integer>> queue = new QueueUse<>();
		queue.enqueue(root);
		while(!queue.isEmpty())  {
			try {
				treeNode<Integer> temp = queue.dequeue();
				System.out.println("Enter no of childrens for : " + temp.data);
				int childCount = s.nextInt();
				for(int i =0 ;i<childCount;i++) {
					System.out.println("Enter the " + (i+1) + "child of "+ temp.data);
					int childData = s.nextInt();
					treeNode<Integer> child = new treeNode<>(childData);
					temp.childs.add(child);
					queue.enqueue(child);
				}
			}catch(QueueException e){
				
			}
		}
		return root;
	}
	public static treeNode<Integer> TakeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the next node");
		int data = s.nextInt();
		treeNode<Integer> root = new treeNode<>(data);
		System.out.println("Enter no of childs");
		int childrens = s.nextInt();
		for(int i = 0; i < childrens ; i++) {
			treeNode<Integer> child = TakeInput();
			root.childs.add(child);
		}
		return root;
	}
	public static int LargestData(treeNode<Integer> root) {
		
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int data = root.data;
		for(int i = 0;i<root.childs.size();i++) {
			int childData = LargestData(root.childs.get(i));
			if(childData > data) {
				data = childData;
			}
		}
		return data;
	}
	public static int Height(treeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int ans = 0;
		for(treeNode<Integer> child : root.childs) {
			int childHeight = Height(child);
			if(childHeight > ans)
					ans = childHeight;
		}
		return ans+1;
	}
	//print nodes of depth k
	public static void printDepthKnodes(treeNode<Integer> root,int k) {
		if(k<0) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		for(treeNode<Integer> child : root.childs) {
			printDepthKnodes(child,k-1);
		}
		return;
	}
	public static int countLeafNodes(treeNode<Integer> root){
	    if(root == null)
	        return 0;
	    int count=1;
	        if(root.childs.size() == 0)
	            return 1;
	    int nodecount=0;
	        for(int i = 0 ; i < root.childs.size();i++){
	            nodecount+=countLeafNodes(root.childs.get(i));
	        }
			return nodecount;

		}
	public static void main(String[] args) {
		//treeNode<Integer> root = TakeInput();
	
		treeNode<Integer> root = takeInputLL();
		print(root);
		System.out.println();;
		//printDepthKnodes(root,3);
		//System.out.println(LargestData(root));

	}

	

}
