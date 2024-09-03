/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package student;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class StudentManagementSystemTest {
    
    private StudentManagementSystem sms;
    private Student student1;
    private Student student2;

    @Before
    public void setUp() {
        sms = new StudentManagementSystem();
        student1 = new Student("ST1004576", "Ntsako", "Mogale", 20, "Computer Science");
        student2 = new Student("ST1004577", "Karabo", "Mfopa", 22, "Mathematics");
        sms.students.add(student1);
        sms.students.add(student2);
    }

    @Test
    public void testCaptureStudent() {
        int initialSize = sms.students.size();
        Student newStudent = new Student("ST1004577", "Larry", "Brown", 19, "Engineering");
        sms.students.add(newStudent);
        assertEquals(initialSize + 1, sms.students.size());
        assertTrue(sms.students.contains(newStudent));
    }

    @Test
    public void testSearchStudent() {
        Student foundStudent = null;
        for (Student student : sms.students) {
            if (student.getStudentID().equals("ST1004576")) {
                foundStudent = student;
            }
        }
        assertNotNull(foundStudent);
        assertEquals("Ntsako", foundStudent.getFirstName());
    }

    @Test
    public void testDeleteStudent() {
        int initialSize = sms.students.size();
        sms.students.remove(student1);
        assertEquals(initialSize - 1, sms.students.size());
        assertFalse(sms.students.contains(student1));
    }

    @Test
    public void testViewStudentReport() {
        assertEquals(2, sms.students.size());
        assertEquals("Ntsako", sms.students.get(0).getFirstName());
        assertEquals("Karabo", sms.students.get(1).getFirstName());
    }
}
