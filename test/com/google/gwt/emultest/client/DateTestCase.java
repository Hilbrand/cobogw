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

import java.sql.Date;

/**
 * Unit test for java.sql.Date GWT emulation class
 */
public class DateTestCase extends GWTTestCase {

  /* (non-Javadoc)
   * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
   */
  public String getModuleName() {
    return "com.google.gwt.emultest.Emul";
  }

  /**
   * Test {@link Date#valueOf(String)}
   */
  public void testValueOf1() {
    Date d1 = Date.valueOf("2007-10-20");
    assertEquals(107, d1.getYear());
    assertEquals(9, d1.getMonth());
    assertEquals(20, d1.getDate());
    assertEquals(1192831200000L, d1.getTime());
  }

  public void testValueOf2() {
    Date d2 = Date.valueOf("2007-9-1");
    assertEquals(107, d2.getYear());
    assertEquals(8, d2.getMonth());
    assertEquals(1, d2.getDate());
    assertEquals(1188597600000L, d2.getTime());
  }    

  public void testValueOf3() {
    try {
      Date d3 = Date.valueOf("2007-10x20");

      throw new AssertionError("Invalid date: 2007-10x20, got:" + d3);
    } catch (Exception e) {
      assertTrue(e instanceof IllegalArgumentException); 
    }
  }

  public void testValueOf4() {
    try {
      Date d4 = Date.valueOf("2007-xx-20");

      throw new AssertionError("Invalid date: 2007-xx-20, got:" + d4);
    } catch (Exception e) {
      assertTrue(e instanceof IllegalArgumentException); 
    }
  }
  
  /**
   * Test {@link Date#Date(long)}
   */
  public void testDate1() {
    Date d1 = new Date(1234567890123L);
    assertEquals(1234567890123L, d1.getTime());
  }

  /**
   * Test {@link Date#Date(int, int, int)}
   */
  public void testDate2() {
    Date d2 = new Date(107, 9/*10*/, 20);
    assertEquals(107, d2.getYear());
    assertEquals(9, d2.getMonth());
    assertEquals(20, d2.getDate());
    assertEquals(1192831200000L, d2.getTime());
    assertEquals("2007-10-20", d2.toString());
  }

  /**
   * Test {@link Date#setTime(long)}
   */
  public void testSetTime() {
    Date d1 = new Date(0);
    d1.setTime(1234567890123L);
    
    assertEquals(1234567890123L, d1.getTime());    
  }
  
  /**
   * Test {@link Date#toString())}
   */
  public void testToString1() {
    Date d1 = new Date(107, 9/*10*/, 20);
    assertEquals("2007-10-20", d1.toString());
  }

  public void testToString2() {
    Date d2 = new Date(107, 0, 1);
    assertEquals("2007-01-01", d2.toString());
  }
}
