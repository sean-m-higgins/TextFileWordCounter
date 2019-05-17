//package template.group.id.artifact.id;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
	
	
		System.out.println("Please enter the path of the file: ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.nextLine();
		File file = new File(fileName);
		System.out.println("Now please enter a starting index under " + (file.length()/10) + ":");
		int startIndex = keyboard.nextInt();

		// used to store key/value pair of word/count
		HashMap<String, Integer> theMap = new HashMap<>();

		// creates linked list to sort
		LinkedList sortedText = new LinkedList();

		try{
			// put text into map
			// ^ =the pattern must start at new line // \p{Alnum} is the alphanumeric pattern
			//+ allows the pattern to repeat multiple times
			Scanner text = new Scanner(file).useDelimiter("[^\\p{Alnum}]+");
			// skips all positions up to starting index
			for (int i=0; i < startIndex; i++)	{
					text.next();
			}
			// adds next 1000 words to map, and makes them all lowercase
			for (int j=0; j < 1000; j++)	{
				String key = text.next().toLowerCase();
				int count = theMap.getOrDefault(key,0);
				count++;
				theMap.put(key,count);
			}
			// adds map entries to linked list
			for (Map.Entry<String, Integer> entry : theMap.entrySet())	{
				sortedText.push(entry);
			}
		}
		catch(IOException e)	{
			System.out.println("Error: " + e.getMessage());
		}

        // Apply merge Sort 
        sortedText.head = sortedText.mergeSort(sortedText.head); 
        //System.out.print("\n\nSorted Linked List: \n");
        //sortedText.printList(sortedText.head);
		
		// prints top ten nodes
		sortedText.printTopTen(sortedText.head);
	}
}