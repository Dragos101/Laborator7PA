package ro.info.uaic;

public class Tokens {
    private int fValue, sValue, positiveValue;

    Tokens(int fValue, int sValue, int positiveValue){
        this.sValue = sValue;
        this.fValue = fValue;
        this.positiveValue = positiveValue;
    }

    /**Getter pentru fValue - prima valoare din perechea de valori (fValue, sValue)*/
    public int getfValue(){
        return fValue;
    }
    /**Getter pentru sValue - a doua valoare din perechea de valori (fValue, sValue)*/
    public int getsValue(){
        return  sValue;
    }


}
