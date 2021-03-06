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

  private final static float geckoVersion = detectGeckoVersion();

  /**
   * Returns the version of Gecko. If this would fail version 1.9 (which
   * Corresponds with Firefox 3.0) is returned. The version number returned is
   * only one dot, thus 1.9, while the actual version number might be 1.9.0.7.
   *
   * @return Version of Gecko engine
   */
  private static native float detectGeckoVersion() /*-{
    var index = navigator.userAgent.indexOf("rv:") + 3;
    if (index == -1) return 1.9;
    return parseFloat(navigator.userAgent.substring(index));
  }-*/;

  /**
   * This method takes care of the browser specific implementation requirements
   * for the property value 'inline-block' of the property 'display'.
   *
   * In Firefox versions 2 and earlier (Gecko engine 1.8 and earlier) the
   * equivalent of the 'inline-block' is '-moz-inline-box'. This method sets
   * this value for those Firefox versions.
   *
   * GWT supports two user agents gecko1_8 (1.8 and later) and gecko (< 1.8).
   * However since the 'inline-block' has been supported after 1.8 we can't
   * use these user agent feature to generate the correct code.
   *
   * For gecko < 1.8 the '-moz-inline-box' works buggy. For example children of
   * a element with this property may not set it to, this will result in
   * broken layouts.
   *
   * @see <a href="http://reference.sitepoint.com/css/moz-inline-box">http://reference.sitepoint.com/css/moz-inline-box</a>
   */
  @Override
  public void setInlineBlock(Element e) {
    e.getStyle().setProperty("display",
        geckoVersion >= 1.9 ? "inline-block" : "-moz-inline-box");
  }

  @Override
  public void setSelectable(Element e, boolean selectable) {
    e.getStyle().setProperty("MozUserSelect", selectable ? "" : "none");
  }

}