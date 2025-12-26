import java.util.Arrays;
import java.util.Collections;

public class ArraySortExample {

    public static void main(String[] args) {
        Integer[] numb={6,2,6,2,5};
        Arrays.sort(numb, Collections.reverseOrder());


        System.out.println(Arrays.toString(numb));
    }
}