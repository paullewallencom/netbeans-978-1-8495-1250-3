import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = new Person();
        String expResult = "John";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "John";
        Person instance = new Person();
        instance.setName(name);
    }

    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Person instance = new Person();
        int expResult = 30;
        instance.setAge(expResult);
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 30;
        Person instance = new Person();
        instance.setAge(age);
    }

    @Test
    public void testGreet() {
        System.out.println("greet");
        Person instance = new Person();
        String name = "John";
        instance.setName(name);
        int age = 30;
        instance.setAge(age);
        String expResult = "Hi, my name is " + name + "and I am " + age + ".\nNice to meet you!";
        String result = instance.greet();
        assertEquals(expResult, result);
    }

}