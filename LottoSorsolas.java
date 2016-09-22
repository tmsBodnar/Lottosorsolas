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
//itt kérjük be a játékos tippjeit
    public static int tipp(){
        Scanner sc = new Scanner(System.in);
        int tipp;
//ebben a ciklusban vizsgáljuk, hogy 1-35 között van-e a tipp        
        do{
        tipp = sc.nextInt();
        if(tipp <= 0 || tipp > 35){
            System.out.print("Rossz tipp! Adjon újat!");
        }
        }while (!( tipp > 0 && tipp < 35));
        System.out.print("");
        return tipp;
    }
//itt a sorsolás zajlik :-)    
    public static int sorsolas(){
        Random rnd = new Random();
        int sors = rnd.nextInt(34);
        System.out.print("");
        return sors;
    }
//itt megnézzük, van-e már ilyen tipp a tippek tömbben    
    public static boolean tippEllenor(int[] tippek, int tipp){
        boolean helyesTipp = true;
        for( int i = 0; i < tippek.length; i++){
                if (tippek[i] == tipp){
                    helyesTipp = false;
                }
            }
        return helyesTipp;
    }
// itt egy tömbbe helyezzük a találatokat    
    public static void talalat(int[] tippek, int[]sorsolas){
        int talalat = 0;
//először megszámoljuk, hány találata van a játékosnak        
        for (int i = 0; i < tippek.length; i++) {
            for(int szam : sorsolas){
                if(tippek[i] == szam){
                    talalat++;
                }
            }
        }
//majd ezt az előbb megállapított méretű találatok tömbben elhelyezzük        
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
// ha volt találata, kiírjuk hogy mennyi és milyen számokat talált el        
        if ( talalat > 0){
            System.out.println(talalat + " találata volt: ");
            for(int szam:talalatok){
                System.out.println(szam);
            }
// ha nem volt elküldjük a fenébe             
        }else
            System.out.println("Lúzer!(Sajnos nem nyert!)");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//létrehozunk egy 7 elemű tömböt a tippeknek       
        int [] tippek = new int[7];
        int x = 0;
//feltöltjük a tömböt a függvénnyel bekért és ellenőrzött számokkal        
        do{
        System.out.print("Az " + (x+1) + ". tippje a hétből:");    
        int jatekos = tipp();
        if (tippEllenor(tippek, jatekos)){
            tippek[x]= jatekos;
            x++;
        }else{
            System.out.println("Rossz tipp, adjon újat!");
        }
            
        }while( x < 7 );
//A végén kiírjuk egyben a tippeket        
        System.out.print("A tippjei: ");
        for(int szam:tippek){
            System.out.print(szam + ", ");
            
        }
        System.out.println("");
//létrehozunk egy 7 elemű tömböt a sorsolásnak        
        int[] sorsolas = new int[7];
        int y = 0;
//feltöltjük a függvényektől bekért és ellenőrzött számokkal
        do{
        int sors = (sorsolas() + 1);            
        if (tippEllenor(sorsolas, sors)){
            sorsolas[y] = sors;
            y++;
            }
        }while (y < 7);
// kiírjuk a nyerőszámokat
        System.out.print("A nyerőszámok: ");
        for(int szam:sorsolas){
            System.out.print(szam + ", ");
            }
        System.out.println("");
//majd meghívjuk a talalat függvényt, ami kiírja a találatokat        
    talalat(tippek,sorsolas);
    }
    
    
    
}
