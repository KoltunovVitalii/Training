package ru.mfti.koltunov.main;

import ru.mfti.koltunov.Fraction;
import ru.mfti.koltunov.House;
import ru.mfti.koltunov.generic.Line;
import ru.mfti.koltunov.generic.Student;
import ru.mfti.koltunov.Time;
import ru.mfti.koltunov.birds.Birds;
import ru.mfti.koltunov.birds.Cuckoo;
import ru.mfti.koltunov.birds.Parrot;
import ru.mfti.koltunov.birds.Sparrow;
import ru.mfti.koltunov.catAndDog.Cat;
import ru.mfti.koltunov.catAndDog.HouseCat;
import ru.mfti.koltunov.catAndDog.Meowing;
import ru.mfti.koltunov.figures.*;
import ru.mfti.koltunov.human.Man;
import ru.mfti.koltunov.human.Name;
import ru.mfti.koltunov.weapon.Gun;
import ru.mfti.koltunov.weapon.MachineGun;
import ru.mfti.koltunov.weapon.Shooter;

import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        //Точки по заданию 1.1.1.
        Point2D p = new Point2D(34, 45);
        Point2D p1 = new Point2D(45, 52);
        Point2D p2 = new Point2D(67, 65);

//        System.out.println(p + " " + p1 + " " + p2);


        //ФИО по заданию 1.1.3.
        Name n = new Name("", "Клеопатра", "");
        Name n1 = new Name("Пушкин", "Александр", "Сергеевич");
        Name n2 = new Name("Маяковский", "Владимир", "");
//        System.out.println(n);
//        System.out.println(n1);
//        System.out.println(n2);

        //Люди по заданию 1.1.2. + Задание 1.2.2.
//        Man m = new Man(n, 152, null);
//        Man m1 = new Man(n1, 167, null);
//        Man m2 = new Man(n2, 189, null);
//        System.out.println(m + " " + m1 + " " + m2);

        //Задание 1.2.3.
        Name name = new Name("Чудов", "Иван", "");
        Name name1 = new Name("Чудов", "Петр", "");
        Name name2 = new Name("", "Борис", "");
//        Man man = new Man(name, null, null);
//        Man man1 = new Man(name1, null, man);
//        Man man2 = new Man(name2, null, man1);

//        System.out.println(man);
//        System.out.println(man1);
//        System.out.println(man2);


        //Время по заданию 1.1.4.
        Time time = new Time(10);
        Time time1 = new Time(10000);
        Time time2 = new Time(100000);

//        System.out.println(time);
//        System.out.println(time1);
//        System.out.println(time2);

        //Дом по заданию 1.1.5.
        House h = new House(1);
        House h1 = new House(5);
        House h2 = new House(23);

//        System.out.println(h);
//        System.out.println(h1);
//        System.out.println(h2);

        //Линия по заданию 1.2.1
        Point2D p3 = new Point2D(1, 3);
        Point2D p4 = new Point2D(23, 8);
        Point2D p5 = new Point2D(5, 10);
        Point2D p6 = new Point2D(25, 10);
        Line line1 = new Line(p3, p4);
        Line line2 = new Line(p5, p6);
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        p3.setX(2);
        p3.setY(5);
        p6.setX(20);
        p6.setY(20);

        //Сотрудники и отделы 1.2.4.
//        Department department = new Department("IT", null);
//        Employees employees = new Employees("Петров", department);
//        Employees employees1 = new Employees("Козлов", department);
//        Employees employees2 = new Employees("Сидоров", department);
//        department.head = employees1;
//        System.out.println(employees);
//        System.out.println(employees1);
//        System.out.println(employees2);
//        System.out.println(employees1.dept.employees);

        //Студенты по заданию 1.3.1.

        Student student = new Student("A");
        Integer[] grade = new Integer[]{5, 4, 5};
//        Student student1 = new Student("Петя", grade);
//        Student student2 = new Student("Андрей", grade);
        grade = new Integer[]{2, 2, 2};
        //изменение васи не влияет на Андрея
//        System.out.println(student);
//        System.out.println(student1);
//        System.out.println(student2);
        //не совсем понял что значит "Объяснить результат". Меняя оценки у Петра я меняю весь массив, создавая новый
        // он никак не связан с массивом Васи
        // и даже поменяв масив Васи это не отразится на Пете или Андрее, если мы меняем после присвоения


        //Ломаная из задачи 1.3.2.

        Point2D point2D = new Point2D(1, 5);
        Point2D point2D1 = new Point2D(2, 8);
        Point2D point2D2 = new Point2D(5, 3);
        Point2D point2D3 = new Point2D(2, -5);
        Point2D point2D4 = new Point2D(4, -8);
        BrokenLine bL = new BrokenLine(new Point2D[]{point2D, point2D1, point2D2});
        BrokenLine bL1 = new BrokenLine(new Point2D[]{point2D, point2D3, point2D4, point2D2});
        point2D.setX(2);
        point2D.setY(7);


        // Города

        //1.4.1.
        Point2D point2D5 = new Point2D(3, 5);
        Point2D point2D6 = new Point2D(25, 6);
        Point2D point2D7 = new Point2D(7, 8);

        //1.4.2.
        Line line4 = new Line(new Point2D(1, 5), new Point2D(5, 4));
        Line line5 = new Line(new Point3D(5, 5, 5), new Point3D(1, 2, 3));
        Line line6 = new Line(line4.getStart(), line2.getEnd());

        //1.4.3.
        House house = new House(2);
        House house1 = new House(35);
        House house2 = new House(91);
        //house.floor = 5; подсвечивает ошибку и предлагает сделать floor not final

        //1.4.4.
        Time time3 = new Time(10000);
//        System.out.println(time3);
//        System.out.println(time4);

        //1.4.5.
//        Name name3 = new Name("Клеопатра");
//        Name name4 = new Name("Пушкин", "Александр", "Сергеевич");
//        Name name5 = new Name("Маяковский", "Владимир");
//        Name name6 = new Name("Бонифатьевич", "Христофор");
//        System.out.println(name3);
//        System.out.println(name4);
//        System.out.println(name5);
//        System.out.println(name6);

        //1.4.6.
        Man man3 = new Man("Лев", 170);
        Name name7 = new Name("Пушкин", "Сергей");
        Man man4 = new Man(name7, 168, man3);
        Man man5 = new Man("Александр", 167, man4);

        //1.4.7.
//        Student student3 = new Student("Вася", new Integer[]{3, 4, 5});
//        Student student4 = new Student("Максим");
//        System.out.println(student3);
//        System.out.println(student4);

        //1.5.1.
        Gun gun = new Gun(5, 5);
        Gun gun1 = new Gun(3, 5);
//        gun1.shot(5);

        //1.5.2.
        Cat cat = new Cat("Барсик");
//        cat.meow();
//        cat.meow(5);

        //1.5.3.
        Point2D point2D8 = new Point2D(1, 1);
        Point2D point2D9 = new Point2D(10, 15);
        Line line = new Line(point2D8, point2D9);
//        System.out.println(line.distance());

        //1.5.4.
//        System.out.println(time.wat(34056));
//        System.out.println(time.min(4532));
//        System.out.println(time.sec(123));
        //1.5.5.
        Fraction fraction = new Fraction(1, 3);
        Fraction fraction1 = new Fraction(2, 5);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction fraction3 = new Fraction(4, 5);
        Fraction f_sum = fraction.sum(fraction1);
        Fraction f_sub = fraction.sub(fraction1);
        Fraction f_mul = fraction.mul(fraction1);
        Fraction f_div = fraction.div(fraction1);
//        System.out.println(f_sum);
//        System.out.println(f_sub);
//        System.out.println(f_mul);
//        System.out.println(f_div);
//        Fraction f = fraction.sum(fraction1).div(fraction2).sub(fraction3);
//        System.out.println(f);


        //1.5.6.
//        Student st = new Student("Вася", new Integer[]{3, 4, 5, 5});
//        Student st1 = new Student("Петя", new Integer[]{5, 5, 5, 5});
//        int ave = st.average();
//        int ave1 = st1.average();
//        System.out.println(ave);
//        System.out.println(ave1);
//        System.out.println(st.otl());
//        System.out.println(st1.otl());

        //1.5.7.
//        Point2D point2D = new Point2D(1, 5);
//        Point2D point2D1 = new Point2D(2, 8);
//        Point2D point2D2 = new Point2D(5, 3);
//        Point2D point2D3 = new Point2D(2, -5);
//        Point2D point2D4 = new Point2D(4, -8);
//        BrokenLine bL = new BrokenLine(new Point2D[]{point2D, point2D1, point2D2});
//        BrokenLine bL1 = new BrokenLine(new Point2D[]{point2D, point2D3, point2D4, point2D2});

//        Point2D[] point2DS = bL.append(new Point2D[]{point2D1});
//        BrokenLine bL2 = new BrokenLine(point2DS);
////        System.out.println(bL2);
//        Point2D[] points1 = bL2.append(new Point2D[]{point2D, point2D2, point2D3});
//        BrokenLine bL3 = new BrokenLine(points1);
//        System.out.println(bL3);

        //1.5.8.
        Square square = new Square(point2D, 23);
        BrokenLine brokenLine = square.squareToBroken();
        brokenLine.point2D[3].setX(15);
        brokenLine.point2D[3].setY(25);


        //1.6.1.
//        House house3 = new House(0);
        // Exception in thread "main" java.lang.IllegalArgumentException: этажей меньше 1!
//        house3.setFloor(4);
        // Exception in thread "main" java.lang.IllegalArgumentException: этажей меньше 1!

        //1.6.2
        Time time5 = new Time(-350000);
//        System.out.println(time5);

        //1.6.3.
//        Square square = new Square(5, 3, 23);
//        BrokenLine brokenLine = square.squareToBroken();
        square.setSideLength(20);
//        System.out.println(square.squareToBroken());
//        System.out.println(square.getSideLength());
        // или так
        int x = square.getSideLength();
//        System.out.println(x);

        //1.6.4.
//        Fraction fraction4 = new Fraction(5, 0);
        //Exception in thread "main" java.lang.IllegalArgumentException: Знаменатель не может быть <= 0!
        Fraction fraction5 = new Fraction(5, 3);
        int numerator = fraction5.getNumerator();
        int denominator = fraction5.getDenominator();
//        System.out.println(numerator + "/" + denominator);

        //1.6.5.
        Gun gun2 = new Gun(4, 5);
//        gun2.recharge(3);
//        gun2.shot(5);
//        gun2.recharge(8);
//        gun2.shot(2);
//        gun2.discharge();
//        gun2.shot(1);

        //1.6.6.

        //1.6.7.

        //1.6.8.
//        Man man6 = new Man(name, 510);
        //Exception in thread "main" java.lang.IllegalArgumentException: Рост не может быть > 500
//        Man man7 = new Man(name, -10);
        //Exception in thread "main" java.lang.IllegalArgumentException: Рост не может быть отрицательным
        man3.getFather();
        //a сета нет

        //1.6.9.
//        Integer[] grade1 = new Integer[] {3,1,5,4};
//        Student student5 = new Student("Иванов", grade1);
//        Student student5 = new Student("Иванов", new Integer[]{1, 3, 5});
//        Exception in thread "main" java.lang.IllegalArgumentException: Оценка не в диапазоне 2 - 5
//        Student student6 = new Student("Иванов", new Integer[]{3, 3, 5});
        //а тут всё хорошо

        //1.6.10

        //1.6.11.
//        Department department = new Department("IT", null);
//        Employees employees = new Employees("Петров", department);
//        Employees employees1 = new Employees("Козлов", department);
//        Employees employees2 = new Employees("Сидоров", department);
//        Department department1 = new Department("Dep", employees);
//        Exception in thread "main" java.lang.IllegalArgumentException: Не является сотрудником отдела

        //3.1.4
//        MachineGun machineGun = new MachineGun(30, 30, 30);
//        machineGun.shot(2);
//        machineGun.shotTime(5);

        //3.2.1
//        Gun gun3 = new Gun(5, 10);
//        gun3.shot();

        //3.2.3.

//        Cuckoo cuckoo = new Cuckoo();
//        cuckoo.song();
//        Parrot parrot = new Parrot("Шаланды полные кефали");
//        parrot.song();

        //3.2.4.

//        Square square1 = new Square(new Point2D(5, 5), 25);
//        System.out.println(square1.area());

        Triangle triangle = new Triangle(new Point2D(5, -5), new Point2D(-5, 5), new Point2D(5, 10));
//        System.out.println(triangle.area());

        //3.2.5.

//        Point point = new Point(new Point(3, 0), new Point2D(0,0), new Point3D(0, 0, 0), new Time(0),
//                new ColorOne("Красная"));
//        System.out.println(point);

        //3.3.1
        numerator = 2;
        denominator = 5;
        Number x1 = 2;
        Fraction fraction4 = new Fraction(numerator, denominator);
        Number x3 = 2.3;
//        System.out.println(sum(new Number[]{x1,fraction4,x3}));

        Number y1 = 3.6;
        Fraction fraction6 = new Fraction(49, 12);
        Number y2 = 3;
        Fraction fraction7 = new Fraction(3, 2);
//        System.out.println(sum(new Number[]{y1, fraction6, y2, fraction7}));

        Fraction fraction8 = new Fraction(1, 3);
        Number z1 = 1;
//        System.out.println(sum(new Number[]{fraction8, z1}));

        //3.3.2.
        Cuckoo cuckoo = new Cuckoo();
        Parrot parrot =new Parrot("kkdjdjdjd");
        Sparrow sparrow = new Sparrow();
        Birds[] birds = new Birds[]{cuckoo, parrot, sparrow};
//        chirik(birds);

        //3.3.3.
        Square square1 = new Square(new Point2D(5, 5), 23);
        Circle circle = new Circle(new Point2D(15,15), 15);
        Rectangle rectangle = new Rectangle(new Point2D(25,25), 15, 25);
        Figures[] figures = new Figures[]{square1, circle, rectangle};
//        System.out.println(sumArea(figures));

        //3.3.4.
        Cat cat1 = new Cat("Myau");
        Cat cat2 = new Cat("Myauuuu");
        Cat cat3 = new Cat("Myaaaaaau");
        HouseCat houseCat = new HouseCat("wwww");
        Meowing[] meowings = new Meowing[]{cat1, cat2, cat3, houseCat};
//        meow(meowings);

        //3.3.5.
        Point2D[] point2DS1 = new Point2D[]{p, p1, p2};
        BrokenLine brokenLine1 = new BrokenLine(point2DS1);
        LehgthOfLines[] lines = new LehgthOfLines[]{line, line3, brokenLine1};
        double sumLength = length(lines);
//        System.out.println(sumLength);

        //3.3.6. сделал

        //3.3.7


        //3.3.8.
        Shooter shooterA = new Shooter("A");
        Shooter shooterB = new Shooter("B", gun);
        Shooter shooterC = new Shooter("A", new MachineGun(30,30,5));

//        shooterA.shot();
//        shooterB.shot();
//        shooterC.shot();

        //3.3.9
//        City city_A = new CityWithTwoWayTraffic("A");
//        City city_B = new City("B");
//        City city_C = new City("C");
//        City city_D = new CityWithTwoWayTraffic("D");
//        City city_E = new City("E");
//
//        city_A.addRoads(new Roads(city_B), new Roads(city_C));
//        city_B.addRoads(new Roads(city_C));
//        city_D.addRoads(new Roads(city_B), new Roads(city_E));
//        city_E.addRoads(new Roads(city_C));

        double pow = pow(2, 8);



        //4.1.3.
        //  7+11/3+3.21+12345678912345678912
            int x_4 = 7;
            Fraction fraction9 = new Fraction(11, 3);
            double x_d = 3.21;
            BigInteger x2 = new BigInteger("12345678912345678912");
            Number[] numbers = new Number[]{x_4, fraction9,x_d, x2};
//            System.out.println(sum(numbers));

        //4.1.4.
        int e = exponentiation("5", "2");
//        System.out.println(e);

        //4.1.5.
        Point2D point2D_figures = new Point2D(5,5);
        java.awt.geom.Point2D point2D_awt = new java.awt.geom.Point2D() {
            @Override
            public double getX() {
                return 0;
            }

            @Override
            public double getY() {
                return 0;
            }

            @Override
            public void setLocation(double x, double y) {

            }
        };




    }

    public static int exponentiation(String x, String y){
        int x_x = parseInt(x);
        int y_y = parseInt(y);
        return (int) pow(x_x, y_y);
    }

    public static double sum(Number[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        double result = 0;
        for (Number number : numbers) {
            result += number.doubleValue();
        }
        return result;
    }


    public static void chirik(Birds[] birds) {
        if (birds == null || birds.length == 0) return;
        for (Birds bird : birds) {
            bird.song();
        }
    }

    public static int sumArea(Figures[] fig) {
        if (fig == null || fig.length == 0) return -1;
        int sum = 0;
        for (Figures figures : fig) {
            sum+= figures.area();
        }
        return sum;
    }

    public static void meow(Meowing[] meowings) {
        for (Meowing meowing : meowings) {
            meowing.meow();
        }
    }

    public static double length(LehgthOfLines[] lines) {
        double result = 0;
        for (LehgthOfLines line : lines) {
            result += line.getLength();
        }
        return result;
    }

    public static BrokenLine concat(BrokenLine[] brokenLines){
        BrokenLine result = new BrokenLine(brokenLines[0].getPolygonalChain().point2D);

        for (BrokenLine brokenLine : brokenLines) {
            result.append(brokenLine.getPolygonalChain());
        }
        return result;
    }


}