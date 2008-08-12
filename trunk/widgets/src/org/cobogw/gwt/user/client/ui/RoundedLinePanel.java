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
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;


/**
 * The RoundedLinePanel class adds rounded corners with a line around
 * the widget in a different color. The class can be used in the same way as
 * the {@link RoundedPanel} class.
 * 
 * Setting the color of the border.
 * This class extends the {@link #setCornerColor(String)} with two methods.
 * One to set border color and background color and one to set a different 
 * background color on the top and bottom div's. The latter method can be used
 * for widgets that have a heading in a different color.
 * 
 */
public class RoundedLinePanel extends RoundedPanel {

  /*
   * {@see RoundedPanel#RoundedPanel()} 
   */
  public RoundedLinePanel() {
    super();
  }

  /*
   * {@see RoundedPanel#RoundedPanel(int corners)} 
   */
  public RoundedLinePanel(int corners) {
    super(corners);
  }

  /*
   * {@see RoundedPanel#RoundedPanel(int corners, int cornerHeight)} 
   */
  public RoundedLinePanel(int corners, int cornerHeight) {
    super(corners, cornerHeight);
  }
  
  /*
   * {@see RoundedPanel#RoundedPanel(Widget w)} 
   */
  public RoundedLinePanel(Widget w) {
    super(w);
  }
  
  /*
   * {@see RoundedPanel#RoundedPanel(Widget w, int corners)} 
   */
  public RoundedLinePanel(Widget w, int corners) {
    super(w, corners);
  }

  /*
   * {@see RoundedPanel#RoundedPanel(Widget w, int corners, int cornerHeight)} 
   */
  public RoundedLinePanel(Widget w, int corners, int cornerHeight) {
    super(w, corners, cornerHeight);
  }
  
  /**
   * Set the attributes on the border div's to create a line on the corners
   * in a different color than the background. 
   * 
   * @param borderColor color of the border
   * @param inner background color of the border div's
   */
  public void setCornerColor(String borderColor, String inner) {
    setCornerColor(borderColor, inner, inner);
  }

  /**
   * Set the attributes on the border div's to create a line on the corners
   * in a different color than the background. The method takes 2 background 
   * colors which makes it possible to set a different background color on the
   * top and bottom.
   * 
   * @param borderColor color of the border
   * @param innerTop background color of the top div's
   * @param innerBottom background color of the bottom div's
   */
  public void setCornerColor(String borderColor, String innerTop, 
      String innerBottom) {
    setBorderContainer(borderColor, 1);
    if (null != divt[0]) {
      DOM.setStyleAttribute(divt[0], "backgroundColor", borderColor);
      for (int i = 1; i < cornerHeight; ++i) {
        setBorder(divt[i], corners & TOP, borderColor, innerTop);
      }
    }
    if (null != divb[0]) {
      DOM.setStyleAttribute(divb[0], "backgroundColor", borderColor);
      for (int i = 1; i < cornerHeight; ++i) {
        setBorder(divb[i], corners & BOTTOM, borderColor, innerBottom);
      }
    }
  }

  /**
   * Sets the border style attributes on the element. It can be used to set a
   * different color on the border and the element the border is added to.
   * 
   * @param elem element to set the style attributes
   * @param corners corners to set the style attributes
   * @param borderColor color of the border
   * @param backgroundColor backgroundColor of the element
   */
  protected void setBorder(Element elem, int corners, String borderColor, 
      String backgroundColor) {
    DOM.setStyleAttribute(elem, "backgroundColor", backgroundColor);
    setBorder(elem, corners, borderColor);
  }
}
