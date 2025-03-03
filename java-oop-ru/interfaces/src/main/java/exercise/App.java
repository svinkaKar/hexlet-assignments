package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static List<String> buildApartmentsList(List<Home> houses, int count){

        return houses.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(count)
                .map(Home::toString)
                .toList();
    }
}

// END
