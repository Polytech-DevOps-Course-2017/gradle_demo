import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by sasha on 07.12.17.
 */
public class FindMinTest {

    @Test
    public void FindMin1() {
        Integer known_min = -1;

        String args = "5 4 12 8 4 1 -1 8 222";
        ArrayList<Integer> list = FindMin.parse_input(args);
        Integer min = FindMin.doit(list);

        assert(min == known_min);

        System.out.println("Test done.");
    }
}
