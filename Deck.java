import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;


public class Deck {

	private ArrayList<Card> deck;

	//Inner class Card
	public class Card {
		String suit;
		int value;
		String face;

		private Card (int value, String suit) {
			this.suit = suit;
			this.value = value;
		}

		private Card (String face, String suit) {
			this.suit = suit;
			this.face = face;
		}
	}

	public Deck() {
		deck = new ArrayList<Card>();
		createDeck();
	}

	private void shuffle() {
		Collections.shuffle(deck);
	}

	private Card getNextCard() {
		if (deck.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("There are no cards left in this deck");
		}

		Card next = deck.remove(0);
		return  next;
	}

	//Populates the deck with all 52 cards
	private void createDeck() {

		String[] suits = {"spade", "club", "heart", "diamond"};
		HashMap<Integer, String> facecards = new HashMap<Integer, String>();  //Accounting for facecards which dont have a integer value
		facecards.put(11, "J");
		facecards.put(12, "Q");
		facecards.put(13, "K");

		for (String suit: suits) {
			Card ace = new Card("A", suit);
			deck.add(ace);

			int value = 2;
			while (value <= 10) {
				Card c = new Card(value, suit);
				deck.add(c);
				value++;
			}

			while (value <= 13) {
				Card c = new Card(facecards.get(value), suit);
				deck.add(c);
				value++;
			}
		}

	}

	public static void main(String[] args) {

		//Testing whether deck generation is working
		Deck d = new Deck();
		int count = 0;
		while (count < 10) {
			Card next = d.getNextCard();
			if (next.value == 0) {
				System.out.println(next.face + " " + next.suit);
			} else {
				System.out.println(next.value + " " + next.suit);
			}
			count++;
		}

		System.out.println();
		System.out.println("-----Shuffled Cards-----");

		//Testing whether cards are being shuffled correctly
		Deck a = new Deck();
		d.shuffle();
		count = 0;
		while (count < 10) {
			Card next = d.getNextCard();
			if (next.value == 0) {
				System.out.println(next.face + " " + next.suit);
			} else {
				System.out.println(next.value + " " + next.suit);
			}
			count++;
		}

		System.out.println();
		System.out.println("-----Error Testing-----");

		//Testing whether program throws an error correctly
		while (!a.deck.isEmpty()) {
			a.getNextCard();
		}

		a.getNextCard();
	}

}