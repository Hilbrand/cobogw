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
 * Internet Explorer 6, 7 and 8 implementation of
 * {@link org.cobogw.gwt.user.client.impl.CSSImpl}.
 */
public class CSSImplIE6 extends CSSImpl {

  public final static float documentMode = documentMode();
//  private final static float ieVersion = detectIEVersion();
//  private final static boolean inQuiksMode = inQuirksMode();
//  private final static boolean isTridentEngine = isTridentEngine();

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

  public static native boolean inQuirksMode() /*-{
    return $doc.compatMode == 'BackCompat';
  }-*/;
  
  //Trident is the IE 8 JavaScript Engine.
  private static native boolean isTridentEngine() /*-{
    return navigator.userAgent.indexOf("Trident") != -1;
  }-*/;
  
  /**
   * From http://www.howtocreate.co.uk/emails/AlexeiWhite.html:
   * The document.documentMode property gives the version mode it is operating
   * in (currently 5, 7 or 8). This is a floating point number and will increase
   * for new versions, perhaps 8.5 or 9 or 10.35 etc. It is a new property in IE
   * 8, so you can use it to see if it is IE 8+ in IE 7 mode, but it will not be
   * possible to use its existence to check for IE 9 operating in IE 8 mode. It
   * would be more useful if there were some property like document.maximumMode
   * so you could see if it is really version 9 in version 8 mode, but I guess
   * we will have to wait and see what new stuff appears in IE 9.
   * 
   * Note that this property is non-standard, so it will not exist at all in
   * other browsers, and it is very important that you do not display silly
   * messages in other browsers because it does now exist and is therefore
   * smaller than 8.
   * 
   * @return Returns the documentMode
   * @see http://www.howtocreate.co.uk/emails/AlexeiWhite.html
   */
  private static native float documentMode() /*-{
    return $doc.documentMode || 5.0;
  }-*/;

  @Override
  public String getFloatAttribute() {
    return "styleFloat";
  }
  
  /**
   * This method takes care of the browser specific implementation requirements
   * for the property value 'inline-block' of the property 'display'.
   * 
   * For Internet Explorer 8 running in IE8 Standards mode the inline-block
   * problem has been fixed. For that version the method simply sets
   * <code>display</code> to <code>inline-block</code>. To detect what mode of
   * IE* is running the <code>document.documentMode</code> is queried. When
   * running in Quirks Mode this is not set and only for IE8 and IE8
   * Compatibility View when running in IE 8 Standards mode it return 8. These
   * are also the only conditions in which we want the inline-block. 
   *
   * @see http://www.brunildo.org/test/InlineBlockLayout.html
   * @see http://www.tanfa.co.uk/archives/show.asp?var=300
   * @see http://www.brunildo.org/test/inline-block.html
   *
   * @param element Element to set the display property inline-block on
   */
  @Override
  public void setInlineBlock(Element element) {
    if (documentMode >= 8) {
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
