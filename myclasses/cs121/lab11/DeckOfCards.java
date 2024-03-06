import java.util.Random;
import java.util.Arrays;

public class DeckOfCards implements DeckOfCardsInterface
{
	private final int DECKSIZE = 52;
	private Card[] cards;
	private int nextCardIndex;
	
	int dealt;
	int remaining;
	//int currentCard;
	
	public DeckOfCards()
	{
		
		
		for(Suit s : Suit.values())
		{
			for(FaceValue v : FaceValue.values())
			{
				for(int i = 0; i < 2; i++)
					cards[i] = new Card(s, v);
					

			}
		}
	}
	public void shuffle()
	{
	    Random generator = new Random();

	    //Attempt to swap each card with a random card in the deck.
	    //This isn't a perfect random shuffle but it is a simple one.
	    //A better shuffle requires a more complex algorithm.

	    for (int i = 0; i < cards.length; i++) {
	        int j = generator.nextInt(cards.length);
	        Card temp = cards[i];
	        cards[i] = cards[j];
	        cards[j] = temp;
	        
	    }

	    //Reset instance variable that keeps track of dealt and remaining cards.
	    nextCardIndex = 0;
	}
	public String toString()
	{
		return Arrays.toString(cards);
	}
	public Card draw()
	{
		return cards[DECKSIZE];
	}
	public int numCardsRemaining()
	{
		remaining = DECKSIZE - nextCardIndex-1;
		return remaining;
	}
	public int numCardsDealt()
	{
		dealt = nextCardIndex-1;
		return dealt;
	}
	public Card[] dealtCards()
	{
		Card[] dealtCards = new Card[dealt];
		return dealtCards;
	}
	public Card[] remainingCards()
	{
		Card[] remainingCards = new Card[remaining];
		return remainingCards;
	}

}
