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
package org.cobogw.gwt.user.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import org.cobogw.gwt.user.client.ddw.DataEvent;

/**
 * Async interface linked to {@link DataEventService}. 
 */
public interface DataEventServiceAsync {

  /**
   * Utility class for simplifying access to the instance of async service.
   */
  public static class Util {
    private static DataEventServiceAsync instance;
    
    public static DataEventServiceAsync getInstance(String entryPoint) {
      if (null == instance) {
        instance = (DataEventServiceAsync) GWT.create(
            DataEventService.class);
        ServiceDefTarget target = (ServiceDefTarget) instance;

        target.setServiceEntryPoint(GWT.getModuleBaseURL() + entryPoint);
      }
      return instance;
    }
  }

  /**
   * Request data from the server.
   * 
   * @param sid Unique session key for security 
   * @param data Additional data to instrument the request
   * @param callback Method to handle server response
   */
  void requestData(String sid, DataEvent data, AsyncCallback callback);
  
  /**
   * Send data to the server to be stored.
   * 
   * @param sid Unique session key for security 
   * @param data Data to be stored at the server
   * @param callback Method to handle server response
   */
  void sendData(String sid, DataEvent data, AsyncCallback callback);
}
