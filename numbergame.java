import java.util.Random;
import java.util.Scanner;
public class numbergame
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        int lowerbound=1;
        int upperbound=100;
        int maxattempts=5;
        int score=0;
        System.out.println("Welcome! to Number game");
        System.out.println("you have "+maxattempts+" maximum attempts to guess the between  "+ lowerbound+" and  "+upperbound+".");
        boolean playagain;
        do{
            int numbertoguess=rand.nextInt(upperbound - lowerbound + 1 )+lowerbound;
            int attempts=0;
            while(attempts<maxattempts)
            {
                System.out.print("enter your guess:");
                int guess=sc.nextInt();
                attempts++;
                if(guess==numbertoguess)
                {
                    System.out.println("congrats you guess the number("+numbertoguess+") correctly in"+attempts+"attempts");
                    score++;
                    break;

                }
                else if(guess<numbertoguess)
                {
                    System.out.println("Too low! Try again. Attempts left: " + (maxattempts - attempts));
                }
                 else {
                    System.out.println("Too high! Try again. Attempts left: " + (maxattempts - attempts));
                }
            }
            if(attempts==maxattempts)
            {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + numbertoguess);
            }
            System.out.print("Do you want to play again(Y/N):");
            String playagainInput=sc.next().toLowerCase();
            playagain = playagainInput.equals("yes") || playagainInput.equals("y");
        }while (playagain);
        System.out.println("Game Over! Your final score: " + score);
        sc.close();
    }
}