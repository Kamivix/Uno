import java.util.ArrayList;
import java.util.Scanner;

public class Table {

    private ArrayList<Card> cardsOnTable = new ArrayList<>();
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

    public Punishment letsPlay(ArrayList<Card> cardsOnTable, Card card, Player player, boolean flag, ArrayList<Card> remainingCards) {
        if(cardsOnTable.get(cardsOnTable.size()-1).getType().equals("Stop") && flag){
            System.out.println(flag);
            System.out.println("queue should be skipped");
            flag=false;

            return new Punishment(flag,0,0);

        }

//        if(cardsOnTable.get(cardsOnTable.size()-1).getType().equals("ChangDirection")  ){
//            flag=false;
//            return new Punishment(flag,0,0);
//        }

if(!cardsOnTable.get(cardsOnTable.size()-1).isStart() && flag){
    int direct=0;
    if(card.getType().equals(cardsOnTable.get(cardsOnTable.size()-1).getType())){
        if(card.getType().equals("ChangDirection")){
            direct=1;
            System.out.println("Direct = 1");
        }
        cardsOnTable.add(card);
        player.getCardsInHand().remove(card);

        return new Punishment(card.isFlag(),0,direct);
    }
    else {
        System.out.println("Choose another card(1) or do something (2)");
        switch (scanner.nextInt()){
            case 1:
                this.letsPlay(cardsOnTable,player.putCard(),player,cardsOnTable.get(cardsOnTable.size()-1).isFlag(),remainingCards);
                break;
            case 2:
                switch (cardsOnTable.get(cardsOnTable.size()-1).getType()){
                    case "+2":
                    case "ChangeColour + 4":
                        break;
                }
                return new Punishment(false,0,0);
        }

    }
}
else {
    if(cardsOnTable.get(cardsOnTable.size()-1).getColour().equals(card.getColour())||cardsOnTable.get(cardsOnTable.size()-1).getType().equals(card.getType())||card.getColour().equals("Black")){
        cardsOnTable.add(card);
        player.getCardsInHand().remove(card);
        return new Punishment(card.isFlag(),0,0);
    }
    else {
        System.out.println("Choose another card(1) or take one card(2)");
        switch (scanner.nextInt()){
            case 1:
                this.letsPlay(cardsOnTable,player.putCard(),player,cardsOnTable.get(cardsOnTable.size()-1).isFlag(),remainingCards);
                break;
            case 2:
                player.getCardsInHand().add(remainingCards.get(remainingCards.size()-1));
                remainingCards.remove(remainingCards.size()-1);
                return new Punishment(false,0,0);
        }

    }

}

return new Punishment(false,0,1);
    }
}