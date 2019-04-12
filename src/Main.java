import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static final String INPUT = "customer.txt";
	private static final String OUTPUT = "trace.txt";
	public static final String FILE_NOT_FOUND = "The file doesn't exits.";
	
	public static void parseLine(final String line) {
		String pattyCount;
		String pattyType;
		String burgerOrder = "Burger";
		String withCondition = "";
		String burgerOmissions = "";
		String burgerAddtions = "";
		String butCondition = "";
		String burgerExceptions = "";
		Burger burgerType = null;

		final Scanner currentLine = new Scanner(line);
		currentLine.useDelimiter(" "); 
		pattyCount = currentLine.next();
		boolean checkCount = false;
		boolean checkType = false;
		switch (pattyCount) {
			case "Single":
				checkCount = true;
				break;
			case "Double":
				checkCount = true;
				break;
			case "Triple":
				checkCount = true;
				break;			
		}
		
		if (!checkCount) {
			pattyType = pattyCount;
			pattyCount = "Single";			
			checkType = false;
			switch (pattyType) {
				case "Beef":
					checkType = true;
					break;
				case "Chicken":
					checkType = true;
					break;
				case "Veggie":
					checkType = true;
					break;			
			}
			
			if (!checkType) {
				final String burger = pattyType;
				pattyType = "Beef";

				if(burger.toLowerCase().contains("baron")) {
					burgerType = new Burger(true);
					burgerOrder = "Baron Burger";
				} else {
					burgerType = new Burger(false);
				}
			} else {
				final String burger = currentLine.next();
				if(burger.toLowerCase().contains("baron")) {
					burgerType = new Burger(true);
					burgerOrder = "Baron Burger";
				} else {
					burgerType = new Burger(false);
				}
			}
		} else {
			pattyType = currentLine.next();
			checkType = false;
			switch (pattyType) {
			case "Beef":
				checkType = true;
				break;
			case "Chicken":
				checkType = true;
				break;
			case "Veggie":
				checkType = true;
				break;			
			}
			
			if (!checkType) {
				final String burger = pattyType;
				pattyType = "Beef";
				//Checking the input is a baron burger or burger.
				if(burger.toLowerCase().contains("baron")) {
					burgerType = new Burger(true);
					burgerOrder = "Baron Burger";
				} else {
					burgerType = new Burger(false);
				}
			}
		}
		
		if (checkCount && checkType) {
			final String burger = currentLine.next();
			if(burger.toLowerCase().contains("baron")) {
				burgerType = new Burger(true);
				burgerOrder = "Baron Burger";
			} else {
				burgerType = new Burger(false);
			}
		}
		
		String frontPart = "";
		if (!checkCount) {
			if(checkType) {
				frontPart = pattyType.concat(" " + burgerOrder);
			} else {
				frontPart = burgerOrder;
			}			
		} else {
			if(checkType) {
				frontPart = pattyCount.concat(" " + pattyType).concat(" " + burgerOrder);
			} else {
				frontPart = pattyCount.concat(" " + burgerOrder);
			}
			
		}

		currentLine.close();

		String backPart = line.substring(frontPart.length()).trim();
		if (backPart.length() > 0) {
			if (burgerOrder.toLowerCase().contains("baron burger")) {
				withCondition = "with no";
				butCondition = "but";
			} else {
				withCondition = "with";
				butCondition = "but no";
			}
			
			if (backPart.toLowerCase().contains(withCondition) && 
					backPart.toLowerCase().contains(butCondition)) {
				String[] data = backPart.split(butCondition);
				if (burgerOrder.toLowerCase().contains("baron burger")) {
					burgerOmissions = data[0].substring(withCondition.length()).trim();					
				} else {
					burgerAddtions = data[0].substring(withCondition.length()).trim();
				}
				burgerExceptions = data[1].trim();
			} else if (backPart.toLowerCase().contains(withCondition)) {
				if (burgerOrder.toLowerCase().contains("baron burger")) {
					burgerOmissions = backPart.substring(withCondition.length()).trim();					
				} else {
					burgerAddtions = backPart.substring(withCondition.length()).trim();
				}
			} else if (backPart.toLowerCase().contains(butCondition)) {
				burgerExceptions = backPart.substring(butCondition.length()).trim();
			}
		}
		
		//Categories
		if (burgerOrder.toLowerCase().contains("baron burger")) {
			//with no
			String[] arrOmmision;
			if (burgerOmissions.trim().length() > 0) {
				arrOmmision = burgerOmissions.split(" ");
				if (arrOmmision.length > 1) {
					for (int i = 0; i < arrOmmision.length; i++) {
						if (arrOmmision[i].toLowerCase().equals("cheese")) {
							burgerType.removeCategory("Cheese");
						} else if (arrOmmision[i].toLowerCase().equals("sauce")) {
							burgerType.removeCategory("Sauce");
						} else if (arrOmmision[i].toLowerCase().equals("veggies")) {
							burgerType.removeCategory("Veggies");
						} else {
							burgerType.removeIngredient(arrOmmision[i]);
						}
					}
				} else {
					if (arrOmmision[0].toLowerCase().equals("cheese")) {
						burgerType.removeCategory("Cheese");
					} else if (arrOmmision[0].toLowerCase().equals("sauce")) {
						burgerType.removeCategory("Sauce");
					} else if (arrOmmision[0].toLowerCase().equals("veggies")) {
						burgerType.removeCategory("Veggies");
					} else {
						burgerType.removeIngredient(arrOmmision[0]);
					}
				}
			}
		} else {
			String[] arrAdditions;
			if (burgerAddtions.trim().length() > 0) {
				arrAdditions = burgerAddtions.split(" ");
				if (arrAdditions.length > 1) {
					for (int i = 0; i < arrAdditions.length; i++) {
						if (arrAdditions[i].toLowerCase().equals("cheese")) {
							burgerType.addCategory("Cheese");
						} else if (arrAdditions[i].toLowerCase().equals("sauce")) {
							burgerType.addCategory("Sauce");
						} else if (arrAdditions[i].toLowerCase().equals("veggies")) {
							burgerType.addCategory("Veggies");
						} else {
							burgerType.addIngredient(arrAdditions[i]);
						}
					}
				} else {
					if (arrAdditions[0].toLowerCase().equals("cheese")) {
						burgerType.addCategory("Cheese");
					} else if (arrAdditions[0].toLowerCase().equals("sauce")) {
						burgerType.addCategory("Sauce");
					} else if (arrAdditions[0].toLowerCase().equals("veggies")) {
						burgerType.addCategory("Veggies");
					} else {
						burgerType.addIngredient(arrAdditions[0]);
					}
				}
			}
		}

		//Items
		if (burgerOrder.toLowerCase().contains("baron burger")) {
			String[] arrExceptions;
			if (burgerExceptions.trim().length() > 0) {
				arrExceptions = burgerExceptions.split(" ");
				if (arrExceptions.length > 0) {
					for (int i = 0; i < arrExceptions.length; i++) {					
						burgerType.addIngredient(arrExceptions[i]);
					}
				} 
			}
		} else {			
			String[] arrExceptions;
			if (burgerExceptions.trim().length() > 0) {
				arrExceptions = burgerExceptions.split(" ");
				if (arrExceptions.length > 0) {
					for (int i = 0; i < arrExceptions.length; i++) {
						burgerType.removeIngredient(arrExceptions[i]);
					}
				} 
			}			
		}

		//Change Patty
		if (!pattyType.equalsIgnoreCase("beef")) {
			burgerType.changePatties(pattyType);
		}
		

		//Add Patty
		if (pattyCount.equalsIgnoreCase("double")) {
			burgerType.addPatty();
		}
		
		if (pattyCount.equalsIgnoreCase("triple")) {
			burgerType.addPatty();
			burgerType.addPatty();
		}

		System.out.println(burgerType.toString());
	}
	
	public void testMyStack() {
		
	}
	
	public void testBurger() {
		
	}
	
	public static void main(String[] args) throws IOException {		
		final File input = new File(INPUT);
		final File output = new File(OUTPUT);
		
		if (input.isDirectory() || (!input.exists() || !input.isFile())) {
			throw new IOException(FILE_NOT_FOUND);
		}
		
		if (output.isDirectory() || (!output.exists() || !output.isFile())) {
			throw new IOException(FILE_NOT_FOUND);
		}
		
		final Scanner inputScanner = new Scanner(input);
		int processingOrder = 0;
		//Read customer order from file.
		while (inputScanner.hasNextLine()) {   
			System.out.print("Processing Order " + processingOrder + ": ");
            parseLine(inputScanner.nextLine());
            processingOrder++;            
        }
		inputScanner.close();
	}
}
