import java.util.ArrayList;
import java.util.Scanner;

public class Table {

    final private ArrayList<Card> cardsOnTable = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);

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

    public Punishment letsPlay(ArrayList<Card> cardsOnTable, Card card, Player player, boolean flag, ArrayList<Card> remainingCards,int cardToTake) {
         int direct;
        if(cardsOnTable.get(cardsOnTable.size()-1).getType().equals("Stop") && flag){
            System.out.println("queue should be skipped");
            flag=false;

            return new Punishment(flag,0,0,false);

        }


        if(!cardsOnTable.get(cardsOnTable.size()-1).isStart() && flag){
            direct=0;
            if(card.getType().equals(cardsOnTable.get(cardsOnTable.size()-1).getType())){
                if(card.getType().equals("ChangDirection")){
                    direct=1;
                }
                else{
                    direct=0;
                }
                if(card.getType().equals("+2")){
                    cardToTake+=2;
                    System.out.println(cardToTake+ " card to take");
                }

                if(card.getType().equals("ChangeColour + 4")){
                    cardToTake+=4;
                    System.out.println(cardToTake+ " card to take");
                }
                cardsOnTable.add(card);
                player.getCardsInHand().remove(card);
                if(player.getCardsInHand().size()==1){
                    System.out.println("Uno!");
                }
                if(player.getCardsInHand().size()==0){
                    System.out.println("You win");
                    return new Punishment(false,0,0,true);
                }
                return new Punishment(card.isFlag(),cardToTake,direct,false);
            }
            else {
                System.out.println("Choose another card(1) or do something (2)");
                switch (scanner.nextInt()){
                    case 1:
                        this.letsPlay(cardsOnTable,player.putCard(),player,cardsOnTable.get(cardsOnTable.size()-1).isFlag(),remainingCards,cardToTake);
                        break;
                    case 2:
                        switch (cardsOnTable.get(cardsOnTable.size()-1).getType()){
                            case "ChangeColour + 4":
                            case "+2":
                                for(int i=0;i<cardToTake;++i){
                                    player.getCardsInHand().add(remainingCards.get(remainingCards.size()-1));
                                    remainingCards.remove(remainingCards.size()-1);}
                                break;
                        }
                        return new Punishment(false,0,0,false);
                }

            }
        }
        else {
            if(cardsOnTable.get(cardsOnTable.size()-1).getColour().equals(card.getColour())||cardsOnTable.get(cardsOnTable.size()-1).getType().equals(card.getType())||card.getColour().equals("Black")){
                if(card.getType().equals("ChangDirection")){
                    direct=1;
                }
                else{
                    direct=0;
                }

                if(card.getType().equals("+2")){
                    cardToTake+=2;
                    System.out.println(cardToTake+ " card to take");
                }

                if(card.getType().equals("ChangeColour + 4")){
                    cardToTake+=4;
                    System.out.println(cardToTake+ " card to take");
                }

                if(card.getColour().equals("Black")){
                    System.out.println("Now you have to choose colour");
                    System.out.println("1 is Green");
                    System.out.println("2 is Red");
                    System.out.println("3 is Blue");
                    System.out.println("4 is Yellow");

                switch (scanner2.nextInt()) {
                    case 1:
                        card.setColour("Green");
                        break;
                    case 2:
                        card.setColour("Red");
                        break;
                    case 3:
                        card.setColour("Blue");
                        break;
                    case 4:
                        card.setColour("Yellow");
                        break;

                }
                scanner2.nextLine();
                }
                cardsOnTable.add(card);
                player.getCardsInHand().remove(card);
                if(player.getCardsInHand().size()==0){
                    System.out.println("You win!");
                    return new Punishment(false,0,0,true);
                }
                return new Punishment(card.isFlag(),cardToTake,direct,false);
            }
            else {
                System.out.println("Choose another card(1) or take one card(2)");
                switch (scanner.nextInt()){
                    case 1:
                        this.letsPlay(cardsOnTable,player.putCard(),player,cardsOnTable.get(cardsOnTable.size()-1).isFlag(),remainingCards,cardToTake);
                        break;
                    case 2:
                        player.getCardsInHand().add(remainingCards.get(remainingCards.size()-1));
                        remainingCards.remove(remainingCards.size()-1);
                        return new Punishment(false,0,0,false);
                }

            }

        }

        return new Punishment(false,0,0,false);
    }
}