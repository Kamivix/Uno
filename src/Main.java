import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args){
        ReturnPlayerAndCard game;
        Table table =new Table();
        Deck deck=new Deck();

        ArrayList<Player> players = new ArrayList<>();

        System.out.println("How many people will play?");
        Scanner scanner=new Scanner(System.in);
        int peopleCount= scanner.nextInt();
        scanner.nextLine();
        for(int i=1;i<=peopleCount;++i){
            System.out.println(i+" "+ "Player's name");
            players.add(new Player(scanner.nextLine()));
        }

        ArrayList<Card> karty=deck.createDeck();

        karty=deck.shuffleCard(karty);
        game= table.dealTheCards(peopleCount,karty,players);
        System.out.println("First player's card is "+game.players.get(0).getCardsInHand());
        System.out.println("Second player's card is "+game.players.get(1).getCardsInHand());
        System.out.println("Third player's card is "+game.players.get(2).getCardsInHand());

//int counterToChangeDirection=1;
//int cardToTake=0;
//        int i=0;
//        Punishment x= new Punishment(true,0,1,false);
//        while(true){
//            System.out.println("On the table is " + game.cardOnTable);
//            System.out.println(i+1+ " player");
//            x=table.letsPlay(game.cardOnTable,players.get(i).putCard(),players.get(i),x.isFlag(),game.card,cardToTake);
//            cardToTake=x.getCardToTake();
//            counterToChangeDirection+= x.getDirection();
//
//
//            if(counterToChangeDirection%2==0){
//                --i;
//                if(i<0){
//                    i=2;
//                }
//            }
//            else{
//                ++i;
//                if(i>2){
//                    i=0;
//                }
//            }
//            if(x.isOver()){
//                System.out.println("Player" + i+1 +" Win");
//                break;
//
//            }
//
//            }

CardsFlow cardsFlow= new CardsFlow(table,game,players);
cardsFlow.controllCardFlow();
    }
}
