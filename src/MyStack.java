public class MyStack<Type> {
	private Node top;
	
	public MyStack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null ? true : false;
	}
		
	public void push(Type theItem) {
		//Create a node.
		Node node = new Node(theItem, null);
		
		//If the stack is empty, myTop will be theItem
		if(isEmpty()) {
			top = node;			
		} else {	//If the stack is not empty, adding the node into the top. Then, change the top.
			node.next = top;
			top = node;
		}		
	}
	
	public Type pop() {
		if(isEmpty()) {
			return null;
		} 
		Node node = top;
		top = node.next;
		node.next = null;
		return node.data;		
	}
	
	public Type peek() {
		if(isEmpty()) {
			return null;
		} 
		return top.data;	
	}

	public int size() {
		int i = 0;
		if(isEmpty()) {
			return i;
		}
		
		Node p = top;
		while(p != null) {
			i = i + 1;
			p = p.next;
		}
		return i;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		if(isEmpty()) {
			return str.toString();
		}
		Node p = top;
		str.append("[");
		while(p != null) {
			str.append(p.data.toString());
			str.append(", ");
			p = p.next;
		}
		
		String subString = str.toString().substring(0, str.length() - 2);
		
		return subString.concat("]");
	}
	
	public class Node {
		private Type data;
		private Node next;
		public Node(Type data, Node next) {
			this.data = data;
			this.next = next;
		}		
	}
}


