
package prodotto;

import java.text.DecimalFormat;

/**
 *
 * @author XenSide
 */
public class Prodotto {
    //VAR IO
    private final String nome;
    private final float prezzou;
    private final float quantita;
    private float soglia;
    private int sconto;
    //VAR ELAB
    private float prezzoFinale;
    private float prezzoScontato;
    private boolean scontoApplicato;
    private float scontoNetto;
    
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
    public void ApplicaSconto(){
        if (prezzoFinale>soglia&&sconto>0){
            scontoNetto = prezzoFinale*sconto/100;
            prezzoScontato = prezzoFinale-scontoNetto;
            scontoApplicato=true;
    }
    }
    
    public void Stampa(){
        DecimalFormat dfEuro= new DecimalFormat("0.00"); //Formato da usare per gli EUR
        DecimalFormat dfquantita= new DecimalFormat("0.##"); //Formato da usare per la quantita
        System.out.println("Nome prodotto: " + nome);
        System.out.println("Prezzo unitario del prodotto: "+dfEuro.format(prezzou)+"€");
        System.out.println("Quantità acquistate: "+dfquantita.format(quantita));
        
        if (scontoApplicato){
            System.out.println("Prezzo di listino: "+dfEuro.format(prezzoFinale)+"€");
            System.out.println("Sconto applicato: "+sconto+"% ("+dfEuro.format(scontoNetto)+"€)");
            System.out.println("Totale: "+dfEuro.format(prezzoScontato)+"€");
            
        }else if(sconto>0 && scontoApplicato){
            float differenzaSoglia;
            differenzaSoglia = soglia-prezzoFinale;
            System.out.println("Spendi altri "+dfEuro.format(differenzaSoglia)+"€ ("+dfEuro.format(soglia)+"€ in totale) per avere uno sconto del "+sconto+"%");
            System.out.println("Totale: "+ dfEuro.format(prezzoFinale)+"€");
        }else{
            System.out.println("Totale: "+ dfEuro.format(prezzoFinale)+"€");
        }
    }
    
    public void CalcolaTot(){
        prezzoFinale=prezzou*quantita;
    }
}
//FINE METODI
