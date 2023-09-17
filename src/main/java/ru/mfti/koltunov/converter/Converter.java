package ru.mfti.koltunov.converter;

import java.util.function.BiConsumer;
import java.util.function.Function;

class Converter {
    private Function<String, String> read;
    private Function<String, String> convert;
    private BiConsumer<String, String> save;

    public Converter(Function<String, String> read, Function<String, String> convert, BiConsumer<String, String> save) {
        this.read = read;
        this.convert = convert;
        this.save = save;
    }

    public final void converting(String s, String ns){
        String data = read.apply(s);
        String convertData = convert.apply(data);
        save.accept(convertData, ns);
    }
}
