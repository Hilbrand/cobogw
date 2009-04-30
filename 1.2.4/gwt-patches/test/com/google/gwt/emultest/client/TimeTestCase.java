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

import java.sql.Time;

// If class is named TimeTestCase the test fails...
/**
 * Unit test for java.sql.Date GWT emulation class
 *
 */
public class TimeTestCase extends GWTTestCase {

  /* (non-Javadoc)
   * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
   */
  public String getModuleName() {
    return "com.google.gwt.emultest.Emul";
  }

  /**
   * test {@link Time#valueOf(String)}
   */
  public void testValueOf1() {
    Time t1 = Time.valueOf("23:40:20");

    assertEquals(23, t1.getHours());
    assertEquals(40, t1.getMinutes());
    assertEquals(20, t1.getSeconds());
    assertEquals(81620000L, t1.getTime());
  }

  public void testValueOf2() {
    Time t2 = Time.valueOf("1:2:3");
    assertEquals(1, t2.getHours());
    assertEquals(2, t2.getMinutes());
    assertEquals(3, t2.getSeconds());
    assertEquals(123000L, t2.getTime());
  }

  public void testValueOf3() {
    try {
      Time t3 = Time.valueOf("23:10x20");

      throw new AssertionError("Invalid date: 23:10x20, got:" + t3);
    } catch (Exception e) {
      assertTrue(e instanceof IllegalArgumentException);
    }
  }

  public void testValueOf4() {
    try {
      Time t4 = Time.valueOf("23:xx:20");

      throw new AssertionError("Invalid date: 23:xx:20, got:" + t4);
    } catch (Exception e) {
      assertTrue(e instanceof IllegalArgumentException);
    }
  }

  /**
   * test {@link Time#Time(long)}
   */
  public void testTime1() {
    Time t1 = new Time(1234567890123L);
    assertEquals(1234567890123L, t1.getTime());
  }

  /**
   * test {@link Time#Time(int, int, int)}
   */
  public void testTime2() {
    Time t2 = new Time(23, 59, 0);

    assertEquals("23:59:00", t2.toString());
    assertEquals(23, t2.getHours());
    assertEquals(59, t2.getMinutes());
    assertEquals(0, t2.getSeconds());
    assertEquals(82740000L, t2.getTime());
  }

  /**
   * test {@link Time#setTime(long)}
   */
  public void testSetTime() {
    Time t1 = new Time(0);
    t1.setTime(1234567890123L);

    assertEquals(1234567890123L, t1.getTime());
  }

  /**
   * test {@link Time#toString()}
   */
  public void testToString1() {
    Time t1 = new Time(23, 40, 20);
    assertEquals("23:40:20", t1.toString());
  }

  public void testToString2() {
    Time t2 = new Time(1, 2, 3);
    assertEquals("01:02:03", t2.toString());
  }

  public void testToString3() {
    Time t3 = new Time(13, 2, 3);
    assertEquals("13:02:03", t3.toString());
  }
}
