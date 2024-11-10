import java.util.Random;
import java.util.Scanner;
/**
 * Name: Taliya Vallerstein
 * Introduction to Computer Science, Ariel University, Ex1 (manual Example + a Template for your solution)
 * See: https://docs.google.com/document/d/1C1BZmi_Qv6oRrL4T5oN9N2bBMFOHPzSI/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 *
 * Ex1 Bulls & Cows - Automatic solution.
 * **** Add a general readme text here ****
 * Add your explanation here:
 *Function that reveals a given code with 2-6 digits.
 *
 * **** General Solution (algorithm) ****
 * Add your explanation here:
 *I create an array of the range of all the guess options according to the numbers of digits of the code that defined.
 *Choose random number from tha array to be my code guess
 * I made my guess to an array
 * When I got the results of my guess from the game, I compared all of my guess options to my guess according to his results.
 * All of my irrelevant guess's return to be false and then return to be -1.
 * I went over my guess's options array and choose the first one that I find that isn't -1 (>0) to be my new guess.
 *I did the same process until I got the right code.
 * **** Results ****
 * Make sure to state the average required guesses
 * for 2,3,4,5,6 digit code:
 *
 * Average required guesses 2: 6.73
 * Average required guesses 3: 7.05
 * Average required guesses 4: 7.18
 * Average required guesses 5: 7.48
 * Average required guesses 6: 7.81
 *
 */
public class Ex1 {
    //    public static final String Title = "Ex1 demo: manual Bulls & Cows game";
//
    public static int tries = 0;
    public static final String Title = "Ex1 demo: auto Bulls & Cows game";

    public static void main(String[] args) {
        BP_Server game = new BP_Server();   // Starting the "game-server"
        long myID = 324866680L;             // Your ID should be written here
        int numOfDigits = 6;// Number of digits [2,6]
       game.startGame(myID, numOfDigits);
       autoEx1Game(game, numOfDigits);
        }
//        game.startGame(myID, numOfDigits);  // Starting a game
//        System.out.println(Title + " with code of " + numOfDigits + " digits");
//        manualEx1Game(game);
//        autoEx1Game(game, numOfDigits); // you should implement this function )and any additional required functions).

//
//    public static void manualEx1Game(BP_Server game) {
//        Scanner sc = new Scanner(System.in);
//        int ind = 1;      // Index of the guess
//        int numOfDigits = game.getNumOfDigits();
//        double max = Math.pow(10, numOfDigits);
//        while (game.isRunning()) {           // While the game is running (the code has not been found yet
//            System.out.println(ind + ") enter a guess: ");
//            int g = sc.nextInt();
//            if (g >= 0 && g < max) {
//                int[] guess = toArray(g, numOfDigits); // int to digit array
//                int[] res = game.play(guess); // Playing a round and getting the B,C
//                if (game.isRunning()) {     // While the game is running
//                    System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]); // Prints the Bulls [0], and the Cows [1]
//                    ind += 1;               // Increasing the index
//                }
//            } else {
//                System.out.println("ERR: wrong input, try again");
//            }
//        }
//        System.out.println(game.getStatus());
//    }


    /**
     * Simple parsing function that gets an int and returns an array of digits
     *
     * @param a    - a natural number (as a guess)
     * @param size - number of digits (to handle the 00 case).
     * @return an array of digits
     */
    public static int[] toArray(int a, int size) {
        int[] c = new int[size];
        for (int j = c.length - 1; j >= 0; j--) {
            c[j] = a % 10;
            a = a / 10;
        }
        return c;
    }

    /**
     * Both copyGuessArr and copyNumArr are function that get an array and copy it to a new array.
     */

    public static int[] copyGuessArr(int [] guessArr, int numOfDigits){
        int[] copyGuessArr = new int[numOfDigits];
        for(int i =0; i < numOfDigits; i = i+1){
            copyGuessArr[i] = guessArr[i];
        }
        return copyGuessArr;
    }

    public static int[] copyNumArr(int [] numArr, int numOfDigits){
        int[] copyNumArr = new int[numOfDigits];
        for(int i =0; i < numOfDigits; i = i+1){
            copyNumArr[i] = numArr[i];
        }
        return copyNumArr;
    }
    /**
     * checkNum function is function that check if the number it get is relevant for being a next guess.
     * If the number it get, has the same bulls & cows of the previous guess's bulls & cows, then the number is true.
     * else, the number is false.
     */
    public static boolean checkNum(int num, int[] guessArr, int[] res, int numOfDigits) {
        int[] numArr = toArray(num, numOfDigits);
        int[] copyGuess = copyGuessArr(guessArr, numOfDigits);
        int[] copyNum = copyNumArr(numArr, numOfDigits);
        int bulls = res[0];
        int C = res[1];

        // calculates numbers of bulls
        int bullsNum = 0;
        for (int i = 0; i < numOfDigits; i = i + 1) {
            if (copyGuess[i] == copyNum[i] && copyNum[i] >=0 && copyGuess[i] >= 0) {
                bullsNum = bullsNum + 1;
                copyGuess[i] = -1;
                copyNum[i] = -1;
            }
        }

        int CNum = 0;

        for (int i = 0; i < numOfDigits; i = i + 1) {
            for (int j = 0; j < numOfDigits; j = j + 1) {
                if (i != j) {
                    if (copyGuess[i] == copyNum[j] && copyNum[j] >=0 && copyGuess[i] >= 0) {
                        CNum = CNum + 1;
                        copyNum[j] = -1;
                        copyGuess[i] = -1;
                        break;
                    }
                }
            }
        }
        return bullsNum == res[0] && CNum == res[1];
    }

    /**
     * guessProcess function go over all the options of numbers according to the numOfDigits.
     * Sent them to another function for a check if the number is relevant for being next guess.
     * If the number is irrelevant = false the number tern to -1.
     */

    public static int[] guessProcess(int[] guessArr,  int[] res,  int[] numbers , int numOfDigits, int randomIndex) {
        for(int i = 0; i< numbers.length; i = i + 1) {
            if(numbers[i] != -1) {
                int num = numbers[i];
                boolean inGame = checkNum(num, guessArr, res, numOfDigits);
                if (inGame == false) {
                    numbers[i] = -1;
                }
            }
        }
        numbers[randomIndex] = -1;
      return  numbers;
    }
//////////////////////////////////////////////////

    
    public static void autoEx1Game(BP_Server game, int numOfDigits) {

        int arrPlace = (int)(Math.pow(10, numOfDigits));
        int[] numbers;
        numbers= new int[(int) arrPlace];
        for (int i = 0; i < arrPlace; i = i + 1) {
            numbers[i] = i;
        }
        Random guess = new Random();
        int randomIndex = guess.nextInt(arrPlace);
        int randomValue = numbers[randomIndex];
        int[] guessArr = toArray(randomValue, numOfDigits);
        int[] res = game.play(guessArr);


        tries =  1 ;
        numbers = guessProcess(guessArr,  res ,numbers ,numOfDigits, randomIndex);
        int newGuess = -1;
        int newGuessIndex = -1;
       while (game.isRunning()) {
           for (int i = 0; i< arrPlace; i = i + 1) {
               if (numbers[i] >= 0) {
                       newGuess = numbers[i];
                       newGuessIndex = i;
                       break;
               }
           }

           guessArr = toArray(newGuess, numOfDigits);
           res = game.play(guessArr);
           numbers = guessProcess(guessArr,  res ,numbers ,numOfDigits, newGuessIndex);
           tries = tries + 1;
       }

        }
    }



