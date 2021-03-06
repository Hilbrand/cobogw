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
package org.cobogw.gwt.user.client.ui;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.InlineHTML;

/**
 * A widget that contains arbitrary text, <i>not</i> interpreted as HTML. Acts
 * as a Label, except it uses a <code>span</code> tag instead of a <code>div
 * </code> tag to wrap the text in.
 *
 * With GWT 1.6.4 a new widget {@link InlineHTML} was introduced. That widget is
 * almost identical to this widget, with these exceptions: This widgets sinks
 * the ONCLICK, and MOUSEVENTS and has an extra constructor to set wrapping. 
 *
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.cbg-Span { }</li>
 * </ul>
 *
 */
public class Span extends InlineHTML {

  /**
   * Creates an empty span.
   */
  public Span() {
    super();
    sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS | Event.ONMOUSEWHEEL);
    setStyleName("cbg-Span");
  }

  /**
   * Creates a span with the specified text.
   *
   * @param text the new label's text
   */
  public Span(String text) {
    this();
    setText(text);
  }

  /**
   * Creates a span with the specified text.
   *
   * @param text the new span's text
   * @param wordWrap <code>false</code> to disable word wrapping
   */
  public Span(String text, boolean wordWrap) {
    this(text);
    setWordWrap(wordWrap);
  }
}
