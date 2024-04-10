/**
 * 
 */
package test2you;

import java.util.Scanner;

/**
 * A simple text-based user interface for the Test2you COVID-19 Test Kits Distribution System.
 * 
 * @author S H S Wong and H Wang
 * @version 07/11/2022
 */
public class TUI {

	private Controller controller;  

	private Scanner stdIn;
	
	public TUI(Controller controller) {
		
		this.controller = controller;
		
		// Creates a Scanner object for obtaining user input
		stdIn = new Scanner(System.in);
		
		while (true) {
			displayMenu();
			getAndProcessUserOption();
		}
	}

	/**
	 * Displays the header of this application and a summary of menu options.
	 */
	private void displayMenu() {
		display(header());
		display(menu());
	}
	
	/**
	 * Obtains an user option and processes it.
	 */
	private void getAndProcessUserOption() {
		String command = stdIn.nextLine().trim();
		String inputLine, locationA, locationB;
		int deliverTripID;
		
		switch (command) {
		case "1" : // Lists the orders in each delivery trip
			display("Lists all the requests received on that day...");
			display(controller.listAllRequests());
			break;
		case "2" : // Lists the sequence of requests which are fulfilled on the day
			display("Lists the sequence of requests which are fulfilled on the day...");
			display(controller.listFulfilledRequests());
			
			break;
		case "3" : // Lists the sequence of pushed requests on the day
			display("Lists the sequence of pushed requests on the day...");
			display(controller.listPushedRequests());
			break;
		case "4" : // Lists the list of warehouses with the test kits in stock
			display("Lists the list of warehouses with the test kits in stock....");
			display(controller.listAvailableWarehouses());
			break;
		case "5" : // Lists the shortest path to visit all the warehouses
			       //with stock available
			display("Lists the shortest path to all the availble warehouses...");	
			display(controller.showShortestPathWithStock());
			
			break;
		case "6" : // Exits the application
			display("Goodbye!");
			System.exit(0);
			break;
		default : // Not a known command option
			display(unrecogniseCommandErrorMsg(command));
		}
	}
	
	/*
	 * Returns a string representation of a brief title for this application as the header.
	 * @return	a header
	 */
	private static String header() {
		return "\n Test2you COVID-19 Test Kits Distribution System\n";
	}
	
	/*
	 * Returns a string representation of the user menu.
	 * @return	the user menu
	 */
	private static String menu() {
		return "Enter the number associated with your chosen menu option.\n" +
			   "1: Lists all the requests received on that day\n" +
			   "2: Lists the sequence of requests which are fulfilled on the day\n" +
			   "3: Lists the sequence of pushed requests on the day\n" +
			   "4: Lists the list of warehouses with the test kits in stock\n" +
			   "5: Lists the shortest path to all the availble warehouses\n" +
			   "6: Exit this application\n";
	}
	
	/*
	 * Displays the specified info for the user to view.
	 * @param info	info to be displayed on the screen
	 */
	private void display(String info) {
		System.out.println(info);
	}
	
    /*
     * Returns an error message for an unrecognised command.
     * 
     * @param error the unrecognised command
     * @return      an error message
     */
    private static String unrecogniseCommandErrorMsg(String error) {
            return String.format("Cannot recognise the given command: %s.%n", error);
    }

}
