public class Burger {
	private MyStack<String> order = new MyStack<String>();
	private boolean theWorks;
	public Burger(final boolean theWorks) {
		this.theWorks = theWorks;
		if(theWorks) {
			//Initializes a baron burger
			order.push("Bottom Bun");
			order.push("Ketchup");
			order.push("Mustard");
			order.push("Mushrooms");
			order.push("Beef");
			order.push("Cheddar");
			order.push("Mozzarella");
			order.push("Pepperjack");
			order.push("Onions");
			order.push("Tomato");
			order.push("Lettuce");
			order.push("Baron-Sauce");
			order.push("Mayonnaise");
			order.push("Top Bun");
			order.push("Pickle");
		} else {
			//Initializes a burger with only a bun and patty
			order.push("Bottom Bun");
			order.push("Beef");
			order.push("Top Bun");
		}
	}
	
	public void changePatties(final String pattyType) {		
		
	}
	
	public void addPatty() {
		
	}
	
	public void addCategory(final String type) {
		
	}
	
	public void removeCategory(final String type) {
		
	}
	
	public void addIngredient(final String type) {
		
	}
	
	public void removeIngredient(final String type) {
		
	}
	
	public String toString() {
		return order.toString();
	}
}
