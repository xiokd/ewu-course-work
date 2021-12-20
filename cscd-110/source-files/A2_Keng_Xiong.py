#CSCD 110-F01
#October 18, 2019
#Assignment 2

#The purpose of the program is to prompt the user to input a number and then displays a corresponding day of the week to that number
def start():
    #The program prompts user to enter a number within given range here
    wDay = int(input('Enter a number (1-7) for the day of the week: '))

    #The day of the week is returned to user here
    print()
    if wDay == 1:
        print('Monday')
    elif wDay == 2:
        print('Tuesday')
    elif wDay == 3:
        print('Wednesday')
    elif wDay == 4:
        print('Thursday')
    elif wDay == 5:
        print('Friday')
    elif wDay == 6:
        print('Saturday')
    elif wDay == 7:
        print('Sunday')
    #An error message is displayed here when a number out of the range is typed by the user
    else:
        print('Please enter a number that is within (1-7)')

    #This response only occurs when the following conditions are met
    print()
    if wDay >= 6 and wDay <= 7:
        print('Happy weekend!')

    #The program will prompt the user to respond with y or n if they want to restart here
    restart = input('Do you wish to start again? (y/n): ')
    if restart == 'y':
        start()
    else:
        exit()
        
#This is where the program begins
start()
