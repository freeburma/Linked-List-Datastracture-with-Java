

/*
 	This node position is part of the MTFDecoder Class
 */
public class NodeDecode 
{
	// Hiding the properties from miss uses form other programs
	public String word; 
	public int count; 
	
	public NodeDecode prev; 
	public NodeDecode next;
	
	public NodeDecode (int count, NodeDecode next)
	{
		this.count = count; 

		this.next = next; 
		
	}

	
	// For head
	public NodeDecode (int countWord, String word, NodeDecode next)
	{
		this.count = countWord; 
		this.word = word; 
		
		this.next = next; 
	}
	
	public NodeDecode (int countWord, String word, NodeDecode next, NodeDecode prev)
	{
		this.count = countWord; 
		this.word = word; 
		
		this.next = next;
		this.prev = prev; 
	}
	
	// Constructor for final decoding

	public NodeDecode(String word, NodeDecode next) 
	{
		this.word = word; 
		
		this.next = next;
	}

	public NodeDecode(String word, NodeDecode next, NodeDecode prev) 
	{
		this.word = word; 
		
		this.next = next;
		this.prev = prev; 
	}

}
