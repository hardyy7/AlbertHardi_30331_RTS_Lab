import java.util.Arrays;
import java.util.Random;

public class Lab1ex3 {
    public static void main(String[] args) {

        int[] numbers = new int[10];

        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        Arrays.sort(numbers);

        System.out.println("Sorted random numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
