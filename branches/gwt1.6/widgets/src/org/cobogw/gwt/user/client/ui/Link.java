/*
 * Copyright 2007-2008 Hilbrand Bouwkamp, hs@bouwkamp.com
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

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;

/**
 * A standard HTML anchor widget. Use this class to create links to external
 * web pages only. For a link within the GWT application use {@link Hyperlink}
 * or use the event mechanism.
 *
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.cbg-Link { }</li>
 * </ul>
 */
public class Link extends Widget {

  /**
   * Creates an empty anchor.
   */
  public Link() {
    setElement(Document.get().createAnchorElement());
    setStyleName("cbg-Link");
  }

  /**
   * Creates an anchor with <code>href</code> and <code>text</code> set.
   *
   * @param url value of href attribute
   * @param text innerText value
   */
  public Link(String url, String text) {
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
    getElement().<AnchorElement>cast().setTarget(target);
  }

  /**
   * Sets the innterText of the anchor.
   *
   * @param text innerText value
   */
  public void setText(String text) {
    getElement().<AnchorElement>cast().setInnerText(text);
  }

  /**
   * Sets the <code>href</code> attribute.
   *
   * @param url value of href attribute
   */
  public void setUrl(String url) {
    getElement().<AnchorElement>cast().setHref(url);
  }
}
