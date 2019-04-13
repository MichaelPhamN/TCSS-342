/**
 * Burger Class.
 * @author Phuc Pham N
 * @version Spring 2019
 *
 */
public class Burger {
	private MyStack<String> order = new MyStack<String>();
	private boolean theWorks;
	
	/**
	 * Constructor of Burger Class.
	 * @param theWorks true if Baron Burger
	 * 				   false if Burger
	 */
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
	
	/**
	 * Change patty.
	 * @param pattyType chicken or veggies.
	 */
	public void changePatties(final String pattyType) {	
		MyStack<String> temp = new MyStack<String>();
		String pop;		
		
		while (order.size() != 0) {
			pop = order.pop();
			
			//pop all elements in the stack and change patty if needed.
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
	
	/**
	 * Add more patty into the burger.
	 * Convert the burger into five categories.
	 * 1. Bun
	 * 2. Cheese
	 * 3. Veggies
	 * 4. Sauce
	 * 5. Patty
	 * Two items in the burger may be the different categories(Move from the top to the bottom). 
	 * At that time, add a space into the current category and change to another category.
	 * When we have five categories. Add new patty into the Patty stack.
	 * Finally, Combine 5 categories to make a new burger.
	 */
	public void addPatty() {
		String peek = "";
		String food = "";
		MyStack<String> temp = null;
		MyStack<String> bun = new MyStack<String>();
		MyStack<String> cheeses = new MyStack<String>();
		MyStack<String> veggies = new MyStack<String>();
		MyStack<String> sauces = new MyStack<String>();
		MyStack<String> patties = new MyStack<String>();

		int size = order.size();
		
		while (order.size() != 0) {
			peek = order.peek();
			String categories = peek;
			if (size != order.size()) {	
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					categories = "cheese";			
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					categories = "veggies";
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					categories = "sauces";
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					categories = "patties";
				} else {
					categories = "bun";
				}
				
				if (!categories.equalsIgnoreCase(food)) {
					temp.push(" ");
					if(categories.equalsIgnoreCase("cheese")) {
						food = "cheese";			
						cheeses.push(order.pop());
						temp = cheeses;
					} else if (categories.equalsIgnoreCase("veggies")) {
						food = "veggies";
						veggies.push(order.pop());
						temp = veggies;
					} else if (categories.equalsIgnoreCase("sauces")) {
						food = "sauces";
						sauces.push(order.pop());
						temp = sauces;
					} else if (categories.equalsIgnoreCase("patties")) {
						food = "patties";
						patties.push(order.pop());
						temp = patties;
					} else {
						food = "bun";
						bun.push(order.pop());
						temp = bun;
					}	
				} else {
					if(categories.equalsIgnoreCase("cheese")) {
						cheeses.push(order.pop());
					} else if (categories.equalsIgnoreCase("veggies")) {
						veggies.push(order.pop());
					} else if (categories.equalsIgnoreCase("sauces")) {
						sauces.push(order.pop());
					} else if (categories.equalsIgnoreCase("patties")) {
						patties.push(order.pop());
					} else {
						bun.push(order.pop());
					}
				}
			} else {
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					food = "cheese";			
					cheeses.push(order.pop());
					temp = cheeses;
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					food = "veggies";
					veggies.push(order.pop());
					temp = veggies;
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					food = "sauces";
					sauces.push(order.pop());
					temp = sauces;
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					food = "patties";
					patties.push(order.pop());
					temp = patties;
				} else {					
					food = "bun";
					bun.push(order.pop());
					temp = bun;
				}
			}	
		}

		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		if (cheeses.peek() != null && cheeses.peek().equalsIgnoreCase(" ")) {
			cheeses.pop();
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
		
		if (patties.peek() != null && patties.peek().equalsIgnoreCase(" ")) {
			patties.pop();
		}
		
		//Add another patty into patty stack.
		patties.push(patties.peek());
				
		//Combine 5 categories to make a burger.
		if (theWorks) {
			if (veggies.peek() != null && veggies.peek().equalsIgnoreCase("pickle")) {
				order.push(veggies.pop());
			}
			
			if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
				veggies.pop();
			}
			
			if (bun.size() != 0) {
				order.push(bun.pop());
			}
			
			if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
				bun.pop();
			}
			
			while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")
					&& (sauces.peek().equalsIgnoreCase("mayonnaise") ||
					sauces.peek().equalsIgnoreCase("baron-sauce"))) {
				order.push(sauces.pop());
			}
			
			if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
				sauces.pop();
			}
					
			while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(" ")
					&& (veggies.peek().equalsIgnoreCase("onions") 
							|| veggies.peek().equalsIgnoreCase("tomato") 
							|| veggies.peek().equalsIgnoreCase("lettuce"))) {				
				order.push(veggies.pop());
			}
			
			if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
				veggies.pop();
			}
						
			if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
				veggies.pop();
			}

			while (patties.size() != 1) {
				if (patties.peek().equalsIgnoreCase(" ")) {
					patties.pop();
				} else {
					order.push(patties.pop());
				}
			}
			
			while (cheeses.size() != 0) {				
				order.push(cheeses.pop());				
			}
			
			if (patties.size() == 1) {
				order.push(patties.pop());
			}
			
			while (veggies.size() != 0) {
				order.push(veggies.pop());
			}
			
			while (sauces.size() != 0) {
				order.push(sauces.pop());
			}
			
			if (bun.peek() != null) {
				order.push(bun.pop());
			}
		} else {
			if (bun.size() != 0) {
				order.push(bun.pop());
			}			
			
			if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
				bun.pop();
			}
			
			while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")
					&& (sauces.peek().equalsIgnoreCase("mayonnaise") ||
							sauces.peek().equalsIgnoreCase("baron-sauce"))) {
				order.push(sauces.pop());
			}
			
			if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
				sauces.pop();
			}
					
			while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(" ")
					&& (veggies.peek().equalsIgnoreCase("onions") 
							|| veggies.peek().equalsIgnoreCase("tomato") 
							|| veggies.peek().equalsIgnoreCase("lettuce"))) {				
				order.push(veggies.pop());
			}
			
			if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
				veggies.pop();
			}
						
			if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
				veggies.pop();
			}
			
			while (patties.size() > 1) {
				if (patties.peek().equalsIgnoreCase(" ")) {
					patties.pop();
				} else {
					order.push(patties.pop());
				}
			}
			
			while (cheeses.size() != 0) {				
				order.push(cheeses.pop());				
			}
			
			if (patties.size() == 1) {
				order.push(patties.pop());
			}
			
			while (veggies.size() != 0) {
				order.push(veggies.pop());
			}
			
			while (sauces.size() != 0) {
				order.push(sauces.pop());
			}
			
			if (bun.peek() != null) {
				order.push(bun.pop());
			}
		}
	}
	
	/**
	 * Add Category.
	 * @param type add another category.
	 * Convert the burger into five categories.
	 * 1. Bun
	 * 2. Cheese
	 * 3. Veggies
	 * 4. Sauce
	 * 5. Patty
	 * If we want to make a new category, create a new default category stack.
	 * Finally, Combine 5 categories to make a new burger.
	 */
	public void addCategory(final String type) {
		String peek = "";
		String food = "";
		MyStack<String> temp = null;
		MyStack<String> bun = new MyStack<String>();
		MyStack<String> cheeses = new MyStack<String>();
		MyStack<String> veggies = new MyStack<String>();
		MyStack<String> sauces = new MyStack<String>();
		MyStack<String> patties = new MyStack<String>();
		
		int size = order.size();
		while (order.size() != 0) {
			peek = order.peek();
			String categories = peek;
			if (size != order.size()) {	
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					categories = "cheese";			
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					categories = "veggies";
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					categories = "sauces";
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					categories = "patties";
				} else {
					categories = "bun";
				}				
				
				if (!categories.equalsIgnoreCase(food)) {
					temp.push(" ");
					if(categories.equalsIgnoreCase("cheese")) {
						food = "cheese";			
						cheeses.push(order.pop());
						temp = cheeses;
					} else if (categories.equalsIgnoreCase("veggies")) {
						food = "veggies";
						veggies.push(order.pop());
						temp = veggies;
					} else if (categories.equalsIgnoreCase("sauces")) {
						food = "sauces";
						sauces.push(order.pop());
						temp = sauces;
					} else if (categories.equalsIgnoreCase("patties")) {
						food = "patties";
						patties.push(order.pop());
						temp = patties;
					} else {
						food = "bun";
						bun.push(order.pop());
						temp = bun;
					}	
				} else {
					if(categories.equalsIgnoreCase("cheese")) {
						cheeses.push(order.pop());
					} else if (categories.equalsIgnoreCase("veggies")) {
						veggies.push(order.pop());
					} else if (categories.equalsIgnoreCase("sauces")) {
						sauces.push(order.pop());
					} else if (categories.equalsIgnoreCase("patties")) {
						patties.push(order.pop());
					} else {
						bun.push(order.pop());
					}
				}
			} else {
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					food = "cheese";			
					cheeses.push(order.pop());
					temp = cheeses;
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					food = "veggies";
					veggies.push(order.pop());
					temp = veggies;
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					food = "sauces";
					sauces.push(order.pop());
					temp = sauces;
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					food = "patties";
					patties.push(order.pop());
					temp = patties;
				} else {					
					food = "bun";
					bun.push(order.pop());
					temp = bun;
				}
			}	
		}
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		if (cheeses.peek() != null && cheeses.peek().equalsIgnoreCase(" ")) {
			cheeses.pop();
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
		
		if (patties.peek() != null && patties.peek().equalsIgnoreCase(" ")) {
			patties.pop();
		}
		
		//Make a cheese category for the burger
		if (type.equalsIgnoreCase("cheese")) {
			cheeses = new MyStack<String>();
			cheeses.push("Cheddar");
			cheeses.push("Mozzarella");
			cheeses.push("Pepperjack");
		}
		
		//Make a veggies category for the burger
		if (type.equalsIgnoreCase("veggies")) {
			veggies = new MyStack<String>();
			veggies.push("Mushrooms");
			veggies.push(" ");
			veggies.push("Onions");
			veggies.push("Tomato");
			veggies.push("Lettuce");			
			if (theWorks) {
				veggies.push(" ");
				veggies.push("Pickle");
			}
			
		}
		
		//Make a sauce category for the burger
		if (type.equalsIgnoreCase("sauce")) {
			sauces = new MyStack<String>();
			sauces.push("Ketchup");
			sauces.push("Mustard");
			sauces.push(" ");
			sauces.push("Baron-Sauce");
			sauces.push("Mayonnaise");
		}
		
		
		//Combine 5 categories to make a new burger.
		//Top Bun
		if (bun.size() != 0) {
			order.push(bun.pop());
		}			
		
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		//Sauce (Mayonnaise or Baron-Sauce)
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")
				&& (sauces.peek().equalsIgnoreCase("mayonnaise") ||
						sauces.peek().equalsIgnoreCase("baron-sauce"))) {
			order.push(sauces.pop());
		}

		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
		
		//Veggies (Lettuce, Tomato, Onions)
		while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(" ")
				&& (veggies.peek().equalsIgnoreCase("onions") 
						|| veggies.peek().equalsIgnoreCase("tomato") 
						|| veggies.peek().equalsIgnoreCase("lettuce"))) {				
				order.push(veggies.pop());
		}

		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
					
		//Cheeses (cheddar, mozzarella, pepperjack)
		while (cheeses.size() != 0) {				
			order.push(cheeses.pop());				
		}

		if (patties.size() == 1) {
			order.push(patties.pop());
		}
		
		while (veggies.size() != 0) {
			order.push(veggies.pop());
		}

		while (sauces.size() != 0) {
			order.push(sauces.pop());
		}
		
		if (bun.peek() != null) {
			order.push(bun.pop());
		}
	}
	
	/**
	 * Remove Category.
	 * @param type remove another category.
	 * Convert the burger into five categories.
	 * 1. Bun
	 * 2. Cheese
	 * 3. Veggies
	 * 4. Sauce
	 * 5. Patty
	 * If we want to make a new category, create a new empty category stack.
	 * Finally, Combine 5 categories to make a new burger.
	 */
	public void removeCategory(final String type) {
		String peek = "";
		String food = "";
		MyStack<String> temp = null;
		MyStack<String> bun = new MyStack<String>();
		MyStack<String> cheeses = new MyStack<String>();
		MyStack<String> veggies = new MyStack<String>();
		MyStack<String> sauces = new MyStack<String>();
		MyStack<String> patties = new MyStack<String>();
		
		int size = order.size();
		while (order.size() != 0) {
			peek = order.peek();
			String categories = peek;
			if (size != order.size()) {	
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					categories = "cheese";			
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					categories = "veggies";
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					categories = "sauces";
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					categories = "patties";
				} else {
					categories = "bun";
				}				
				
				if (!categories.equalsIgnoreCase(food)) {
					temp.push(" ");
					if(categories.equalsIgnoreCase("cheese")) {
						food = "cheese";			
						cheeses.push(order.pop());
						temp = cheeses;
					} else if (categories.equalsIgnoreCase("veggies")) {
						food = "veggies";
						veggies.push(order.pop());
						temp = veggies;
					} else if (categories.equalsIgnoreCase("sauces")) {
						food = "sauces";
						sauces.push(order.pop());
						temp = sauces;
					} else if (categories.equalsIgnoreCase("patties")) {
						food = "patties";
						patties.push(order.pop());
						temp = patties;
					} else {
						food = "bun";
						bun.push(order.pop());
						temp = bun;
					}	
				} else {
					if(categories.equalsIgnoreCase("cheese")) {
						cheeses.push(order.pop());
					} else if (categories.equalsIgnoreCase("veggies")) {
						veggies.push(order.pop());
					} else if (categories.equalsIgnoreCase("sauces")) {
						sauces.push(order.pop());
					} else if (categories.equalsIgnoreCase("patties")) {
						patties.push(order.pop());
					} else {
						bun.push(order.pop());
					}
				}
			} else {
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					food = "cheese";			
					cheeses.push(order.pop());
					temp = cheeses;
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					food = "veggies";
					veggies.push(order.pop());
					temp = veggies;
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					food = "sauces";
					sauces.push(order.pop());
					temp = sauces;
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					food = "patties";
					patties.push(order.pop());
					temp = patties;
				} else {					
					food = "bun";
					bun.push(order.pop());
					temp = bun;
				}
			}	
		}
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		if (cheeses.peek() != null && cheeses.peek().equalsIgnoreCase(" ")) {
			cheeses.pop();
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
		
		if (patties.peek() != null && patties.peek().equalsIgnoreCase(" ")) {
			patties.pop();
		}
		
		//Make an empty cheese stack
		if (type.equalsIgnoreCase("cheese")) {
			cheeses = new MyStack<String>();
		}
		
		//Make an empty veggies stack
		if (type.equalsIgnoreCase("veggies")) {
			veggies = new MyStack<String>();
		}
		
		//Make an empty sauce stack
		if (type.equalsIgnoreCase("sauce")) {
			sauces = new MyStack<String>();
		}
		
		//Combine 5 categories to make a new burger.
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase("pickle")) {
			order.push(veggies.pop());
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (bun.size() != 0) {
			order.push(bun.pop());
		}
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")
				&& (sauces.peek().equalsIgnoreCase("mayonnaise") ||
						sauces.peek().equalsIgnoreCase("baron-sauce"))) {
			order.push(sauces.pop());
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
				
		while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(" ")
				&& (veggies.peek().equalsIgnoreCase("onions") 
						|| veggies.peek().equalsIgnoreCase("tomato") 
						|| veggies.peek().equalsIgnoreCase("lettuce"))) {				

			order.push(veggies.pop());
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
					
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}

		while (patties.size() != 1) {
			if (patties.peek().equalsIgnoreCase(" ")) {
				patties.pop();
			} else {
				order.push(patties.pop());
			}
		}
		
		while (cheeses.size() != 0) {				
			order.push(cheeses.pop());				
		}
		
		if (patties.size() == 1) {
			order.push(patties.pop());
		}
		
		while (veggies.size() != 0) {
			order.push(veggies.pop());
		}
		
		while (sauces.size() != 0) {
			order.push(sauces.pop());
		}
		
		if (bun.peek() != null) {
			order.push(bun.pop());
		}
	}
	
	/**
	 * Add Ingredient. This is the hardest part of Assignment One.
	 * @param type add another ingredient.
	 * Convert the burger into five categories.
	 * 1. Bun
	 * 2. Cheese
	 * 3. Veggies
	 * 4. Sauce
	 * 5. Patty
	 * After that, put the ingredient in the correct position in the stack.
	 * Finally, Combine 5 categories to make a new burger.
	 */
	public void addIngredient(final String type) {
		String peek = "";
		String food = "";
		MyStack<String> temp = null;
		MyStack<String> bun = new MyStack<String>();
		MyStack<String> cheeses = new MyStack<String>();
		MyStack<String> veggies = new MyStack<String>();
		MyStack<String> sauces = new MyStack<String>();
		MyStack<String> patties = new MyStack<String>();
		
		int size = order.size();
		while (order.size() != 0) {
			peek = order.peek();
			String categories = peek;
			if (size != order.size()) {	
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					categories = "cheese";			
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					categories = "veggies";
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					categories = "sauces";
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					categories = "patties";
				} else {
					categories = "bun";
				}				
				
				if (!categories.equalsIgnoreCase(food)) {
					temp.push(" ");
					if(categories.equalsIgnoreCase("cheese")) {
						food = "cheese";			
						cheeses.push(order.pop());
						temp = cheeses;
					} else if (categories.equalsIgnoreCase("veggies")) {
						food = "veggies";
						veggies.push(order.pop());
						temp = veggies;
					} else if (categories.equalsIgnoreCase("sauces")) {
						food = "sauces";
						sauces.push(order.pop());
						temp = sauces;
					} else if (categories.equalsIgnoreCase("patties")) {
						food = "patties";
						patties.push(order.pop());
						temp = patties;
					} else {
						food = "bun";
						bun.push(order.pop());
						temp = bun;
					}	
				} else {
					if(categories.equalsIgnoreCase("cheese")) {
						cheeses.push(order.pop());
					} else if (categories.equalsIgnoreCase("veggies")) {
						veggies.push(order.pop());
					} else if (categories.equalsIgnoreCase("sauces")) {
						sauces.push(order.pop());
					} else if (categories.equalsIgnoreCase("patties")) {
						patties.push(order.pop());
					} else {
						bun.push(order.pop());
					}
				}
			} else {
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					food = "cheese";			
					cheeses.push(order.pop());
					temp = cheeses;
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					food = "veggies";
					veggies.push(order.pop());
					temp = veggies;
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					food = "sauces";
					sauces.push(order.pop());
					temp = sauces;
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					food = "patties";
					patties.push(order.pop());
					temp = patties;
				} else {					
					food = "bun";
					bun.push(order.pop());
					temp = bun;
				}
			}	
		}
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		if (cheeses.peek() != null && cheeses.peek().equalsIgnoreCase(" ")) {
			cheeses.pop();
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
		
		if (patties.peek() != null && patties.peek().equalsIgnoreCase(" ")) {
			patties.pop();
		}
		
		//Check what is the category of the ingredient 
		String categories = "";
		switch (type) {
			case "Cheddar":
				categories = "cheeses";
				break;
			case "Mozzarella":
				categories = "cheeses";
				break;
			case "Pepperjack":
				categories = "cheeses";
				break;		
			case "Lettuce":
				categories = "veggies";
				break;
			case "Tomato":
				categories = "veggies";
				break;
			case "Onions":
				categories = "veggies";
				break;
			case "Pickle":
				categories = "veggies";
				break;
			case "Mushrooms":
				categories = "veggies";
				break;
			case "Ketchup":
				categories = "sauces";
				break;
			case "Mustard":
				categories = "sauces";
				break;
			case "Mayonnaise":
				categories = "sauces";
				break;
			case "Baron-Sauce":
				categories = "sauces";
				break;
		}		
		
		if (theWorks) {			
			//Barron Burger and exceptions (ingredients)
			//Try to put the current ingredients in the correct position in the veggies stack.
			if (categories.equalsIgnoreCase("veggies")) {
				if (veggies.size() == 0) {
					veggies.push(type);
				} else {
					MyStack<String> container = new MyStack<String>();
					while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(type)) {
						container.push(veggies.pop());
					}
					
					if (veggies.size() != 0) {
						while (veggies.size() != 0) {
							veggies.push(container.pop());
						}
					} else {
						
						if (type.equalsIgnoreCase("mushrooms")) {
							veggies.push(type);
							veggies.push(" ");
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("onions")) {
							if (container.peek().equalsIgnoreCase("mushrooms")) {
								veggies.push(container.pop());
								if (container.peek().equalsIgnoreCase(" ")) {
									veggies.push(container.pop());
								}
							}
							veggies.push(type);
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("tomato")) {
							if (container.peek().equalsIgnoreCase("mushrooms")) {
								veggies.push(container.pop());
								if (container.peek().equalsIgnoreCase(" ")) {
									veggies.push(container.pop());
								}
							}
							
							if (container.peek().equalsIgnoreCase("onions")) {
								veggies.push(container.pop());
							}
							
							veggies.push(type);
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("lettuce")) {
							if (container.peek().equalsIgnoreCase("mushrooms")) {
								veggies.push(container.pop());
								if (container.peek().equalsIgnoreCase(" ")) {
									veggies.push(container.pop());
								}
							}
							
							if (container.peek().equalsIgnoreCase("onions")) {
								veggies.push(container.pop());
							}
							
							if (container.peek().equalsIgnoreCase("Tomato")) {
								veggies.push(container.pop());
							}
							
							veggies.push(type);
							
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("pickle")) {
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
							veggies.push(type);
						}
						
					}
				}
			}
			
			//Try to put the current ingredients in the correct position in the sauce stack.
			if (categories.equalsIgnoreCase("sauces")) {
				if (sauces.size() == 0) {
					sauces.push(type);
				} else {
					MyStack<String> container = new MyStack<String>();
					while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(type)) {
						container.push(sauces.pop());
					}
					
					if (sauces.size() != 0) {
						while (sauces.size() != 0) {
							sauces.push(container.pop());
						}
					} else {
						if (type.equalsIgnoreCase("ketchup")) {							
							sauces.push(type);
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("mustard")) {
							if (container.peek().equalsIgnoreCase("ketchup")) {
								sauces.push(container.pop());
							}
							sauces.push(type);
							if (container.size() != 0) {
								sauces.push(" ");
							}
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("baron-sauce")) {
							if (container.peek().equalsIgnoreCase("ketchup")) {
								sauces.push(container.pop());
							}
							
							if (container.peek().equalsIgnoreCase("mustard")) {
								sauces.push(container.pop());
								sauces.push(" ");
							}
							
							sauces.push(type);
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("mayonnaise")) {
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
							sauces.push(type);
						}
						
					}
				}
			}
			
			//Try to put the current ingredients in the correct position in the cheese stack.
			if (categories.equalsIgnoreCase("cheeses")) {
				if (cheeses.size() == 0) {
					cheeses.push(type);
				} else {
					MyStack<String> container = new MyStack<String>();
					while (cheeses.size() != 0 && !cheeses.peek().equalsIgnoreCase(type)) {
						container.push(cheeses.pop());
					}
					
					if (cheeses.size() != 0) {
						while (cheeses.size() != 0) {
							cheeses.push(container.pop());
						}
					} else {
						if (type.equalsIgnoreCase("cheddar")) {
							cheeses.push(type);
							while (container.size() != 0) {
								cheeses.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("mozzarella")) {
							if (container.peek().equalsIgnoreCase("cheddar")) {
								cheeses.push(container.pop());
							}
							cheeses.push(type);							
							while (container.size() != 0) {
								cheeses.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("pepperjack")) {
							while (container.size() != 0) {
								cheeses.push(container.pop());
							}
							cheeses.push(type);
						}
						
					}
				}
			}			
		} else {
			//Burger and add ingredients
			if (categories.equalsIgnoreCase("veggies")) {
				if (veggies.size() == 0) {
					veggies.push(type);
				} else {
					MyStack<String> container = new MyStack<String>();
					while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(type)) {
						container.push(veggies.pop());
					}
					
					if (veggies.size() != 0) {
						while (veggies.size() != 0) {
							veggies.push(container.pop());
						}
					} else {
						if (type.equalsIgnoreCase("mushrooms")) {
							veggies.push(type);
							veggies.push(" ");
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("onions")) {
							if (container.peek().equalsIgnoreCase("mushrooms")) {
								veggies.push(container.pop());
								if (container.peek().equalsIgnoreCase(" ")) {
									veggies.push(container.pop());
								}
							}
							veggies.push(type);
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("tomato")) {
							if (container.peek().equalsIgnoreCase("mushrooms")) {
								veggies.push(container.pop());
								if (container.peek().equalsIgnoreCase(" ")) {
									veggies.push(container.pop());
								}
							}
							
							if (container.peek().equalsIgnoreCase("onions")) {
								veggies.push(container.pop());
							}
							
							veggies.push(type);
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("lettuce")) {
							if (container.peek().equalsIgnoreCase("mushrooms")) {
								veggies.push(container.pop());
								if (container.peek().equalsIgnoreCase(" ")) {
									veggies.push(container.pop());
								}
							}
							
							if (container.peek().equalsIgnoreCase("onions")) {
								veggies.push(container.pop());
							}
							
							if (container.peek().equalsIgnoreCase("Tomato")) {
								veggies.push(container.pop());
							}
							
							veggies.push(type);
							
							while (container.size() != 0) {
								veggies.push(container.pop());
							}
						}
					}
				}
			}
			
			if (categories.equalsIgnoreCase("sauces")) {
				if (sauces.size() == 0) {
					sauces.push(type);
				} else {
					MyStack<String> container = new MyStack<String>();
					while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(type)) {
						container.push(sauces.pop());
					}
					
					if (sauces.size() != 0) {
						while (sauces.size() != 0) {
							sauces.push(container.pop());
						}
					} else {
						if (type.equalsIgnoreCase("ketchup")) {
							sauces.push(type);
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("mustard")) {
							if (container.peek().equalsIgnoreCase("ketchup")) {
								sauces.push(container.pop());
							}
							sauces.push(type);
							if (container.size() != 0) {
								sauces.push(" ");
							}
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("baron-sauce")) {
							if (container.peek().equalsIgnoreCase("ketchup")) {
								sauces.push(container.pop());
							}
							
							if (container.peek().equalsIgnoreCase("mustard")) {
								sauces.push(container.pop());
								sauces.push(" ");
							}
							
							sauces.push(type);
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("mayonnaise")) {
							while (container.size() != 0) {
								sauces.push(container.pop());
							}
							sauces.push(type);
						}
						
					}
				}
			}
			
			if (categories.equalsIgnoreCase("cheeses")) {
				if (cheeses.size() == 0) {
					cheeses.push(type);
				} else {
					MyStack<String> container = new MyStack<String>();
					while (cheeses.size() != 0 && !cheeses.peek().equalsIgnoreCase(type)) {
						container.push(cheeses.pop());
					}
					
					if (cheeses.size() != 0) {
						while (cheeses.size() != 0) {
							cheeses.push(container.pop());
						}
					} else {
						if (type.equalsIgnoreCase("cheddar")) {
							cheeses.push(type);
							while (container.size() != 0) {
								cheeses.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("mozzarella")) {
							if (container.peek().equalsIgnoreCase("cheddar")) {
								cheeses.push(container.pop());
							}
							cheeses.push(type);							
							while (container.size() != 0) {
								cheeses.push(container.pop());
							}
						}
						
						if (type.equalsIgnoreCase("pepperjack")) {
							while (container.size() != 0) {
								cheeses.push(container.pop());
							}
							cheeses.push(type);
						}
						
					}
				}
			}				
		}

		//Combine 5 categories stack to make a burger.
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase("pickle")) {
			order.push(veggies.pop());
		}

		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (bun.size() != 0) {
			order.push(bun.pop());
		}
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}

		
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")
				&& (sauces.peek().equalsIgnoreCase("mayonnaise") ||
						sauces.peek().equalsIgnoreCase("baron-sauce"))) {
			order.push(sauces.pop());
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}

		while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(" ")
				&& (veggies.peek().equalsIgnoreCase("onions") 
						|| veggies.peek().equalsIgnoreCase("tomato") 
						|| veggies.peek().equalsIgnoreCase("lettuce"))) {
			order.push(veggies.pop());
		}
		
		
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
					
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}

		while (patties.size() != 1) {
			if (patties.peek().equalsIgnoreCase(" ")) {
				patties.pop();
			} else {
				order.push(patties.pop());
			}
		}

		while (cheeses.size() != 0) {
			order.push(cheeses.pop());				
		}

		if (patties.size() == 1) {
			order.push(patties.pop());
		}
		
		while (veggies.size() != 0) {
			order.push(veggies.pop());
		}
		
		while (sauces.size() != 0) {
			order.push(sauces.pop());
		}
		
		if (bun.peek() != null) {
			order.push(bun.pop());
		}
		
	}
	
	/**
	 * Remove Ingredient.
	 * @param type remove another ingredient.
	 * Convert the burger into five categories.
	 * 1. Bun
	 * 2. Cheese
	 * 3. Veggies
	 * 4. Sauce
	 * 5. Patty
	 * After that, remove the ingredient in the stack.
	 * Finally, Combine 5 categories to make a new burger.
	 */
	public void removeIngredient(final String type) {
		String peek = "";
		String food = "";
		MyStack<String> temp = null;
		MyStack<String> bun = new MyStack<String>();
		MyStack<String> cheeses = new MyStack<String>();
		MyStack<String> veggies = new MyStack<String>();
		MyStack<String> sauces = new MyStack<String>();
		MyStack<String> patties = new MyStack<String>();
		
		int size = order.size();
		while (order.size() != 0) {
			peek = order.peek();
			String categories = peek;
			if (size != order.size()) {	
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					categories = "cheese";			
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					categories = "veggies";
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					categories = "sauces";
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					categories = "patties";
				} else {
					categories = "bun";
				}				
				
				if (!categories.equalsIgnoreCase(food)) {
					temp.push(" ");
					if(categories.equalsIgnoreCase("cheese")) {
						food = "cheese";			
						cheeses.push(order.pop());
						temp = cheeses;
					} else if (categories.equalsIgnoreCase("veggies")) {
						food = "veggies";
						veggies.push(order.pop());
						temp = veggies;
					} else if (categories.equalsIgnoreCase("sauces")) {
						food = "sauces";
						sauces.push(order.pop());
						temp = sauces;
					} else if (categories.equalsIgnoreCase("patties")) {
						food = "patties";
						patties.push(order.pop());
						temp = patties;
					} else {
						food = "bun";
						bun.push(order.pop());
						temp = bun;
					}	
				} else {
					if(categories.equalsIgnoreCase("cheese")) {
						cheeses.push(order.pop());
					} else if (categories.equalsIgnoreCase("veggies")) {
						veggies.push(order.pop());
					} else if (categories.equalsIgnoreCase("sauces")) {
						sauces.push(order.pop());
					} else if (categories.equalsIgnoreCase("patties")) {
						patties.push(order.pop());
					} else {
						bun.push(order.pop());
					}
				}
			} else {
				if(peek.equalsIgnoreCase("cheddar") || peek.equalsIgnoreCase("mozzarella") ||
						peek.equalsIgnoreCase("pepperjack")) {
					food = "cheese";			
					cheeses.push(order.pop());
					temp = cheeses;
				} else if (peek.equalsIgnoreCase("lettuce") || peek.equalsIgnoreCase("tomato") ||
						peek.equalsIgnoreCase("onions") || peek.equalsIgnoreCase("pickle") || 
						peek.equalsIgnoreCase("mushrooms")) {
					food = "veggies";
					veggies.push(order.pop());
					temp = veggies;
				} else if (peek.equalsIgnoreCase("ketchup") || peek.equalsIgnoreCase("mustard") ||
						peek.equalsIgnoreCase("mayonnaise") || peek.equalsIgnoreCase("baron-sauce")) {
					food = "sauces";
					sauces.push(order.pop());
					temp = sauces;
				} else if (peek.equalsIgnoreCase("beef") || peek.equalsIgnoreCase("chicken") || peek.equalsIgnoreCase("veggie")) {
					food = "patties";
					patties.push(order.pop());
					temp = patties;
				} else {					
					food = "bun";
					bun.push(order.pop());
					temp = bun;
				}
			}	
		}
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		if (cheeses.peek() != null && cheeses.peek().equalsIgnoreCase(" ")) {
			cheeses.pop();
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
		
		if (patties.peek() != null && patties.peek().equalsIgnoreCase(" ")) {
			patties.pop();
		}
		
		//Check what is the category of the ingredient 
		String categories = "";
		switch (type) {
			case "Cheddar":
				categories = "cheese";
				break;
			case "Mozzarella":
				categories = "cheese";
				break;
			case "Pepperjack":
				categories = "cheese";
				break;		
			case "Lettuce":
				categories = "veggies";
				break;
			case "Tomato":
				categories = "veggies";
				break;
			case "Onions":
				categories = "veggies";
				break;
			case "Pickle":
				categories = "veggies";
				break;
			case "Mushrooms":
				categories = "veggies";
				break;
			case "Ketchup":
				categories = "sauces";
				break;
			case "Mustard":
				categories = "sauces";
				break;
			case "Mayonnaise":
				categories = "sauces";
				break;
			case "Baron-Sauce":
				categories = "sauces";
				break;
		}	
		
		if (theWorks) {		
			//Try to remove the current ingredients in the cheese stack.
			if (categories.equalsIgnoreCase("cheese")) {
				MyStack<String> container = new MyStack<String>();
				while (cheeses.size() != 0 && !cheeses.peek().equalsIgnoreCase(type)) {
					container.push(cheeses.pop());
				}
				
				if (cheeses.size() != 0) {
					cheeses.pop();
				}
				
				while (container.size() != 0) {
					cheeses.push(container.pop());
				}			
			}
			
			//Try to remove the current ingredients in the sauces stack.
			if (categories.equalsIgnoreCase("sauces")) {
				MyStack<String> container = new MyStack<String>();
				while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(type)) {
					container.push(sauces.pop());
				}
				
				if (sauces.size() != 0) {
					sauces.pop();
				}
				
				while (container.size() != 0) {
					sauces.push(container.pop());
				}
			}
			
			//Try to remove the current ingredients in the veggies stack.
			if (categories.equalsIgnoreCase("veggies")) {
				MyStack<String> container = new MyStack<String>();
				while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(type)) {
					container.push(veggies.pop());
				}
				
				if (veggies.size() != 0) {
					veggies.pop();
				}
				
				while (container.size() != 0) {
					veggies.push(container.pop());
				}
			}
		} else {
			//Remove ingredients in burger
			if (categories.equalsIgnoreCase("cheese")) {
				MyStack<String> container = new MyStack<String>();
				while (cheeses.size() != 0 && !cheeses.peek().equalsIgnoreCase(type)) {
					container.push(cheeses.pop());
				}
				
				if (cheeses.size() != 0) {
					cheeses.pop();
				}
				
				while (container.size() != 0) {
					cheeses.push(container.pop());
				}			
			}
			
			if (categories.equalsIgnoreCase("sauces")) {
				MyStack<String> container = new MyStack<String>();
				while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(type)) {
					container.push(sauces.pop());
				}
				
				if (sauces.size() != 0) {
					sauces.pop();
				}
				
				while (container.size() != 0) {
					sauces.push(container.pop());
				}
			}
			
			if (categories.equalsIgnoreCase("veggies")) {
				MyStack<String> container = new MyStack<String>();
				while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(type)) {
					container.push(veggies.pop());
				}
				
				if (veggies.size() != 0) {
					veggies.pop();
				}
				
				while (container.size() != 0) {
					veggies.push(container.pop());
				}
			}
		}
		
		//Combine 5 categories to make a burger
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase("pickle")) {
			order.push(veggies.pop());
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
		
		if (bun.size() != 0) {
			order.push(bun.pop());
		}
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")
				&& (sauces.peek().equalsIgnoreCase("mayonnaise") ||
				sauces.peek().equalsIgnoreCase("baron-sauce"))) {
			order.push(sauces.pop());
		}
		
		if (sauces.peek() != null && sauces.peek().equalsIgnoreCase(" ")) {
			sauces.pop();
		}
				
		while (veggies.size() != 0 && !veggies.peek().equalsIgnoreCase(" ")
				&& (veggies.peek().equalsIgnoreCase("onions") 
						|| veggies.peek().equalsIgnoreCase("tomato") 
						|| veggies.peek().equalsIgnoreCase("lettuce"))) {				
			order.push(veggies.pop());
		}
		
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}
					
		if (veggies.peek() != null && veggies.peek().equalsIgnoreCase(" ")) {
			veggies.pop();
		}

		while (patties.size() != 1) {
			if (patties.peek().equalsIgnoreCase(" ")) {
				patties.pop();
			} else {
				order.push(patties.pop());
			}
		}
		
		while (cheeses.size() != 0) {				
			order.push(cheeses.pop());				
		}
		
		if (patties.size() == 1) {
			order.push(patties.pop());
		}
		
		while (veggies.size() != 0) {
			order.push(veggies.pop());
		}
		
		while (sauces.size() != 0) {
			order.push(sauces.pop());
		}
		
		if (bun.peek() != null) {
			order.push(bun.pop());
		}
	}
	
	public String toString() {	
		MyStack<String> convert = new MyStack<String>();
		
		while (order.size() != 0) {
			if (order.peek().equalsIgnoreCase("Top Bun")
					|| order.peek().equalsIgnoreCase("Bottom Bun")) {
				order.pop();
				convert.push("Bun");
			} else {
				convert.push(order.pop());
			}	
		}
		
		if (convert.size() != 0) {
			order = convert;
		}
		return order.toString();
	}
}
