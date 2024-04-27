import random

#Defination of lists of words having length 3,4,6,8
words_of_length_3 = [
    "cat", "dog", "rat", "hat", "bat", "pen", "cup", "car", "bus", "run",
    "eat", "fly", "sit", "box", "fox", "toy", "sun", "nut", "map", "bed",
    "bag", "mud", "pie", "job", "lip", "hop", "ice", "cow", "ant", "man",
    "fan", "leg", "arm", "ear", "eye", "bee", "gum", "egg", "car", "key",
    "pin", "pen", "pig", "ham", "bat", "top", "mop", "can", "pan", "pot",
    "bar", "bow", "cap", "bug", "rug", "mat", "van", "gem", "hen", "hat",
    "hut", "ink", "jam", "joy", "lab", "nut", "ram", "pie", "pet", "pod",
    "pup", "rug", "car", "toy", "pen", "sun", "tap", "ten", "toy", "van",
    "web", "wig", "bun", "kit", "log", "den", "fox", "pie", "fan", "jug",
    "mug", "owl", "rat", "zoo", "bar", "bud", "dim", "lid", "log", "nap"
]

words_of_length_4 = [
    "cake", "ball", "desk", "fish", "bird", "lamp", "book", "tree", "road", "rain",
    "blue", "star", "moon", "milk", "song", "home", "door", "bell", "ring", "hope",
    "wish", "wind", "bird", "hand", "foot", "soap", "chip", "beef", "rice", "wine",
    "lime", "leaf", "bear", "wolf", "tiger", "lion", "fish", "frog", "bird", "duck",
    "swan", "pork", "beak", "peak", "peak", "cone", "dent", "chip", "seal", "deer",
    "meat", "work", "play", "skip", "jump", "frog", "bird", "deer", "lion", "lamb",
    "wolf", "line", "gold", "cage", "tool", "idea", "food", "time", "hour", "week",
    "year", "life", "love", "feel", "hear", "cool", "warm", "cold", "home", "rock",
    "sand", "wave", "surf", "ship", "boat", "plane", "bird", "star", "moon", "sun",
    "fire", "ice", "wind", "rain", "snow", "hail", "sleet", "sunny", "cloud", "dark"
]

words_of_length_6 = [
    "banana", "people", "yellow", "purple", "orange", "circle", "square", "purple", "banana", "circle",
    "yellow", "purple", "people", "banana", "circle", "purple", "yellow", "square", "banana", "orange",
    "people", "purple", "yellow", "circle", "orange", "banana", "square", "people", "purple", "orange",
    "circle", "yellow", "square", "banana", "people", "orange", "purple", "yellow", "circle", "square",
    "banana", "people", "yellow", "purple", "orange", "circle", "square", "purple", "banana", "circle",
    "yellow", "purple", "people", "banana", "circle", "purple", "yellow", "square", "banana", "orange",
    "people", "purple", "yellow", "circle", "orange", "banana", "square", "people", "purple", "orange",
    "circle", "yellow", "square", "banana", "people", "orange", "purple", "yellow", "circle", "square",
    "banana", "people", "yellow", "purple", "orange", "circle", "square", "purple", "banana", "circle",
    "yellow", "purple", "people", "banana", "circle", "purple", "yellow", "square", "banana", "orange"
]

words_of_length_8= [
    "mountain", "children", "building", "software", "elephant", "computer", "language", "hospital", "journey", "treasure",
    "daughter", "solution", "tomorrow", "whenever", "strength", "distance", "birthday", "property", "happiness", "knowledge",
    "calendar", "sunshine", "forever", "champion", "tomorrow", "happiness", "building", "computer", "elephant", "language",
    "solution", "distance", "children", "treasure", "birthday", "property", "knowledge", "mountain", "happiness", "tomorrow",
    "building", "computer", "language", "elephant", "solution", "distance", "children", "treasure", "birthday", "property",
    "knowledge", "mountain", "happiness", "tomorrow", "building", "computer", "language", "elephant", "solution", "distance",
    "children", "treasure", "birthday", "property", "knowledge", "mountain", "happiness", "tomorrow", "building", "computer",
    "language", "elephant", "solution", "distance", "children", "treasure", "birthday", "property", "knowledge", "mountain",
    "happiness", "tomorrow", "building", "computer", "language", "elephant", "solution", "distance", "children", "treasure"
]

def start():
   #how_to_play()
   no_words = 0

   mode = ""

   #Logic to enter valid mode
   while mode not in ['c','f']:
      mode = str.lower(input("Enter 'c' to play individually or 'f' to play with your friend: "))
      if mode not in ['c','f']:
         print("Invalid input!!!! Enter either c/C or f/F")
   
   #Logic to enter valid no of words
   while no_words not in [3,4,6,8]:
      if(no_words not in [3,4,6,8]):
         print("Available length of words are 3,4,6,8\nPress \"0\" (zero) to exit")
      no_words = int(input("Enter number of words you need to guess: "))
      if(no_words == 0):
         print("Thankyou, Have a nice day :)")
         exit()

   #generating a word of length no_words
   answer = generate_random_word(no_words)

   #print(answer)

   #Game in single player mode
   if(mode == 'c'):
      guess, no_of_attempted = start_guessing(answer)  #for individual player
      
      print("The actual word is ", answer)
      #evaluation of result
      if '-' not in guess:
         print("Hurray you guessed all the characters in ",no_of_attempted, "attemps !!!!!!!!")
      else:
         print("You failed to guess better luck next time :)")

   #Game in 2 players mode
   else:
      print("\n\n\nPlayer1`s term: ")
      guess1, no_of_attempted_player_1 = start_guessing(answer) #for 1st player
      print("Test result: ")
      print("\n\nYour guess is true ? ", "YES" if '-' not in guess1 else "NO",  "Number of attempts you took: ", no_of_attempted_player_1)
      print("Correct answer is: ", answer)
      answer = generate_random_word(no_words)   #regenerating another word for player2
      #print(answer)
      print("\n\n\nPlayer2`s term: ")
      guess2, no_of_attempted_player_2 = start_guessing(answer) #for 2nd player
      print("Your guess is true ? ", "YES" if '-' not in guess2 else "NO", "Number of attempts you took: ", no_of_attempted_player_2)
      print("\n\nCorrect answer is: ", answer)

      # print(guess1, no_of_attempted_player_1)
      # print(guess2, no_of_attempted_player_2)
      
      print("\n")
      #evaluation of result
      #When both have guessed, winner is decided on least number of attempts
      if ('-' not in guess1) and ('-' not in guess2):
         if no_of_attempted_player_1 < no_of_attempted_player_2:
            print("Congratulations player1 won!!!! :)" )
         elif no_of_attempted_player_2 < no_of_attempted_player_1:
            print("Congratulations player2 won!!!! :)")
         else:
            print("Ooops its an draw")
      
      else:
         print("No player guessed the words!!! better luck next time :(")
   
   repeat()

def repeat():
   print()
   isRepeat = input("Enter any key to play again, '0' to stop: ")
   if(isRepeat == '0'):
      exit()
   print("\n\n\n")
   start()
   


def generate_random_word(no_words):

   ans = ""
   if(no_words == 3):
      ans = words_of_length_3[random.randint(0,99)]
   elif(no_words == 4):
      ans = words_of_length_4[random.randint(0,99)]
   elif(no_words == 6):
      ans = words_of_length_6[random.randint(0,99)]
   elif(no_words == 8):
      ans = words_of_length_8[random.randint(0,99)]
   
   return ans


def start_guessing(ans):
   print("\nYour guessing starts now!!!!!\n\n\n")
   no_words = len(ans)
   guess = []
   for i in range(no_words):
      guess.append('-')
   
   for no_attempts in range((len(ans))*5):
      ch = ""
      while not ch.isalpha():
         ch = str.lower(input("Enter any alphabet(if string entered, only first character is accepted): "))
         ch = ch[0]
         if not ch.isalpha():
            print("Invalid character enter only alphabet, either upper or lower case")
      
      for i in range(no_words):
         if ch == ans[i]:
            guess[i] = ch
      
      for ch in guess:
         print(ch)
      
      if '-' not in guess:
         return guess, no_attempts
   
   return guess, no_attempts
   
def how_to_play():
   print("Choose number of words you want to play with (3,4,6,8)")
   print("If number of words you have chosen is 'n' you will be given 'n*5' attempts")
   print("In single player mode, you will win if you guess all the words in given attempts")
   print("In multiplayer mode, player who guesses will win, if both players guess, player guessed in minimum number of attempts will win")
   print("*************************************************************************\nAll the best********************************************************************\n\n")

print("\n\nwelcome !!!")
how_to_play()
start()
