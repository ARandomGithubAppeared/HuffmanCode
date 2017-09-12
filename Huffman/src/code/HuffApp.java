package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;


public class HuffApp {
	private int[]freqTable;
	private final static int ASCII_TABLE_SIZE = 128;
	private String originalMessage = "";
	private PriorityQ theQueue;
	private HuffTree huffTree;
	private String encodedMessage = "";
	private String[] codeTable;
	private String decodedMessage = "";
	

	public static void main(String[] args) {
		new HuffApp();	
	}
		
	
	public HuffApp() {
		codeTable = new String[ASCII_TABLE_SIZE];  
		readInput();
		displayOriginalMessage();
		makeFrequencyTable(originalMessage);
		displayFrequencyTable();
		addToQueue();
		buildTree(theQueue);
		//when the following method is implemented, remove the "//", so it executes
		//makeCodeTable(huffTree.root, "");  						
		encode();
		displayEncodedMessage();
		displayCodeTable();
		decode();
		displayDecodedMessage();		
	}
	
	private void readInput() {
		try {
		BufferedReader in = new BufferedReader(new FileReader(new File ("input.txt")));
			
				originalMessage= in.readLine();
				in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//read input in from the input.txt file and save to originalMessage	field
	}
	
	private void displayOriginalMessage() {
		System.out.println("Original message: " +  originalMessage);
	}
	
	private void makeFrequencyTable(String inputString)
	{	
		char tempChar;
		freqTable= new int[256];
		for (int x=0; x<inputString.length();x++) {
			tempChar=inputString.charAt(x);
			freqTable[tempChar]++;
		}
		
		for(int x=0;x<256;x++) {
			if (freqTable[x]!=0) {
				
			}
		}
		
		//populate the frequency table using inputString. results are saved to the 
		//freqTable field
	}
	
	private void displayFrequencyTable()
	{	
		char letter;
		for(int x=0;x<256;x++) {
			letter=(char) x;
			if (freqTable[x]!=0) {
				System.out.println(letter+"    " + freqTable[x]);
			}
		}
		//print the frequency table. skipping any elements that are not represented
	}
	
	private void addToQueue() 
	{
		for(int x=0;x<256;x++) {
			if (freqTable[x]!=0) {
				HuffTree tree= new HuffTree ((char) x,freqTable[x]);
				theQueue.insert(tree);
			}
		}
		
		//add the values in the frequency table to the PriorityQueue. Hint use the 
		//PriorityQ class. save the results to theQueue field
	}
	
	private void buildTree(PriorityQ hufflist) 
	{
		
		//pull items from the priority queue and combine them to form 
		//a HuffTree. Save the results to the huffTree field
	}
	
	private void makeCodeTable(HuffNode huffNode, String bc)
	{		
		
		//hint, this will be a recursive method
	}
	
	private void displayCodeTable()
	{	
		//print code table, skipping any empty elements
	}
	
	private void encode()                   
	{		
		//use the code table to encode originalMessage. Save result in the encodedMessage field
	}

	private void displayEncodedMessage() {
		System.out.println("\nEncoded message: " + encodedMessage);		
	}

	private void decode()
	{
		//decode the message and store the result in the decodedMessage field
	}
	
	public void displayDecodedMessage() {
		System.out.println("Decoded message: " + decodedMessage);
	}	
}
