import java.util.ArrayList;

public class CardsFlow {
    public CardsFlow(Table table,ReturnPlayerAndCard game, ArrayList<Player> players){
        this.table=table;
        this.players=players;
        this.game=game;
    };
    int counterToChangeDirection=1;
    int cardToTake=0;
    boolean shouldStop=false;
    int i=0;
    Table table;
    ReturnPlayerAndCard game;
    ArrayList<Player> players;

    public void controllCardFlow(){

        Punishment punishment= new Punishment(true,0,1,false,false);
        while(true){
            System.out.println("On the table is " + game.cardOnTable);
            System.out.println(i+1+ " player");
            punishment=table.letsPlay(game.cardOnTable,players.get(i).putCard(),players.get(i),punishment.isFlag(),game.card,cardToTake);
            cardToTake=punishment.getCardToTake();
            counterToChangeDirection+= punishment.getDirection();
shouldStop=punishment.isStop();
if(shouldStop && counterToChangeDirection%2==0){
    --i;
    if(i<0){
        i=players.size()-1;
    }
}
else if(counterToChangeDirection%2!=0 &&shouldStop ){
    ++i;
    if(i> players.size()-1){
        i=0;
    }
}
            if(counterToChangeDirection%2==0){
                --i;
                if(i<0){
                    i=players.size()-1;
                }
            }
            else{
                ++i;
                if(i> players.size()-1){
                    i=0;
                }
            }
            if(punishment.isOver()){
                System.out.println("Player" + i +" Win");
                break;

            }

        }
    }
}
