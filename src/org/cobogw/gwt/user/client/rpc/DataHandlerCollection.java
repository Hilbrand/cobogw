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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A helper class for implementers of the {@link DataHandler} interface.
 */
public class DataHandlerCollection extends ArrayList/* <DataEvent>*/ 
    implements DataHandler {

  /**
   * Fires the {@link DataHandler#onError(String) method to all listeners.
   */
  public void onError(String error) {
    for (Iterator/* <DataHandler>*/ it = iterator(); it.hasNext();) {
      DataHandler handler = (DataHandler) it.next();

      handler.onError(error);
    }
  }

  /**
   * Fires the {@link DataHandler#onRequested(DataEvent) method to all 
   * listeners.
   */
  public void onRequested(DataEvent data) {
    for (Iterator/* <DataHandler>*/ it = iterator(); it.hasNext();) {
      DataHandler handler = (DataHandler) it.next();

      handler.onRequested(data);
    }
  }

  /**
   * Fires the {@link DataHandler#onSend(Object) method to all listeners.
   */
  public void onSend(Object data) {
    for (Iterator/* <DataHandler>*/ it = iterator(); it.hasNext();) {
      DataHandler handler = (DataHandler) it.next();

      handler.onSend(data);
    }
  }
}
