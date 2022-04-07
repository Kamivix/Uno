import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    private ArrayList<Card> cardsOnTable = new ArrayList<>();
    private int anotherCard;
    private boolean flag=true;
    Scanner scanner = new Scanner(System.in);

    public ReturnPlayerAndCard dealTheCards(int playerCount, ArrayList<Card> cards, ArrayList<Player> players) {
        final int cardAtBeginning = 7;

        for (int i = 0; i < cardAtBeginning; ++i) {

            for (int j = 0; j < playerCount; ++j) {
                players.get(j).addCardToPlayerHand(cards.get(0));
                cards.remove(0);
            }
        }
        while (true) {
            if (cards.get(0).isStart()) {
                cardsOnTable.add(cards.get(0));
                cards.remove(0);
                break;
            } else {
                cardsOnTable.add(cards.get(0));
                cards.remove(0);
            }
        }

        return new ReturnPlayerAndCard(players, cards, cardsOnTable);


    }

    public boolean letsPlay(ArrayList<Card> cardsOnTable, Card card, Player player, boolean flag, ArrayList<Card> remainingCards) {



    }