import java.util.Random;
import java.util.Scanner;

public class Guess{
    public static void main(String[] args) {
        
    Scanner sc=new Scanner(System.in);


    int comp_choice;
    int compwon=0;
    int my_choice;
    int me=0;
    int game=1;
    {
    System.out.println("0 is for rock");
    System.out.println("1 is for paper");
    System.out.println("2 is for scissor");

    while(game<=5){
        Random random=new Random();
        comp_choice=random.nextInt(2);
        my_choice=sc.nextInt();

        switch ((my_choice)) {
            case 0:
                  System.out.println("you choose rock");
                  break;
            case 1:
                System.out.println("you choose paper");
                break;
            case 2:
                System.out.println("you choose scissor");
            default:
                break;
        }
    switch ((comp_choice)) {
      case 0:
            System.out.println("computer choose rock");
            break;
      case 1:
          System.out.println("computer choose paper");
          break;
      case 2:
          System.out.println("computer choose scissor");
    }

    if (comp_choice==my_choice) {
        System.out.println("match tie");
        
    }
    else if(comp_choice==0&&my_choice==1){
        System.out.println("I won !!! ");
        me++;
    }
    else if(comp_choice==0 && my_choice==2){
        System.out.println("Computer Won!!");
        compwon++;
    }
    else if(comp_choice==1 && my_choice==0){
        System.out.println("Computer won!!");
        compwon++;
    }
    else if(comp_choice==1 && my_choice==2){
        System.out.println("I Won !!");
        me++;

    }
    else if(comp_choice==2 && my_choice==0){
        System.out.println("I won !!");
        me++;
    }
    else if(comp_choice==2 && my_choice==1){
        System.out.println("Computer Won !!");
        compwon++;
    }
    if (game==5) {
        break;
    }
    game++;
}

System.out.println("_________________________________________");
System.out.println("me"+":"+me);
System.out.println("_________________________________________");

if(compwon>me){
    System.out.println("Computer Won The Game");
}
else if(compwon==me){
    System.out.println("Match tie");
}
else{
    System.out.println("I Won The Game!!");
}
    }
}
}