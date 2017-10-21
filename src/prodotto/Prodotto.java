
package prodotto;

import java.text.DecimalFormat;

/**
 *
 * @author XenSide
 */
public class Prodotto {
    //VAR IO
    private final String nome;
    private final float prezzou,quantita;
    private float soglia;
    private int sconto;
    //VAR ELAB
    private float prezzoFinale,prezzoScontato,scontoEur;
    
    //Costruttore
    public Prodotto(String nome, float prezzou, float quantita) {
        this.nome = nome;
        this.prezzou = prezzou;
        this.quantita = quantita;
    }
    
     

// GET/SET
    public float getPrezzoFinale() {
        return prezzoFinale;
    }

    public float getSoglia() {
        return soglia;
    }

    public int getSconto() {
        return sconto;
    }

    public void setPrezzoFinale(float prezzoFinale) {
        this.prezzoFinale = prezzoFinale;
    }

    public void setSoglia(float soglia) {
        this.soglia = soglia;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }
//FINE GET SET
    
//METODI   
    public float applicaSconto(){
        if (prezzoFinale>soglia&&sconto>0){
            scontoEur = prezzoFinale*sconto/100;
            prezzoScontato = prezzoFinale-scontoEur;
            return prezzoScontato;
    }
        return 0;
    }
    
    public void stampa(){
        DecimalFormat dfEuro= new DecimalFormat("0.00"); //Formato da usare per gli EUR
        DecimalFormat dfquantita= new DecimalFormat("0.##"); //Formato da usare per la quantita
        System.out.println("Nome prodotto: " + nome);
        System.out.println("Prezzo unitario del prodotto: "+dfEuro.format(prezzou)+"€");
        System.out.println("Quantità acquistate: "+dfquantita.format(quantita));
        
        if (scontoEur>0){
            System.out.println("Prezzo di listino: "+dfEuro.format(prezzoFinale)+"€");
            System.out.println("Sconto applicato: "+sconto+"% ("+dfEuro.format(scontoEur)+"€)");
            System.out.println("Totale: "+dfEuro.format(prezzoScontato)+"€");
            
        }else if(sconto>0){
            float differenzaSoglia;
            differenzaSoglia = soglia-prezzoFinale;
            System.out.println("Totale: "+ dfEuro.format(prezzoFinale)+"€");
            System.out.println("Spendi altri "+dfEuro.format(differenzaSoglia)+"€ ("+dfEuro.format(soglia)+"€ in totale) per avere uno sconto del "+sconto+"%");
        }else{
            System.out.println("Totale: "+ dfEuro.format(prezzoFinale)+"€");
        }
    }
    
    public float calcolaTot(){
        prezzoFinale=prezzou*quantita;
        return prezzoFinale; 
    }
}
//FINE METODI
