import javafx.scene.chart.PieChart;
import org.codehaus.groovy.antlr.treewalker.SourceCodeTraversal;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by sergey-mishin on 24.11.17.
 */
public class HelloWorld {

    private static int LOWERBOUND = -5;
    private static int UPPERBOUND = 5;

    public static void main(String[] args) {
        if (args.length < 1) {
            File file = new File("src/main/resources/data.txt");
            process_file(file.getAbsolutePath());
        } else {
            process_file(args[0]);
        }

    }

    static void process_file(String arg) {
        ArrayList<DataStruct> store = new ArrayList<DataStruct>();

        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(arg));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                store.add(new DataStruct(line, LOWERBOUND, UPPERBOUND));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.util.Collections.sort(store, new DataStructComparator());

        for (DataStruct item : store) {
            System.out.println(item.toString());
        }
    }
}

class DataStructComparator implements Comparator<DataStruct> {

    public int compare(DataStruct o1, DataStruct o2) {
        if (o1.getKey1() == o2.getKey1()) {
            if (o1.getKey2() == o2.getKey2()) {
                // compare str
                if (o1.getStr().length() < o2.getStr().length()) {
                    return -1;
                } else if (o1.getStr().length() == o2.getStr().length()) {
                    return 0;
                } else if (o1.getStr().length() > o2.getStr().length()) {
                    return 1;
                }
            } else {
                // compare k2
                if (o1.getKey2() < o2.getKey2()) {
                    return -1;
                } else if (o1.getKey2() == o2.getKey2()) {
                    return 0;
                } else if (o1.getKey2() > o2.getKey2()) {
                    return 1;
                }
            }
        } else {
            // compare k1
            if (o1.getKey1() < o2.getKey1()) {
                return -1;
            } else if (o1.getKey1() == o2.getKey1()) {
                return 0;
            } else if (o1.getKey1() > o2.getKey1()) {
                return 1;
            }
        }
        return 0; // unreachable?
    }
}

class DataStruct implements Comparable<DataStruct> {
    int key1;
    int key2;
    String str;

    DataStruct(String input) {
        String[] v = input.split(",");
        key1 = Integer.parseInt(v[0].trim());
        key2 = Integer.parseInt(v[1].trim());
        str = v[2];
    }

    DataStruct(String input, int lowerBound, int upperBound) throws Exception {
        if (lowerBound > upperBound) {
            throw new Exception();
        }

        String[] v = input.split(",");

        key1 = Integer.parseInt(v[0].trim());
        if ((key1 < lowerBound) || (key1 > upperBound)) {
            throw new Exception();
        }

        key2 = Integer.parseInt(v[1].trim());
        if ((key2 < lowerBound) || (key2 > upperBound)) {
            throw new Exception();
        }

        str = v[2];
        if (str.length() == 0) {
            throw new Exception();
        }
    }

    int getKey1() {
        return key1;
    }

    int getKey2() {
        return key2;
    }

    String getStr() {
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof DataStruct) {
            return (key1 == ((DataStruct) obj).getKey1())
                    && (key2 == ((DataStruct) obj).getKey2())
                    && (str.equals(((DataStruct) obj).getStr()));
        }
        return false;
    }

    public int compareTo(DataStruct o) {
        if (key1 == o.key1) {
            if (key2 == o.key2) {
                // compare str
                if (str.length() < o.str.length()) {
                    return -1;
                } else if (str.length() == o.str.length()) {
                    return 0;
                } else if (str.length() > o.str.length()) {
                    return 1;
                }
            } else {
                // compare k2
                if (key2 < o.key2) {
                    return -1;
                } else if (key2 == o.key2) {
                    return 0;
                } else if (key2 > o.key2) {
                    return 1;
                }
            }
        } else {
            // compare k1
            if (key1 < o.key1) {
                return -1;
            } else if (key1 == o.key1) {
                return 0;
            } else if (key1 > o.key1) {
                return 1;
            }
        }
        return 0; // unreachable?
    }

    public String toString() {
        return key1 + ", " + key2 + ", " + str;
    }
}