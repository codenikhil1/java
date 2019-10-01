package ds;
import java.util.Scanner;
public class linkedlist {
	public static Node<Integer> add(){
		Node<Integer> head=null,tail=null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		while(data!=-1) {
			Node<Integer> newnode = new Node<Integer>(data);
			if(head ==null) {
				head = newnode;
				tail = newnode;
			}else {
				
				tail.next = newnode;
				tail = newnode;
			}
			data = s.nextInt();
			
		}
		
		return head;
	}
	public static void print1(Node<Integer> head) {
		Node<Integer> temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		
	}

	public static void main(String[] args) {
		Node<Integer> head = add();
		print1(head);
		
		

	}

}
