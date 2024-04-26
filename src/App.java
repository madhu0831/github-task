
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        var theMagicNumber=7;
        var theGuess=0;
    while (theGuess!=theMagicNumber) {
        
        System.out.println("Guess the number !");
        theGuess= sc.nextInt();

        if(theGuess<theMagicNumber)
        System.out.println(theGuess+" is too low!");

        if(theGuess>theMagicNumber)
        System.out.println(theGuess+" is too high!");

        if(theGuess==theMagicNumber)
        System.out.println(theGuess+" is correct!");
    }
}
}

