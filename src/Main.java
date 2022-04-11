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
//        table.letsPlay(game.cardOnTable,players.get(0).putCard(),players.get(0));
//        System.out.println("on the table is " + game.cardOnTable);
//        System.out.println("After put card you have"+ game.players.get(0).getCardsInHand());
        int i=0;
        Table.Punishment x= new Table.Punishment(true,0,1);
        while(true){
            System.out.println("On the table is " + game.cardOnTable);
            System.out.println(i+1+ " player");
            x=table.letsPlay(game.cardOnTable,players.get(i).putCard(),players.get(i),x.isFlag(),game.card);

            System.out.println(x.getDirection());


            switch (x.getDirection()){
                case 1:
                    --i;
//                    i=i-1;
                    if(i<0){
                        i=2;
                    }
                    break;
                case 0:
                    ++i;
                    if(i>2){
                        i=0;
                    }
                    break;
            }
            }


    }
}
