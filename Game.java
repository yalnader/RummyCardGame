/**
* Class Game for my Rummy Card game
*@author Yasser Alnader (yalna104@uottawa.ca)
*
*/
public class Game{
  public Deck main;
  public Deck player;
  public Die die;

  /**
  *contsrutor for the class game, intizalizes a Die as well as a main deck
  *@param ranks the number of ranks the user wants in their game
  */
  public Game(int ranks){
    die = new Die();
    main = new Deck(ranks);
  }
  // methods
  /**
  *method the contains the logic for the Rummy Card game
  */
  public void play(){
    main.shuffle();
    player = main.deal(7);

    System.out.println("Here is your starting hand: " + player);
    boolean flag = true;
    int counter = 0;
    while(flag ){
      die.roll();
      System.out.println(die);
      counter++;
      if(player.size() == 1 && main.size() == 0){
        die.setValueToOne();
      }
      if (die.getValue() == 1) {
        System.out.println("You rolled a " + die.getValue());
        player.print();
        System.out.println("Discard any card of your choice. Choose wisely!");
        // Card inputCard = Utils.readCard();
        boolean cardRemoved = true;
        while(cardRemoved){
        Card inputCard = Utils.readCard();
        if (player.contains(inputCard)) {
          player.remove(inputCard);
          System.out.println("");
          System.out.println("The following card has been discarded from your hand: " + inputCard);
          System.out.println("");
          System.out.println("Here is your current hand.");
          System.out.println(player);
          cardRemoved =false;
        }
        else{
          System.out.println("The card you picked isnt in your hand. Try again.");
          System.out.println("Here are the cards you have in your hand: " + player);
          }
        }
      }
      else{
        System.out.println("You rolled a " + die.getValue());
        if (main.size() == 0) {
          System.out.println("There are no more cards to add to your deck, try to make melds with the cards you have!");
        }
        else {
          if (main.size() < die.getValue()) {
            System.out.println(main.size() + " card(s) have been added to your hand. Since you rolled higher than the amount of cards in the game deck, the rest of the cards have been added to your hand");
          }
          else {
            System.out.println( die.getValue()+ " cards have been added to your hand.");
          }

        }


        int j = die.getValue();
        if (main.size() < die.getValue()) {
          j = main.size();
        }

        Deck x = main.deal(j);
        player.addAll(x);
        player.print();

        do{
          Deck discards = Utils.readCards("Which 3+ sequence or 2+ of a kind would you like to discard? ");
          //check if players containsAll of discards
          // then check if its a sequence or a kind
          if (player.containsAll(discards) == false) {
            System.out.println("Please make sure all the cards you enter are currently in your hand.");
          }
          else{
            if (discards.isSeq() == true) {
              System.out.println("Congrats! You made a sequence with the cards in your hand, the following cards have been discarded: " + discards);
              player.removeAll(discards);
              System.out.println("");
              System.out.println("Here are the cards currently in your hand printed in 2 ways: ");
              player.print();
            }
            else if(discards.isKind() == true){
              System.out.println("Congrats! You made a kind with the cards in your hand, the following cards have been discarded: " + discards);
              player.removeAll(discards);
              System.out.println("");
              System.out.println("Here are the cards currently in your hand printed in 2 ways: ");
              player.print();
            }
            else{
              System.out.println("The cards you entered don't make a sequence or a kind! If you want to try again enter [Y]es.");
            }
          }
        }while (player.size() !=0 && Utils.readYesOrNo("Do you have anymore melds? ") == true);

      }
      flag = (player.size() != 0);
    }
    System.out.println("You finished Rummy in " + counter + " round(s)!");
  }
  //main
  // public static void main(String[] args) {
  //   Game game = new Game(3);
  //   game.play();
  // }
}
