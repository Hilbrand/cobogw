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
package org.cobogw.gwt.user.client.impl;

import com.google.gwt.dom.client.Element;

/**
 * Internet Explorer 6 implementation of
 * {@link org.cobogw.gwt.user.client.impl.CSSImpl}.
 */
public class CSSImplIE6 extends CSSImpl {

  private final static float ieVersion = detectIEVersion();

  /**
   * Returns the version of Internet Explorer
   *
   * @return Version of Internet Explorer
   */
  private static native float detectIEVersion() /*-{
    var index = navigator.userAgent.indexOf("MSIE") + 5;
    if (index == -1) return 6.0; // assume IE 6 in this case
    return parseFloat(navigator.userAgent.substring(index));
  }-*/;

  @Override
  public String getFloatAttribute() {
    return "styleFloat";
  }
  /**
   * This method takes care of the browser specific implementation requirements
   * for the property value 'inline-block' of the property 'display'.
   * 
   * For Internet Explorer 8 running in IE8 mode the inline-block problem has
   * been fixed. For that version the method simply sets <code>display</code>
   * to <code>inline-block</code>.
   *
   * @see http://www.brunildo.org/test/InlineBlockLayout.html
   * @see http://www.tanfa.co.uk/archives/show.asp?var=300
   * @see http://www.brunildo.org/test/inline-block.html
   *
   * @param element Element to set the display property inline-block on
   */
  @Override
  public void setInlineBlock(Element element) {
    if (ieVersion >= 8) {
      element.getStyle().setProperty("display", "inline-block");
    } else {
      element.getStyle().setProperty("display", "inline");
      element.getStyle().setProperty("zoom", "1");
    }
  }

  @Override
  public void setOpacity(Element e, float opacity) {
    e.getStyle().setProperty("filter", "alpha(opacity=" + opacity*100 + ")");
  }

  @Override
  public void setSelectable(Element e, boolean selectable) {
    e.getStyle().setProperty("userSelect", selectable ? "" : "none");
    e.setPropertyString("unselectable", selectable ? "" : "on");
  }
}
