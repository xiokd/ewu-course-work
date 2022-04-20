# CSCD 110-F01
# December 6, 2019
# Assignment 7
# First program

# This program prompts the user for player name and score for golf
def main():
    # Reads file and opens it to be appended
    readFile = "golf.txt"
    appendFile = open(readFile, 'a')

    # Prompts for user input
    numberPlayers = int(input("Enter the number of players in the tournament: "))
    
    for i in range(0,numberPlayers):
        playerName = input("Enter the player name: ")
        playerScore = int(input("Enter the score for the hole: "))

        appendFile.write(playerName + "\n" + str(playerScore) + "\n")

    appendFile.close()

# The start of the program
main()
