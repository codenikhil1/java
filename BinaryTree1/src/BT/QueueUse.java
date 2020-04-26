package BT;

public class QueueUse<T> {
		QueueNode<T> front;
		QueueNode<T> rear;
		int size;
		public QueueUse() {
			front = rear = null;
			size = 0;
		}
		public int size() {
			return size();
		}
		public boolean isEmpty() {
			if(size == 0) {
				return true;
			}else {
				return false;
			}
		}
		T front() throws QueueException{
			if(isEmpty()) {
				throw new QueueException();
			}else {
				return front.data;
			}
		}
		public void enqueue(T data) {
			QueueNode<T> temp = new QueueNode<>(data);
			if(isEmpty()) {
				rear = front = temp;
				size++;
			}else {
				rear.next = temp;
				rear = temp;
				size++;
			}
		}
		T dequeue() throws QueueException {
			if(isEmpty()) {
				throw new QueueException();
			}else {
				T data = front();
				front = front.next;
				size--;
				return data;
			}
		}
		
}

















