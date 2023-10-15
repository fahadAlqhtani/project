//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
public class Node<T> {
	public T data;
	public Node<T> next;

	public Node() {
		data = null;
		next = null;
	}

	public Node(T data) {
		this.data = data;
		next = null;
	}
}
