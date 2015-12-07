

/*
 	This node position is part of the MTFEncoder Class
 */
public class NodePosition 
{
	public String word; 
	public boolean lastItemFlag; 
	public NodePosition next; 
	public NodePosition prev; 
	// This constructor is for encoding index of the word
	public NodePosition (String word, boolean lastItemFlag, NodePosition next) 
	{
		this.word = word; 
		this.lastItemFlag = lastItemFlag;
		
		this.next = next;
	}


	public NodePosition (String word, boolean lastItemFlag, NodePosition next, NodePosition prev) 
	{
		this.word = word; 
		this.lastItemFlag = lastItemFlag;
		
		this.next = next;
		this.prev = prev;
	}
}
