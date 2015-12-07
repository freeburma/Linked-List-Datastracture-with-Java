import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MTFEncoder 
{
	
	// The size of the list
	private int size = 0; 
	
	// Creating the constructor
	public MTFEncoder ()
	{	
		headDraft = null;
		tailDraft = null;
		
		// Creating a head item 
		head = null;
		tail = null;
		
	}
	
	/*
	 	Draft Linked List for Encoding
	 	
	 	 This method will collect the all the letters and spaces 
	 	 from the textFile. 
	 */

	private Node headDraft;
	private Node tailDraft;

	/*
	  	This method will create the node 
	 */
	public void addToLinkedListDraft (String word) 
	{
		if (headDraft == null)
		{
			tailDraft = new Node (word, null);
			headDraft = tailDraft;
			
		}
		else
		{
			tailDraft.next = new Node (word, null, tailDraft);
			tailDraft = tailDraft.next; 
		}
		
	}
	
	
	/*
	  	This method will create the node 
	 */
	private Node head ;
	private Node tail;
	public void addToLinkedList (int count, boolean haveSeen) 
	{
		if (headDraft == null)
		{
			tailDraft = new Node (count, haveSeen, null);
			headDraft = tailDraft;
			
		}
		else
		{
			tailDraft.next = new Node (count, haveSeen, null, tailDraft);
			tailDraft = tailDraft.next; 
		}
		
	}
	

	/*
	  	This method will create the node 
	 */
	public void addToLinkedList (int count, String word, boolean haveSeen) 
	{
		if (headDraft == null)
		{
			tailDraft = new Node (count, word, haveSeen, null);
			headDraft = tailDraft;
			
		}
		else
		{
			tailDraft.next = new Node (count, word, haveSeen, null, tailDraft);
			tailDraft = tailDraft.next; 
		}
		
	}
	
	
	/*
	 	This method will calculate the encode word 
	 */
	private NodePosition headPosition = null;
	private NodePosition tailPosition = null;
	
	public   void addToLinkedListPosition (String word, boolean lastItemFlag) 
	{
		if (headPosition == null)
		{
			tailPosition = new NodePosition (word, lastItemFlag, null);
			headPosition = tailPosition;
			
		}
		else
		{
			tailPosition.next = new NodePosition (word, lastItemFlag, null, tailPosition);
			tailPosition = tailPosition.next; 
		}
		
	}
	
	
	/*
	 	 This method will calculate the length of the list
	 */
	public int Size()
	{
		Node tempHead = headDraft; 
		
		// Counting the size of the linked list
		while (tempHead != null)
		{
			size ++;
			tempHead = tempHead.next; 
		}
		
		return size; 
	}
	
	
	
	/*
	  	This method will display the linked list.
	 */
	public void display ()
	{
		Node tmp = headDraft; 
		
		while (tmp != null)
		{
			if (tmp.count == 0)
			{
				//System.out.println(tmp.count + " " + tmp.word);
				System.out.println(tmp.count + " " + tmp.word);
				
			}
			else
			{
				System.out.println(tmp.count);
				//System.out.println(tmp.count);
				
			}
			
			
			tmp = tmp.next; 
		}
		
		System.out.println("\n\bThe size of the list : " + Size ()); 
	} 
	
	/*
	 	 This method will encode the word and calculate the 
	 	 its position. 
	 	 For example - the word found first time will display [0 word] 
	 */
	public void encode (String word)
	{
		
		int countWord = 0; 
		
		 
		 NodePosition tempHead = headPosition; 
		 
		/*
		  	Calculating the index
		 */
		 while (tempHead != null )
		 {
			 // Checking the last node 
			 if (tempHead.word.equals(word)&& tempHead.lastItemFlag == true )
			 {
				 tempHead.lastItemFlag = false;
				 countWord  = 1; 
				 
			 }
			 else 
				 countWord ++; 
			 
			 
			  
			 tempHead = tempHead.next; 
			 
		 }
		 
		 	// Adding to the list
		 	addToLinkedList (countWord, true);
		 	countWord = 0; 
	}
	
	
	/*
	 	This method will check if there word is in the list 
	 	or not 
	 	
	 	return true if found, otherwise return false
	 */		
	public boolean hasElement (String word)
	{
		// Creating a new head to get the keys from the linkedlist
		NodePosition tempHead = headPosition; 
		 
		//boolean flag = false; 
		
		if (headPosition == null)
			return false; 
		
		// Checking the item in the list 
		
		while (tempHead != null)
		{
			// The word found in the list
			if (tempHead.word.equals(word))
			{
				// Found the word is in the list
				return true;
				 
			}
			 
			tempHead = tempHead.next; 
			
		}
		
		// Return not found
		return false; 
		
	}// End hasElement
	
	/*
	 	This method will read from the file and seperates
	 	to the single word
	 */
	
	public void readingFiles (String fileName) throws IOException
	{
		// Creating buffer reader and FileReader to read file
		FileReader reader = new FileReader (fileName); 
		BufferedReader buffer = new BufferedReader (reader); 
		
		String line = buffer.readLine(); 
		String tempWord = ""; 
		
		// Spliting the line to sperate words
		//StringTokenizer split; 
		
		// Reading the file
		while (line != null)
		{
			// Reading including special chars 
			String p = "\\W|\\w+"; 
			
			// Looking for pattern
			Pattern pattern = Pattern.compile(p); 
			Matcher matcher = pattern.matcher(line); 
			
			// Looking for more elements in the list
			while (matcher.find())
			{
				String word = matcher.group(0);
				
				if (word.equals(" "))
				{
					word = "**Space**";
				}
				
				if (!hasElement (word))
				{
					addToLinkedList (0, word, true);
					// Adding the word to get position
					addToLinkedListPosition (word, true);
				}
				else
				{
					// Encode the word
					encode (word);
					
					// adding to the linked list
					addToLinkedListPosition (word, true);
					
				}
			}// end while - match
			
			// Putting new line char
			String newLine = "**new_line**";
			if (!hasElement (newLine))
			{	
				addToLinkedListDraft (newLine);
				addToLinkedListPosition (newLine, true);
			}	
			else
			{
				encode (newLine);
				addToLinkedListPosition (newLine, true);
			}
				
			// Getting new line char
			
			
			// Reading the next line
			line = buffer.readLine(); 
			
		}
		
		// Closing the file
		System.out.println("Encode Read File Successfully ..."); 
		reader.close(); 		// Otherwise, it be still in memory
		
		
	}// End readingFiles
	
	/*
	 	Output to file 
	 */
	public void writeFileEncode (String fileName) throws IOException
	{
		// Creating filewriter and print writer to write to file
		FileWriter writer = new FileWriter (fileName + ".txt"); 
		PrintWriter output = new PrintWriter (writer); 
		
		// Crating temp head
		Node tempHead = headDraft; 
		
		while (tempHead != null)
		{
			if (tempHead.count == 0)
				output.println(tempHead.count + " " + tempHead.word);
			else
				output.println(tempHead.count);
			
			tempHead = tempHead.next; 
		}
		
		
		System.out.println("\n\nProgram has been output the Encode textfile successfully...\n\n");
		
		// closing the file
		writer.close(); 
		
	}
	
	
	
	
	
	

}
