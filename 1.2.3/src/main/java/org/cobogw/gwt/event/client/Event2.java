/*
 * Copyright 2009 Hilbrand Bouwkamp, hs@bouwkamp.com
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
package org.cobogw.gwt.event.client;

import org.cobogw.gwt.event.client.impl.EventImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;

/**
 * Class with additional native method implementing browser specific code
 * related to Events. 
 */
public class Event2 {

  private static final EventImpl impl = GWT.create(EventImpl.class);

  /**
   * Programmatically fire a click event, as if the user clicked on the element.
   *
   * @param element Element to fire click event on
   */
  public static void fireClickEvent(Element element) {
    impl.fireClickEvent(element);
  }
}
