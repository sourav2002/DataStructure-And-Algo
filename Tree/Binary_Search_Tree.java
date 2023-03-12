package Tree;
//import java.util.Scanner;

public class Binary_Search_Tree
{
	 
    public static void main(String[] args){
		
        BinarySearchTree bstree = new BinarySearchTree(); 

        System.out.println("Binary Search Tree\n");          
        char chr;
        
		bstree.insert( 5 ); 
		bstree.insert( 12 ); 
		bstree.insert( 21 ); 
		bstree.insert( 2 ); 
		bstree.insert( 19 ); 
		bstree.insert( 1 ); 
		bstree.insert( 25 ); 
		bstree.insert( 9 );
		bstree.insert( 3 );
		
		//  Displaying the tree
		System.out.print("\nPost order traversal: ");
		bstree.inOrder();
		System.out.print("\nPre order traversal: ");
		bstree.inOrder();
		System.out.print("\nIn order traversal: ");
		bstree.inOrder();
		
		System.out.println();
		
		bstree.insert( 10 );
		
		System.out.println( bstree.search( 9 ) );
		
		bstree.delete( 9 );
		
		System.out.println( bstree.search( 9 ) );
		
		bstree.insert( 9 ); 
		
		System.out.println( bstree.search( 9 ) );

		bstree.delete( 12 );
		
		bstree.insert( 12 );
		
		System.out.println( bstree.search( 12 ) );
		
		
		System.out.println("Number of nodes = "+ bstree.countNodes());
		
		System.out.println("Is empty = "+ bstree.isEmpty());
            
		//  Displaying the tree 
        System.out.print("\nPost order traversal: ");
        bstree.inOrder();
        System.out.print("\nPre order traversal: ");
        bstree.inOrder();
        System.out.print("\nIn order traversal: ");
        bstree.inOrder();  

		System.out.print("\nDescending Order: ");
        bstree.descending(); 	

		System.out.print("\nMinimum Value: ");
        System.out.println(bstree.minValue()); 	

		System.out.print("\nMaximum Value: ");
        System.out.println(bstree.minValue()); 				

    }
}
