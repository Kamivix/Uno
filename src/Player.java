import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    final private String name;
    private ArrayList<Card> cardsInHand = new ArrayList<>();
    final private Scanner scanner=new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void addCardToPlayerHand(Card card) {
        cardsInHand.add(card);

    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public String getName() {
        return name;
    }

    public Card putCard(){
        for (int i=0;i< cardsInHand.size();++i){
            int temp=i+1;
            System.out.println("Your"+ " " + temp +" " +"card is:"+" "+ cardsInHand.get(i));

        }
        System.out.println("Choose card:");
        return cardsInHand.get(scanner.nextInt()-1);
    }
}
