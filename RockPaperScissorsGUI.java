import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsGUI extends JFrame implements ActionListener{
    JButton rockButton, paperButton, scissorsButton;
    JLabel computerChoice;

    JLabel computerScoreLabel, playerScoreLabel;

  //backend
  RockPaperScissors rockPaperScissors;
    public RockPaperScissorsGUI() {
        super("Rock Paper Scissor");

        setSize(450, 574);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        //initialize backend obj
        rockPaperScissors = new RockPaperScissors();

        //add GUI components
        addGUIComponents();
    }
        private void addGUIComponents() {
            //computer score label
            computerScoreLabel = new JLabel("Computer: 0");
            computerScoreLabel.setBounds(0, 43, 450, 30);
            computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(computerScoreLabel);

            //computer choice
            computerChoice = new JLabel("?");
            computerChoice.setBounds(175, 118, 98, 81);
            computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
            computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
            computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(computerChoice);

            //players score
            playerScoreLabel = new JLabel("Player: 0");
            playerScoreLabel.setBounds(0, 317, 450, 30);
            playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
            playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(playerScoreLabel);

            //buttons
            rockButton = new JButton("Rock");
            rockButton.setBounds(40, 387, 105, 81);
            rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
            rockButton.addActionListener(this);
            add(rockButton);

            paperButton = new JButton("Paper");
            paperButton.setBounds(165, 387, 105, 81);
            paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
            paperButton.addActionListener(this);
            add(paperButton);

            scissorsButton = new JButton("Scissors");
            scissorsButton.setBounds(290, 387, 105, 81);
            scissorsButton.setFont(new Font("Dialog", Font.PLAIN, 18));
            scissorsButton.addActionListener(this);
            add(scissorsButton);
    }
    private void showDialog(String message) {
        JDialog resultsDialog = new JDialog(this, "Result", true);
        resultsDialog.setSize(227, 124);
        resultsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultsDialog.setResizable(false);

        JLabel resultsLabel = new JLabel(message);
        resultsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultsDialog.add(resultsLabel, BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                computerChoice.setText("?");

                resultsDialog.dispose();
            }
        });
        resultsDialog.add(tryAgainButton, BorderLayout.SOUTH);
        resultsDialog.setLocationRelativeTo(this);
        resultsDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand().toString();

        String result = rockPaperScissors.playRockPaperScissors(playerChoice);

        computerChoice.setText(rockPaperScissors.getComputerChoice());

        //update score
        computerScoreLabel.setText("Computer: " + rockPaperScissors.getComputerScore());
        playerScoreLabel.setText("Player: " + rockPaperScissors.getComputerScore());

        showDialog(result);
    }
}
