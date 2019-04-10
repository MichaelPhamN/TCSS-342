public class Burger {
	private MyStack<String> order = new MyStack<String>();
	private MyStack<String> temp = new MyStack<String>();
	private MyStack<String> cheese = new MyStack<String>();
	private boolean theWorks;
	
	public Burger(final boolean theWorks) {
		this.theWorks = theWorks;
		if(theWorks) {
			//Initializes a baron burger
			order.push("Pickle");
			order.push("Top Bun");
			order.push("Mayonnaise");
			order.push("Baron-Sauce");
			order.push("Lettuce");
			order.push("Tomato");
			order.push("Onions");
			order.push("Pepperjack");
			order.push("Mozzarella");
			order.push("Cheddar");
			order.push("Beef");
			order.push("Mushrooms");
			order.push("Mustard");
			order.push("Ketchup");
			order.push("Bottom Bun");
		} else {
			//Initializes a burger with only a bun and patty
			order.push("Top Bun");
			order.push("Beef");
			order.push("Bottom Bun");
		}
	}
	
	public void changePatties(final String pattyType) {		
		String pop;
		while (order.size() != 0) {
			pop = order.pop();
			if((pop.equalsIgnoreCase("beef") || pop.equalsIgnoreCase("chicken") ||
					pop.equalsIgnoreCase("veggie")) && !pop.equalsIgnoreCase(pattyType)) {
				temp.push(pattyType);
			} else {
				temp.push(pop);
			}
		}
		
		while (temp.size() != 0) {
			order.push(temp.pop());
		}
	}
	
	public void addPatty() {
		String peek;
		while (order.size() != 0) {
			peek = order.peek();
			if(!peek.equalsIgnoreCase("cheddar") || !peek.equalsIgnoreCase("mozzarella") ||
					!peek.equalsIgnoreCase("pepperjack") || !peek.equalsIgnoreCase("beef")
					|| !peek.equalsIgnoreCase("chicken") || !peek.equalsIgnoreCase("veggie")) {
				temp.push(order.pop());
			} else {
				
			}
		}
	}
	
	public void addCategory(final String type) {
		
	}
	
	public void removeCategory(final String type) {
		
	}
	
	public void addIngredient(final String type) {
		
	}
	
	public void removeIngredient(final String type) {
		
	}
	
	@Override
	public String toString() {		
		return temp.toString();
	}
}
