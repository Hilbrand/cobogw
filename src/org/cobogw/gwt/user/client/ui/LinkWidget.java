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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;

/**
 * A standard HTML achor widget. Use this class to create links to external
 * web pages only. For a link within the GWT application use {@link Hyperlink}
 * or use the event mechanism.
 * 
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.cbg-Link { }</li>
 * </ul>
 */
public class LinkWidget extends Widget {

  /**
   * Creates an empty anchor.
   */
  public LinkWidget() {
    setElement(DOM.createAnchor());
    setStyleName("cbg-LinkWidget");
  }

  /**
   * Creates an anchor with <code>href</code> and <code>text</code> set.
   * 
   * @param url value of href attribute
   * @param text innerText value
   */
  public LinkWidget(String url, String text) {
    this();
    setUrl(url);
    setText(text);
  }

  /**
   * Sets the <code>target</code> attribute.
   * 
   * @param target anchor target, e.g. "new"
   */
  public void setTarget(String target) {
    DOM.setAttribute(getElement(), "target", target);
  }

  /**
   * Sets the innterText of the anchor.
   * 
   * @param text innerText value
   */
  public void setText(String text) {
    DOM.setInnerText(getElement(), text);
  }

  /**
   * Sets the <code>href</code> attribute.
   * 
   * @param url value of href attribute
   */
  public void setUrl(String url) {
    DOM.setAttribute(getElement(), "href", url);
  }  
}
