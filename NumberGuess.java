import java.util.*;

class NumberGuess{
    public static void main(String args[]){
       start();
       
    }

    public static void start(){
        Scanner sc = new Scanner(System.in);
       Random rand = new Random();
       HashMap<Integer,Integer> max_chances = new HashMap<>();
       int n = rand.nextInt(100)+1;
       max_chances.put(1,10);
       max_chances.put(2,5);
       max_chances.put(3,3);
       System.out.println("Welcome to the Number Guessing Game!\nI'm thinking of a number between 1 and 100\nI challenge you to guess the number within the given no.of chances");
       System.out.println();
       System.out.println("Please select the difficulty level:\n 1. Easy (10 chances)\n 2. Medium (5 chances)\n 3. Hard (3 chances)");
       System.out.println();
       System.out.print("Enter your choice (1-Easy, 2-Medium, 3-Hard): ");
       String[] dif_levels = {"Easy","Medium","Hard"};
       int choice_no = sc.nextInt();
       System.out.println();
       
       System.out.println("Great! You have selected the "+dif_levels[choice_no-1]+" level.\nLet's start the game!");
       guess(choice_no,n,max_chances.get(choice_no));
    }

    public static void guess(int c,int n,int max_guess){
        Scanner sc = new Scanner(System.in);
        int x = max_guess;
        while(max_guess>0){
            System.out.println();
            System.out.print("Enter your guess: ");
            int g = sc.nextInt();
            if(g==n){
                System.out.println("Congratulations! You guessed the correct number in "+(x-max_guess+1)+" attempts.");
                break;
            }else if(g<n){
                System.out.println("Incorrect! The number is greater than "+g);
            }else{
                System.out.println("Incorrect! The number is less than "+g);
            }
            max_guess--;
        }
        System.out.println();
        if(max_guess==0){
            System.out.println("You have finished the max attempts.");
            System.out.println("The correct answer is "+n+"\nBetter luck next time!");
            System.out.println();
        }
        System.out.println("Type 'q' to quit or 'y' to play again");
        char a = sc.next().charAt(0);
        if(a=='q') return;
        else start();
    }
}