import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField guessField;
  JButton guessButton, playAgainButton;

  JLabel jlabUserGuess, jlabHighLow, jlabPreviousGuess;

  Random r = new Random();
  int randomNum;

  GuessingGame() {

    randomNum = r.nextInt(101);

    JFrame frame = new JFrame("Guessing Game"); 
    frame.setLayout(new FlowLayout()); 
    frame.setSize(240, 120); 
    guessField = new JTextField(10); 
    guessField.setActionCommand("myTF");
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    guessField.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    jlabUserGuess = new JLabel("Enter your guess: ");
    jlabHighLow = new JLabel("");
    jlabPreviousGuess = new JLabel("");

    frame.add(jlabUserGuess);
    frame.add(guessField);
    frame.add(guessButton);
    frame.add(jlabHighLow);
    frame.add(jlabPreviousGuess);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(guessField.getText());
      if (guess < randomNum) {
        jlabHighLow.setText("Too low!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
      else if (guess > randomNum) {
        jlabHighLow.setText("Too high!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
      else {
        jlabHighLow.setText("You got it!");
        jlabPreviousGuess.setText("Last guess was " + guess);
      }
    }
    else if(ae.getActionCommand().equals("Play Again")) {
      randomNum = r.nextInt(101);
      jlabHighLow.setText("");
      jlabPreviousGuess.setText("");
      guessField.setText("");
    }
    else {
      jlabHighLow.setText("You pressed Enter. Please press the Guess Button.");
    }
  }
}
