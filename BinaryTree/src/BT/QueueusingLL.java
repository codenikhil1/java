package BT;

public class QueueusingLL<T> {
	private NOde<T> front;
	private NOde<T> rear;
	int size;
	public QueueusingLL() {
		front=rear=null;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}else
			return false;
	}
	T front() throws Queueexception {
		if(size == 0) {
			throw new Queueexception();
		}else
			return front.data;
	}
	void enqueue(T data) {
		NOde<T> temp = new NOde<>(data);
		if(size() == 0) {
			front=rear=temp;
			size++;
		}else {
			rear.next = temp;
			rear=temp;
			size++;
		}
	}
	T dequeue() throws Queueexception {
		if(size == 0) {
			throw new Queueexception();
		}else {
			T temp = front();
			front=front.next;
			size--;
			return temp;
		}
	}
}
