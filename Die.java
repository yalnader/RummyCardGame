/**
* The class Die for the Rummy Card game
*
*
* @author Yasser Alnader (yalna104@uottawa.ca)
*/
import java.util.Random;


public class Die{
  private int di;
  public final int MAXVALUE = 6;
  /**
  * This is the construcor for this class Die
  * takes no paramators but it intizalize the die by giving it a random number
  * using java.util.Random
  */
  public Die() {
    Random rolling = new Random();
    di =  rolling.nextInt(MAXVALUE) + 1;
  }

  // public static void main(String[] args) {
  //     Die d;
  //     d = new Die();
  //     System.out.println(d);
  // }
  /**
  *Getter method, gets the current value of the die
  *@return the current int value of the die
  */
  public int getValue(){
      return di;
  }
  /**
  *Sets the die value to 1
  *@return die value = 1
  */
  public int setValueToOne(){
    return di = 1;
  }
  /**
  *Method rolls the die using Random
  *the method makes the die's current value into that value that was rollled
  */
  public void roll() {
    Random rolling = new Random();
    di =  rolling.nextInt(MAXVALUE) + 1;
  }
  /**
  *@Override the method toString() to print a human readable of what is contained at the adress of objects of class Die
  @return a string that repersents the die
  */
  public String toString() {
  return "Die {value:" + di +"}";
  }

}
