#CSCD 110-F01
#October 11, 2019
#Assignment 1

#The program prompts the user to input two integers here
numStr1 = input('Please enter an integer not equal to zero: ')
numStr2 = input('Please enter another integer not equal to zero: ')

#User input gets assigned to a variable here as an integer
intNum1 = int(numStr1)
intNum2 = int(numStr2)

#Mathematical calculations are completed here
numAdd = intNum1 + intNum2
numSub = intNum1 - intNum2
numMul = intNum1 * intNum2
numExp = intNum1 ** intNum2
numDiv = intNum1 // intNum2
numRem = intNum1 % intNum2

#The program displays the mathematical calculations here
print(intNum1, 'plus', intNum2, 'equals', numAdd)
print(intNum1, 'minus', intNum2, 'equals', numSub)
print(intNum1, 'multiplied by', intNum2, 'equals', numMul)
print(intNum1, 'raised to the', intNum2, 'equals', numExp)
print(intNum1, 'divided by', intNum2, 'equals', numDiv, 'with a remainder of', numRem)
