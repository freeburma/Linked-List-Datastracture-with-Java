import java.io.IOException;
import java.util.Scanner;

/*
  java EncodingDecodingMain testFile.txt
*/


public class EncodingDecodingMain 
{
	public static void main (String args []) throws IOException
	{
		// Creating the objects from Encoder and Decoder
		MTFEncoder encoder = new MTFEncoder (); 
		MTFDecoder decoder = new MTFDecoder (); 
		
		
		//String fileName = "testFile.txt";
		
		// Getting input and output file name
		String fileNameInput = ""; 
		Scanner input = new Scanner (System.in); 
		if (args.length == 1)
		{	
			// Getting file name
			String fileName = args [0]; 
			
			// Reading the file
			encoder.readingFiles (fileName);
			
			//Displaying from linkedList
			encoder.display (); 
			
			// Getting the user input to avoid overriding the file
			System.out.print ("\n\nEnter to output the text file name for Encoding  : "); 
			fileNameInput = input.nextLine(); 
			
			// Writing the list to the text file
			encoder.writeFileEncode (fileNameInput); 
			
			// Reading input for decoding
			decoder.readingFiles(fileNameInput + ".txt");
			
			// Decoding
			decoder.decode ();
			
			// Displaying decoded list
			decoder.decodeDisplay ();
			
			// Getting the user input to avoid overriding the file
			System.out.print ("\n\nEnter to output the text file name for Decoding : "); 
			fileNameInput = input.nextLine(); 
			
			// Writing the list to the text file
			decoder.writeFileDecode (fileNameInput); 
			
		}
		else
		{
			System.out.println ("\n\nYou haven't entered file name or \n You should enter only 1 arguments. " ); 
			
		}	
		
		System.out.println("\nProgram finished... draft"); 
	}
	

}
