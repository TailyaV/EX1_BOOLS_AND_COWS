import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Name: Taliya Vollerstein
 * ID: 324866680
 */

public class Ex1Test {
    @Test
    public void guessProcessTest  () {
        int[] guessArr = {3, 2};
        int[] res = {1, 0};
        int[] numbers = {1, 5, 95, 8, 23, 35, 78, 41, 99, 92, 32};
        int numOfDigits = 2;
        int randomValue = 2;
        int[] nt = Ex1.guessProcess(guessArr, res, numbers, numOfDigits, randomValue);

        if (numbers[5] == -1 || numbers[9] == -1) {
            fail("error");
        }
    }

    @Test
    public void checkNumTest (){
        int num = 1222;
        int[] guessArr = {2,2,2,4};
        int[] res = {2,1};
        int numOfDigits = 4;
        boolean ens = Ex1.checkNum(num, guessArr, res, numOfDigits);
        assertTrue(ens);
    }

    @Test
    public void copyGuessArrTest (){
        int [] guessArr = {3,2};
        int numOfDigits = 2;
        int [] ans = Ex1.copyGuessArr(guessArr, numOfDigits);
        assertArrayEquals(guessArr, ans);
    }

    @Test
    public void copynumArrTest (){
        int [] numArr = {3,2};
        int numOfDigits = 2;
        int [] ans = Ex1.copyGuessArr(numArr, numOfDigits);
        assertArrayEquals(numArr, ans);
    }

        @Test
        public void gameTest2 () {
            BP_Server game = new BP_Server();
            long myID = 324866680L;
            int numOfDigits = 2;
            double sum = 0;
            int size = 100;
            for (int i = 0; i < size; i = i + 1) {
                game.startGame(myID, numOfDigits);
                Ex1.autoEx1Game(game, numOfDigits);
                System.out.println(i);
                sum = sum + Ex1.tries;
            }
            double avg = sum / size;
            System.out.println("Your avg is: " + avg);
        }

    @Test
    public void gameTest3 () {
        BP_Server game = new BP_Server();
        long myID = 324866680L;
        int numOfDigits = 3;
        double sum = 0;
        int size = 100;
        for (int i = 0; i < size; i = i + 1) {
            game.startGame(myID, numOfDigits);
            Ex1.autoEx1Game(game, numOfDigits);
            System.out.println(i);
            sum = sum + Ex1.tries;
        }
        double avg = sum / size;
        System.out.println("Your avg is: " + avg);
    }

    @Test
    public void gameTest4 () {
        BP_Server game = new BP_Server();
        long myID = 324866680L;
        int numOfDigits = 4;
        double sum = 0;
        int size = 100;
        for (int i = 0; i < size; i = i + 1) {
            game.startGame(myID, numOfDigits);
            Ex1.autoEx1Game(game, numOfDigits);
            System.out.println(i);
            sum = sum + Ex1.tries;
        }
        double avg = sum / size;
        System.out.println("Your avg is: " + avg);
    }

    @Test
    public void gameTest5 () {
        BP_Server game = new BP_Server();
        long myID = 324866680L;
        int numOfDigits = 5;
        double sum = 0;
        int size = 100;
        for (int i = 0; i < size; i = i + 1) {
            game.startGame(myID, numOfDigits);
            Ex1.autoEx1Game(game, numOfDigits);
            System.out.println(i);
            sum = sum + Ex1.tries;
        }
        double avg = sum / size;
        System.out.println("Your avg is: " + avg);
    }

    @Test
    public void gameTest6 () {
        BP_Server game = new BP_Server();
        long myID = 324866680L;
        int numOfDigits = 6;
        double sum = 0;
        int size = 100;
        for (int i = 0; i < size; i = i + 1) {
            game.startGame(myID, numOfDigits);
            Ex1.autoEx1Game(game, numOfDigits);
            System.out.println(i);
            sum = sum + Ex1.tries;
        }
        double avg = sum / size;
        System.out.println("Your avg is: " + avg);
        }

        @Test
        public void gameAvgTest(){
            double allAvg = 0;
            for (int i = 2; i < 7;i = i + 1 ){
                BP_Server game = new BP_Server();
                long myID = 324866680L;
                int numOfDigits = i;
                double sum = 0;
                int size = 100;
                for (int j = 0; j < size; j = j + 1) {
                    game.startGame(myID, numOfDigits);
                    Ex1.autoEx1Game(game, numOfDigits);
                    System.out.println(j);
                    sum = sum + Ex1.tries;
                }
                double avg = sum / size;
                System.out.println("Your avg of" + i + "digits code, is: " + avg);
                allAvg = allAvg + avg;
            }
            double avgSum = allAvg/5;
            System.out.println("Your all games average is:" + avgSum);
        }

}






