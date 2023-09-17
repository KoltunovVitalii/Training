package ru.mfti.koltunov;

import lombok.*;
import ru.mfti.koltunov.generic.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Start15 {
    public static void main(String[] args) {
        NewStudent st = new NewStudent("Ivan", x->x>0);
        st.setName("Petya");
        Save save = st.save();
        st.addMarks(4, 3, 5);
        st.setName("Ivan");
        System.out.println(st);
        save.load();
        Map<Date, List<Save>> saves = null;
        for (Save s : saves.get(new Date())) {
            s.load();
        }
        System.out.println(st);
    }
}



class NewStudent implements Comparable<Student> {
    @Getter@Setter
    private String name;
    private List<Integer> lst= new ArrayList<>();
    private Predicate<Integer> rule;

    public NewStudent(String name, Predicate<Integer> rule) {
        this.name = name;
        this.rule = rule;
    }

    void addMarks(Integer ... marks){
        for(Integer x:marks){
            if(!rule.test(x)) throw new IllegalArgumentException(x+" wrong mark");
            this.lst.add(x);
        }
    }

    public List<Integer> getLst() {
        return new ArrayList<>(lst);
    }

    public Save save(){
        return new SaveImpl(name,getLst());
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    @AllArgsConstructor
    private class SaveImpl implements Save{
        private String name;
        private List<Integer> lst;
        public void load(){
            NewStudent.this.name=name;;
            NewStudent.this.lst=new ArrayList<>(lst);
        }
    }
}

interface Save{
    void load();
}