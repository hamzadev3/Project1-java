import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PuzzleGUI extends JFrame{

private JLabel puzzle; // label to store target word
private JTextArea resultsarea;
private String first; 
private String[] results;
private LinkedList<String> guesses;
private int track;

public PuzzleGUI(String first, String[] results) {
	this.first=first;
	this.results=results;
	this.guesses=new LinkedList<>();
	this.track=0;
	box();
}
private void box() {
	setTitle("Guess the combinations");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel main=new JPanel(new GridLayout(1,2)); // create a grid 1 by 2
	puzzle=new JLabel("Enter combinations for this word: "+first);
	// 'puzzle' is given the target word or blueprint for left column
	resultsarea=new JTextArea();//right column blueprint created 
	resultsarea.setEditable(false);//Small detail to make writing impossible outside of the button 
	JButton guess=new JButton("Click here to guess!");
	//button for submitting guesses is created 
	guess.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			guessaction();
		}
	}
);
	main.add(puzzle); //puzzle or target word is added to left column 
	JPanel rightColumn=new JPanel(new BorderLayout());
	rightColumn.add(resultsarea, BorderLayout.CENTER);
	//results are added to the right column, at the center of it 
	rightColumn.add(guess, BorderLayout.SOUTH);
	//guess button is placed at the bottom of the right column 
	main.add(rightColumn);
	//right column is added to the grid 
	add(main); //grid is added to the frame
	setSize(700, 500);
	setVisible(true);
	
}
private void guessaction() { //handles user input 
	String enterguess=JOptionPane.showInputDialog(null, "Enter your guess: ");
	//check if guess is correct
	if(enterguess.length()<5) {
		JOptionPane.showMessageDialog(null, "Enter a guess 5 char's or longer.");
	} //length check works 
	boolean condition=false;
	for(int i=0; i<enterguess.length(); i++) {
			char hold=enterguess.charAt(i);
			if(hold=='l'||hold=='a'||hold=='t'||hold=='i'||hold=='p'||hold=='m'||hold=='o') { // CONTINUE HERE WORKING ON Character contains check 
				condition=true;
			} else {
				condition=false;
				if(condition==false) { //to exit after one incorrect
					incChar();
					break; // all this extra code to make sure program exits after repeating the dialog ONE TIME
				}
			}
		
		
		/*	
		if(condition!=true) {
			JOptionPane.showMessageDialog(null, "Enter a character that belongs to the initial word");
		} */
	} // letter check works but can be optimized  
	
	if(guesscheck(enterguess)) {
		guesses.add(enterguess);
		track+=1;
		updateBox();
	} else { //show dialog for incorrect guess 
		JOptionPane.showMessageDialog(null, "Incorrect guess, try again");
	}
}
	private void incChar() {
		JOptionPane.showMessageDialog(null, "Enter a character that belongs to the initial word");
	}

	private boolean guesscheck(String enterguess) { //function to check if entered guess is correct
		for(int i=0; i<results.length; i++) {
			if(enterguess.equalsIgnoreCase(results[i])) {
				return true;
			}
		}
		return false;
	}
	private void updateBox() { //handles gui box updating with each correct user input 
		
		StringBuilder sb=new StringBuilder(); //control right panel
		
		sb.append("Guesses:\n");
		for(String x: guesses) {
			sb.append(x).append("\n");
		}
		sb.append("\nScore: ").append(track);
		resultsarea.setText(sb.toString());
	}
	
	public static void main(String[] args) {
		PuzzleGUI puzzleGUI=new PuzzleGUI("latipmo", new String[] {"aioli", "allot", "appall", "atilt", "atoll", "impala", "laptop", "lollipop", "lotto", "mallot", "mammal", "militia", "moola", "optimal", "palatial", "papal", "pilot", "plait", "polio", "tilapia", "total"});
	}
}





		/*
	 * 
	 * Create a GUI for the puzzle with a grid layout of one row and two columns. In the left column put the
puzzle letters, and in the right column display the words that the user has found so far (words the user
has guessed and your program has found on the solutions list.) and the user’s score. Accept words
from the user via a JOptionPane.
MessageDialogs should be shown to the user in the following cases: 1. The user has used a letter that
is not one of the seven letters given. 2. The user’s guess is less than 5 letters long. 3. The user’s guess
is not in the solutions list.
	 * 
	 * 
	 */
	
	
	
