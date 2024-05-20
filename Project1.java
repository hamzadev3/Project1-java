
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Project1 {
	public static void main(String[] args) throws FileNotFoundException {
	//read in file from my local desktop
		// may not work on a computer with different directory 
		
		File file=new File("/Users/hamza/Desktop/P1input.txt");
		int length=0;

		try(Scanner filescanner=new Scanner(file)){
			while (filescanner.hasNextLine()) {
				filescanner.nextLine();
				length++;
			}
		}
		Scanner filescanner=new Scanner(file);
		String [] storage=new String[length]; //storage holds rest of string values
		//String [] results=new String[length-1];
		for(int i=0; i<length; i++) { //deliberately put i beginning at 1 to ignore first value
		storage[i]=filescanner.nextLine();
		}
		String[] results=new String[storage.length-1];
		System.arraycopy(storage, 1, results, 0, results.length);
		// String array results HOLDS RESULTS
		// String first HOLDS FIRST STRING VALUE
		System.out.println("The possible combinations as solutions are: ");
		for(int i=0; i<results.length; i++) {
			System.out.println(results[i]); 
		}
		String first=storage[0]; // first line of text file
		System.out.println("The word to reference is: ");
		System.out.println(first);
		
}

}