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
 * Abstract implementation of DataBroker interface. This class takes care of the
 * generic part of adding and removing DataHandlers. 
 */
public abstract class AbstractDataBroker implements DataBroker {

  private DataHandlerCollection dataHandlers = null;
  
  /**
   * Adds a data handler to the list of data handlers.
   * 
   * @param handler The handler to add
   */
  public void addDataHandler(final DataHandler handler) {
    if (null == dataHandlers) {
      dataHandlers = new DataHandlerCollection/* <DataHandler>*/();
    }
    dataHandlers.add(handler);
  }
 
  /**
   * Fired when request or send returns with an error. The error is passed as
   * argument. The implementing class must call this method to pass the results
   * to the {@link DataHandler} class.
   * 
   * @param error Error of event
   */
  protected void fireOnError(String error) {
    dataHandlers.onError(error);
  }

  /**
   * Fired when the server request succesfull returns from the server. The 
   * argument contains the data as send from the server. The implementing class 
   * must call this method to pass the results to the {@link DataHandler} class.
   * 
   * @param data Data send from the server
   */
  protected void fireOnRequested(DataEvent data) {
    dataHandlers.onRequested(data);
  }

  /**
   * Fired when the server send succesfull returns from the server. The 
   * argument contains the data as send from the server. The implementing class 
   * must call this method to pass the results to the {@link DataHandler} class.
   * 
   * @param data Data send from the server
   */
  protected void fireOnSend(Object data) {
    dataHandlers.onSend(data);
  }
 
  /**
   * Removes the data handler to the list of data handlers.
   * 
   * @param handler The handler to remove
   */
  public void removeDataHandler(DataHandler dh) {
    if (null != dataHandlers) {
      dataHandlers.remove(dh);
    }
  }
}
