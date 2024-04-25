import random

def validate(playing_with):
   if(playing_with != 'f' and playing_with != 'c'):
      return False
   
   return True

def rules():
   print("***********Rules*************")
   print("1. You should enter rock, paper, scissor only; else input will not be validated")
   print("2. The case of  your choice does'nt matter (rock, RocK is same; Pape, paper is same)\n\n")

def start(player1_name, no_rounds):
   rules()
   person_score = 0
   bot_score = 0

   for i in range(no_rounds):
      entity_map = {1: "rock", 2: "paper", 3: "scissor"}
      
      person_choice = ""

      while((person_choice != 'rock' and person_choice != 'scissor' and person_choice != 'paper')):
         person_choice = str.lower(input("Choose rock/paper/scissor: "))
         if((person_choice != 'rock' and person_choice != 'scissor' and person_choice != 'paper')):
            print("Recived invalid input")
            rules()
      
      bot_choice = entity_map[random.randint(1,3)]

      print("Bot chooses: ", bot_choice)

      if((person_choice == "rock" and bot_choice == "scissor") or (person_choice == "paper" and bot_choice == "rock") or (person_choice == "scissor" and bot_choice == "paper")):
         person_score += 1
      elif((bot_choice == "rock" and person_choice == "scissor") or (bot_choice == "paper" and person_choice == "rock") or (bot_choice == "scissor" and person_choice == "paper")):
         bot_score += 1
      
      print("Round ", i, " result: ", "\nBot Score: ", bot_score, "\tYour score: ", person_score,"\n\n")

   if(person_score > bot_score):
      print("\n\nHurray!!!", player1_name, " you won against bot!!!!! :)")
   elif(bot_score > person_score):
      print("Ooops",player1_name," Bot won :(")
   else:
      print("Its an draw... ",player1_name,", better luck next time")

print("Welcome to ROCK PAPER SCISSOR")
print("\n\n")

playing_with = ""
no_rounds = abs(int(input("Enter number of rounds you wish to play: ")))

print("You are playing with computer!!")
player1_name = input("Enter your name: ")
start(player1_name,no_rounds)

   #accepting valid mode(Either with friend or computer)
# while(not validate(playing_with)):
#    playing_with = str.lower(input("Enter c/C to challenge Bot or f/F to play with your friend: "))
#    if(playing_with != 'f' and playing_with != 'c'):
#       print("Enter either c/C or f/F")

# if(playing_with == 'c'):
#    print("You are playing with computer!!")
#    player1_name = input("Enter your name: ")
#    start(player1_name,no_rounds)
#    # return player1_name
   
# else:
#    print("You are challenging your friend!!")
#    player1_name = input("Enter Player-1 name: ")
#    player2_name = input("Enter Player-2 name: ")
#    start(player1_name, player2_name, no_rounds)
#    # return player1_name, player2_name


