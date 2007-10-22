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

import com.google.gwt.user.client.rpc.RemoteService;

import org.cobogw.gwt.user.client.ddw.DataEvent;

/**
 * Marker interface that RPC interfaces 
 */
public interface DataEventService extends RemoteService {

  /**
   * Request data from the server.
   * 
   * @param sid Unique session key for security 
   * @param data Additional data to instrument the request
   */
  DataEvent requestData(String sid, DataEvent data);
  
  /**
   * Send data to the server to be stored.
   * 
   * @param sid Unique session key for security 
   * @param data Data to be stored at the server
   */
  String sendData(String sid, DataEvent data);
}
