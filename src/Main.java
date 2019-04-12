import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static final String INPUT = "customer.txt";
	private static final String OUTPUT = "trace.txt";
	public static final String FILE_NOT_FOUND = "The file doesn't exits.";
	private static BufferedWriter writer;
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
			if (backPart.toLowerCase().contains("but")) {
				butCondition = "but";
				if (backPart.toLowerCase().contains("no")) {
					if (backPart.toLowerCase().contains("but no")) {
						butCondition = "but no";	
					}
				} 
				String[] data = backPart.split(butCondition);

				if (data.length > 1) {
					if(burgerOrder.toLowerCase().contains("baron burger")) {
						if (data[0].toLowerCase().contains("with")) {
							withCondition = "with";
							if (data[0].toLowerCase().contains("no")) {
								if (backPart.toLowerCase().contains("with no")) {
									withCondition = "with no";
								}
							}
							burgerOmissions = data[0].substring(withCondition.length()).trim();
						}
						burgerExceptions = data[1].trim();
					} else {
						if (data[0].toLowerCase().contains("with")) {
							withCondition = "with";
							if (data[0].toLowerCase().contains("no")) {
								if (data[0].toLowerCase().contains("with no")) {
									withCondition = "with no";
								}
							}
							burgerAddtions = data[0].substring(withCondition.length()).trim();
						}
						burgerExceptions = data[1].trim();
					}
				} else {
					burgerExceptions = data[0].trim();
				}
			} else if (backPart.toLowerCase().contains("with")) {
				if (backPart.toLowerCase().contains("no")) {
					if (backPart.toLowerCase().contains("with no")) {
						withCondition = "with no";
					}
				}
				if(burgerOrder.toLowerCase().contains("baron burger")) {
					burgerOmissions = backPart.substring(withCondition.length()).trim();
				} else {
					burgerAddtions = backPart.substring(withCondition.length()).trim();
				}
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
		try {
			writer.write(burgerType.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testMyStack() {
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("======================Begin Test Stack======================");
		MyStack <String> test = new MyStack<String>();
		if(test.isEmpty()) {
			System.out.println("Stack is not empty.");
		} else {
			System.out.println("Stack is empty now.");
		}
		
		test.push("Computer");
		test.push("Engineering");
		test.push("University");
		test.push("Washington");
		test.push("Of");
		test.push("Tacoma");
		test.push("Spring");
		test.push("2019");
		System.out.println(test.toString());
		System.out.println("Stack Size:  " + test.size());
		System.out.println("Pop and push to a new stack");
		MyStack <String> temp = new MyStack<String>();
		StringBuilder str = new StringBuilder();
		while (test.size() != 0) {
			str.append(test.peek());
			str.append(" ");
			temp.push(test.pop());
		}
		System.out.println(str.toString());
		
		if(test.isEmpty()) {
			System.out.println("Stack is empty now.");
		}
		
		System.out.println(test.pop());
		System.out.println(test.pop());
		
		System.out.println("Change Engineering to Science");
		while (temp.size() != 0) {
			if (temp.peek().equalsIgnoreCase("Engineering")) {
				temp.pop();
				test.push("Science");
			} else {
				test.push(temp.pop());
			}			
		}
		System.out.println(test.toString());
		System.out.println("======================End Test Stack======================");
	}
	
	public static void testBurger() throws IOException {
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("======================Begin Test Burger======================");
		Burger testBurger = new Burger(true);
		testBurger.toString();
		testBurger.changePatties("Veggie");
		testBurger.toString();
		System.out.println(testBurger.toString());
		testBurger = new Burger(true);
		testBurger.removeCategory("Cheese");
		testBurger.addIngredient("Mozzarella");
		testBurger.addPatty();
		testBurger.addPatty();
		System.out.println(testBurger.toString());
		testBurger = new Burger(false);
		testBurger.toString();
		testBurger.addCategory("Veggies");
		testBurger.removeIngredient("Lettuce");
		testBurger.toString();
		System.out.println(testBurger.toString());
		testBurger = new Burger(false);
		testBurger.addIngredient("Ketchup");
		testBurger.addIngredient("Cheddar");
		testBurger.addIngredient("Onions");
		testBurger.addIngredient("Mushrooms");
		testBurger.addPatty();
		testBurger.changePatties("Chicken");
		System.out.println(testBurger.toString());
		System.out.println("======================End Test Burger======================");
	}
	
	public static void main(String[] args) throws IOException {		
		final File input = new File(INPUT);
		final File out = new File(OUTPUT);
		final FileWriter output = new FileWriter(out);
		
		if (input.isDirectory() || (!input.exists() || !input.isFile())) {
			throw new IOException(FILE_NOT_FOUND);
		}
		
		if ((!out.exists())) {
			out.createNewFile();
		}
		
		final Scanner inputScanner = new Scanner(input);
		writer = new BufferedWriter(output);
		int processingOrder = 0;
		//Read customer order from file.
		while (inputScanner.hasNextLine()) {   
			String nextLine = inputScanner.nextLine();
			if (nextLine.length() > 0) {
				writer.write("Processing Order " + processingOrder + ": " + nextLine);
				System.out.println("Processing Order " + processingOrder + ": " + nextLine);
				writer.write("\n");
	            parseLine(nextLine);
	            System.out.println("");
	            writer.write("\n");
	            writer.write("\n");
	            processingOrder++;  
			}    
        }
		writer.close();
		inputScanner.close();
		testMyStack();
		testBurger();
	}
}
