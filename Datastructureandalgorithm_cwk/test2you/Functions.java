/**
 * 
 */
package test2you;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author divya
 *
 */
public class Functions implements Controller {

	  public String distributionOrderOne = "Keyworker";
	  public String distributionOrderTwo = "Symptomatic";
	  public String distributionOrderThree = "Standard";
	  public static int totalKitsInStock = 100;
	  public static int pack = 0;
	  public static boolean result = false;
	  public static int partially_filled = 0;
	  public static int partially_filled_order = 0;
	  static int[] previous;
	    
	    
	  /**
	   * Read data from the customerOrders file and compare the data based on the priority
	   * @return stringBuilder object returns the data 
	   * 
	   */
	    
	    @Override
	  public String listAllRequests() {
	      StringBuilder stringBuilder = new StringBuilder();
	      String line;
	        
	      //comparing with keyworker
	      try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	          while((line = br.readLine()) != null){
	              String[] items = line.split(",");                   
	              if(items[1].equalsIgnoreCase(distributionOrderOne)){  
	              // Call function to display each record
	                  displayAllRequests(items,stringBuilder);
	                  stringBuilder.append("\n");
	              }
	          }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        
	      //comparing with Sympotomatic
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            while((line = br.readLine()) != null){
	                String[] items = line.split(",");                   
	                if(items[1].equalsIgnoreCase(distributionOrderTwo)){
	                    // Call function to display each record
	                    displayAllRequests(items,stringBuilder);
	                    stringBuilder.append("\n");
	                }
	            }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        
	      //comparing with Standard
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            while((line = br.readLine()) != null){
	                String[] items = line.split(",");   
	                if(items[1].equalsIgnoreCase(distributionOrderThree)){
	                    // Call function to display each record
	                    displayAllRequests(items,stringBuilder);
	                    stringBuilder.append("\n");
	                }
	            }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        System.out.println("");
	        if(stringBuilder.length() == 0){
	            System.out.println("No Record Found");
	        } 
	        return stringBuilder.toString();
	    }
	    
	    
	    /**
		 * This function displays each requests one by one in sorted order 
		 * @param items
		 * @param stringBuilder
		 */
	    public static void displayAllRequests(String[] items, StringBuilder stringBuilder){
	        for(int i=0; i<items.length; i++){
	            if(i==0){
	                 stringBuilder.append("Order Number : "+items[0]);
	            }
	            if(i==1){
	                 stringBuilder.append("\tPriority : "+items[1]);
	            }
	            if(i==2){
	                 stringBuilder.append("\t\tCustomer Name : "+items[2]);
	            }
	            if(i==3){
	                char[] pad = new char[25 - items[2].length()];
	                Arrays.fill(pad, ' ');
	                stringBuilder.append(pad).append("\tNo. Of Kits : "+items[3]+" packs");
	            }
	            if(i==4){
	                char[] pad = new char[15 - items[3].length()];
	                Arrays.fill(pad, ' ');
	                stringBuilder.append(pad).append("\tAddress : "+items[4]);
	            }
	        }
	    }
	    /**
	     * view all the requests which are fulfilled on that day 
	     * @return the fulfilled data from the requests
	     */
	    @Override
	    public String listFulfilledRequests() {
	        partially_filled = 0;
	        totalKitsInStock = 100;
	        partially_filled_order = 0;
	        
	        
	        StringBuilder stringBuilder = new StringBuilder();
	        String line;
	        boolean breakLoop = false;
	         
	         
	        //distributionOrderOne
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            while((line = br.readLine()) != null && !breakLoop){

	                String[] items1 = line.split(",");  
	                String[] items = new String[6];
	                items[0] = items1[3];// kits in order
	                items[1] = items1[0];// order number
	                items[2] = items1[1]; // priority
	                items[3] = items1[2];// customer name
	                items[4] = items1[4];// Location
	                // keyworker
	                if(items[2].equalsIgnoreCase(distributionOrderOne)){
	                    /*
	                    * Print all records
	                    */
	                    displayFulfilledRequests(items,stringBuilder,breakLoop);
	                }
	            }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        
	        // Symptomatic
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            while((line = br.readLine()) != null && !breakLoop){

	                String[] items1 = line.split(",");  
	                String[] items = new String[6];
	                items[0] = items1[3];// kits in order
	                items[1] = items1[0];// order number
	                items[2] = items1[1];// priority
	                items[3] = items1[2];// customer name
	                items[4] = items1[4];// Location
	                 

	                if(items[2].equalsIgnoreCase(distributionOrderTwo)){  
	                    /*
	                    * Print all records
	                    */
	                    displayFulfilledRequests(items,stringBuilder,breakLoop);
	                }
	            }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        
	        //Standard
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            while((line = br.readLine()) != null && !breakLoop){

	                String[] items1 = line.split(",");  
	                String[] items = new String[6];
	                items[0] = items1[3];// kits in order
	                items[1] = items1[0];// order number
	                items[2] = items1[1]; // priority
	                items[3] = items1[2]; // customer name
	                items[4] = items1[4];// Location

	                if(items[2].equalsIgnoreCase(distributionOrderThree)){  
	                    /*
	                    * Print all records
	                    */
	                    displayFulfilledRequests(items,stringBuilder,breakLoop);
	                }
	            }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        System.out.println("");
	        
	        if(stringBuilder.length() == 0){
	            System.out.println("No Record Found");
	        } 
	        return stringBuilder.toString();
	    }
	    
	    
	    
	    /**
		   *  Function to display FulFilled Requests
		   * @param items
		   * @param stringBuilder
		   * @param breakLoop
		   */
	    public static void displayFulfilledRequests(String[] items, StringBuilder stringBuilder, boolean breakLoop){
	        for(int i=0; i<items.length; i++){
	            /*
	            * Print all records
	            */  
	            if(i==1 && totalKitsInStock > 0 && partially_filled == 0){
	                stringBuilder.append("\tOrder Number : "+items[1]);
	                if(partially_filled == 1){
	                  breakLoop = true;
	                }  
	            }
	            if(i==2 && totalKitsInStock > 0 && partially_filled == 0){
	                stringBuilder.append("\tPriority : "+items[2]);
	                if(partially_filled == 1){
	                  breakLoop = true;
	                } 
	            }
	            if(i==3 && totalKitsInStock > 0 && partially_filled == 0){
	                stringBuilder.append("\t\tCustomer Name : "+items[3]);
	                if(partially_filled == 1){
	                  breakLoop = true;
	                } 
	            }
	            if(i==0 && totalKitsInStock > 0 && partially_filled == 0){
	                pack = Integer.parseInt(items[0]);
	                /*
	                * Fulfill the order
	                */                                                
	                result  = fulfillOrder(pack);

	                if(partially_filled == 0){
	                    stringBuilder.append("No. Of Kits Ordered : "+items[0]+" packs");
	                    stringBuilder.append("\t\tFulfilled Order : "+pack+" packs");
	                }
	                if(partially_filled == 1){
	                  breakLoop = true;
	                }   
	            }
	            if(i==4 && totalKitsInStock > 0 && partially_filled == 0){
	                char[] pad = new char[26 - items[3].length()];
	                Arrays.fill(pad, ' ');
	                stringBuilder.append(pad).append("\tAddress : "+items[4]);
	                if(partially_filled == 1){
	                  breakLoop = true;
	                } 
	            }
	        }
	        if(partially_filled == 0){
	            stringBuilder.append("\n");
	        }
	    }
	    
	    
	    /**
	     * Function to fulfill the orders (Partially / Fully)
	     * @param packs
	     * @return
	     */
	    public static boolean fulfillOrder(int packs){
	        int subtract =  totalKitsInStock - packs;
	        
	        //Partially filled Orders
	        if(subtract <= 0){
	            pack = packs - 1;
	            partially_filled = 1;
	            return false;
	        }
	       
	        //Fulfilled Orders
	        else{
	            totalKitsInStock = totalKitsInStock - packs;
	            return true;
	        }
	    }
	    /**
		 * unfulfilled and partially fulfilled requests which are pushed to the next day's order
		 * @return partially fulfilled data in the file
		 */

	    @Override
	    public String listPushedRequests() {
	        partially_filled = 0;
	        totalKitsInStock = 100;
	        partially_filled_order = 0;
	        
	        StringBuilder stringBuilder = new StringBuilder();
	        String line;
	        boolean breakLoop = false;
	         
	         
	        //distributionOrderOne
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            
	            while((line = br.readLine()) != null && !breakLoop){
	                
	                String[] items1 = line.split(",");  
	                String[] items = new String[6];
	                items[0] = items1[3];
	                items[1] = items1[0];
	                items[2] = items1[1];
	                items[3] = items1[2];
	                items[4] = items1[4];

	                if(items[2].equalsIgnoreCase(distributionOrderOne)){
	                    /*
	                    * Print all records
	                    */
	                     displayPartiallyFilledRequests(items,stringBuilder);
	                }
	            }
	        } catch (Exception e){
	        }
	        
	        //distributionOrderTwo
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            while((line = br.readLine()) != null && !breakLoop){

	                String[] items1 = line.split(",");  
	                String[] items = new String[6];
	                items[0] = items1[3];
	                items[1] = items1[0];
	                items[2] = items1[1];
	                items[3] = items1[2];
	                items[4] = items1[4];

	                if(items[2].equalsIgnoreCase(distributionOrderTwo)){
	                    /*
	                    * Print all records
	                    */
	                     displayPartiallyFilledRequests(items,stringBuilder);
	                }
	            }
	        } catch (Exception e){
	        }
	        
	        //distributionOrderThree
	        try (BufferedReader br = new BufferedReader(new FileReader("customerOrders.csv"))) {
	            while((line = br.readLine()) != null && !breakLoop){

	                String[] items1 = line.split(",");  
	                String[] items = new String[6];
	                items[0] = items1[3];
	                items[1] = items1[0];
	                items[2] = items1[1];
	                items[3] = items1[2];
	                items[4] = items1[4];

	                if(items[2].equalsIgnoreCase(distributionOrderThree)){
	                    /*
	                    * Print all records
	                    */
	                    displayPartiallyFilledRequests(items,stringBuilder);
	                }
	            }
	        } catch (Exception e){
	        }
	        
	        System.out.println("");
	        
	        if(stringBuilder.length() == 0){
	            System.out.println("No Record Found");
	        }        
	        return stringBuilder.toString();

	    }

	    
	    
	    /**
		  * Function to display Partially Filled Requests
		  * @param items
		  * @param stringBuilder
		  */
	    public static void displayPartiallyFilledRequests(String[] items, StringBuilder stringBuilder){
	        for(int i=0; i<items.length; i++){
	            if(i==1 && totalKitsInStock > 0 && partially_filled == 1){
	                stringBuilder.append("\tOrder Number : "+items[1]);
	            }
	            if(i==2 && totalKitsInStock > 0 && partially_filled == 1){
	                stringBuilder.append("\tPriority : "+items[2]);
	            }
	            if(i==3 && totalKitsInStock > 0 && partially_filled == 1){
	                stringBuilder.append("\t\tCustomer Name : "+items[3]);
	            }
	            if(i==0 && totalKitsInStock > 0){
	                pack = Integer.parseInt(items[0]);

	                /*
	                * Fulfill the order
	                */
	                
	                result  = fulfillOrder(pack);

	                if(partially_filled == 1){
	                    pack = 0;
	                    stringBuilder.append("No. Of Kits Ordered : "+items[0]+" packs");
	                    stringBuilder.append("\t\tFulfilled Order : "+pack+" packs");
	                }                         
	            }
	            if(i==4 && totalKitsInStock > 0 && partially_filled == 1){
	                char[] pad = new char[26 - items[3].length()];
	                Arrays.fill(pad, ' ');
	                stringBuilder.append(pad).append("\tAddress : "+items[4]);
	            }
	        }
	        if(partially_filled == 1){
	            stringBuilder.append("\n");
	        }
	    }
	    
	    
	    /**
		 * displays how many test kits are available in warehouse
		 * @return the warehouse available stock    
		 */
	    
	    @Override
	    public String listAvailableWarehouses() {
	        StringBuilder stringBuilder = new StringBuilder();
	        
	        String line;
	        try (BufferedReader br = new BufferedReader(new FileReader("warehouseStock.csv"))) {
	            while((line = br.readLine()) != null){
	                String[] items = line.split(",");                
	                if(!items[1].equals("0")){
	                	//add the items
	                    stringBuilder.append("\n"+line);
	                }
	            }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        if(stringBuilder.length() == 0){
	            System.out.println("No Record Found");
	        } 
	        return stringBuilder.toString();
	    }
	    
	    /**
		 * finding the shortest path of warehouses
		 * 
		 */

	 
	    @Override
	    public String showShortestPathWithStock() {
	        
	    	int I = Integer.MAX_VALUE;

	        int[][] adjMatrix = readwarehouseLocationMap("warehouseLocationMap.csv");
	        
	        Set<Integer> noStockIndexes = new HashSet<>();
	        /*for warehouse A stock is 0 - noStockIndexes.add(0)
	         * for warehouse B stock is 0 - noStockIndexes.add(1)
	         * for warehouse C stock is 0 - noStockIndexes.add(2)
	         * for warehouse D stock is 0 - noStockIndexes.add(3)
	         * for warehouse E stock is 0 - noStockIndexes.add(4)*/
	        noStockIndexes.add(2);
	        int n = adjMatrix.length;
	       
	        for (int v = 0; v < n; v++)
	        {
	            for (int u = 0; u < n; u++)
	            {
	                if(noStockIndexes.contains(v) || noStockIndexes.contains(u) )
	                {
	                    adjMatrix[v][u] = I;
	                }
	            }
	        }

	        floydWarshall(adjMatrix, noStockIndexes);
		StringBuilder stringBuilder= new StringBuilder();
		
	        return stringBuilder.toString();
	    }

	    /**
		 * to print the paths of the warehouses and add the route
		 * @param path
		 * @param v
		 * @param u
		 * @param route
		 */
		 private static void printPath(int[][] path, int v, int u, List<Integer> route)
		    {
		        if (path[v][u] == v) {
		            return;
		        }
		        printPath(path, v, path[v][u], route);
		        route.add(path[v][u]);
		    }
		 /**
		  * finding  the possible paths
		  * @param nums
		  * @return results of the possible route
		  */
		 private static List<List<Integer>> permute(int[] nums) {
		        List<List<Integer>> result = new ArrayList<>();
		        permutation(0, nums, result);
		        return result;
		    }
		 	/**
		 	 *  
		 	 * it describes the number of ways the  paths can be in ordered 
		 	 * @param i
		 	 * @param nums
		 	 * @param result
		 	 */
		    private static void permutation(int i, int[] nums, List<List<Integer>> result) {
		        if (i == nums.length - 1) {
		            List<Integer> list = new ArrayList<>();
		            for (int n : nums) list.add(n);
		            result.add(list);
		        } else {
		            for (int j = i, l = nums.length; j < l; j++) {
		                int temp = nums[j];
		                nums[j] = nums[i];
		                nums[i] = temp;
		                permutation(i + 1, nums, result);
		                temp = nums[j];
		                nums[j] = nums[i];
		                nums[i] = temp;
		            }
		        }
		    }
		    /**
		     * finding valid nodes,and least distance paths and total distance of the shortest path
		     * @param path
		     * @param cost
		     * @param n
		     * @param noStockIndexes
		     */
		    private static void printSolution(int[][] path, int[][] cost, int n,Set<Integer> noStockIndexes)
		    {
		        Set<Integer> validNodes= new HashSet<>();
		        // noStockIndexes  is 1(i.e B) other than 1 remaining paths are valid  
		        for (int i = 1; i < n; i++)
		        {
		            if(!noStockIndexes.contains(i))
		            {
		                validNodes.add(i);// size of the validpaths
		            }
		        }
		        // finding valid paths
		        int[] nodes = new int[validNodes.size()];

		        int startIndex = 0;

		        for (int node : validNodes)
		        {
		            nodes[startIndex] = node;
		            startIndex++;
		        }
		        // nodes =[2,3,4,5]
		        List<List<Integer>> possibleRoutes = permute(nodes);


		        int leastDistance = Integer.MAX_VALUE;
		        List<List<Integer>> leastPath = new ArrayList<>();
		        // 
		        for (List<Integer> route : possibleRoutes)
		        {
		            boolean[] visited = new boolean[n];
		            visited[0] = true;
		            int currentDistance = 0;
		            int  startNode = 0;
		            List<List<Integer>>  pathFollowed = new ArrayList<>();
		            // once the path is visited, it doesn't visit again
		            for (int endNode : route)
		            {
		            	
		                if(!visited[endNode])
		                {
		                    List<Integer> leastRoute = new ArrayList<>();
		                    leastRoute.add(startNode);
		                    printPath(path, startNode, endNode, leastRoute);
		                    leastRoute.add(endNode);
		                    pathFollowed.add(leastRoute);
		                    for (int routeNode : leastRoute)
		                    {
		                        visited[routeNode] = true;
		                    }
		                    currentDistance += cost[startNode][endNode];
		                    startNode = endNode;
		                }
		            }
		            currentDistance += cost[startNode][0];
		            List<Integer> leastRoute = new ArrayList<>();
		            leastRoute.add(startNode);
		            printPath(path, startNode, 0, leastRoute);
		            leastRoute.add(0);
		            pathFollowed.add(leastRoute);
		            // if current distance is less than least distance then least distance is equal to current distance
		            if(currentDistance < leastDistance)
		            {
		                leastDistance = currentDistance;
		                leastPath = new ArrayList<>(pathFollowed);
		            }
		        }

		        System.out.println("The total distance needed to be covered is " + leastDistance +" miles");


		        int prevNode = 0;
		        for (List<Integer> route: leastPath)
		        {
		            System.out.println("Path -> " + route.toString() + " cost -> " + cost[route.get(0)][route.get(route.size()-1)]);
		        }
		        
		    }
		    /**
		     * floydWarshall helps to find out the shortest path
		     * @param adjMatrix
		     * @param noStockIndexes
		     */
		    public static void floydWarshall(int[][] adjMatrix, Set<Integer>  noStockIndexes)
		    {
		        if (adjMatrix ==null || adjMatrix.length == 0) {
		            return;
		        }

		        int n = adjMatrix.length;
		        int[][] cost = new int[n][n];
		        int[][] path = new int[n][n];
		        //implementing foldy algorithm
		        for (int v = 0; v < n; v++)
		        {
		            for (int u = 0; u < n; u++)
		            {
		                cost[v][u] = adjMatrix[v][u];

		                if (v == u) {
		                    path[v][u] = 0;
		                }
		                else if (cost[v][u] != Integer.MAX_VALUE) {
		                    path[v][u] = v;
		                }
		                else {
		                    path[v][u] = -1;
		                }
		            }
		        }
		        // Adding vertices individually
		        for (int k = 0; k < n; k++)
		        {
		            for (int v = 0; v < n; v++)
		            {
		                for (int u = 0; u < n; u++)
		                {
		                    if (cost[v][k] != Integer.MAX_VALUE
		                            && cost[k][u] != Integer.MAX_VALUE
		                            && (cost[v][k] + cost[k][u] < cost[v][u]))
		                    {
		                        cost[v][u] = cost[v][k] + cost[k][u];
		                        path[v][u] = path[k][u];
		                    }
		                }
		            }
		        }

		        printSolution(path, cost,  n, noStockIndexes);
		    }
		    /**
		     * Read warehouseLocationMap file data for graph
		     * @param fileName
		     * @return a 2 dimentional graph data
		     */
			private static int[][] readwarehouseLocationMap(String fileName) {
				List<List<Integer>> arrayList = new ArrayList<>();
		        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		            String line;
		            boolean row1 = true;
		            
		            while ((line = br.readLine()) != null) {
		                if (row1) {
		                    row1 = false;
		                    continue;
		                }
		                String[] items = line.split(",");
		                
		                ArrayList<Integer> arrayList1 = new ArrayList<>();
		                
		                boolean rows = true;
		                for (String item : items) {
		                    if (rows) {
		                        rows = false;
		                        continue;
		                     }
		                    // add the item in arrayList1
		                    arrayList1.add(Integer.parseInt(item));
		                }
		                // add the arrayList data into arrayList
		                arrayList.add(arrayList1);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        // from warehousemaplocation file size is 6
		        int[][] adjMatrix = new int[arrayList.size()][];
		        for (int i = 0; i < arrayList.size(); i++) {
		            List<Integer> row = arrayList.get(i);
		            adjMatrix[i] = new int[row.size()];
		            for (int j = 0; j < row.size(); j++) {
		                adjMatrix[i][j] = row.get(j);
		            }
		        }
		        return adjMatrix;
				
			}

	   
}
