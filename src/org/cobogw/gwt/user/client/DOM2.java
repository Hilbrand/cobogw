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
package org.cobogw.gwt.user.client;

import com.google.gwt.user.client.Element;

/**
 * This class provides a set of static methods that are an addition to the DOM
 * manipulation methods from the {@link com.google.gwt.user.client.DOM} class.
 */
public class DOM2 {

  /**
   * This method disables the event to select the element.
   *
   * @param element the element on which selection will be disabled
   */
  public static native void disableSelection(Element element) /*-{
    try {
       element.onselectstart = function() {
         return false;
       };
       element.unselectable = 'on';
       element.style.MozUserSelect = 'none';
     } catch (e) {
       // ignore error on other browsers
     }
  }-*/;

  /**
   * This method reloads the current whole GWT web application. This method
   * can be used to reload all in case some global settings are changed.
   */
  public static native void reload()  /*-{
    $win.location.reload(true);
  }-*/;
}
