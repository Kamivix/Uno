public class Punishment {
        final private boolean flag;
        final private int cardToTake;
        final private int direction;
         private boolean over;

        public Punishment(boolean flag, int cardToTake,int direction,boolean over) {
            this.flag = flag;
            this.cardToTake = cardToTake;
            this.direction=direction;
            this.over=over;

        }

        public boolean isFlag() {
            return flag;
        }

        public int getCardToTake() {
            return cardToTake;
        }

        public int getDirection() {
            return direction;
        }

    public boolean isOver() {
        return over;
    }
}
