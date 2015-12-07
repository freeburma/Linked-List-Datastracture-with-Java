import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/*
 	This method will decode back to original conditions and format
 */
public class MTFDecoder 
{
	// Decoding Head 
	private   NodeDecode decodeHead;
	private   NodeDecode decodeTail;
	
	private int size = 0; 
	
	public MTFDecoder ()
	{	
	}

	
	// Adding to linked list for importing from file
	public void addToLinkedList_2Arg (int count, String word) 
	{
		if (decodeHead == null)
		{
			decodeTail = new NodeDecode (count, word, null);
			decodeHead = decodeTail;
			
		}
		else
		{
			decodeTail.next = new NodeDecode (count, word, null, decodeTail);
			decodeTail = decodeTail.next; 
		}
		
	}
	
	// Creating linked list that decoded words 
	private NodeDecode decodeHeadFinal = null;
	private NodeDecode decodeTailFinal = null;
	public   void addToLinkedList (String word) 
	{
		if (decodeHeadFinal == null)
		{
			decodeTailFinal = new NodeDecode (word, null);
			decodeHeadFinal = decodeTailFinal;
			
		}
		else
		{
			decodeTailFinal.next = new NodeDecode (word, null, decodeTailFinal);
			decodeTailFinal = decodeTailFinal.next; 
		}
		
	}
	/*
	 	This method will track and trace for decoding
	 */
	private NodeDecode decodeTempHead = null; 
	private NodeDecode decodeTempTail = null; 
	
	public void addToLinkedListDecodeTemp (String word) 
	{
		if (decodeTempHead == null)
		{
			decodeTempTail = new NodeDecode (word, null);
			decodeTempHead = decodeTempTail;
			
		}
		else
		{
			decodeTempTail.next = new NodeDecode (word, null, decodeTempTail);
			decodeTempTail = decodeTempTail.next; 
		}
		
	}
	
	
	/*
	 	This method will add the 
	 */
	
	public void readingFiles (String fileName) throws IOException
	{
		// Creating buffer reader and FileReader to read file
		FileReader reader = new FileReader (fileName); 
		BufferedReader buffer = new BufferedReader (reader); 
		
		String line = buffer.readLine(); 
		
		// Reading the file
		while (line != null)
		{
			// Reading words by space
			String[] tokens = line.split(" ");
			
			// Found decoded code
			if (tokens.length == 1)
			{
				//System.out.println(tokens [0]);
				addToLinkedList_2Arg (Integer.parseInt(tokens [0]), "");
			}
			else
			{
				// word and decode code
				String tempWord = tokens [1];
				
				if (tempWord.equals("**Space**"))
				{
					tempWord = " "; 
				}
				
				if (tempWord.equals("**new_line**"))
				{
					tempWord = "\n"; 
				}
				addToLinkedList_2Arg (Integer.parseInt(tokens [0]), tempWord );
			
			}
			
		
			// Reading the next line
			line = buffer.readLine(); 
			
		}
		
		System.out.println("Decode Read File successfully ...."); 
		
		// Closing the file
		reader.close(); 		// Otherwise, it be still in memory
		
		
	}// End readingFiles

	/*
		This method will decode the words back to original conditions. 
		
	 */
	public void decode ()
	{
		// Creating temp node
		NodeDecode tempHead = decodeHead; 
		
		// Reading though list
		while (tempHead != null)
		{
			
			String word = ""; 
			
			// Found genuine word - no need to decode
			if (tempHead.count == 0)
			{				
				word = tempHead.word;
				addToLinkedList(tempHead.word);
			}
			// Found word which is the neighbours
			else if (tempHead.count == 1)
			{
				
				word = tempHead.prev.word;
				addToLinkedList(tempHead.prev.word);
			}
			else // Encoding 
			{
				String tempString = backwardReading (tempHead.count) ;
				
				
				word = tempString;
				addToLinkedList(tempString);
			}
			
			// Adding and keeping the list at current then decoder know the exact word
			addToLinkedListDecodeTemp (word);
			tempHead = tempHead.next; 
		}
		
	}

	/*
	  This method will read the word back ward. So it knows the positions and 
	  return its word
	 */
	public String backwardReading (int countWord) 
	{
		String word = ""; 
		int count = 0; 
		NodeDecode tempTail = decodeTempTail; 			
		
		while (tempTail != null)
		{
			
			count ++; 
			// Go int to word index
			if (count == countWord)
			{
				word = tempTail.word;
			}
			
			//System.out.println(tempTail.word); 
			tempTail = tempTail.prev; 
			
		}
		
		// Return the word
		return word; 
	}
	
	
	/*
	 	 This method will display the decoded word
	 */
	public void decodeDisplay ()
	{
		NodeDecode decode = decodeHeadFinal; 
		
		System.out.println("Decoding Display"); 
		while (decode != null)
		{
			System.out.print(decode.word); 
			decode = decode.next; 
		}
	}
	
	
	/*
 		Output to file 
	 */
	public void writeFileDecode (String fileName) throws IOException
	{
		// Creating filewriter and print writer to write to file
		FileWriter writer = new FileWriter (fileName + ".txt"); 
		PrintWriter output = new PrintWriter (writer); 
		
		// Crating temp head
		NodeDecode tempHead = decodeHeadFinal; 
		
		while (tempHead != null)
		{
			output.print(tempHead.word); 
			
			tempHead = tempHead.next; 
		}
		
		
		System.out.println("\n\nDecode Program has been output the textfile successfully...");
		
		// closing the file
		writer.close(); 
		
	}

}
