/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 *
 * @author XenSide
 */
public class Cassa {
    public static void main(String[] args) {
        DecimalFormat dfEuro = new DecimalFormat("0.00");
        DecimalFormat dfquantita = new DecimalFormat("0.##");
        
        String nome;
        float prezzou;
        prezzou = 0;
        float quantita;
        quantita = 0;
                
        InputStreamReader input;
        input = new InputStreamReader(System.in);
        BufferedReader tastiera;
        tastiera = new BufferedReader(input);
        
        
        /*System.out.println("Inserisci il numero di prodotti da inserire: ");
        try {
            nprodotti=Integer.valueOf(tastiera.readLine());                             WIP, ha bisogno di un vettore di oggetti e non so come si facciano.
        } catch (IOException ex) {
           System.out.println("Errore nell'inserimento del numero di prodotti");
        }
        while (nprodotti>0) {*/ 
        
        try {
            do{
            System.out.println("Inserisci il nome del prodotto:");
            nome=tastiera.readLine();
            }while (nome.length()>30);
        } catch (IOException e) {
            nome="ERROR";
            System.out.println("Errore nell'inserimento del nome");
        }
        
        
        try {
            do {
                System.out.println("Inserisci il prezzo unitario del prodotto: ");
                prezzou=Float.valueOf(tastiera.readLine());
            } while (prezzou>=2000);
        } catch (IOException | NumberFormatException e){
            System.out.println("Errore nell'inserimento del prezzo unitario");
            
        }
                
        try {
            do {
                System.out.println("Inserisci la quantita' acquistata del prodotto: ");
                quantita=Float.valueOf(tastiera.readLine());
            }while (quantita>1000);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Errore nell'inserimento della quantita'");
        }
        
        Prodotto prodottoTest = new Prodotto(nome,prezzou,quantita);
        
        try {
            do{
            System.out.println("Inserisci la soglia in euro da superare per effettuare lo sconto:");
            prodottoTest.setSoglia(Float.valueOf(tastiera.readLine()));
            }while (prodottoTest.getSoglia()>200000);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Errore nell'inserimento della soglia");
        }
               
        try {
            do {
                System.out.println("Inserisci la percentuale di sconto da applicare nel caso in cui venga superata la soglia:");
                prodottoTest.setSconto(Integer.valueOf(tastiera.readLine()));
            }while(prodottoTest.getSconto()<0 && prodottoTest.getSconto()>100);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Errore nell'inserimento della soglia");
        }
        
        prodottoTest.CalcolaTot();
        prodottoTest.ApplicaSconto();
        prodottoTest.Stampa();
        
        //}
            
       
    
}
}
