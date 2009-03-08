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

public class CSSImplMozilla extends CSSImpl {

  @Override
  public void setInlineBlock(Element element) {
    if (detectFirefoxVersion() >= 3) {
      element.getStyle().setProperty("display", "inline-block");
    } else {
      element.getStyle().setProperty("display", "-moz-inline-box");
    }
  }

  @Override
  public void setSelectable(Element e, boolean selectable) {
    e.getStyle().setProperty("MozUserSelect", selectable ? "" : "none");
  }

  /**
   * Returns the version of Internet Explorer
   *
   * @return Version of Internet Explorer
   */
  private native float detectFirefoxVersion() /*-{
    var index = navigator.userAgent.indexOf("Firefox") + 8;
    if (index == -1) return 3.0;
    return parseFloat(navigator.userAgent.substring(index));
  }-*/;
}