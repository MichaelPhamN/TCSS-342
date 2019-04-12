public class Burger {
	private MyStack<String> order = new MyStack<String>();
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
		MyStack<String> temp = new MyStack<String>();
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
		
		patties.push(patties.peek());
				
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
			
			while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")) {
				if (sauces.peek().equalsIgnoreCase("mayonnaise") ||
						sauces.peek().equalsIgnoreCase("baron-sauce")) {
					order.push(sauces.pop());
				}
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
			
			while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")) {
				if (sauces.peek().equalsIgnoreCase("mayonnaise") ||
						sauces.peek().equalsIgnoreCase("baron-sauce")) {
					order.push(sauces.pop());
				}
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
		
		if (type.equalsIgnoreCase("cheese")) {
			cheeses = new MyStack<String>();
			cheeses.push("Cheddar");
			cheeses.push("Mozzarella");
			cheeses.push("Pepperjack");
		}
		
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
		
		if (type.equalsIgnoreCase("sauce")) {
			sauces = new MyStack<String>();
			sauces.push("Ketchup");
			sauces.push("Mustard");
			sauces.push(" ");
			sauces.push("Baron-Sauce");
			sauces.push("Mayonnaise");
		}
		
		//Top Bun
		if (bun.size() != 0) {
			order.push(bun.pop());
		}			
		
		
		if (bun.peek() != null && bun.peek().equalsIgnoreCase(" ")) {
			bun.pop();
		}
		
		//Sauce (Mayonnaise or Baron-Sauce)
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")) {
			if (sauces.peek().equalsIgnoreCase("mayonnaise") ||
					sauces.peek().equalsIgnoreCase("baron-sauce")) {
				order.push(sauces.pop());
			}
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
		
		if (type.equalsIgnoreCase("cheese")) {
			cheeses = new MyStack<String>();
		}
		
		if (type.equalsIgnoreCase("veggies")) {
			veggies = new MyStack<String>();
		}
		
		if (type.equalsIgnoreCase("sauce")) {
			sauces = new MyStack<String>();
		}
		
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
		
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")) {
			if (sauces.peek().equalsIgnoreCase("mayonnaise") ||
					sauces.peek().equalsIgnoreCase("baron-sauce")) {
				order.push(sauces.pop());
			}
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
		
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")) {
			if (sauces.peek().equalsIgnoreCase("mayonnaise") ||
					sauces.peek().equalsIgnoreCase("baron-sauce")) {
				order.push(sauces.pop());
			}
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
		
		while (sauces.size() != 0 && !sauces.peek().equalsIgnoreCase(" ")) {
			if (sauces.peek().equalsIgnoreCase("mayonnaise") ||
					sauces.peek().equalsIgnoreCase("baron-sauce")) {
				order.push(sauces.pop());
			}
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
		return order.toString();
	}
}
