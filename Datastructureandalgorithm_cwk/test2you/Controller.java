/**
 * 
 */
package test2you;

/**
 * A controller for the Test2you COVID-19 Test Kits Distribution system.
 * This controller includes the 5 features that the intended prototype COVID-19
 * Test Kits Distribution system is expected to have.
 * 
 * @author Hai Wang
 * @version 07/11/2022
 */
public interface Controller {

	/**
	 * Lists all the requests received on that day.
	 * 
	 * @return a String representation of the list of requests received on that day,
	 *         presented by the order of distribution.
	 */
	String listAllRequests();

	/**
	 * Lists the sequence of requests which are fulfilled on the day.
	 * 
	 * @return a String representation of the sequence of fulfilled requests.
	 */
	String listFulfilledRequests();

	/**
	 * Lists the sequence of the unfulfilled and partially fulfilled requests which are
	 * pushed to the next day's order. Note when the requests are pushed, the order
	 * number might change so that they will be in the front of the next day request
	 * queue.
	 * 
	 * @return a String representation of the sequence of pushed requests.
	 */

	String listPushedRequests();

	/**
	 * Lists the warehouses with the test kits in stock.
	 * 
	 * @return a String representation of the list of warehouses with the test
	 *         kits in stock and the stock information.
	 */

	String listAvailableWarehouses();

	/**
	 * Lists the shortest path view the shortest path to visit all the warehouses
	 * with stock available. The path is represented as a sequence of locations
	 * between the specified locations.
	 * 
	 * @return a String representation of a path to visit all the warehouses with
	 *         stock available and the expected travel distance between stops.
	 */
	String showShortestPathWithStock();

}
