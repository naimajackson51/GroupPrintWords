import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class GroupPrintWords 
{
	public static void main(String[] args) throws IOException
	{
		String filename = "test.txt";
		Map<Integer, Long> result = new TreeMap<>();
		
		
		try(Scanner in = new Scanner(new File(filename)))
		{
			List <String> wordsList = new ArrayList<>();
			while(in.hasNext())
			{
				wordsList.add(in.next());
			}//end of while
			
			Stream<String> words = wordsList.stream();
			result = words.collect(
			Collectors.groupingBy(w -> w.length(), //key
			Collectors.counting()));//count
		}//end of try
		
		System.out.println("Word Count in: " + filename + " " + result);
	} //end of main method
} //end of class
