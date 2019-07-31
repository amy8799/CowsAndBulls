package Moo;

import java.util.*;
import Dataset.*;

 class Moo{
    Scanner sc = new Scanner(System.in);
    Random rand=new Random();
    data d = new data();
    
    String secret;
    
    void calculate() {
    
        //generating random 4 letter word
        int n=rand.nextInt(600);
        secret=d.dataset[n];
        System.out.println();
        
        System.out.println("You have 10 chances to guess the word");
        int count = 0;
        int k=0;
        int co=0;
        int bu=0;
        String s[]=new String[10];
        int c[]=new int [10];
        int b[]=new int[10];
        
        while(count !=10) {
            int cows = 0;
            int bulls = 0;
            
            //Asking the user to enter the word
            System.out.println("Guess the 4 letter word");
            String guess = sc.next();
            if(guess.length()<4 || guess.length()>4){
                System.out.println("Enter a 4 letter word");
                continue;
            }
                
            s[k]=guess;
            k++;
            char gu[] = guess.toCharArray();
            
            
            count++;
            char se[] = secret.toCharArray();
           
            
            //counting the number of bulls
            for(int i=0; i<4; i++) {    
                    if(secret.charAt(i)==guess.charAt(i)) {
                        bulls++;

                        se[i]='!';
                        gu[i]='#';
        }
    }
            
    b[bu]=bulls;
    bu++;
    
    //counting the number of cows
    for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(se[i]==gu[j]) {
                    cows++;

                    se[i]='!';
                    gu[j]='#';
            }
        }
    }
    c[co]=cows;
    co++;

    //if the word is right
    if(bulls == 4) {
        System.out.println();
        System.out.println("Congo you got the word right");
        check(count);
    }
    else {
        System.out.println(" Word"+"\t"+" Cows"+"\t"+"Bulls");
        System.out.println("-----------------------");
        for(int i=0;i<k;i++)
            System.out.println((i+1)+"."+s[i]+"\t   "+ c[i]+"\t   "+b[i]);

        }

    }
    if(count==10){
        check(count);
     }
   }

    //To check if the user wants to continue the game 
    void check(int chk)
    {
        if(chk==10){
            System.out.println("");
            System.out.println("10 trials done");
            System.out.println("The correct word was "+secret);
        }   
        System.out.println("");
        System.out.println("Do you want to continue,Yes or No");
        System.out.println("");
        String str=sc.next().toLowerCase();

        if(str.compareTo("yes")==0)
            calculate();
        else{
            System.out.println("");
            System.out.println("Game over :)");
            System.exit(0);
        }
    } 




    public static void main(String args[]) {

        Moo m =  new Moo();
        m.calculate();
    }
}

