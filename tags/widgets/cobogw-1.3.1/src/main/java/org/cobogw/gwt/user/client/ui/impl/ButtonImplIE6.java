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
package org.cobogw.gwt.user.client.ui.impl;

import org.cobogw.gwt.user.client.CSS;
import org.cobogw.gwt.user.client.impl.CSSImplIE6;

import com.google.gwt.dom.client.DivElement;

/**
 * Class that implements IE browser specific code for the Button widget.
 */
public class ButtonImplIE6 extends ButtonImpl {

  @Override
  public void inner(DivElement inner) {
    CSS.setInlineBlock(inner);
    //Hack for IE Transitional mode to fix negative margin:
    if (CSSImplIE6.documentMode < 8 || CSSImplIE6.inQuirksMode()) {
      CSS.setPropertyPx(inner, CSS.A.LEFT, -1);
    }
    //Hack for IE6 strict mode to not overflow the buttonTop width, because
    //IE6 doesn't understand width 100% correctly.
    CSS.setProperty(inner, CSS.A.OVERFLOW, CSS.V.OVERFLOW.HIDDEN);
  }

  @Override
  public void buttonTop(DivElement buttonTop) {
    //Hack for IE6 and IE7 Transitional mode to give buttonTop correct width,
    //otherwise it will show the width of the content.:
    CSS.setProperty(buttonTop, CSS.A.WIDTH, "100%");
  }

  @Override
  public void correctMargin(DivElement inner, boolean leftBorder, boolean set) {
    if (leftBorder && (CSSImplIE6.documentMode < 8 || CSSImplIE6.inQuirksMode())) {
      CSS.setPropertyPx(inner, CSS.A.LEFT, set ? 0 : -1);
    }
  }
}
