package ru.mfti.koltunov;

import java.util.ArrayList;
import java.util.function.*;
import java.util.List;

public class Lesson16 {
    public static void main(String[] args) {
        Predicate<Integer> rule = x->x>=0&&x<=100;
        Supplier<String> stringSupplier = ()->"Hello world";
        BinaryOperator<Integer> binaryOperator = (x,y)->x+y;
        Function<String, Integer> integerFunction = x->Integer.parseInt(x);
        Consumer<String> consumer = x-> System.out.println(x);
        System.out.println(
                filter(List.of(4,5,6,7,8,9), x->x%2==0)
        );
        int x = reduce(List.of(1, 2, 3, 4, 5), binaryOperator).getObj(0);
        System.out.println(x);

    }

    class DataStream<T> {
        private List<T> list;

        public DataStream(Object lst) {
        }

        private void dataStream(T...list) {
            this.list = new ArrayList<>(list.length);
            for (T t:list) {
                this.list.add(t);
            }
        }
        public DataStream(List<T> list) {
            this.list = list;
        }
        public <T> DataStream<T> of(T...lst) {
            return new DataStream<>(lst);
        }
        public <P> DataStream<P> function(Function<T, P> tpFunction) {
            List<P> res = new ArrayList<>();
            for (T t:list) {
                res.add(tpFunction.apply(t));
            }
            list = (List<T>) res;
            return (DataStream<P>) this;
        }
    }

    public static <T> List<T> filter(List<T> l, Predicate<T> rule) {
        List<T> lstT = new ArrayList<T>(l.size());
        for (T t:l) {
            if (rule.test(t))lstT.add(t);
        }
        return lstT;
    }

    public static <T> Holder<T> reduce(List<T> lst, BinaryOperator<T> op) {
        if(lst.size() < 1){
            return new Holder<>(null);
        }
        T res = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            res = op.apply(res, lst.get(i));
        }
        return new Holder<>(res);
    }

    static class Holder<T> {
        private T obj;

        public Holder(T obj) {
            this.obj = obj;
        }

        public T getObj(T t){
            if (obj != null) {
                return obj;
            }
            return t;
        }

    }
}
