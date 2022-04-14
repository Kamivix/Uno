public class Punishment {
        private boolean flag;
        final private int cardToTake;
        private int direction;

        public Punishment(boolean flag, int cardToTake,int direction) {
            this.flag = flag;
            this.cardToTake = cardToTake;
            this.direction=direction;

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

}
