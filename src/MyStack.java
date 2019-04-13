/**
 * My Stack Class.
 * @author Phuc Pham N
 * @version Spring 2019
 *
 */
public class MyStack<Type> {
	//The Node top of the Stack
	private Node top;
	/**
	 * constructor of a stack.
	 */
	public MyStack() {
		top = null;
	}
	
	/**
	 * Checking the empty stack.
	 * @return true if stack is empty 
	 * 		   false if stack is not empty
	 */
	public boolean isEmpty() {
		return top == null ? true : false;
	}
	
	/**
	 * Push an item to the stack.
	 * @param theItem the item.
	 */
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
	
	/**
	 * Pop the item at the top of the stack.
	 * @return the item.
	 */
	public Type pop() {
		//if the stack is empty, return null.
		if(isEmpty()) {
			return null;
		} 
		
		//if the stack is not empty, pop the node. Then, return the data.
		Node node = top;
		top = node.next;
		node.next = null;
		return node.data;		
	}
	
	/**
	 * Seeking the data of the node top, but the node still in the top of the stack.
	 * @return the data of the node on the top.
	 */
	public Type peek() {
		if(isEmpty()) {
			return null;
		} 
		return top.data;	
	}

	/**
	 * return the number of items in the stack.
	 * @return the size.
	 */
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
	
	/**
	 * Convert content of 0the stack to a string.
	 */
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
	
	/**
	 * This is an inner class. Create a node class.
	 * @author Phuc Pham N
	 * @version Spring 2019
	 *
	 */
	public class Node {
		private Type data;
		private Node next;
		public Node(Type data, Node next) {
			this.data = data;
			this.next = next;
		}		
	}
}


