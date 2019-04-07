import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static final String ORDER = "customer.txt";
	
	public static final String FILE_NOT_FOUND = "The file doesn't exits.";
	
	public static void parseLine(final String line) {
		String pattyCount;
		String pattyType;
		String burgerOrder = " ";
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
					burgerOrder = burgerOrder.concat("Baron Burger");
				} else {
					burgerType = new Burger(false);
					burgerOrder = burgerOrder.concat("Burger");
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
					burgerOrder = burgerOrder.concat("Baron Burger");
				} else {
					burgerType = new Burger(false);
					burgerOrder = burgerOrder.concat("Burger");
				}
			}
		}
		
		if (checkCount && checkType) {
			final String burger = currentLine.next();
			if(burger.toLowerCase().contains("baron")) {
				burgerType = new Burger(true);
				burgerOrder = burgerOrder.concat("Baron Burger");
			} else {
				burgerType = new Burger(false);
				burgerOrder = burgerOrder.concat("Burger");
			}
		}
		currentLine.close();
		
		if(checkCount && checkType) {
			System.out.println(pattyCount.concat(burgerOrder));
		} 
		
		if (!checkCount) {
			System.out.println(burgerOrder);
		}
		
		System.out.println(burgerType.toString());
	}
	
	public void testMyStack() {
		
	}
	
	public void testBurger() {
		
	}
	
	public static void main(String[] args) throws IOException {		
		final File order = new File(ORDER);
		
		if (order.isDirectory() || (!order.exists() || !order.isFile())) {
			throw new IOException(FILE_NOT_FOUND);
		}
		
		final Scanner input = new Scanner(order);
		int processingOrder = 0;
		//Read customer order from file.
		while (input.hasNextLine()) {   
			System.out.print("Processing Order " + processingOrder + ": ");
            parseLine(input.nextLine());
            processingOrder++;            
        }
        input.close();
	}
}
