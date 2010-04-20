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

import com.google.gwt.dom.client.DivElement;

/**
 * Class that implements browser generic specific code for the Button widget
 * that possible should not be in certain other browser implementations.
 */
public class ButtonImpl {

  public void outer(DivElement outer) {
    CSS.setInlineBlock(outer);
  }

  public void inner(DivElement inner) {
    CSS.setInlineBlock(inner);
    //float added for Firefox 2.0 to correct inline block problems.
    CSS.setProperty(inner, CSS.A.FLOAT, CSS.V.FLOAT.LEFT);
  }

  public void buttonTop(DivElement buttonTop) {}

  public void correctMargin(DivElement inner, boolean leftBorder, boolean set) {
  }
}
