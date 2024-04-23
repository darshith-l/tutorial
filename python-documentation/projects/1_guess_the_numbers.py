import random
import sys

print("Welocome to GUESS THE NUMBERS!!!!!")
no_players = int(input("Enter number of players:  "))

scores = []

no_rounds = int(input("Enter number of rounds:  "))

print("\n\n\n")

for i in range(0, no_players):
   scores.append(0)

for j in range(no_rounds):
   for i in range(1,no_players+1):

      print("Player",i,"   Guess a number b/w 0-10")

      guessed_no = 11
 
      while(guessed_no > 10 or guessed_no <0):
         guessed_no = int(input())
         if(guessed_no > 10 or guessed_no<0):
            print("Please enter number between 0 and 10")

      if guessed_no == random.randint(0,10):
         scores[i-1] += 1
         print("You are right!! you won a point :)")
      
      else:
         print("Oops, your guess is wrong :(")
      
      print("Score table: ", scores, "\n")

winners = []

highest_score = max(scores)

for i in range(no_players):
   if scores[i] == highest_score:
      winners.append(i+1)

print("Winners are players: ", winners)      