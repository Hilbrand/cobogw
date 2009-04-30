/*
 * Copyright 2007-2009 Hilbrand Bouwkamp, hs@bouwkamp.com
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

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A helper class for implementers of the AsynCallback interface. This class
 * assumes that all objects added to it will be of type {@link AsyncCallback}.
 */
@SuppressWarnings("serial")
public class AsyncCallbackCollection<T> extends ArrayList<AsyncCallback<T>>
    implements AsyncCallback<T> {

  /**
   * Fires the {@link #onFailure(Throwable)} method to all listeners.
   */
  public void onFailure(Throwable caught) {
    for (Iterator<AsyncCallback<T>> it = iterator(); it.hasNext();) {
      AsyncCallback<T> acceptor = it.next();

      acceptor.onFailure(caught);
    }
  }

  /**
   * Fires the {@link #onSuccess(Object)} method to all listeners.
   */
  public void onSuccess(T result) {
    for (Iterator<AsyncCallback<T>> it = iterator(); it.hasNext();) {
      AsyncCallback<T> acceptor = it.next();

      acceptor.onSuccess(result);
    }
  }
}
