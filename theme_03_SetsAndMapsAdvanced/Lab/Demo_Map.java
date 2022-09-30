package theme_03_SetsAndMapsAdvanced.Lab;

import java.util.*;

public class Demo_Map {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> map = new HashMap<>();

        //3 ways to iterate a map

        //1) Iterate the keys
        Set<Integer> integers = map.keySet();

        //2) Iterate keys and values
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        //3) Iterate values (don't use unless needed)
        Collection<String> values = map.values();
    }
}
