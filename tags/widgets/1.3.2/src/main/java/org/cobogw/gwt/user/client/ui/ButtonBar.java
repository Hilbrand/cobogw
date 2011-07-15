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
package org.cobogw.gwt.user.client.ui;

import org.cobogw.gwt.user.client.CSS;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The ButtonBar is horizontal panel on which {@link Button} widgets can be
 * placed. When a {@link Button} is placed on the ButtonBar, depending on it's
 * position on the bar left and right border effects are applied to create a
 * aligned button effect. The ButtonBar is a {@link FlowPanel} that is set
 * to <code>display</code> as an <code>inline-block</code>. It is therefore also
 * possible to add non {@link Button} widgets to the ButtonBar. These widgets
 * also are set to <code>display</code> as an <code>inline-block</code> to keep
 * the horizontal state.
 *
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.cbg-ButtonBar { }</li>
 * <li>.cbg-BCLeft { }</li>
 * <li>.cbg-BCRight { }</li>
 * </ul>
 */
public class ButtonBar extends FlowPanel {

  //class style names.
  public static final String CBG_BUTTON_BAR = "cbg-ButtonBar";
  public static final String CBG_BUTTON_COLLAPSE_LEFT = "cbg-BCLeft";
  public static final String CBG_BUTTON_COLLAPSE_RIGHT = "cbg-BCRight";

  /**
   * Creates a new empty ButtonBar.
   */
  public ButtonBar() {
    super();
    CSS.setInlineBlock(getElement());
    setStyleName(CBG_BUTTON_BAR);
  }

  /**
   * Adds a new {@link Button} to the panel.
   *
   * @param button the Button to added
   */
  public void add(Button button) {
    super.add(button);
    final int wc = getWidgetCount();

    if (wc > 1) {
      button.setInnerBorderColor(true, true);
      setStyleName(button.getElement(), CBG_BUTTON_COLLAPSE_LEFT, true);
      final Widget left = getWidget(wc-2);

      if (left instanceof Button) {
        ((Button) left).setInnerBorderColor(true, false);
      }
      setStyleName(left.getElement(), CBG_BUTTON_COLLAPSE_RIGHT, true);
    }
  }

  /**
   * Adds a new child widget to the panel and set it to <code>display</code>
   * as <code>inline-block</code>.
   *
   * @param w the widget to be added
   */
  @Override
  public void add(Widget w) {
    super.add(w);
    CSS.setInlineBlock(w.getElement());
  }

  @Override
  public boolean remove(int index) {
    final boolean present = super.remove(index);

    if (present) {
      final int cnt = getWidgetCount();

      if (cnt > 0) {
        if (index == 0) {
          // correct the new first button, since the first was removed.
          final Widget right = getWidget(0);

          if (right instanceof Button) {
            ((Button) right).setInnerBorderColor(false, true);
          }
          setStyleName(right.getElement(), CBG_BUTTON_COLLAPSE_LEFT, false);
          setStyleName(right.getElement(), CBG_BUTTON_COLLAPSE_RIGHT, false);
        } else if (index == cnt) {
          // correct the new last button, since the last button was removed.
          final Widget left = getWidget(index-1);

          if (left instanceof Button) {
            ((Button) left).setInnerBorderColor(false, false);
          }
          setStyleName(left.getElement(), CBG_BUTTON_COLLAPSE_RIGHT, false);
        } // else button removed in between other buttons, so nothing to do
      }
    }
    return present;
  }
}
