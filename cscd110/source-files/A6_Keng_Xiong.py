# CSCD 110-F01
# November 26, 2019
# Assignment 6

# This program opens a file, reads the contents, and then prints it
def main():
    # Assign variable with the file name
    my_file = "numbers.txt"

    # Opens file for reading
    fileInput = open(my_file, 'r')

    # Reads content and assigns to variable
    fString = fileInput.read()

    # Prints content on the file
    print(fString)

    # Closes the file
    fileInput.close()

# Calls main function
main()
