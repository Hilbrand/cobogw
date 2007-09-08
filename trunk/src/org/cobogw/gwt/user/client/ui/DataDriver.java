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
package org.cobogw.gwt.user.client.ui;

import org.cobogw.gwt.user.client.rpc.DataBroker;
import org.cobogw.gwt.user.client.rpc.DataEvent;
import org.cobogw.gwt.user.client.rpc.DataHandler;

/**
 * Each DataDriver will be associated with a single Widget and DataBroker. 
 * Neither the Widget nor the DataBroker should have any knowledge of the 
 * DataDriver. 
 * 
 * Each DataDriver should also be associated with a string 
 * representing the data source linked with the DataDriver.
 * 
 * <p>Each DataDriver will generate custom DataHandler objects with fill methods
 *  to handle the data received from the server.
 */
public abstract class DataDriver/* <? extends DataEvent>*/ 
    implements DataHandler, DataStateHandler {

  private final DataBroker broker;
  
  public DataDriver(DataBroker broker) {
    this.broker = broker;
    broker.addDataHandler(this);
  }
  
  /**
   * Adds a data handler to the list of data handlers.
   * 
   * @param handler The request handler to add
   */
  public void addDataHandler(final DataHandler handler) {
    broker.addDataHandler(handler);
  }

  public void requestData(DataEvent data) {
    broker.requestData(data);
  }

  public void removeDataHandler(DataHandler dh) {
    broker.removeDataHandler(dh);
  }

  // send data to server
  public void sendData(DataEvent data) {
    broker.sendData(data);    
  }
}
