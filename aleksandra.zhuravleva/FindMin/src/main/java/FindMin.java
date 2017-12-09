import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by sasha on 07.12.17.
 */
public class FindMin {
    public static ArrayList<Integer> parse_input(String app_args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] parts = app_args.split(" ");
        for (String part : parts) {
            Integer a = Integer.parseInt(part.trim());
            list.add(a);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        String joined = String.join(" ", list); // "foo and bar and baz"
        ArrayList<Integer> integers = parse_input(joined);

        Integer min = doit(integers);

        System.out.println("Minimum found: " + min);
    }

    public static Integer doit(ArrayList<Integer> integers) {
        Integer min = integers.get(0);

        for (int i : integers) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }
}
