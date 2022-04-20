# CSCD 110-F01
# November 15, 2019
# Assignment 4

# Define constant variables
FEET_TO_METERS = 1
METERS_TO_FEET = 2
CONVERT_TO_CELCIUS = 3
CONVERT_TO_FAHRENHEIT = 4
QUIT = 0

# Calls for main
def main():
    # Initialize the choice variable
    choice = 7

    while choice != QUIT:
        display_menu()

        # Prompt the user to enter a choice
        choice = int(input("\nPlease select a choice from the menu: "))

        if choice == FEET_TO_METERS:
            dist_feet = float(input("Please enter a distance for Feet: "))
            print(dist_feet, "feet is", convert_to_meters(dist_feet), "in meters")
        elif choice == METERS_TO_FEET:
            dist_meter = float(input("Please enter a distance for Meters: "))
            print(dist_meter, "meters is", convert_to_feet(dist_meter), "in feet")
        elif choice == CONVERT_TO_CELCIUS:
            temp_fah = float(input("Please enter a temperature for Fahrenheit: "))
            print(temp_fah, "degrees Fahrenheit is", convert_to_celcius(temp_fah), "degrees in Celcius")
        elif choice == CONVERT_TO_FAHRENHEIT:
            temp_cel = float(input("Please enter a temperature for Celcius: "))
            print(temp_cel, "degrees in Celcius is", convert_to_fahrenheit(temp_cel), "degrees in Fahrenheit")
        elif choice == QUIT:
            print("Goodbye")
        else:
            print("Please enter a valid number from the menu")

# Displays menu for the program
def display_menu():

    print("\t\tMenu")
    print("\n1. Convert Feet to Meters")
    print("2. Convert Meters to Feet")
    print("3. Convert Fahrenheit to Celcius")
    print("4. Convert Celcius to Fahrenheit")
    print("0. Quit")

# Conversions for the program
# Conversion from Feet to Meters
def convert_to_meters(dist_feet):
    return(dist_feet / 3.281)
# Conversion from Meters to Feet
def convert_to_feet(dist_meter):
    return(dist_meter * 3.281)
# Conversion from Fahrenheit to Celcius
def convert_to_celcius(temp_fah):
    return(temp_fah - 32) * 5/9
# Conversion from Celcius to Fahrenheit
def convert_to_fahrenheit(temp_cel):
    return(temp_cel * 9/5) + 32

# This is where the program begins
main()
