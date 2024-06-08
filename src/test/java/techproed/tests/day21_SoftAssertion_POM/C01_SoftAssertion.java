package techproed.tests.day21_SoftAssertion_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C01_SoftAssertion {

    @Test
    public void softAssertion() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(13, 3);
        System.out.println("Kod çalışmaya devam eder");
        softAssert.assertTrue(3>12);
        System.out.println("Kod çalışmaya devam eder");
        softAssert.assertFalse(2<1);
        System.out.println("Kod çalışmaya devam eder");
        softAssert.assertNotEquals("java", "java");
        System.out.println("Kod çalışmaya devam eder");

        softAssert.assertAll();
        System.out.println("Soft Assertion'lardan bir tanesi bile hata verirse, bu kod çalışmaz");

    }

    @Test
    public void hardAssertion() {

        Assert.assertTrue(true);
        System.out.println("Kod çalışmaya devam eder");
        Assert.assertFalse(false);
        System.out.println("Kod çalışmaya devam eder");
        Assert.assertEquals(3, 2);
        System.out.println("Kod çalışmaya devam etmez");
        Assert.assertNotEquals("java", "selenium");
        System.out.println("Kod çalışmaya devam eder");

    }
}