# CSCD 110-F01
# November 20, 2019
# Assignment 5

# Main as a function
def main(): 
    # Prompt for user input and assigns variable
    hole = int(input("Enter the number of the hole: "))
    par = int(input("Enter the par value of the hole: " ))
    stroke = int(input("Enter the number of strokes it took to finish the hole: "))

    # Displays the final statement
    print("On hole number ", hole, " a par ", par, " you shot ", stroke_relation(par,stroke), stroke_slang(stroke), sep = "")

# Function to calculate the stroke relation to par
def stroke_relation(par,stroke):

    # Define variable for mathematical calculation
    strokeCalc = stroke - par
    
    if strokeCalc == -5:
        return("ostrich")
    elif strokeCalc == -4:
        return("condor")
    elif strokeCalc == -3:
        return("albatross")
    elif strokeCalc == -2:
        return("eagle")
    elif strokeCalc == -1:
        return("birdie")
    elif strokeCalc == 0:
        return("even par")
    elif strokeCalc == 1:
        return("bogey")
    elif strokeCalc == 2:
        return("double bogey")
    elif strokeCalc == 3:
        return("triple bogey")
    elif strokeCalc == 4:
        return("four over par")
    elif strokeCalc > 4:
        return("too many times over par")

# Function for slang
def stroke_slang(stroke):
    if stroke == 1:
        return(", a hole in one ace!")
    elif stroke == 4:
        return(", a sailboat.")
    elif stroke == 8:
        return(", a snowman.")
    elif stroke == 10:
        return(", a Bo Derek")
    else:
        return(".")

# This is where the program begins
main()
