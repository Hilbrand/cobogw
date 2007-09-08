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

/**
 * Data Handler is an abstract handler class. Each DataDriver will create one 
 * DataHandler per request to the server.  The DataHandler contains the query 
 * string as well as the fill() method that should be called each time the 
 * server returns data in response. The DataHandler is sent to the DataBroker 
 * by the DataDriver. 
 */
public interface DataHandler {

  /**
   * Fired when the Asynchronous request or send call returns with a failure
   * from the server. 
   * 
   * @param error String containing the error message
   */  
  void onError(String error);
  
  /**
   * Fired when the Asynchronous request call successful returns from the server
   * with the data in the parameter <code>data</code>. The class implementing 
   * this interface should handle specific implementation details on what data 
   * is available in the data class.
   * 
   * @param data {@link DataEvent} data object containing data to set
   */  
  void onRequested(DataEvent data);
  
  /**
   * Fired when the Asynchronous request call successful returns from the server
   * with the data in the parameter <code>data</code>. The class implementing 
   * this interface should handle specific implementation details on what data 
   * is available in the data class.
   * 
   * @param data {@link DataEvent} data object containing data to set
   */  
  void onSend(Object data);
}
