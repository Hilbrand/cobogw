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

import com.google.gwt.core.client.GWT;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public interface RPCJavaSqlServiceAsync {

  /**
   * Utility class for simplifying access to the instance of async service.
   */
  public static class Util {
    private static RPCJavaSqlServiceAsync instance;

    public static RPCJavaSqlServiceAsync getInstance(String entryPoint) {
      if (null == instance) {
        instance = (RPCJavaSqlServiceAsync) GWT.create(RPCJavaSqlService.class);
        ServiceDefTarget target = (ServiceDefTarget) instance;

        target.setServiceEntryPoint(GWT.getModuleBaseURL() + entryPoint);
      }
      return instance;
    }
  }

  void getTimestamp(Timestamp timestamp, AsyncCallback callback);

  void getDate(Date date, AsyncCallback callback);

  void getTime(Time time, AsyncCallback callback);
}
