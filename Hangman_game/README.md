Hangman Game
Hangman is a classic word-guessing game where the player must guess a hidden word by suggesting letters within a certain number of guesses.

Overview
This Java program implements a simple console-based Hangman game. It reads a list of words from a text file (short_words.txt), randomly selects one word, hides a random letter from that word, and prompts the player to guess the missing letter. The player has one chance to guess the correct letter.

Prerequisites
To run this game, ensure you have the following installed:

Java Development Kit (JDK) version 8 or higher
Installation
Clone or download the repository to your local machine:

bash
Copy code
git clone <repository-url>
Navigate to the directory containing the Java files.

Usage
Ensure the ShortWords.txt file is in the same directory as your Java files and contains a list of words, each on a separate line.

Compile the Java files:

bash
Copy code
javac HangmanGame.java
Run the game:

bash
Copy code
java HangmanGame
Follow the prompts to play the game. Guess the missing letter to win!

File Structure
HangmanGame.java: Main Java file containing the Hangman game logic.
ShortWords.txt: Text file containing a list of words for the game.
