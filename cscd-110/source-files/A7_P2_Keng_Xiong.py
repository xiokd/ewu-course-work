# CSCD 110-F01
# December 6, 2019
# Assignment 7
# Second Program

# This program prompts the user for filename and prints contents
def main():
    try:
        contents = ''

        # Prompt user for filename
        filename = input("Enter the name of the file: ")
        fileInput = open(filename, 'r')

        contents = fileInput.read()

        # Displays file content
        print(contents)

        fileInput.close()
        
    except:
        print("Error")

main()

