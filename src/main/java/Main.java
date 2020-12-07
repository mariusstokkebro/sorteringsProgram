
import processing.core.PApplet;
import processing.data.IntList;

public class Main extends PApplet{
    public static void main(String[] args) {
        PApplet.main("Main");
    }
PApplet p;

    IntList liste = new IntList();

    @Override
    public void settings() {

        size(500,500);
    }
    public static IntList tal(IntList tal, int k) {
        if (tal.size()<10) {
            tal.append(k);
            k=k-1;
            tal(tal,k);
            tal.shuffle();
            return tal;
        }
        else{return tal;}
    }
    public void bongoShuffle(IntList tal,int index){


    }
   public void display(IntList nummer, int k) {

       int num = nummer.get(k);
       fill(200);
       rect(width/10* k, height, width/10, -num * 20);
       fill(0);
       text(num,width/10*k,height-10);
       if (k< nummer.size()-1) {
           display(nummer, ++k);
       }

   }

    @Override
    public void setup(){
    liste =tal(liste ,10);
    println(liste);
    display(liste,0);
    }


    @Override
    public void draw() {

    }
}

