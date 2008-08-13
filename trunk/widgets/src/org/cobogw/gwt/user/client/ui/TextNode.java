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

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * This class creates a DOM TextNode as a Widget. This is useful to simple add 
 * text with minimal overhead. A {@link Label} class will wrap the text in a 
 * <code>div</code>, which displays as a <code>block</code>.  
 *
 * <p>This class doesn't have any eventListeners attached because a 
 * <code>TextNode</code> tag doesn't support this. For this reason all methods
 * overwritten were needed to remove the eventListeners from the super 
 * {@link Widget} class.
 */
public class TextNode extends Widget {

  /**
   * The attached state is locally maintained to trick the super class 
   * {@link Widget} to think it is not attached when it accesses it's own 
   * private field attached when it sets EventListeners and no EventListener
   * will be set.  
   */
  private boolean attached;

  /**
   * Creates a new TextNode with the text assigned.
   * 
   * @param text Text to be assigned to the TextNode
   */
  public TextNode(String text) {
    setElement(Document.get().createTextNode(text).<Element>cast());
  }

  /**
   * Determines whether this widget is currently attached to the browser's
   * document (i.e., there is an unbroken chain of widgets between this widget
   * and the underlying browser document).
   * 
   * @return <code>true</code> if the widget is attached
   */
  @Override
  public boolean isAttached() {
    return attached;
  }

  /**
   * This method is called when a widget is attached to the browser's document.
   * To receive notification after a Widget has been added from the
   * document, override the {@link #onLoad} method.
   * 
   * <p>
   * Subclasses that override this method must call
   * <code>super.onAttach()</code> to ensure that the Widget has been
   * attached to the underlying Element.
   * </p>
   * 
   * @throws IllegalStateException if this widget is already attached
   */
  @Override
  protected void onAttach() {
    if (isAttached()) {
      throw new IllegalStateException(
          "Should only call onAttach when the widget is detached from the browser's document");
    }

    attached = true;

    // Now that the widget is attached, call onLoad().
    onLoad();
  }

  /**
   * This method is called when a widget is detached from the browser's
   * document. To receive notification before a Widget is removed from the
   * document, override the {@link #onUnload} method.
   * 
   * <p>
   * Subclasses that override this method must call
   * <code>super.onDetach()</code> to ensure that the Widget has been
   * detached from the underlying Element.  Failure to do so will result
   * in application memory leaks due to circular references between DOM
   * Elements and JavaScript objects.
   * </p>
   * 
   * @throws IllegalStateException if this widget is already detached
   */
  @Override
  protected void onDetach() {
    if (!isAttached()) {
      throw new IllegalStateException(
          "Should only call onDetach when the widget is attached to the browser's document");
    }
    
    // Give the user a chance to clean up, but don't trust the code to not throw
    try {
      onUnload();
    } finally {
      attached = false;
    }
  }
}
