

import java.sql.Timestamp;

/**
 * @author Bouwkamp
 *
 */
public class DateTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
//    System.out.println(java.sql.Date.valueOf("2007-x0-99").toString());
long t1 = 1234567;
Timestamp ts1 = new Timestamp(t1);
    System.out.println(ts1.toString());
    System.out.println("nanos=" + ts1.getNanos());
    System.out.println("time=" + ts1.getTime());
    ts1.setNanos(321 * 1000000);
    
    System.out.println("nanos=" + ts1.getNanos());
    System.out.println("time=" + ts1.getTime());
    System.out.println("time=" + ts1.getTime() % 1000);
  }

}
