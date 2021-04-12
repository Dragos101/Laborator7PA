package ro.info.uaic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Tokens> tokens;
    private List<Player> jucatori;
    private int numberTokens, randomValueF, randomValueS, randomValue, totalNumber, time;
    private Random rand;

    Board(int number){
        this.tokens = new ArrayList<>();
        this.jucatori = new ArrayList<>();
        this.rand = new Random();
        this.numberTokens = number;
        this.time = 10; // 10 secunde
        this.totalNumber = number;
        this.randomValueF = 0;
        this.randomValueS = 0;
        this.randomValue = 0;
        int i = 0;
        /**creez -number- token uri cu valori random / daca cele doua valori nu sunt diferite se incearca randomizarea pana cand randomValueF si randomValueS au valori diferite*/
        while(i != number){
            randomValueF = rand.nextInt(number + 1);
            randomValueS = rand.nextInt(number + 1);
            randomValue = rand.nextInt(number + 1);
            if(randomValueF != randomValueS) {
                tokens.add(new Tokens(randomValueF, randomValueS, randomValue));
                i++;
            }
        }
    }

    /**Setter/Getter pentru lista de tokeni*/
    public void setTokens(List<Tokens> lista){
        this.tokens = lista;
    }
    public List<Tokens> getTokens(){
        return tokens;
    }
    /**Setter/Getter pentru numarul de tokeni*/
    public void setNumberTokens(int numberTokens) {
        this.numberTokens = numberTokens;
    }
    public int getNumberTokens(){
        return numberTokens;
    }
    /**getter pentru total number*/
    public int getTotalNumber(){return totalNumber;}
    /**getter pentru lista jucatori*/
    public List<Player> getJucatori(){
        return jucatori;
    }
    /**
     * returneaza timpul
     * @return
     */
    public int getTime(){return time;}
    /**Afiseaza boardul*/
    public void afisareBoard(){
        int i = 0;
        for(Tokens e : tokens)
            System.out.println("tokenul ->" + i++ + " / prima valoare => " + e.getfValue() + " a doua valoare => "  + e.getsValue());
    }
    /**Afiseaza scorul playerilor*/
    public void afisarePlayeri(){
        for(Player e : jucatori)
            System.out.println(e.getScore());
    }
}
