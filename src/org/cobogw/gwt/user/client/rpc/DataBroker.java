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
 * The DataBroker provides an abstract set of classes and interfaces that can be
 * easily customized to facilitate communication with the server. The DataBroker
 * is responsible for batching, fetching, and caching server response data.
 *  
 * <p>Each DataDriver is associated with a single DataBroker. The DataBroker is 
 * responsible for gathering and processing data requests and using the returned
 * information to populate data  widgets.   It knows how to take a string 
 * payload from the server and translate it into a response object. 
 * 
 * <p>The DataBroker is data-agnostic. It should only be able to communicate 
 * with the server, cache data responses from the server, and re-assemble server
 * side response. It may use whatever technology is most convenient for the 
 * user, RPC, JSON, HTTPRequests, etc. Only the server response and the 
 * DataHandler object should be aware of the underlying data.
 */
public interface DataBroker {
  
  /**
   * Adds the data handler to the list of handlers.
   * 
   * @param dh The handler to add
   */
  void addDataHandler(DataHandler dh);
  
  /**
   * Removes the data handler from the list of handlers.
   * 
   * @param dh The handler to remove
   */
  void removeDataHandler(DataHandler dh);
  
  /**
   * Performs the RPC to request data from the server, the received data will be 
   * passed to the {@link DataHandler#onRequested(DataEvent)} handlers.
   * 
   * @param data Additional data to send to the server to instrument request
   */
  void requestData(DataEvent data);
  
  /**
   * Performs the RPC call to send data to the server. The received data will be 
   * passed to the {@link DataHandler#onSend(Object)} handlers.
   * 
   * @param data Data to send to the server
   */
  void sendData(DataEvent data);
}
