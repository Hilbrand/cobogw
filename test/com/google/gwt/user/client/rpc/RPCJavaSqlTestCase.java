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
package com.google.gwt.user.client.rpc;

import com.google.gwt.junit.client.GWTTestCase;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class RPCJavaSqlTestCase extends GWTTestCase {

  private RPCJavaSqlServiceAsync service;

  public String getModuleName() {
    return "com.google.gwt.user.RPCTest";
  }

  /**
   *  Test {@link Date} serialization
   */
  public void testDate1() {
    runTestDate(Date.valueOf("2007-10-20"));
  }

  public void testDate2() {
    runTestDate(Date.valueOf("2007-1-1"));
  }

  public void testDate3() {
    runTestDate(Date.valueOf("2007-12-31"));
  }

  private void runTestDate(final Date date) {
    initService();
    service.getDate(date, new AsyncCallback() {
      public void onFailure(Throwable caught) {
        fail(caught.getMessage());
      }

      public void onSuccess(Object result) {
        if (result instanceof Date) {
          assertEquals(date.getTime(), ((Date) result).getTime());
        } else {
          fail("Result not instance of java.sql.Date");
        }
        finishTest();
      }
    });
    delayTestFinish(500);
  }

  /**
   *  Test {@link Time} serialization.
   */
  public void testTime1() {
    runTestTime(Time.valueOf("00:00:00"));
  }

  public void testTime2() {
    runTestTime(Time.valueOf("1:2:3"));
  }

  public void testTime3() {
    runTestTime(Time.valueOf("12:34:56"));
  }

  public void testTime4() {
    runTestTime(Time.valueOf("23:59:59"));
  }

  private void runTestTime(final Time time) {
    initService();
    service.getTime(time, new AsyncCallback() {
      public void onFailure(Throwable caught) {
        fail(caught.getMessage());
      }

      public void onSuccess(Object result) {
        if (result instanceof Time) {
          assertEquals(time.getTime(), ((Time) result).getTime());
        } else {
          fail("Result not instance of java.sql.Time");
        }
        finishTest();
      }
    });
    delayTestFinish(500);
  }

  /**
   *  Test {@link Timestamp} serialization.
   */

  public void testTimestamp1() {
    runTestTimestamp(new Timestamp(0));
  }

  public void testTimestamp2() {
    runTestTimestamp(Timestamp.valueOf("2007-1-1 0:0:0.0"));
  }

  public void testTimestamp3() {
    runTestTimestamp(Timestamp.valueOf("2007-12-31 23:59:59.999999999"));
  }

  private void runTestTimestamp(final Timestamp ts) {
    initService();
    service.getTimestamp(ts, new AsyncCallback() {
      public void onFailure(Throwable caught) {
        fail(caught.getMessage());
      }

      public void onSuccess(Object result) {
        if (result instanceof Timestamp) {
          assertEquals(ts.getTime(), ((Timestamp) result).getTime());
        } else {
          fail("Result not instance of java.sql.Timestamp");
        }
        finishTest();
      }
    });
    delayTestFinish(500);
  }

  /*
   * Private method to start RPC service.
   */
  private void initService() {
    if (service == null) {
      service = RPCJavaSqlServiceAsync.Util.getInstance("RPCJavaSqlTestCase");
    }
  }
}
