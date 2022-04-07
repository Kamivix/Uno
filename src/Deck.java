import java.util.ArrayList;
import java.util.Collections;

public class Deck {


    public ArrayList<Card> createDeck(){
        ArrayList<Card> deck=new ArrayList<>();
        int x;
        for(int i=0;i<19;++i) {
            x=i;
            if(i>9){
                x-=9;
            }
            deck.add(new Card("Red",Integer.toString(x)));
            deck.add(new Card("Green",Integer.toString(x)));
            deck.add(new Card("Blue",Integer.toString(x)));
            deck.add(new Card("Yellow",Integer.toString(x)));

            if(i<=1){
                deck.add(new Card("Red","+2",false));
                deck.add(new Card("Green","+2",false));
                deck.add(new Card("Blue","+2",false));
                deck.add(new Card("Yellow","+2",false));

                deck.add(new Card("Red","Stop",false));
                deck.add(new Card("Green","Stop",false));
                deck.add(new Card("Blue","Stop",false));
                deck.add(new Card("Yellow","Stop",false));

                deck.add(new Card("Red","ChangDirection",false));
                deck.add(new Card("Green","ChangDirection",false));
                deck.add(new Card("Blue","ChangDirection",false));
                deck.add(new Card("Yellow","ChangDirection",false));
            }

            if(i<=3){
                deck.add(new Card("Black","ChangeColour",false));
                deck.add(new Card("Black","ChangeColour + 4",false));
            }
        }


        return deck;
    }

    public ArrayList<Card> shuffleCard(ArrayList<Card> cards){
        Collections.shuffle(cards);
        return cards;
    }

}
