/**Pair of Dice
 * 
 * @author Ryan Thompson
 *
 * Creates a pair of dice from Die.java.
 * Makes it possible to roll two dice at once, 
 *  instead of just one at a time.
 */
public class PairOfDice 
{	
	private Die die1, die2;
	/**
	 * Bundles two separate dice together, from Die.java. 
	 */
	public PairOfDice()
	{
		die1 = new Die();
		die2 = new Die();
	}
	/**
	 * @param numSides
	 * numSides determines the number of sides on the dice.
	 * Once numSides is established, it creates two separate dice
	 *  with the number of sides specified by numSides.
	 */
	public PairOfDice(int numSides)
	{
		die1 = new Die(numSides);
		die2 = new Die(numSides);
	}
	/**
	 * @return die1.getFaceValue()
	 * Represents the rolled/current value of dice number one.
	 */
	public int getFaceValue1()
	{
		return die1.getFaceValue();
	}
	/**
	 * @return die2.getFaceValue()
	 * Represents the rolled/current value of dice number two.
	 */
	public int getFaceValue2()
	{
		return die2.getFaceValue();
	}
	/**
	 * @return getFaceValue1() + getFaceValue2() 
	 * Represents the current sum of dice1 and dice2.
	 */
	public int getTotal()
	{
		return getFaceValue1() + getFaceValue2();
	}
	/**
	 * @return die1.roll() + die2.roll()
	 * Returning the current roll of dice one and dice two.
	 */
	public int roll()
	{
		return die1.roll() + die2.roll();
	}
	/**
	 * @return getTotal getFaceValue1() getFaceValue2()
	 * Shows the current total roll value, plus the two 
	 *   individual values for each dice.
	 */
	public String toString()
	{
		return getTotal() + " (" + getFaceValue1() + " + " + getFaceValue2() + ") ";
	}
}