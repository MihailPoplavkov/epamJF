package task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplineTest {
    @Test
    void test() {
        Student student1 = new Student("Steve Jobs");
        Student student2 = new Student("Mark Zuckerberg");
        Student student3 = new Student("Mihail Poplavkov");

        Discipline<Integer> physics = new Discipline<>(Subject.PHYSICS);
        Discipline<Double> math = new Discipline<>(Subject.MATH);

        physics.addStudent(student1);
        physics.addStudent(student3);
        math.addStudent(student2);
        math.addStudent(student3);

        physics.estimateStudent(student1, 3);
        physics.estimateStudent(student3, 5);
        assertThrows(RuntimeException.class, () -> physics.estimateStudent(student2, 4));

        math.estimateStudent(student2, 3.8);
        math.estimateStudent(student3, 5.0);

        assertEquals(new Integer(5), physics.getMark(student3));
        assertEquals(new Double(5), math.getMark(student3));
    }
}