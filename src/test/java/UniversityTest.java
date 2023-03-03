import org.example.lessons.Student;
import org.example.lessons.StudentValueGenerator;
import org.example.lessons.University;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UniversityTest {
    private Student student1;
    private Student student2;
    private Student student3;
    private University university;
    @Mock
    StudentValueGenerator studentValueGenerator;

    @BeforeEach
    public void setUp(){
//        student1 = new Student("Евгений", 35,true);
//        student2 = new Student("Марина", 19,false);
//        student3 = new Student("Алина", 7,false);
        university= new University(studentValueGenerator);
//        university.addStudent(student1);
//        university.addStudent(student2);
//        university.addStudent(student3);
    }

    @Test
    public void getAllStudents(){
        Student student1 = new Student("Евгений", 35,true);
        Student student2 = new Student("Марина", 19,false);
        Student student3 = new Student("Алина", 7,false);

        University university= new University(studentValueGenerator);
        List<Student> expected = university.getAllStudents();
        List<Student> actual = new ArrayList<Student>();

        actual.add(student1);
        actual.add(student2);
        actual.add(student3);

        assertEquals(expected,actual);
    }
    @Test
    public void getAllStudentNotNull(){
        University university = new University(studentValueGenerator);
        List<Student> expected = university.getAllStudents();
        assertNotNull(expected);
    }

    @Test
    public void getAllStudentMockito(){
        assertNotNull(studentValueGenerator);
        Mockito.when(studentValueGenerator.generateAgeInRange()).thenReturn(50);
        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(0).getAge(), 50);

    }
    @Test
    public void getAllStudentMockitoWithCountAgeGenerate(){
        assertNotNull(studentValueGenerator);
        Mockito.when(studentValueGenerator.generateAgeInRange()).thenReturn(50);
        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(0).getAge(), 50);
//        Mockito.verify(studentValueGenerator).generateAgeInRange(); // Проверка на 1 раз вызов метода
        Mockito.verify(studentValueGenerator, Mockito.times(2)).generateAgeInRange(); // Проверка на ДВА вызова метода
    }
    @Test
    public void getAllStudentMockitoInOrder(){
        assertNotNull(studentValueGenerator);
        Mockito.when(studentValueGenerator.generateAgeInRange()).thenReturn(50);

        InOrder inOrder = Mockito.inOrder(studentValueGenerator);

        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(0).getAge(), 50);
//        Mockito.verify(studentValueGenerator).generateAgeInRange(); // Проверка на 1 раз вызов метода
        Mockito.verify(studentValueGenerator, Mockito.times(2)).generateAgeInRange(); // Проверка на ДВА вызова метода
        Mockito.verify(studentValueGenerator, Mockito.timeout(100)).generateAgeInRange(); // Проверка на скорость вызова метода <10 милисекунд
    }

    @Test
    public void getAllStudentsIsMale(){
        Student student1 = new Student("Евгений", 35,true);
        Student student2 = new Student("Марина", 19,false);
        Student student3 = new Student("Алина", 7,false);

        University university= new University(studentValueGenerator);
        university.addStudent(student1);


        List<Student> expected = university.getAllStudents(true);

        List<Student> actual = new ArrayList<Student>();

        actual.add(student1);

        assertEquals(expected,actual);
    }

}

