
import processing.core.PApplet;
import processing.data.IntList;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    PApplet p;

    IntList liste = new IntList();
    IntList nyTal = new IntList();

    @Override
    public void settings() {

        size(500, 500);
    }
//Laver listen med tal fra 1 til 10
    public static IntList tal(IntList tal, int k) {
        if (tal.size() < 10) {
            tal.append(k);
            k = k - 1;
            tal(tal, k);
            return tal;
        } else {
            return tal;
        }
    }
//Shuffler listen så hvert tal har en random plads
    public IntList bongoShuffle(IntList tal, int k, IntList nyTal) {


        int c;
        if (0 < k) {
            println("Bongo");
            c = (int) random(0, tal.size());
            nyTal.append(tal.get(c));
            tal.remove(c);
            k -= 1;
            bongoShuffle(liste, k, nyTal);
            return nyTal;
        } else
            return nyTal;
    }
//her bliver talene byttet rundt
    public IntList bongoSwap(IntList tal, int start, int slut) {
        IntList nyTal = new IntList();
        nyTal = tal;

        println(tal);
        int b = nyTal.get(start);
        nyTal.set(start, tal.get(slut));
        nyTal.set(slut, b);
        println(tal);
        return nyTal;


    }
// her blier bongoswap brugt til at gøre så talene enten bliver byttet rundt så det højeste tal ender i højre eller venstre side
    public void bongoSort(IntList tal, int k, boolean reverse) {
        if (k > 1) {
            if (reverse) {
                if (tal.get(k - 1) < tal.get(k - 2)) {

                    bongoSwap(tal, k - 1, k - 2);
                    k = 10;

                } else {
                    k -= 1;
                    bongoSort(tal, k, true);
                }
            } else if (tal.get(k - 1) > tal.get(k - 2)) {

                bongoSwap(tal, k - 1, k - 2);
                k = 10;

            } else {
                k -= 1;
                bongoSort(tal, k, false);
            }

        }
    }

//her bliver kolonnerne tegnet
    public void display(IntList nummer, int k) {

        int num = nummer.get(k);
        fill(200);
        rect(width / 10 * k, height, width / 10, -num * 20);
        fill(0);
        text(num, width / 10 * k, height - 10);
        if (k < nummer.size() - 1) {
            display(nummer, ++k);
        }

    }

    @Override
    //her bliver listen lavet og shufflet
    public void setup() {
        liste = tal(liste, 10);
        liste = bongoShuffle(liste, 10, nyTal);
        println(liste);

    }


    @Override
    //her bliver den tegnet
    public void draw() {
        clear();
        display(liste, 0);

    }

    @Override
    //her gør vi så listen ender med den højeste i højre hvis man klikker på højre museknap og omvendt hvis man klikker på vesntre
    public void mousePressed() {
        if (mouseButton == LEFT)
            bongoSort(liste, 10, false);
        else
            bongoSort(liste, 10, true);
    }
}

