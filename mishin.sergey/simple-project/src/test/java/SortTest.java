import javafx.scene.chart.PieChart;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

/**
 * Created by sergey-mishin on 24.11.17.
 */
public class SortTest {

    @Test
    public void sortTwoThings() throws Exception {
        int lower = -5;
        int upper = 5;

        String input1 = "4, -3,  fdxofggmyme";
        DataStruct ds1 = new DataStruct(input1, lower, upper);

        String input2 = "3, 1,  cfnfldkrlvsroqrdzplrfkuo";
        DataStruct ds2 = new DataStruct(input2, lower, upper);

        ArrayList<DataStruct> store = new ArrayList<>();

        store.add(ds1);
        store.add(ds1);
        store.add(ds2);

        java.util.Collections.sort(store, new DataStructComparator());

        ArrayList<DataStruct> sorted = new ArrayList<>();

        sorted.add(ds2);
        sorted.add(ds1);
        sorted.add(ds1);

        for (int i = 0; i < store.size(); ++i) {
            assert(store.get(i).equals(sorted.get(i)));
        }

        System.out.println("Success.");
    }
}
