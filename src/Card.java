public class Card {
     private String colour;
    final private String type;
    final private boolean start;
    final private boolean flag;
    public Card(String colour, String type){
        this(colour,type,true);
    }
    public Card(String colour, String type,boolean start) {
        this.colour = colour;
        this.type = type;
        this.start = start;
        if(this.type.equals("ChangDirection")|| (this.colour.equals("Black"))&& !this.type.equals("ChangeColour + 4")||this.type.equals("Stop")){
            this.flag=false;
        }
        else{

        this.flag=!isStart();}
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isStart() {
        return start;
    }

    public String getColour() {
        return colour;
    }

    public String getType() {
        return type;
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public String toString(){
        return this.colour + " " + this.type;
    }
}
