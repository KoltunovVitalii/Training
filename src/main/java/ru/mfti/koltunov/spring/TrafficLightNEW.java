package ru.mfti.koltunov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLightNEW {

    @Autowired
    @Qualifier("black")
    Color off;
    @Autowired
    @Qualifier("red")
    Color on;
    Color cur = off;

    @PostConstruct
    public void init(){
        cur = off;
    }


    public void on() {
        cur = on;
    }

    public void off() {
        cur = off;
    }

    public void next() {
        cur = (Color) cur.next();
        System.out.println(cur);
    }
}

@Component
@Qualifier("red")
class RedColor implements Color {

    @Autowired
    @Qualifier("redyellow")
    Color next;
    @Override
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "Red";
    }
}

@Component
@Qualifier("green")
class GreenColor implements Color {
    @Autowired
    @Qualifier("greenyellow")
    Color next;

    @Override
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "Green";
    }
}

@Component
@Qualifier("redyellow")
class RedYellowColor implements Color {
    @Autowired
    @Qualifier("green")
    Color next;

    @Override
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}

@Component
@Qualifier("greenyellow")
class GreenYellowColor implements Color {
    @Autowired
    @Qualifier("red")
    Color next;

    @Override
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}


@Component
@Qualifier("black")
class BlackColor implements Color {
    @Override
    public Color next() {
        return this;
    }
    @Override
    public String toString() {
        return "Black";
    }
}

interface Color{
    Color next();
};

