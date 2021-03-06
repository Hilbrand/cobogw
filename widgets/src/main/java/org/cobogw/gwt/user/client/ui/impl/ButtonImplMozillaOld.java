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

import com.google.gwt.dom.client.DivElement;

/**
 * Class that implements Mozilla before gecko 1.8 (used in Firefox 2.0) browser
 * specific code for the Button widget.
 */
public class ButtonImplMozillaOld extends ButtonImpl {

  @Override
  public void outer(DivElement outer) {
    //The inline block should not be set, only on top level element of Button
  }

  @Override
  public void inner(DivElement inner) {
    //The inline block should not be set, only on top level element of Button
  }
}
