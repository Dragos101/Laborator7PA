package ro.info.uaic;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private int score, dimensiune;
    private List<Tokens> listaTokeni;
    private Board masa;

    Player(String s, Board masa) {
        this.name = s;
        this.dimensiune = 0;
        this.score = 0;
        this.listaTokeni = new ArrayList<Tokens>();
        this.masa = masa;
    }

    /**
     * Fiecare jucator extrage cate un token din lista de tokeni disponibili
     */
    @Override
    public void run() {
        masa.getJucatori().add(this);
        int index;
        int time = masa.getTime() * 1000;
        if(Thread.currentThread().isDaemon()){
            try{
                if(time != 0){
                    sleep(1000);
                    System.out.println("A trecut o secunda");
                    time -= 1000;
                }
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        else{
            while(masa.getNumberTokens() != 0){

                synchronized (this){
                    index = masa.getNumberTokens() - 1;
                    masa.setNumberTokens(masa.getNumberTokens() - 1);
                    this.listaTokeni.add(masa.getTokens().get(index));
                    this.dimensiune++;
                    System.out.println(Thread.currentThread().getName() + " -> " + masa.getTokens().get(index).getfValue() + " " + masa.getTokens().get(index).getsValue());
                }
            }
            punctaj();
        }
    }
    public void punctaj(){
        int secventa, secventaMaxima;
        secventaMaxima = 1;
        for(int i = 0; i < dimensiune - 1; ++i){
            secventa = 1;
            for(int j = i + 1; j < dimensiune; ++j){
                if(listaTokeni.get(j - 1).getsValue() == listaTokeni.get(j).getfValue())
                    secventa++;
                else{
                    if(secventaMaxima > secventa) secventaMaxima = secventa;
                    secventa = 0;
                }
            }
        }
        this.score = secventaMaxima;
    }
    public int getScore(){return score;}
}
