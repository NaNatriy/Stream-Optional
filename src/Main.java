import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }
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

    public static void task1(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 4, 6, 34, 23, 54);
        findMinMax(list.stream(), (x, y) -> {
            return x.compareTo(y);
        }, (x, y) -> System.out.println("Min = " + x + " Max = " + y));
    }

    public static void task2(){
        List<Integer> numList = new ArrayList<>();
        Collections.addAll(numList, 3,45,6,7,89,64,32,67,8,5,67,32);
        System.out.println(numList.stream().filter(integer -> integer % 2 == 0).count());
    }
}