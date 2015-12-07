
/*
 	This is the node class, which will create a linked list 
 	node by node. The constructor may be vary according to the 
 	needs. 
 	
 	This node position is part of the MTFEncoder Class
 
 */
public class Node 
{
	// Hiding the properties from miss uses form other programs
	public String word; 
	public Node prev; 
	public Node next;
	public int count; 
	
	public boolean removeFlag; 
	public boolean lastItemFlag; 
	
	

		
	// Constructors for Draft
	
	// For head
	public Node (int countWord, boolean lastItemFlag, Node next)
	{
		this.count = countWord;
		this.lastItemFlag = lastItemFlag; 
		
		
		this.next = next;
	}
	
	public Node (int countWord, String word,  boolean lastItemFlag, Node next)
	{
		this.count = countWord;
		this.lastItemFlag = lastItemFlag; 
		
		this.word = word; 
		this.next = next;
	}
	
	public Node (int countWord, boolean lastItemFlag, Node next, Node prev)
	{
		this.count = countWord; 
		this.lastItemFlag = lastItemFlag; 
		
		this.next = next;  
		this.prev = prev; 
		
	}
	
	public Node (int countWord, String word, boolean lastItemFlag, Node next, Node prev)
	{
		this.count = countWord; 
		this.word = word; 
		this.lastItemFlag = lastItemFlag; 
		
		this.next = next;  
		this.prev = prev; 
		
	}
	
	public Node(String word, Node next) 
	{
		this.word = word; 
		
		this.next = next;
	}

	public Node(String word, Node next, Node prev) 
	{
		this.word = word; 
		
		this.next = next;
		this.prev = prev; 
	}
	
	
	
	
	
	
	

	

	
	
}
