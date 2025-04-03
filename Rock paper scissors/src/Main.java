import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creates a Scanner object to get user input
        Scanner scan = new Scanner(System.in);

        // List and defines the possible choices for the game of rock, paper, and scissors
        String[] choices = {"rock", "paper", "scissors"};

        String userChoice = "";

        // Repeatedly asks the user to enter a valid choice
        while (!(userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors"))) {
            System.out.println("Enter your choice (rock, paper, or scissors): ");
            userChoice = scan.next().toLowerCase();  // Reads the user's choice and converts it to lowercase

            // Checks if the input is invalid
            if (!(userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors"))) {
                System.out.println("Invalid choice. Enter rock, paper, or scissors.");
            }
        }

        // Generates a number randomly from 0-2 using Math.random()
        int random = (int) (Math.random() * 3);  // Generates a number between 0 and 2

        // Chooses the computer's choice using the random number
        String computerChoice = choices[random];

        // Displays the computer's choice
        System.out.println("The computer chose: " + computerChoice);

        // Determine the outcome by comparing the choices to each other
        if (userChoice.equals(computerChoice)) {
            // If both choices are the same, declare a tie game
            System.out.println("tie game");
        } else if (userChoice.equals("rock") && computerChoice.equals("scissors") ||
                userChoice.equals("paper") && computerChoice.equals("rock") ||
                userChoice.equals("scissors") && computerChoice.equals("paper")) {
            // If the user wins, display a congratulatory message
            System.out.println("You win");
        } else {
            // If the computer wins, display a message declaring the player's defeat
            System.out.println("You lose.");
        }

        // Closes the scanner
        scan.close();
    }
}
