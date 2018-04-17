import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImpresorLCDTest{
  private ImpresorLCD printer1;
  private ImpresorLCD printer2;

  @Before
  public void setup(){
    printer1 = new ImpresorLCD();
    printer2 = new ImpresorLCD();
  }

  @Test
  public void isNumericTest(){
    Assert.assertTrue(ImpresorLCD.isNumeric("123"));
  }

  @Test
  public void puntosFijosTest(){
    printer1.procesar("2,123", 2);
    printer2.procesar("5,67589", 4);
    int[][] tester1 = {{0,12}, {3,12}, {6,12}, {3,15}, {0,15}};
    int[][] tester2 = {{0,44}, {6,44}, {12,44}, {6,50}, {0,50}};
    Assert.assertArrayEquals(printer1.getPuntosFijos(), tester1);
    Assert.assertArrayEquals(printer2.getPuntosFijos(), tester2);
  }

  /*@Test
  public void getVaraiblesGlobalesTest(){

  }*/
}
