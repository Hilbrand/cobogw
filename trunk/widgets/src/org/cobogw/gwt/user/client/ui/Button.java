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

import org.cobogw.gwt.event.client.Event2;
import org.cobogw.gwt.user.client.CSS;
import org.cobogw.gwt.user.client.Color;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Accessibility;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.KeyboardListener;

/**
 * A push-button widget build with div elements using only CSS to create
 * shading effects. Uses the same interface as
 * {@link com.google.gwt.user.client.ui.Button} (Except for the wrap method).
 * The button is based on the technique used in several Google&trade;
 * applications and described on the web site stopdesign.com.
 *
 * <h2>Usage requirements:</h2>
 * <p>To be able to correctly use this Widget in different browsers the
 * following two requirements must be met.
 * <ol>
 * <li>A <code>DOCTYPE</code> must be set at the top of the HTML page, otherwise
 * the coloring will not work correctly in Internet Explorer.</li>
 * <li>For the best user experience in Opera add the following CSS to the main
 * style sheet. Unfortunally there is no way to set this via JavaScript. The CSS
 * code is needed to override the Opera effect that an element when it gets
 * focus will get a different background color. This CSS will remove that
 * background color, but won't affect any of the other widgets.</li>
 * <pre>
 * .cbg-ButtonContent::selection {
 *     background-color:transparent;
 * }
 * </pre>
 * </ol>
 *
 * <h2>Difference with HTML button element</h2>
 * <p>While this widget tries to act as much as a button there are still
 * difference between this widget and a HTML <code>button</code> element as
 * used in the gwt {@link com.google.gwt.user.client.ui.Button} widget.
 * <ol>
 * <li>Access Key: This widget doesn't support the <code>accessKey</code>
 * attribute. This attribute is only supported on <code>input</code> elements
 * and can't be added to other elements.</li>
 * <li>HTML form support: A <code>button</code> element has a <code>type</code>
 * attribute. When this attribute has the value <code>submit</code> or
 * <code>reset</code> they get specific functionality that operates on a HTML
 * <code>form</code> element. This widget doesn't support such functionality. To
 * get the similar behavior a {@link ClickListener} could be used.
 * </ol>
 *
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.cbg-Button { }</li>
 * <li>.cbg-ButtonOuter { }</li>
 * <li>.cbg-ButtonInner { }</li>
 * <li>.cbg-ButtonTop { }</li>
 * <li>.cbg-ButtonContent { }</li>
 * <li>.cbg-active { }</li>
 * <li>.cbg-disabled { }</li>
 * <li>.cbg-focus { }</li>
 * <li>.cbg-hover { }</li>
 * </ul>
 *
 * @see http://stopdesign.com/archive/2009/02/04/recreating-the-button.html
 */
public class Button extends FocusWidget implements HasHTML {

  //class style names.
  public static String CBG_BUTTON = "cbg-Button";
  public static String CBG_BUTTON_OUTER = "cbg-ButtonOuter";
  public static String CBG_BUTTON_INNER = "cbg-ButtonInner";
  public static String CBG_BUTTON_TOP = "cbg-ButtonTop";
  public static String CBG_BUTTON_CONTENT = "cbg-ButtonContent";

  public static String CBG_ACTIVE = "cbg-active";
  public static String CBG_DISABLED = "cbg-disabled";
  public static String CBG_FOCUS = "cbg-focus";
  public static String CBG_HOVER = "cbg-hover";

  // Div member variables
  private final DivElement outer;
  private final DivElement inner;
  private final DivElement buttonTop;
  private final DivElement buttonContent;

  // Color member variables
  protected String colorBorderFocus;
  protected String colorBorderHover;
  protected String colorBorder = "";
  protected String colorBorderLeft;
  protected String colorBorderRight;
  protected String colorContentTop;
  protected String colorContentMid;
  protected String colorContentBottom;
  protected String colorDisabled;
  protected String colorText;
  protected String customColorDisabled;
  protected String customColorText;

  private boolean enabled = true;
  private int tabIndex = 0;
  private boolean hasFocus = false;
  private boolean active = false;

  /**
   * Creates a button with no caption.
   */
  public Button() {
    super(Document.get().createDivElement());
    sinkEvents(
        Event.ONCLICK|Event.FOCUSEVENTS|Event.MOUSEEVENTS|Event.KEYEVENTS);
    CSS.setInlineBlock(getElement());
    CSS.setProperty(this, CSS.A.OUTLINE, CSS.V.NONE);
    CSS.setPropertyPx(this, CSS.A.PADDING, 0);
    CSS.setProperty(this, CSS.A.POSITION, CSS.V.POSITION.RELATIVE);
    CSS.setProperty(this, CSS.A.TEXT_DECORATION, CSS.V.NONE);
    CSS.setProperty(this, CSS.A.VERTICAL_ALIGN,
        CSS.V.VERTICAL_ALIGN.MIDDLE);
    CSS.setSelectable(getElement(), false);
    setStyleName(CBG_BUTTON);
    Accessibility.setRole(getElement(), Accessibility.ROLE_BUTTON);
    //outer
    outer = Document.get().createDivElement();
    getElement().appendChild(outer);
    setStyleName(outer, CBG_BUTTON_OUTER);
    CSS.setProperty(outer, CSS.A.BORDER_STYLE, CSS.V.BORDER_STYLE.SOLID);
    CSS.setProperty(outer, CSS.A.BORDER_WIDTH, "1px 0");
    CSS.setInlineBlock(outer);
    CSS.setPropertyPx(outer, CSS.A.LINE_HEIGHT, 0);
    CSS.setPropertyPx(outer, CSS.A.MARGIN, 0);
    CSS.setPropertyPx(outer, CSS.A.PADDING, 0);
    CSS.setProperty(outer, CSS.A.POSITION, CSS.V.POSITION.RELATIVE);
    CSS.setSelectable(outer, false);
    inner = Document.get().createDivElement();
    //inner
    outer.appendChild(inner);
    setStyleName(inner, CBG_BUTTON_INNER);
    CSS.setProperty(inner, CSS.A.DISPLAY, CSS.V.DISPLAY.INLINE_BLOCK);
    CSS.setProperty(inner, CSS.A.BORDER_STYLE, CSS.V.BORDER_STYLE.SOLID);
    CSS.setProperty(inner, CSS.A.BORDER_WIDTH, "0 1px");
    CSS.setProperty(inner, CSS.A.LINE_HEIGHT, CSS.V.LINE_HEIGHT.NORMAL);
    CSS.setProperty(inner, CSS.A.MARGIN, "0 -1px");
    CSS.setProperty(inner, CSS.A.POSITION, CSS.V.POSITION.RELATIVE);
    CSS.setSelectable(inner, false);
    /* The following div was in the original design, but could be omitted
     * without negative consequences on the layout as far as known.
      button = Document.get().createDivElement();
      inner.appendChild(button);
      CSS.setProperty(button, CSS.A.HEIGHT, "100%");
      CSS.setProperty(button, CSS.A.POSITION, CSS.V.POSITION.RELATIVE);
    */
    //buttonTop
    buttonTop = Document.get().createDivElement();
    inner.appendChild(buttonTop);
    setStyleName(buttonTop, CBG_BUTTON_TOP);
    CSS.setProperty(
        buttonTop, CSS.A.BORDER_BOTTOM_STYLE, CSS.V.BORDER_STYLE.SOLID);
    CSS.setPropertyPx(buttonTop, CSS.A.LEFT, 0);
    CSS.setProperty(buttonTop, CSS.A.OVERFLOW, CSS.V.OVERFLOW.HIDDEN);
    CSS.setProperty(buttonTop, CSS.A.POSITION, CSS.V.POSITION.ABSOLUTE);
    CSS.setPropertyPx(buttonTop, CSS.A.RIGHT, 0);
    CSS.setPropertyPx(buttonTop, CSS.A.TOP, 0);
    //buttonContent
    buttonContent = Document.get().createDivElement();
    inner.appendChild(buttonContent);
    setStyleName(buttonContent, CBG_BUTTON_CONTENT);
    CSS.setProperty(buttonContent, CSS.A.POSITION, CSS.V.POSITION.RELATIVE);
    CSS.setProperty(buttonContent, CSS.A.TEXT_ALIGN, CSS.V.TEXT_ALIGN.CENTER);
    CSS.setProperty(
        buttonContent, CSS.A.VERTICAL_ALIGN, CSS.V.VERTICAL_ALIGN.MIDDLE);
    CSS.setProperty(buttonContent, CSS.A.WHITE_SPACE, CSS.V.WHITE_SPACE.NOWRAP);
    CSS.setSelectable(buttonContent, false);
    setEnabled(true);
    setSize(70);
    setSizeRatio(1, 8);
    CSS.setProperty(this, CSS.A.FONT_FAMILY, "Arial, Helvetica, sans-serif");
    setColor(0, 0);
  }

  /**
   * Creates a button with the given HTML caption.
   *
   * @param html the HTML caption
   */
  public Button(String html) {
    this();
    setHTML(html);
    setTitle(html);
  }

  /**
   * Creates a button with the given HTML caption and click listener.
   *
   * @param html the HTML caption
   * @param listener the click listener
   */
  public Button(String html, ClickListener listener) {
    this(html);
    addClickListener(listener);
  }

  /**
   * Programmatic equivalent of the user clicking the button.
   */
  public void click() {
    Event2.fireClickEvent(getElement());
  }

  /**
   * Returns the text of the button as HTML.
   *
   * @return text of the button as HTML
   */
  public String getHTML() {
    return buttonContent.getInnerHTML();
  }

  /**
   * Returns the text of the button as plain text.
   *
   * @return text of the button as plain text
   */
  public String getText() {
    return buttonContent.getInnerText();
  }

  /**
   * Gets whether this widget is enabled.
   *
   * @return <code>true</code> if the widget is enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public void onBrowserEvent(Event event) {
    if (!enabled) {
      DOM.eventPreventDefault(event);
      return;
    }
    switch (DOM.eventGetType(event)) {
      case Event.ONCLICK:
        onActive(false);
        break;
      case Event.ONBLUR:
        onFocus(false);
        break;
      case Event.ONFOCUS:
        onFocus(true);
        break;
      case Event.ONKEYDOWN:
        final int kd = event.getKeyCode();
        if (kd == 32 /*spacebar*/ || kd == KeyboardListener.KEY_ENTER) {
          onActive(true);
        }
        break;
      case Event.ONKEYUP:
        final int ku = event.getKeyCode();
        if (ku == 32 /*spacebar*/ || ku == KeyboardListener.KEY_ENTER) {
          click();
        }
        onActive(false);
        break;
      case Event.ONMOUSEUP:
        onActive(false);
        break;
      case Event.ONMOUSEDOWN:
        if (Event.BUTTON_LEFT == event.getButton()) {
          setFocus(true); // also set focus when clicked with mouse
          onActive(true);
        } else {
          DOM.eventPreventDefault(event);
          return;
        }
        break;
      case Event.ONMOUSEOVER:
        onHover(true);
        break;
      case Event.ONMOUSEOUT:
        // on mouse out remove all styles, except focus
        onHover(false);
        onActive(false);
        break;
    }
    super.onBrowserEvent(event);
  }

  /**
   * @deprecated Unfortunally the attribute <code>accessKey</code> only works on
   * certain HTML elements. It's not supported on div elements as used in this
   * implementation. Therefore setting an access key has no effect. This method
   * has been added to provide interface compatibility with the
   * {@link com.google.gwt.user.client.ui.Button} class and made deprecated to
   * indicate it should not be used.
   */
  @Override
  @Deprecated
  public void setAccessKey(char key) {
    super.setAccessKey(key);
  }

  /**
   * Sets the color of the Button using hue and saturation. The specific effect
   * of shading is created using a fixed set of brightness parameters to
   * calculate the rgb values from hue, saturation and brightness.
   *
   * <p>The text color is based on the saturation level. If it's higher then
   * 50 the text color will be white, otherwise it will be black. The color for
   * the text of a disabled button is similarly created, but also uses the hue.
   * If the calculated text colors need to be different they can be overridden
   * with the method {@link #setColorText(String, String)}.
   *
   * @param hue the hue component of the color, between 0-359
   * @param saturation the saturation component of the color, between 0-100
   */
  public void setColor(int hue, int saturation) {
    // Arbitrary factor applied to brightness to get better coloring.
    final int satof = (int) ((float)saturation * 0.03 /*=8.0/255*/);
    // numbers in comment represent a brightness range of 0-255 as used in
    // the Firefox color picker add-on.
    colorBorderFocus =
        Color.HSBtoRGB(hue, saturation, 27/*68*/-satof).toRGBString();
    colorBorderHover =
        Color.HSBtoRGB(hue, saturation, 58/*147*/-satof).toRGBString();
    colorBorder =
        Color.HSBtoRGB(hue, saturation, 74/*187*/-satof).toRGBString();
    colorContentTop =
        Color.HSBtoRGB(hue, saturation, 98/*249*/-satof).toHexString();
    colorContentMid =
        Color.HSBtoRGB(hue, saturation, 93/*238*/-3/*7*/*satof).toRGBString();
    colorContentBottom =
        Color.HSBtoRGB(hue, saturation, 89/*227*/-6/*16*/*satof).toRGBString();
    CSS.setProperty(outer, CSS.A.BORDER_COLOR, colorBorder);
    CSS.setProperty(inner, CSS.A.BORDER_COLOR, colorBorder);
    if (colorBorderLeft != null) {
      CSS.setProperty(inner, CSS.A.BORDER_LEFT_COLOR, colorBorderLeft);
    }
    if (colorBorderRight != null) {
      colorBorderRight = colorBorder;
    }
    CSS.setProperty(buttonTop, CSS.A.BORDER_BOTTOM_COLOR, colorContentMid);
    setColorActive(false);
    final boolean sg = saturation > 50/*127*/;
    colorText =  sg ? Color.WHITE : Color.BLACK;
    colorDisabled =
        Color.HSBtoRGB(hue, sg ? saturation / 2: saturation,
            sg ? 94/*240*/ : 53/*136*/).toRGBString();
    if (customColorText == null) {
      setColorText();
    }
  }

  /**
   * Set the color of the font and the color of the font when the button is
   * disabled. This method can be used to set an alternative font color, in case
   * the default font color's are not as desired. The default font color is
   * black and default disabled font color is #888888. When a custom color is
   * set via {@link #setColor(int, int)} the font color is white and the
   * disabled color will depend on the hue and saturation used.
   *
   * @param colorText Color of the text
   * @param colorDisabled Color of the text when the button is disabled
   */
  public void setColorText(String colorText, String colorDisabled) {
    customColorText = colorText;
    customColorDisabled = colorDisabled;
    setColorText();
  }

  /**
   * Enable or disable the button.
   *
   * @param enabled <code>true</code> to enable the widget, <code>false</code>
   *                to disable it
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
    setStyleName(getElement(), CBG_DISABLED, !enabled);
    CSS.setProperty(this, CSS.A.CURSOR,
        enabled ? CSS.V.CURSOR.POINTER : CSS.V.CURSOR.DEFAULT);
    setTabIndex(enabled ? tabIndex : -1);
    setColorText();
    if (enabled) {
      Accessibility.removeState(getElement(), "aria-disabled");
    } else {
      Accessibility.setState(getElement(), "aria-disabled", "true");
    }
  }

  /**
   * Set's the button text as HTML.
   *
   * @param html The button text as HTML
   */
  public void setHTML(String html) {
    buttonContent.setInnerHTML(html);
  };

  /**
   * Sets the size of the font, implicitly sets the size of the button, because
   * the button scales accordingly. The default size is 70% of the derived font
   * size of the button. In practice this means the button is sized relatively
   * to the general font size used.
   *
   * @param precentage Size of font in percentage.
   */
  public void setSize(int precentage) {
    CSS.setProperty(this, CSS.A.FONT_SIZE, precentage + "%");
  }

  /**
   * Sets the ratio between the button size and the font size. The ratio is
   * applied to the height of elements and the calculated ratio's are set in
   * <code>em</code> on the elements. The padding is applied to the left and
   * right padding of the <code>div</code> containing the text and is specified
   * in <code>px</code>.
   *
   * @param ratio Ratio between button size and font size
   * @param padding Padding left and right side of text in <code>px</code> 
   */
  public void setSizeRatio(double ratio, int padding) {
    CSS.setProperty(buttonTop, CSS.A.BORDER_BOTTOM_WIDTH, ratio * 0.2 + "em");
    CSS.setProperty(buttonTop, CSS.A.HEIGHT, ratio * 0.9 + "em");
    CSS.setProperty(buttonContent, CSS.A.PADDING, "0 " + padding + "px");
    CSS.setProperty(buttonContent, CSS.A.LINE_HEIGHT, ratio*1.8 + "em");
  }

  @Override
  public void setTabIndex(int index) {
    tabIndex = index;
    super.setTabIndex(index);
  }

  /**
   * Set's the button text as plain text.
   *
   * @param text The button text as plain text
   */
  public void setText(String text) {
    buttonContent.setInnerText(text);
  }

  /**
   * Set the button style in active state if <code>true</code> or
   * remove the style when <code>false</code>. During the active state the
   * button the CSS class name <code>cbg-active</code> is applied.
   *
   * @param active Set button in active state if <code>true</code>
   */
  protected void onActive(boolean active) {
    if (!this.active || !active) {
      setStyleName(getElement(), CBG_ACTIVE, active);
      setColorActive(active);
      Accessibility.setState(getElement(), "aria-pressed",
          active ? "true" : "false");
      this.active = active;
    }
  }

  /**
   * Set the button in focus state if focus is <code>true</code>.During the
   * focus state the button the CSS class name <code>cbg-focus</code> is
   * applied.
   *
   * @param focus Set button in focus state if <code>true</code>
   */
  protected void onFocus(boolean focus) {
    hasFocus = focus;
    onFocus(focus, CBG_FOCUS, colorBorderFocus);
  }

  /**
   * Set the button in hover state if hover is <code>true</code>, but only if
   * the button doesn't have focus, in that case the focus style applied
   * overrides the hover style. If hover state is enabled the button the CSS
   * class name <code>cbg-hover</code> is applied.
   *
   * @param hover Set button in hover state if <code>true</code>
   */
  protected void onHover(boolean hover) {
    if (!hasFocus) {
      onFocus(hover, CBG_HOVER, colorBorderHover);
    }
  }

  /**
   * Helper method specific for {@link ButtonBar} to set style properties on
   * the left and/or right border of a button when this button is placed within
   * a {@link ButtonBar}.
   *
   * @param set <code>true</code> if border style properties must be set,
   *        <code>false</code> if they must be removed.
   * @param leftBorder <code>true</code> if the style settings must apply to the
   *        left border, <code>false</code> if they must apply to the right
   *        border
   */
  void setInnerBorderColor(boolean set, boolean leftBorder) {
    if (leftBorder) {
      colorBorderLeft = set ? Color.WHITE : null;
      CSS.setProperty(inner, CSS.A.BORDER_LEFT_COLOR,
          set ? colorBorderLeft : colorBorder);
    } else {
      colorBorderRight = set ? colorBorder : null;
    }
    CSS.setPropertyPx(inner,
        leftBorder ? CSS.A.MARGIN_LEFT : CSS.A.MARGIN_RIGHT, set ? 0 : -1);
  }

  /**
   * Helper method for {@link #onFocus(boolean)} and {@link #onHover(boolean)}.
   *
   * @param set <code>true</code> if effect must be set, <code>false</code>
   *               if it must be removed.
   * @param style Name of the style class
   * @param color Color of the border when enabled.
   */
  private void onFocus(boolean set, String style, String color) {
    setStyleName(getElement(), style, set);
    CSS.setProperty(outer, CSS.A.BORDER_COLOR, set ? color : colorBorder);
    CSS.setProperty(inner, CSS.A.BORDER_COLOR, set ? color : colorBorder);
    if (colorBorderLeft != null) {
      CSS.setProperty(inner, CSS.A.BORDER_LEFT_COLOR, colorBorderLeft);
    }
    if (colorBorderRight != null) {
      CSS.setProperty(inner, CSS.A.BORDER_RIGHT_COLOR, colorBorderRight);
    }
    if (!set) {
      onActive(false);
    }
  }

  /**
   * Set the background color when the user activates the button.
   *
   * @param active When the button is select call with <code>true</code>
   *                 otherwise call with <code>false</code>
   */
  private void setColorActive(boolean active) {
    CSS.setProperty(buttonTop, CSS.A.BACKGROUND_COLOR,
        active ? colorContentBottom : colorContentTop);
    CSS.setProperty(inner, CSS.A.BACKGROUND_COLOR,
        active ? colorContentTop : colorContentBottom);
  }

  /**
   * Sets the color on the text. If a custom color set defined via
   * {@link #setColor(int, int)}, this color is used, else the default color is
   * set. The default color is black, or if the saturation is > 50% it's white.
   */
  private void setColorText() {
    if (customColorText != null) {
      CSS.setProperty(buttonContent, CSS.A.COLOR,
              enabled ? customColorText : customColorDisabled);
    } else {
      CSS.setProperty(buttonContent, CSS.A.COLOR,
              enabled ? colorText : colorDisabled);
    }
  }
}
