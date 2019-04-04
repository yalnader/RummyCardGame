/**
* Class Card for my Rummy Card game
*@author Yasser Alnader (yalna104@uottawa.ca)
*
*/
public class Card{
  private  int suit;
  private int rank;
  //Constants
  public static int DIAMOND = 0;
  public static int CLUB = 1;
  public static int HEART = 2;
  public static int SPADE = 3;
/**
* construcor for the class Card
* @param  theSuit the Card's suit
* @param theRank the Card's Rank
*/
  public Card(int theSuit, int theRank){
    suit = theSuit;
    rank = theRank;
  }
  /**
  * getter function that gets the Card's suit
  *@return suit the Card's suit
  */
  public int getSuit(){
    return suit;
  }
  /**
  * getter function that gets the Card's rank
  *@return rank the Card's suit
  */
  public int getRank(){
    return rank;
  }
  /**
  * @Override toString to print Card in readable fashion
  *@return string repersenting the card
  */
  public String toString(){
    return "{"+getSuit()+","+getRank()+"}";
  }
  /**
  *@Override the method equals to compare two cards and their values i.e (Suit, Rank)
  *@param object an object to compare to an instance of Card
  *@return a boolean to see weather two cards equal
  */
  public boolean equals(Object object){
    if (!(object instanceof Card)) {
      return false;
    }
    Card other;
    other = (Card) object;
    return suit == other.suit && rank == other.rank;
    }


}
