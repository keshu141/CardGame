
/*@Suman 
  Code for card game
*/
import java.util.ArrayList; //import ArrayList  
import java.util.Random; //import Random
import java.util.Scanner;
import java.util.List; //import List
import java.util.Collections; //import Collections
import java.util.LinkedList; //import LinkList

public class WarCardGame {
	public static String a;
	public static String b;

	public static void main(String[] args) {

		List<Card> cardDeck = new ArrayList<Card>(); // create an ArrayList "cardDeck"

		for (int x = 0; x < 4; x++) { // 0-3 for suit (4 suits)
			for (int y = 2; y < 15; y++) { // 2-14 for rank (13 ranks)
				cardDeck.add(new Card(x, y)); // create new card and add into the deck
			} // end rank for
		} // end suit for

		Collections.shuffle(cardDeck, new Random()); // shuffle the deck randomly

		// creating 2 decks, each for player1/player2
		LinkedList<Card> deck1 = new LinkedList<Card>();
		LinkedList<Card> deck2 = new LinkedList<Card>();

		deck1.addAll(cardDeck.subList(0, 25)); // 26 cards for player1
		deck2.addAll(cardDeck.subList(26, cardDeck.size()));// 26 cards for player2

		while (true) {
			Card c1Card = deck1.pop(); // each player place one card face up
			Card c2Card = deck2.pop();
			Scanner input = new Scanner(System.in);
			ArrayList<String> players = new ArrayList<String>();

			for (int i = 1; i <= 2; i++) {
				System.out.println("\nPlayer " + i + ", please state your name: ");
				String name = input.next();
				// add player name to array
				players.add(name);

			}

			String a = players.get(0);// get player1 name by index no
			System.out.println(a);

			String b = players.get(1);// get player2 name by index no
			System.out.println(b);

			// display the face up cardl

			System.out.println(a + ":" + c1Card.toString());
			System.out.println(b + ":" + c2Card.toString());

			// rank comparation between two cards
			if (c1Card.getCard() > c2Card.getCard()) {// if player 1 win
				deck1.addLast(c1Card); // higher rank wins both cards and
				deck1.addLast(c2Card); // places them at the bottom of his deck.
				System.out.println(a + " wins the round:");
			} // end if

			else if (c1Card.getCard() < c2Card.getCard()) {// if player 2 win
				deck2.addLast(c1Card);
				deck2.addLast(c2Card);
				System.out.println(b + " wins the round");
			} // end else if

			else { // Cards Battle happens when both cards' rank matched
				System.out.println("Cards Battle");

				// creating Cards Battle cards
				List<Card> war1 = new ArrayList<Card>();
				List<Card> war2 = new ArrayList<Card>();

				// checking do players have enough (4)cards to stay in game
				for (int x = 0; x < 3; x++) {
					// either one player runs out of card is game over
					if (deck1.size() == 0 || deck2.size() == 0) {
						break;
					} // end if

					war1.add(deck1.pop()); // place additional card for 'cards Battle'
					war2.add(deck2.pop());
				} // end for

				// only compare result when both players have enough cards for 'cards Battle'
				if (war1.size() == 3 && war2.size() == 3) {
					// display the battle cards from each player
					System.out.println("Battle card for " + a + " is " + war1.get(0).toString());
					System.out.println("Battle card for " + b + " is " + war2.get(0).toString());

					// if player 1 wins the cards Battle round
					if (war1.get(2).getCard() > war2.get(2).getCard()) {
						deck1.addAll(war1); // player1 get all 10 cards
						deck1.addAll(war2);
						System.out.println(a + " wins the cards battle round");
					} // end if
						// otherwise player 2 wins the war round
					else {
						deck2.addAll(war1); // player2 get all 10 cards
						deck2.addAll(war2);
						System.out.println(b + " wins the cards battle round");
					} // end else
				} // end if

			} // end war round else

			// game over either one player runs out of card(deck size is 0)
			if (deck1.size() == 0) {
				System.out.println("game over\nPlayer 1 wins the game");
				break;
			} else if (deck2.size() == 0) {
				System.out.println("game over\nPlayer 2 wins the game");
				break;
			}

			System.out.println("Re-shuffling- returning all cards deck");
			Collections.shuffle(cardDeck, new Random());// re-shuffle//end while
		}

	}

}// end main
