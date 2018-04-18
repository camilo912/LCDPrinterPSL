import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestsRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(ImpresorLCDTest.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      if(result.wasSuccessful()){
        System.out.println("Todas las pruebas correctas");
      } else {
        System.out.println("Fallaron algunas pruebas");
      }
   }
}
