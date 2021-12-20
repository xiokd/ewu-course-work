#Simulation that demonstrates what it is like to be in a car with a child on a long road trip
#Ask the age of the child
age = int(input("Enter the child's age: "))
ageCount = 1
#set up the loop that will run the string "Are we there yet?" for each year of the child's age
while ageCount <= age:
    print("Are we there yet?")
    ageCount = ageCount + 1
#To close the program neatly    
input("press enter to exit")
