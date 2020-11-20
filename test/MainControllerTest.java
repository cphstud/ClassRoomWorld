import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainControllerTest {
    MainController mc;

    @Before
    public void setup() {
        mc = new MainController();

    }

    @org.junit.Test
    public void getConnection() {
        Connection con = mc.getConnection();
        assertNotNull(con);
    }

    @Test
    public void findAllC() {
        int actual = mc.findAllC();
        int expected = 123;
        assertEquals(expected,actual);
    }

    @Test
    public void findSomeC() {
        int brugerInput = 8000000;
        List<City> cities = mc.findSomeC(brugerInput);
        int expected = 123;
        int actual = cities.size();
        assertEquals(expected,actual);
    }

    @Test
    public void findAllCountries() {
        List<Country> contries = new ArrayList<>();
        contries = mc.findAllCountries();
        int expected = 123;
        int actual = contries.size();
        assertEquals(expected,actual);
    }
}