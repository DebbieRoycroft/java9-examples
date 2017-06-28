import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FactoryForCollections {

    public static void main(String[] args){
        //Prior to Java9 there were multiple ways to initialise a list:

        //This is long-winded but does not require any additional objects created
        //Note the list is not immutable, and can accept null values
        List<String> initialisedWithAdd = new ArrayList<>();
        initialisedWithAdd.add("A");
        initialisedWithAdd.add("B");
        initialisedWithAdd.add("C");
        initialisedWithAdd.add(null);

        //Shorter version, but creates intermediate object
        List<String> initialisedFromArray = new ArrayList<>(Arrays.asList( new String[]{"A","B", "C", null}));
        initialisedFromArray.add("D");

        //Again, intermediate object is created by the double brace
        List<String> intialisedFromDoubleBrace = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
        }};
        intialisedFromDoubleBrace.add("D");

        List<String> initialisedFromStream = Stream.of("A","B","C", null).collect(Collectors.toList());
        initialisedFromStream.add("D");

        //Java 9 adds new factory for list
        //Note: the list is immutable, and won't accept null values
        List<String> initialisedFromNewFactory = List.of("A", "B", "C");
        try {
            initialisedFromNewFactory.add("D");
        } catch (UnsupportedOperationException e){
            System.out.println("Caught UnsupportedOperationException " + e);
        }

        //Similarly Map previously had to be initialised either like this, or with double brace
        HashMap<Integer, String> oldMap = new HashMap<>();
        oldMap.put(1, "One");
        oldMap.put(2, "Two");
        oldMap.put(3, "Three");
        Map<Integer, String> immutableMap = Collections.unmodifiableMap(oldMap);

        System.out.println("Map contents : " );
        immutableMap.forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v));

        //Now has a shorter version for up to 10 entries - again this is immutable and won't accept null
        Map<Integer, String> mapFromFactory = Map.of(1, "I", 2, "II", 3, "III", 4, "IV",
                5, "V", 6, "VI", 7, "VII" );

        System.out.println("Map contents : " );
        mapFromFactory.forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v));

        //For more than 10 entries use new Map.ofEntries
        Map<Integer, String> bigMapFromFactory = Map.ofEntries(
                Map.entry(1, "I"),
                Map.entry(2, "I"),
                Map.entry(3, "IIII"),
                Map.entry(4, "IV"),
                Map.entry(5, "V"),
                Map.entry(6, "VI"),
                Map.entry(7, "VII"),
                Map.entry(8, "VIII"),
                Map.entry(9, "IX"),
                Map.entry(10, "X"),
                Map.entry(11, "XI"),
                Map.entry(12, "XII")
        );

        System.out.println("Map contents : " );
        bigMapFromFactory.forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v));
    }
}
