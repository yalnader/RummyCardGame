/**
* Class Deck for my Rummy Card game
*@author Yasser Alnader (yalna104@uottawa.ca)
*
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
public class Deck{

  private ArrayList<Card> deck;
  private Card card;
//constructors
  /**
  *construcor for creating an empty Deck
  */
  public Deck(){
    deck = new ArrayList<Card>();
  }
  /**
  *construcor that creates a deck using
  *@param ranks the number of ranks this deck will go to
  */
  public Deck(int ranks){
    deck = new ArrayList<Card>();
    for (int i = 0;i < ranks; i ++ ) {
    deck.add(new Card(card.DIAMOND, i));
    deck.add(new Card(card.CLUB, i));
    deck.add(new Card(card.HEART, i));
    deck.add(new Card(card.SPADE, i));
    }

  }
  // public static void main(String[] args) {
  //   Deck z = new Deck();
  //   z.add(new Card(0,0));
  //   z.add(new Card(0,1));
  //   z.add(new Card(0,2));
  // }
  /**
  *@return the size of the deck
  */
  public int size(){
    return deck.size();
  }

  /**
  *@return true if the deck has cards in it or if its empty
  */
  public boolean hasCards(){
    if (deck.isEmpty() == true){
      return false;
    }
    return true;
  }


  /**
  *@param pos the index in the deck
  *@return the Card at index pos
  */
  public Card get(int pos){
    return deck.get(pos);
  }

  /**
  *Adds a Card to the end of the deck
  *@param card the Card you want to add
  *
  */
  public void add(Card card){
    deck.add(card);
  }

  /**
  *adds the cards from other to the calling deck, the Deck other becomes null after wards
  *@param other a instance of Deck other than the calling deck
  *
  */
  public void addAll(Deck other){
    for (int i = 0; i < other.size() ;i++ ) {
      deck.add(other.get(i));
    }
      other = null;
  }
  /**
  *method removes the Last card in the calling deck
  *@return the last card the was removed from Deck
  */
  public Card removeLast(){
    //n-1
    Card last;
    last = deck.get(deck.size() - 1);
    if (deck.size()>0) {
      deck.remove(deck.size()-1);
    }
    return last;
  }
  /**
  *method removes the frist card in the calling deck
  *@return the frist card the was removed from Deck
  */
  public Card removeFirst(){
  //0
  Card first;
  first = deck.get(0);
  deck.remove(0);
  return first;
  }
  /**
  *removes the card from deck Returns a boolean if the card was removed or not
  *@param card the card you want to remove from the deck
  *@return true if the card was found and removed false otherwise
  */
  public boolean remove(Card card){
    return deck.remove(card);
  }
  /**
  *removes all the cards in Deck other from the calling deck
  *@param other a deck of cards you want to remove from another Deck
  *
  */
  public void removeAll(Deck other){
    for(int i = 0; i < deck.size(); i++){ //test this METHOD
      for (int j = 0;j<other.size() ; j++) {
        if(other.get(j).equals(deck.get(i))){
          deck.remove(other.get(j));
        }
      }
    }
  }
  /**
  *shuffles the deck of cards
  */

  public void shuffle(){
    Collections.shuffle(deck);
  }
  /**
  * methods removes n number of cards starting from element n-1
  * and adds those cards to a new deck and returns the new deck (note the calling deck will only have cards removed from it)
  *@param n the number of cards you want to deal
  *@return a new deck with the cards delt from the calling deck
  */
  public Deck deal(int n){
    Deck d;
    d = new Deck();

    if (deck.size() < n) {
      // int count = 0;
      for(int i = 0; i < deck.size(); i++){
        d.add(this.removeLast());
      }
    }
    else {

      for(int i = 0; i < n; i++){
        d.add(this.removeLast());
      }
    }
    return d;
  }
  /**
  *@param card the card you want to look for
  *@return true if the card is in the calling Deck
  */
  public boolean contains(Card card){
    for(int i = 0; i < this.size() ; i++){
      if(this.get(i).equals(card)){
        return true;
      }
    }
    return false;
  }
  /**
  *
  *@param other deck that you want to compare to the calling Deck
  *@return  true if an only if all the Cards from other are in the calling Deck
  */
  public boolean containsAll(Deck other){

    for (int i = 0; i < other.size() ; i++ ) {
      if (deck.contains(other.get(i)) == false) {
        return false;
      }

    }
    return true;
  }
  /**
  *@return true if and only if the Calling deck is a kind. eg Deck [{0,1},{1,1},{2,1}] i.e all the cards in the deck have the same rank.
  *
  */
  public boolean isKind(){
    boolean flag =false;
    for (int i = 0; i < this.size()-1  ;i++ ) {
      for (int j = 1;j< this.size() ;j++ ) {
        if ((this.get(i).getRank()==this.get(j).getRank()) && (this.get(i).getSuit() != this.get(j).getSuit())) {
          flag = true;
        }
        else{
          flag = false;
        }
      }
    }
    return flag;
  }
  /**
  *@return true if and only if the calling Deck is a sequence i.e the cards in the deck have to be consecutive e.g Deck [{0,1},{0,2},{0,3}]
  */
  public boolean isSeq(){
    int counter = 1;
    this.sortBySuit();
    for (int i = 0; i< this.size() - 1 ; i++ ) {
      if(this.get(i).getSuit() == this.get(i + 1).getSuit()){
        if (this.get(i).getRank() == (this.get(i+1).getRank() - 1)) {
          counter ++;
        }
      }
      else{
        return false;
      }
    }
    if(counter > 2){
      return true;
    }
    return false;
  }
  /**
  *method sorts the calling deck by the suits
  */
  public void sortBySuit(){
    this.sortByRank();
    Card swap;
      for (int i = 0;i < this.size() -1 ; i++) {
        for (int j =0;j < this.size() -i -1 ;j++ ) {
          Card firstCard =  new Card(this.get(j+1).getSuit(), this.get(j+1).getRank());
          Card secondCard = new Card(this.get(j).getSuit(),this.get(j).getRank());
          if (firstCard.getSuit() < secondCard.getSuit()) {

            Collections.swap(deck,j, j+1 );
          }
        }
      }

  }
  /**
  *method sorts the calling Deck by ranks
  */
  public void sortByRank(){
    Card swap;
      for (int i = 0;i < this.size() -1 ; i++) {
        for (int j =0;j < this.size() -i -1 ;j++ ) {
          Card firstCard =  new Card(this.get(j+1).getSuit(), this.get(j+1).getRank());
          Card secondCard = new Card(this.get(j).getSuit(),this.get(j).getRank());
          if (firstCard.getRank() < secondCard.getRank()) {
            Collections.swap(deck,j, j+1 );
          }
        }
      }
  }
  /**
  *method prins out the calling deck in two ways, first way is the Deck sorted by suit, and the other is the deck sorted by rank
  */
  public void print(){
    this.sortBySuit();
    System.out.println( "Here is the deck sorted by suit: " + this);
    System.out.println("");
    this.sortByRank();
    System.out.println("Here is the deck sorted by rank: "+ this);
    System.out.println("");
  }
  /**
  *@Override the toString() method
  */
  public String toString(){
    String x = new String();
    for (int i = 0;i < this.size() ;i++ ) {
      if(i == this.size()-1){
        x = x + deck.get(i);
      }
      else{
        x = x + deck.get(i) + ",";
      }
    }
    return "Deck ["+ x + "]";
  }

}
