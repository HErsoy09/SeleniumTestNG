package techproed.tests.day26_Listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ReusableMethods;

import java.util.NoSuchElementException;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest {

    @Test
    public void test01() {
        System.out.println("PASS");
        Assert.assertTrue(true);
    }

    @Test
    public void test02() {
        System.out.println("FAIL");
        Assert.assertTrue(false);
    }

    @Test
    public void test03() {
        System.out.println("SKIP");
        throw new SkipException("test03 ignore edildi");
    }

    @Test
    public void test04() {
        System.out.println("EXCEPTION");
        throw new NoSuchElementException("No Such Element");
    }
}