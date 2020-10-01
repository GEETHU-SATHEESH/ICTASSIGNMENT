import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class Listner  implements ITestNGListener,ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        System.out.println("Start of suite");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("End of suite");
    }

}
