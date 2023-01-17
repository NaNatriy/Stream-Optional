import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
//
        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 4, 6, 34, 23, 54);
        findMinMax(list.stream(), (x, y) -> {
            return x.compareTo(y);
        }, (x, y) -> System.out.println("Min = " + x + " Max = " + y));

    }


}