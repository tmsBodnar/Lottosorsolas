/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottosorsolas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bodnart
 */
public class LottoSorsolas {

    public static int tipp(){
        Scanner sc = new Scanner(System.in);
        int tipp = sc.nextInt();
        System.out.print("");
        if(tipp <= 0 || tipp > 35){
            System.out.print("Rossz tipp! Adjon újat!");
            tipp = sc.nextInt();
        }
        return tipp;
    }
    
    public static int sorsolas(){
        Random rnd = new Random();
        int sors = rnd.nextInt(34);
        System.out.print("");
        return sors;
    }
    
    public static boolean tippEllenor(int[] tippek, int tipp){
        boolean helyesTipp = true;
        for( int i = 0; i < tippek.length; i++){
                if (tippek[i] == tipp){
                    helyesTipp = false;
                }
            }
        return helyesTipp;
    }
    
    public static void talalat(int[] tippek, int[]sorsolas){
        int talalat = 0;
        
        for (int i = 0; i < tippek.length; i++) {
            for(int szam : sorsolas){
                if(tippek[i] == szam){
                    talalat++;
                }
            }
        }
        int talalatok[] = new int[talalat];
        int x = 0;
        for (int i = 0; i < tippek.length; i++) {
            for(int szam : sorsolas){
                if(tippek[i] == szam){
                    talalatok[x] = tippek[i];
                    x++;
                }
            }
        }
        if ( talalat > 0){
            System.out.println(talalat + " találata volt: ");
            for(int szam:talalatok){
                System.out.println(szam);
            }
        }else
            System.out.println("Sajnos nem nyert!");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] tippek = new int[7];
        int x = 0;
        do{
        System.out.print("Az " + (x+1) + ". tippje a hétből:");    
        int jatekos = tipp();
        if (tippEllenor(tippek, jatekos)){
            tippek[x]= jatekos;
            x++;
        }else{
            System.out.println("Rossz tipp, újat kérek!");
        }
            
        }while( x < 7 );
        System.out.print("A tippjei: ");
        for(int szam:tippek){
            System.out.print(szam + ", ");
            
        }
        System.out.println("");
        int[] sorsolas = new int[7];
        int y = 0;
        do{
        int sors = (sorsolas() + 1);            
        if (tippEllenor(sorsolas, sors)){
            sorsolas[y] = sors;
            y++;
            }
        }while (y < 7);
        System.out.print("A nyerőszámok: ");
        for(int szam:sorsolas){
            System.out.print(szam + ", ");
            }
        System.out.println("");
    talalat(tippek,sorsolas);
    }
    
    
    
}
