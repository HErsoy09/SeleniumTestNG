package techproed.tests.day20_Annotations;

import org.testng.annotations.*;

public class C01_Notasyonlar {

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Her şeyden önce BeforeSuite notasyonuna sahip olan metot 1 kez çalışır");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("Her şeyden sonra AfterSuite notasyonuna sahip olan metot 1 kez çalışır");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Testlerden önce BeforeTest notasyonuna sahip olan metot 1 kez çalışır");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Testlerden sonra AfterTest notasyonuna sahip olan metot 1 kez çalışır");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her Class'tan önce BeforeClass notasyonuna sahip olan metot 1 kez çalışır");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Her Class'tan sonra AfterClass notasyonuna sahip olan metot 1 kez çalışır");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Her test metodundan önce BeforeMethod notasyonuna sahip olan metot 1 kez çalışır");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Her test metodundan sonra AfterMethod notasyonuna sahip olan metot 1 kez çalışır");
    }

//---------------------TESTS----------------

    @Test(groups = "smoke") // belirliGruplarıCalistirma.xml kullanmak için isimlendirdik
    public void test01() {
        System.out.println("test01 test metodu çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("test02 test metodu çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("test03 test metodu çalıştı");
    }
}