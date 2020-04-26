package BT;

import java.util.Scanner;

public class BinaryTreeUse {
	public static BinaryTreeNode<Integer> TakeInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root element");
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		root.left=TakeInput();
		root.right=TakeInput();
		return root;
		
		
		
	}
	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		String s=root.data+":";
		if(root.left !=null) {
			s+="L:"+root.left.data+",";
		}
		if(root.right !=null) {
			s+="R:"+root.right.data;
		}
		System.out.println(s);
		print(root.left);
		print(root.right);
		
		
	}
	public static int countNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int ans = 1;
		ans+=countNodes(root.left);
		ans+=countNodes(root.right);
		return ans;
		
		
		
		
		
	}
	public static BinaryTreeNode<Integer> TakeInputLW() throws Queueexception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root node");
		int rootdata=s.nextInt();
		if(rootdata == -1) {
			return null;
		}
		QueueusingLL<BinaryTreeNode<Integer>> queue = new QueueusingLL<>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> frontElement;
			try {
				frontElement=queue.dequeue();
			}catch(Queueexception e) {
				throw new Queueexception();
			}
			System.out.println("Enter left element for"+frontElement.data);
			int leftelement = s.nextInt();
			if(leftelement != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftelement);
				queue.enqueue(left);
				frontElement.left=left;
			}
			System.out.println("Enter right element for"+frontElement.data);
			int rightelement = s.nextInt();
			if(rightelement != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightelement);
				queue.enqueue(right);
				frontElement.right=right;
			}
		}
		
		return root;
		
	}
	public static pair<Integer,Integer> diameterheight(BinaryTreeNode<Integer> root){
		if(root == null) {
			pair<Integer,Integer> output = new pair<>();
			output.first=0;
			output.second=0;
			return output;
		}
		pair<Integer,Integer> lo = diameterheight(root.left);
		pair<Integer,Integer> ro = diameterheight(root.right);
		int height = 1+Math.max(lo.first,ro.first);
		int option1 = lo.first+ro.first;
		int option2 = lo.second;
		int option3= ro.second;
		int diameter = Math.max(option1, Math.max(option1, option2));
		pair<Integer,Integer> output = new pair<>();
		output.first = height;
		output.second = diameter;
		return output;
		
	}
	
	
	public static void main(String args[]) throws Queueexception {
			BinaryTreeNode<Integer> root;
			root=TakeInputLW();
			print(root);
			System.out.println();
			//System.out.println(countNodes(root));
			System.out.println("Diameter:"+diameterheight(root).second);
			System.out.println("Height:"+diameterheight(root).first);
		}
}
