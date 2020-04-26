package BT;

import java.util.Scanner;

public class BtUse {
	
	public static void main(String[] args) {
		BtNode<Integer> root = TakeInputI();
		printR(root);
		Diameter(root);
	}
	public static BtNode<Integer> TakeInputI() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Root Data");
		int data = s.nextInt();
		BtNode<Integer> root = new BtNode<>(data);
		QueueUse<BtNode<Integer>> queue = new QueueUse<>();
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			try {
				BtNode<Integer> FrontElement = queue.dequeue();
				System.out.println("Enter left child of " + FrontElement.data);
				int ldata = s.nextInt();
				if(ldata != -1) {
					BtNode<Integer> left = new BtNode<>(ldata);
					FrontElement.left = left;
					queue.enqueue(left);
				}
				System.out.println("Enter right child of " + FrontElement.data);
				int rdata = s.nextInt();
				if(rdata != -1) {
					BtNode<Integer> right = new BtNode<>(rdata);
					FrontElement.right = right;
					queue.enqueue(right);
				}
				
			}catch(QueueException e) {
				
			}
		}
		s.close();
		return root;
	}
	public static BtNode<Integer> TakeInputR() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int data = s.nextInt();
		if(data == -1) {
			return null;
		}
		BtNode<Integer> root = new BtNode<>(data);
		root.left = TakeInputR();
		root.right = TakeInputR();
		
		return root;
	}
	public static void printR(BtNode<Integer> root) {
		if(root == null) {
			return;
		}
		String toBePrinted = root.data + " ";
		if(root.left !=null) {
			toBePrinted += "L: " + root.left.data + " ";
		}
		if(root.right !=null) {
			toBePrinted += "R : " + root.right.data + " ";
		}
		System.out.println(toBePrinted);
		printR(root.left);
		printR(root.right);
	}
	
	public static Pair<Integer,Integer> Diameter(BtNode<Integer> root){
		if(root  == null) {
			Pair<Integer,Integer> pair = new Pair<>();
			pair.height = 0;
			pair.diameter = 0;
			return pair;
		}
		Pair<Integer,Integer> Ltree = Diameter(root.left);
		Pair<Integer,Integer> Rtree = Diameter(root.right);
		int height = 1 + Math.max(Ltree.height,Rtree.height);
		int option1 = Ltree.height + Rtree.height;
		int option2 = Ltree.height;
		int option3 = Rtree.height;
		int diameter = Math.max(option1,Math.max(option2, option3));
		Pair<Integer,Integer> pair = new Pair<>();
		pair.height = height;
		pair.diameter = diameter;
		return pair;
		
	}
}
