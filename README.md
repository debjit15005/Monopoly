# Monopoly
Monopoly simulation engine <br> <br>
## Use Case Diag
![Use Case Diag](/assets/UMLUseCaseDiag.jpeg)
## Description of Classes & Methods
### Square Class : 
- represents all the squares/tiles of
the board
### Bank Class:
- contains all the cities in the arraylist "tickets"
called “tickets” and one for the Community Chest/ Chance cards called
“commCards”.
- has 2 methods, setProp() to add Squares to the tickets arrayList and
setCards() to add special cards to the commCards arrayList
### Player Class : 
- maintains every player's state - their wallet and properties.
- arrayList boughtProp holds the names of all the
properties that the player owns.
### Card Class : 
- represents special cards
- objects of this card class will be stored in the commCards
### State Class :
- maintains the ongoing turn in the game
### Dice Class:
- represents the dice used for rolling
- roll() method generates a random integer from 2 to 12 
### Board Class :
- contains logic of the player
- implements runnable; each player runs on a separate thread
- arrayList players stores all the players.

## Game Logic
### Player on square tile i.e. normal tile
1. Square is available to buy and player has enough money, then player buys it
2. Square is available to buy but player does not have enough money
3. Square is already owned, so player pays rent

### Player on card tile i.e. special tile
1. Community Chest : Cards are stored in a stack which pops off the first
element when a player picks a card and adds it to a random position in the
stack afterwards
2. Chance : same functioning as Community Chest
3. GO
4. Free Parking
5. Jail
6. Go To Jail
