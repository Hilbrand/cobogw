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

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * This class is an extended version of the {@link DeferredCommand} class. This
 * class will show a {@link PopupPanel} for the duration of the
 * {@link Command#execute()} method. This will make it possible to provide
 * easy user interactive feedback. For example showing a popup displaying the
 * text 'Loading...'.
 *
 * <p>The class contains 2 addCommand methods. One that accepts a String and
 * creates a {@link PopupPanel} with this String. The second accepts a
 * {@link PopupPanel} and can be used to create a custom popup.
 *
 * <p>When using {@link #addCommand(Command, PopupPanel)} make sure the popup is
 * created with <code>autohide</code> set to <code>false</code> (This is default
 * , but can be set). Otherwise the popup will disappear when the user clicks
 * outside the popup.
 *
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.cbg-DeferredPopupCommand { }</li>
 * </ul>
 *
 * <p>The following CSS example will show a small dark red {@link PopupPanel} in
 * the upper right corner with white text:
 * <pre>
 * .cbg-DeferredPopupCommand {
 *   background-color : #DF4545;
 *   color            : white;
 *   padding          : 2px;
 *   margin-top       : 2px;
 *   right            : 0;
 *   top              : 0;
 * }
 * </pre>
 */
public class DeferredPopupCommand {
  PopupPanel popup;

  public DeferredPopupCommand() {
    this(true);
  }
  /**
   * 
   * @param modal <code>true</code> if keyboard or mouse events that do not
   *          target the PopupPanel or its children should be ignored
   */
  public DeferredPopupCommand(boolean modal) {
    this(new PopupPanel(false, modal));
  } 
  
  public DeferredPopupCommand(PopupPanel popup) {
    this.popup = popup;
    popup.setStyleName("cbg-DeferredPopupCommand");
  }
  
  /**
   * Enqueues a {@link Command} to be fired after all current events have been
   * handled and displays an optional modal {@link PopupPanel} during the time
   * the command is executed.
   *
   * @param cmd the command to be fired
   * @param text String to be displayed on the {@link PopupPanel} for the
   *           duration of the {@link Command#execute()} method
   */
  public void addCommand(final Command cmd, final String text) {

    popup.setWidget(new Label(text));
    DeferredPopupCommand.addCommand(cmd, popup);
  }

  /**
   * Enqueues a {@link Command} to be fired after all current events have been
   * handled and displays the {@link PopupPanel} during the time the command is
   * executed.
   *
   * @param cmd the command to be fired
   * @param popup {@link PopupPanel} to be displayed for the duration of the
   *          {@link Command#execute()} method
   */
  public static void addCommand(final Command cmd, final PopupPanel popup) {
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        cmd.execute();
        popup.hide();
      }
    });
    popup.show();
  }
}
