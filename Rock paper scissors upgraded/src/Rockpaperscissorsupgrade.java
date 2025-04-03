public class Rockpaperscissorsupgrade {

    public static void main(String[] args) throws java.io.IOException {
        // boots up the player, computer, and tie scores
        int playerScore = 0;
        int computerScore = 0;
        int tieScore = 0;

        System.out.println("Welcome to Paper Rock Scissors!");
        System.out.println("Type 'q' to quit the game.");

        // Game loop
        while (true) {
            // Displays the current score of the game
            System.out.println("\nCurrent Score:");
            System.out.println("\tPlayer: " + playerScore + " | Computer: " + computerScore + " | Ties: " + tieScore);

            // Asks the player to enter a valid choice
            System.out.print("\nEnter your choice (rock, paper, or scissors): ");
            String playerChoice = readInput();

            // The keybind to exit the game of rock paper scissors
            if (playerChoice.equals("q")) {
                System.out.println("\nThank you for playing! Final Score: Player - " + playerScore + ", Computer - " + computerScore + ", Ties - " + tieScore);
                break;  // Exits the loop and ends the game
            }

            // A check to see if the player inputted a valid choice
            if (!(playerChoice.equals("rock") || playerChoice.equals("paper") || playerChoice.equals("scissors"))) {
                System.out.println("Invalid input. Please enter 'rock', 'paper', or 'scissors'.");
                continue;  // Skip the rest of the loop and ask again
            }

            // Generate the computer's choice
            String computerChoice = generateComputerChoice();

            // Display choices chosen
            System.out.println("\nPlayer chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Determines the winner
            String result = determineWinner(playerChoice, computerChoice);

            // Update the scores and display the result
            if (result.equals("Player")) {
                playerScore++;
                System.out.println("You win this round!");
            } else if (result.equals("Computer")) {
                computerScore++;
                System.out.println("Computer wins this round!");
            } else {
                tieScore++;
                System.out.println("It's a draw!");
            }
        }
    }

    // a method used to read player input
    public static String readInput() throws java.io.IOException {
        // Reading a single line of input from System.in (keyboard)
        int inputChar;
        StringBuilder input = new StringBuilder();
        while ((inputChar = System.in.read()) != '\n' && inputChar != -1) {
            input.append((char) inputChar);
        }
        return input.toString().trim().toLowerCase();  // Return input as lowercase
    }

    // How the computers choice is generated
    public static String generateComputerChoice() {
        // The computer will follow a pattern (rock, paper, scissors in sequence)
        String[] choices = {"rock", "paper", "scissors"};
        long currentTime = System.currentTimeMillis();  // Uses the current time to determine choice
        int choiceIndex = (int) (currentTime % 3);  // Cycle through 3 choices based on time
        return choices[choiceIndex];
    }

    // Applies the rules of rock paper scissors to determine the winner
    public static String determineWinner(String playerChoice, String computerChoice) {
        // Logic for determining the winner
        if (playerChoice.equals(computerChoice)) {
            return "Draw";
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "Player";
        } else {
            return "Computer";
        }
    }
}


