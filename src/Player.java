import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    final private String name;
    final private List<Card> cardsInHand = new ArrayList<>();
    final private Scanner scanner=new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void addCardToPlayerHand(Card card) {
        cardsInHand.add(card);

    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }



    public Card putCard(){
        for (int i=0;i< cardsInHand.size();++i){
            int temp=i+1;
            System.out.println("Your"+ " " + temp +" " +"card is:"+" "+ cardsInHand.get(i));

        }

        System.out.println("Choose card:");
        System.out.println("If you have no card choose 0");
        int choose = scanner.nextInt();
        if(choose==0){
            scanner.nextLine();
            return null;
        }
        return cardsInHand.get(choose-1);
    }
}
