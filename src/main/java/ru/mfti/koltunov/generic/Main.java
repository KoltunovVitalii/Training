package ru.mfti.koltunov.generic;

import ru.mfti.koltunov.figures.Point2D;
import ru.mfti.koltunov.figures.Point3D;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setObject(3);
        print(box);


        NotNull<Integer> notNull = new NotNull<>(null);
        print(notNull.getObject(0));
        NotNull<Integer> notNull1 = new NotNull<>(99);
        print(notNull1.getObject(-1));
        NotNull<String> notNull2 = new NotNull<>(null);
        print(notNull2.getObject("default"));
        NotNull<String> notNull3 = new NotNull<>("hello");
        print(notNull3.getObject("hello world"));

        Student student1 = new Student("Иван", new Integer[]{5, 3, 3, 4});
        Student student2 = new Student("Иван", new Integer[]{5, 5, 3, 4});
        System.out.println(student1.compareTo(student2));

        List<Integer> list1 = function(List.of("qwerty", "asdfg", "zx"), String::length);
        System.out.println(list1);

        List<Integer> list2 = function(List.of(1, -3 , 7), Math::abs);
        System.out.println(list2);

        List<Integer> list3 = function(List.of(new Integer[]{1, 5, 8}, new Integer[]{4, 5, 9}, new Integer[]{4, 5, 10}),
                x -> Collections.max(Arrays.asList(x)));
        System.out.println(list3);

        List<String> stringList = filter(List.of("qwerty", "asdfg", "zx"), x -> x.length() >= 3);
        System.out.println(stringList);

        List<Integer> integerList = filter(List.of(1, -3, 7), x -> x > 0);
        System.out.println(integerList);

        List<Integer[]> integers = filter(List.of(new Integer[]{-1, -5, -8}, new Integer[]{-4, -5, -9}, new Integer[]{4, 5, 10}),
                x -> Collections.max(Arrays.asList(x)) < 0);
        System.out.println(Arrays.deepToString(integers.toArray()));

        String str1 = reduce(List.of("qwerty", "asdfg", "zx"), (x, y) -> x + y, "что-то");
        System.out.println(str1);

        Integer integer = reduce(List.of(1, -3, 7), Integer::sum, -1);
        System.out.println(integer);

        List<Integer[]> list = List.of(new Integer[]{1, 5, 8}, new Integer[]{4, 5, 9}, new Integer[]{4, 5, 10});
        Integer result = reduce(function(list, x -> x.length), Integer::sum, 0);
        System.out.println(result);







    }

    public static <T> void print(T t) {
        System.out.println(t);
    }
    //5.2.1.
    public <T extends Point2D> void moveTo10(Line<T> line) throws CloneNotSupportedException {
        T start = line.getStart();
        start.setX(start.getX() + 10);

        T end = line.getEnd();
        end.setX(end.getX() + 10);

        line.setStart(start);
        line.setEnd(end);
    }

    //5.2.2.
    public static <T extends Number> double maxOfNotNullList(List<NotNull<T>> notNullList) {
        if (notNullList.size() == 0) {
            return Double.MAX_VALUE;
        }
        double max = notNullList.get(0).getObject(null).doubleValue();
        for (NotNull<T> tNotNull : notNullList) {
            max = Math.max(max, tNotNull.getObject(null).doubleValue());
        }
        return max;
    }

    //5.2.3.
    public static <T> void putPoint3D(Box<? super Point3D> box, Point3D point3D) {
        box.setObject(point3D);
    }


    //5.2.4.
    public static void fillList(List<? super Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    //5.3.1.

    public static <T, P> List<P> function(List<T> tList, Function<T, P> tpFunction) {
        List<P> res = new ArrayList<>();
        for (T t : tList) {
            res.add(tpFunction.apply(t));
        }
        return res;
    }

    //5.3.2.

    public static <T> List<T> filter(List<T> tList, Predicate<T> tPredicate) {
        List<T> res = new ArrayList<>();
        for (T t : tList) {
            if (tPredicate.test(t)) {
                res.add(t);
            }
        }
        return res;
    }

    //5.3.3
    public static <T> T reduce(List<T> tList, BiFunction<T, T, T> tFunction, T alter) {
        if (tList == null || tList.size() == 0) {
            return alter;
        }
        T t = tList.get(0);
        for (int i = 1; i < tList.size(); i++) {
            t = tFunction.apply(t, tList.get(i));
        }
        return t;
    }
    //5.3.4

    public static <T, P extends Collection> P collecting(List<T> tList, Supplier<P> supplier, BiConsumer<P, T> consumer) {
        P result = supplier.get();
        for (T t : tList) {
            consumer.accept(result, t);
        }
        return result;
    }
}
