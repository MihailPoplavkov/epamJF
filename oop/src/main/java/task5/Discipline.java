package task5;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class Discipline<T extends Number> {
    @SuppressWarnings("FieldCanBeLocal")
    private Subject subject;
    private Map<Student, T> map = new HashMap<>();

    public Discipline(Subject subject) {
        this.subject = subject;
    }

    public void addStudent(Student student) {
        map.put(student, null);
    }

    public void estimateStudent(Student student, T mark) {
        if (!map.containsKey(student)) throw new RuntimeException("Student is not in this course");
        map.replace(student, mark);
    }

    public T getMark(Student student) {
        return map.get(student);
    }

    public boolean containsStudent(Student student) {
        return map.containsKey(student);
    }
}
