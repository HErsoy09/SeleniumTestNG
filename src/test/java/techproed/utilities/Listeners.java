package techproed.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart -> Tüm testlerden önce tek bir sefer çağrılır : " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish -> Tüm testlerden sonra tek bir sefer çağrılır : " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart -> Her bir @Test'ten önce bir kere çağrılır : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess -> Sadece PASS olan testlerden sonra bir kere çağrılır : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure -> Sadece FAIL olan testlerden sonra bir kere çağrılır : " + result.getName());
        ReusableMethods.screenShot(result.getName()); // Her metot için kullanılabilir.
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped -> Sadece ATLANAN testlerden sonra bir kere çağrılır : " + result.getName());
    }

    //IRetryAnalyzer, IAnnotationTransformer için;
    private static int retryCount = 0;
    private static final int maxRetryCount = 1; // Testin ek çalışma sayısı

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    // Yukarıda yazılan retry metoduna yardımcı olur ve bu retry metodunun xml dosyası üzerinden kullanılabilmesini sağlar.
    // Böylece arka planda @Test notasyonuna sahip olan metotları yapılandırıp, testin başarısız olma durumunda otomatik olarak rety metodunda belirttiğimiz sayı kadar tekrar çalıştırabilmemizi sağlar.
    //Eğer bu metodu burada yazmazsak yeniden çalıştırma için ilgili metotlara manuel olarak yazmamız gerekecek.
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConsturactor, Method testMethod) {
        annotation.setRetryAnalyzer((Listeners.class));
    }
}