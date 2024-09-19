import java.util.Random;

//backend
public class RockPaperScissors {
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private String computerChoice;
    private int computerScore, playerScore;

    private Random random;

    public RockPaperScissors() {
        random = new Random();
    }

    //play game
    public String playRockPaperScissors(String playerChoice) {
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        String result;

        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Scissors")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        }
        else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissors")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        }
            else {
                if (playerChoice.equals("Rock")) {
                    result = "Player Wins";
                    playerScore++;
                } else if (playerChoice.equals("Paper")) {
                    result = "Computer Wins";
                    computerScore++;
                } else {
                    result = "Draw";
                }
            }
            return result;
        }
    }