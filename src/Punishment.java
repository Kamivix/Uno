public class Punishment {
        final private boolean flag;
        final private int cardToTake;
        final private int direction;
        final private boolean over;
        final private boolean stop;

        public Punishment(boolean flag, int cardToTake,int direction,boolean over,boolean stop) {
            this.flag = flag;
            this.cardToTake = cardToTake;
            this.direction=direction;
            this.over=over;
            this.stop=stop;

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

    public boolean isStop() {
        return stop;
    }
}
