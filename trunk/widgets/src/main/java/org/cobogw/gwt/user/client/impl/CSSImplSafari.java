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
package org.cobogw.gwt.user.client.impl;

import com.google.gwt.dom.client.Element;

public class CSSImplSafari extends CSSImpl {
  /**
   * Make an element unselectable by the user. Safari implementation.
   *
   * <p>Available in Safari 2.0 and later. Property is called
   * <code>-webkit-user-select</code> in Safari 3.0 and later and 
   * <code>-khtml-user-select</code> in Safari 2.0.
   * 
   * @see <a href="http://developer.apple.com/documentation/appleapplications/Reference/SafariCSSRef/Articles/StandardCSSProperties.html#//apple_ref/doc/uid/TP30001266--webkit-user-select">http://developer.apple.com/documentation/appleapplications/Reference/SafariCSSRef/Articles/StandardCSSProperties.html#//apple_ref/doc/uid/TP30001266--webkit-user-select</a>
   */
  @Override
  public void setSelectable(Element e, boolean selectable) {
    e.getStyle().setProperty("KhtmlUserSelect", selectable ? "" : "none");
    e.getStyle().setProperty("WebkitUserSelect", selectable ? "" : "none");
  }
}
