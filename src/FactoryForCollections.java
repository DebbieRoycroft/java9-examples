import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by user on 14/05/2017.
 */
public class FactoryForCollections {

    public static void main(String[] args){

        List<String> initialisedWithAdd = new ArrayList<>();
        initialisedWithAdd.add("A");
        initialisedWithAdd.add("B");
        initialisedWithAdd.add("C");
        initialisedWithAdd.add(null);

        List<String> initialisedFromArray = new ArrayList<>(Arrays.asList( new String[]{"A","B", "C", null}));

        List<String> initialisedFromStream = Stream.of("A","B","C", null).collect(Collectors.toList());

        List<String> initialisedFromNewFactory = List.of("A", "B", "C");

        initialisedWithAdd.add("D");
        List<String> unmodifiable = Collections.unmodifiableList(initialisedWithAdd);

        initialisedFromArray.add("D");
        initialisedFromStream.add("D");
        try {
            initialisedFromNewFactory.add("D");
        } catch (UnsupportedOperationException e){
            System.out.println("Caught UnsupportedOperationException " + e);
        }
        List<String> mutable = new ArrayList<>(initialisedFromNewFactory);
        mutable.add("D");


        HashMap<Integer, String> oldMap = new HashMap<>();
        oldMap.put(1, "One");
        oldMap.put(2, "Two");
        oldMap.put(3, "Three");

        Map<Integer, String> immutableMap = Collections.unmodifiableMap(oldMap);

        System.out.println("Map contents : " );
        immutableMap.forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v));

        Map<Integer, String> mapFromFactory = Map.of(1, "I", 2, "II", 3, "III", 4, "IV", 5, "V", 6, "VI", 7, "VII" );

        System.out.println("Map contents : " );
        mapFromFactory.forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v));

    }
}
