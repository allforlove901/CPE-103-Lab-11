import java.util.Scanner;

public class AVLTest {

	public static void main(String[] args) {
		
		boolean quit = false;
		BasicAVL myTree = new BasicAVL();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu of operations:");
		System.out.println("   - add/insert..(enter the letter a)");
		System.out.println("   - print.......(enter the letter p)");
    	System.out.println("   - quit........(enter the letter q)");
    	
    	while(!quit){
    		System.out.println("Choose an option");
    		String input =  sc.nextLine();
    		
    		switch(input){
    		
    		case"a":
    			System.out.println("please enter a numerical value to add");
    			int store = Integer.parseInt(sc.nextLine());
        		myTree.insert(store);
    			System.out.println(store + " inserted");
    			break;
    			
    		case"p":
    			myTree.print();
    			break;
    			
    		case"q":
    			System.out.println("quitting");
    			quit = true;
    			break;
    			
			default:
    			System.out.println("invalid choice");
    			break;
    		}
    	}
	}
}
