package ru.mfti.koltunov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

abstract class FileWorker {
    public String Data;
    private String readFilePath;
    private String writeFilePath;

    public abstract void read();

    public abstract void write();

}

interface Action{
    String action();
}

class StreamData {

    @Autowired
    private FileWorker f;

    @Bean
    @Primary
    public FileWorker fileSetter() {
        return new FileWorker() {
            @Override
            public void read() {
                try (FileReader reader = new FileReader("ffff")){
                    int c;
                    while ((c = reader.read()) != -1) {
                        f.Data += (char) c;
                    }
                } catch (IOException ioException) {
                    System.out.println(ioException.getMessage());
                }
            }

            @Override
            public void write() {
                try (FileWriter writer = new FileWriter("ffff")){
                    writer.write(f.Data);
                    writer.flush();
                } catch (IOException ioException) {
                    System.out.println(ioException.getMessage());
                }
            }
        };
    }

    @Bean
    Action toUpper(FileWorker read) {
        return () -> read.Data.toUpperCase();
    }

    @Bean
    Action replace(Action toUpper) {
        return () -> toUpper.action().replace("A", "");
    }


    @Bean
    Action filter(Action replace) {
        return () -> {
            String[] arr = replace.action().split(" ");
            return Arrays.stream(arr)
                    .filter(x -> x.length() > 4)
                    .collect(Collectors.joining(" "));
        };
    }

    @Bean
    Action write(FileWorker fileWorker, Action filter) {
        return () -> {
            fileWorker.Data = filter.action();
            fileWorker.write();
            return "";
        };
    }
}
