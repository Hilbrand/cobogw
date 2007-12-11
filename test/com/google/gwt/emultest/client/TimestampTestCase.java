/*
 * Copyright 2007 Hilbrand Bouwkamp, hs@bouwkamp.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.emultest.client;

import com.google.gwt.junit.client.GWTTestCase;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Unit test for java.sql.Timestamp GWT emulation class
 */
public class TimestampTestCase extends GWTTestCase {

  /* (non-Javadoc)
   * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
   */
  public String getModuleName() {
    return "com.google.gwt.emultest.Emul";
  }

  /**
   * test {@link Timestamp#valueOf(String)}
   */
  public void testValueOf1() {
    Timestamp ts = Timestamp.valueOf("2007-10-20 23:40:20.123456789");

    assertEquals(107, ts.getYear());
    assertEquals(9, ts.getMonth());
    assertEquals(20, ts.getDate());
    assertEquals(23, ts.getHours());
    assertEquals(40, ts.getMinutes());
    assertEquals(20, ts.getSeconds());
    assertEquals(123456789, ts.getNanos());
  }

  public void testValueOf2() {
    Timestamp ts = Timestamp.valueOf("2007-01-01 00:00:00");

    assertEquals(107, ts.getYear());
    assertEquals(0, ts.getMonth());
    assertEquals(1, ts.getDate());
    assertEquals(0, ts.getHours());
    assertEquals(0, ts.getMinutes());
    assertEquals(0, ts.getSeconds());
    assertEquals(0, ts.getNanos());
  }

  public void testValueOf3() {
    Timestamp ts = Timestamp.valueOf("2007-10-20 1:2:3.123456789");

    assertEquals(107, ts.getYear());
    assertEquals(9, ts.getMonth());
    assertEquals(20, ts.getDate());
    assertEquals(1, ts.getHours());
    assertEquals(2, ts.getMinutes());
    assertEquals(3, ts.getSeconds());
    assertEquals(123456789, ts.getNanos());
  }

  public void testValueOf4() {
    Timestamp ts = Timestamp.valueOf("2007-12-31 23:59:59.999999999");

    assertEquals(107, ts.getYear());
    assertEquals(11, ts.getMonth());
    assertEquals(31, ts.getDate());
    assertEquals(23, ts.getHours());
    assertEquals(59, ts.getMinutes());
    assertEquals(59, ts.getSeconds());
    assertEquals(999999999, ts.getNanos());
  }

  public void testValueOf5() {
    try {
      Timestamp ts = Timestamp.valueOf("2007-10-20 23:10x20.123456789");

      throw new AssertionError(
          "Invalid date: 23:10x20 23:10x20.123456789, got:" + ts);
    } catch (Exception e) {
      assertTrue(e instanceof IllegalArgumentException);
    }
  }

  public void testValueOf6() {
    try {
      Timestamp ts = Timestamp.valueOf("2007-10-20 23:xx:20.123456789");

      throw new AssertionError(
          "Invalid date: 2007-10-20 23:xx:20.123456789, got:" + ts);
    } catch (Exception e) {
      assertTrue(e instanceof IllegalArgumentException);
    }
  }

  /**
   * test {@link Timestamp#Timestamp(long)}
   */
  public void testTimestamp1() {
    Timestamp ts = new Timestamp(1234567890123L);

    assertEquals(123000000, ts.getNanos());
    assertEquals(1234567890123L, ts.getTime());
  }

  public void testTimestamp2() {
    Timestamp ts = new Timestamp(-1234567890123L);

    assertEquals(877000000, ts.getNanos());
    assertEquals(-1234567890123L, ts.getTime());
  }

  /**
   * test {@link Timestamp#Timestamp(int, int, int, int, int, int, int)}
   */
  public void testTimestamp3() {
    Timestamp ts = new Timestamp(107, 11/*12*/, 31, 23, 59, 59, 999999999);

    assertEquals(107, ts.getYear());
    assertEquals(11, ts.getMonth());
    assertEquals(31, ts.getDate());
    assertEquals(23, ts.getHours());
    assertEquals(59, ts.getMinutes());
    assertEquals(59, ts.getSeconds());
    assertEquals(999999999, ts.getNanos());
//    assertEquals(1199141999999L, ts.getTime());
    assertEquals("2007-12-31 23:59:59.999999999", ts.toString());
  }

  public void testTimestamp4() {
    Timestamp ts = new Timestamp(70, 0/*1*/, 1, 0, 0, 0, 0);

    assertEquals(70, ts.getYear());
    assertEquals(0, ts.getMonth());
    assertEquals(1, ts.getDate());
    assertEquals(0, ts.getHours());
    assertEquals(0, ts.getMinutes());
    assertEquals(0, ts.getSeconds());
    assertEquals(0, ts.getNanos());
//    assertEquals(0L, ts.getTime());
    assertEquals("1970-01-01 00:00:00.0", ts.toString());
  }

  /**
   * test {@link Timestamp#after(Timestamp)}
   */
  public void testAfter1() {
   assertEquals(false, (new Timestamp(100)).after(new Timestamp(200)));
   assertEquals(false, (new Timestamp(10000)).after(new Timestamp(20000)));
  }

  public void testAfter2() {
    assertEquals(false, (new Timestamp(100)).after(new Timestamp(100)));
    assertEquals(false, (new Timestamp(100)).after(new Timestamp(10000)));
  }

  public void testAfter3() {
    assertEquals(true, (new Timestamp(200)).after(new Timestamp(100)));
    assertEquals(true, (new Timestamp(20000)).after(new Timestamp(10000)));
  }
  /**
   * test {@link Timestamp#before(Timestamp)}
   */
  public void testBefore1() {
    assertEquals(true, (new Timestamp(100)).before(new Timestamp(200)));
    assertEquals(true, (new Timestamp(10000)).before(new Timestamp(20000)));
  }

  public void testBefore2() {
    assertEquals(false, (new Timestamp(100)).before(new Timestamp(100)));
    assertEquals(false, (new Timestamp(10000)).before(new Timestamp(10000)));
  }

  public void testBefore3() {
    assertEquals(false, (new Timestamp(200)).before(new Timestamp(100)));
    assertEquals(false, (new Timestamp(20000)).before(new Timestamp(10000)));
  }

  /**
   * test {@link Timestamp#compareTo(Timestamp)}
   */
  public void testCompareTo1() {
    assertEquals(-1, (new Timestamp(100)).compareTo(new Timestamp(200)));
    assertEquals(-1, (new Timestamp(10000)).compareTo(new Timestamp(20000)));
    assertEquals(-1, (new Timestamp(1111111)).compareTo(new Timestamp(2222222)));
  }

  public void testCompareTo2() {
    assertEquals(0, (new Timestamp(100)).compareTo(new Timestamp(100)));
    assertEquals(0, (new Timestamp(10000)).compareTo(new Timestamp(10000)));
    assertEquals(0, (new Timestamp(1111111)).compareTo(new Timestamp(1111111)));
  }

  public void testCompareTo3() {
    assertEquals(1, (new Timestamp(200)).compareTo(new Timestamp(100)));
    assertEquals(1, (new Timestamp(20000)).compareTo(new Timestamp(10000)));
    assertEquals(1, (new Timestamp(2222222)).compareTo(new Timestamp(1111111)));
  }

  public void testCompareTo4() {
    Timestamp ts = new Timestamp(12345);
    Date d = new Date(12345);

    assertEquals(0, ts.compareTo(d));
  }

  /**
   * test {@link Timestamp#equals(Timestamp)}
   */
  public void testEquals1() {
    assertEquals(false, (new Timestamp(100)).equals(new Timestamp(200)));
    assertEquals(false, (new Timestamp(10000)).equals(new Timestamp(20000)));
    assertEquals(false, (new Timestamp(1111111)).equals(new Timestamp(2222222)));
  }

  public void testEquals2() {
    assertEquals(true, (new Timestamp(100)).equals(new Timestamp(100)));
    assertEquals(true, (new Timestamp(10000)).equals(new Timestamp(10000)));
    assertEquals(true, (new Timestamp(1111111)).equals(new Timestamp(1111111)));
  }

  public void testEquals3() {
    assertEquals(false, (new Timestamp(200)).equals(new Timestamp(100)));
    assertEquals(false, (new Timestamp(20000)).equals(new Timestamp(10000)));
    assertEquals(false, (new Timestamp(2222222)).equals(new Timestamp(1111111)));
  }

  /**
   * test {@link Timestamp#getNanos()}
   */
  public void testGetNanos1() {
    assertEquals(345000000, (new Timestamp(12345)).getNanos());
  }

  public void testGetNanos2() {
    assertEquals(999000000, (new Timestamp(99999)).getNanos());
  }

  public void testGetNanos3() {
    Timestamp ts = new Timestamp(0);

    ts.setNanos(12345);
    assertEquals(12345, ts.getNanos());
  }

  public void testGetNanos4() {
    Timestamp ts = new Timestamp(0);

    ts.setNanos(999999999);
    assertEquals(999999999, ts.getNanos());
  }

  public void testGetNanos5() {
    Timestamp ts = new Timestamp(-999999999);

    assertEquals(1000000, ts.getNanos());
  }

  public void testGetNanos6() {
    Timestamp ts = new Timestamp(-123456789);

    assertEquals(211000000, ts.getNanos());
  }

  /**
   * test {@link Timestamp#setTime(long)}
   */
  public void testSetTime1() {
    Timestamp Timestamp = new Timestamp(0);

    Timestamp.setTime(1234567890123L);
    assertEquals(1234567890123L, Timestamp.getTime());
    assertEquals(123 * 1000000, Timestamp.getNanos());
  }

  /**
   * test {@link Timestamp#toString()}
   */
  public void testToString1() {
    Timestamp ts = new Timestamp(107, 11/*12*/, 31, 23, 59, 58, 999999999);

    assertEquals("2007-12-31 23:59:58.999999999", ts.toString());
  }

  public void testToString2() {
    Timestamp ts = new Timestamp(0, 0, 1, 0, 0, 0, 123456789);

    assertEquals("1900-01-01 00:00:00.123456789", ts.toString());
  }

  public void testToString3() {
    Timestamp ts = new Timestamp(107, 0, 1, 13, 2, 3, 123456789);

    assertEquals("2007-01-01 13:02:03.123456789", ts.toString());
  }

  public void testToString4() {
    Timestamp ts = new Timestamp(107, 0, 1, 13, 2, 3, 0);

    assertEquals("2007-01-01 13:02:03.0", ts.toString());
  }
}
