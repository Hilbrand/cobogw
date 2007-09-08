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

/**
 * Interface to extends DataHandlers with the ability to revert to the initial 
 * state and check if it still is in the initial state.
 */
public interface DataStateHandler {

  /**
   * Returns true if the current state, i.e. current selection or value of the
   * item matches the state equal to the requested state, which is the 
   * current state saved on the server. If the value was changed and later set
   * back to the requested state this method should return <code>true</code>.
   * 
   * @return <core>true</code> If the state matches the requested state
   */
  boolean isInitialState();

  /**
   * Sets the state back to the state as was requested from the sever.
   */
  void revert();
}
