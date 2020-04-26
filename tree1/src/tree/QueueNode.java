package tree;

public class QueueNode<T> {
		public T data;
		QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
}
