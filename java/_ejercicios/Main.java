import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main
 */



public class Main {

    public static int add(int x, int n) {
        if (n == 0) {
            return x;
        }
        else {
            int tmp= 1 + add(x, n-1);
            return tmp; // Apply add function recursively
        }
    }

    public static void main(String[] args) {

        System.out.println(add(15,10));
    }
}