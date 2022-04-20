# CSCD 110-F01
# November 4, 2019
# Assignment 3

# This program will display a menu with options for the user
# Define menu variables
MSEQ1 = 1
MSEQ2 = 2
MSEQ3 = 3
PLINE = 4
PINT = 5
QUIT = 0

# Initialization of the choice variable
choice = 7
# Menu options displayed
while choice != QUIT:
    print('''\t Please choose from the following menu''')
    print('''\n1. Count from 0 to 75 by 5's''')
    print('''2. Count from 3 to 129 by 7's''')
    print('''3. Add the numbers from 210 to 235''')
    print('''4. Print the phrase "Don't be evil." one letter per line''')
    print('''5. Print the integers from 5 to 15''')
    print('''0. Quit''')
    # User input collected here
    choice = int(input("\nEnter your choice from the available options: "))
    # Executes following codes after user input
    if choice == MSEQ1:
        num1 = 0
        while num1 <= 75:
            num1 = num1 + 5
            print(num1)
    elif choice == MSEQ2:
        num2 = -4
        while num2 < 129:
            num2 = num2 + 7
            print(num2)
    elif choice == MSEQ3:
        num3 = 210
        subNum = 0
        while num3 <= 235:
            subNum = subNum + num3
            num3 = num3 + 1
            print(subNum)
    elif choice == PLINE:
        phrase = "Don't be evil."
        for letter in phrase:
            print(letter)
    elif choice == PINT:
        for num4 in range (5,16,1):
            print(num4)
    # This option ends the program and prints a message
    elif choice == QUIT:
        print("Goodbye")
    # Error message for the user if they provided number out of range
    else:
        print("Please enter a number from 1 to 5 or 0.")
        
