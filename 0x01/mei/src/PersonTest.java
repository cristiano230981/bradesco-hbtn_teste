import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

public class PersonTest {

    private Person person;

    @Before
    public void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 1); // 1 de janeiro de 2000
        Date birthDate = cal.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200f);
        assertEquals(14400f, person.calculateYearlySalary(), 0.01);
    }

    @Test
    public void person_is_MEI() {
        person.setSalary(1000f); // 12.000 anual
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setSalary(15000f); // 180.000 anual
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);
        assertFalse(person.isMEI());
    }
}