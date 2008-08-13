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
package org.cobogw.gwt.user.client;

import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.IncrementalCommand;
import com.google.gwt.user.client.Timer;

/**
 * This class allows you to execute code a maximum number of times or less with 
 * a configurable delay between each execute, after all currently pending event 
 * handlers have completed, using the 
 * {@link #addCommand(IncrementalCommand, int, int)} method. This is useful when
 * you need to execute code outside of the context of the current stack and want
 * to limit the number of times the command is run.
 */
public class DeferredTimesCommand extends DeferredCommand {

  /**
   * Enqueues an {@link IncrementalCommand} to be fired after all current events
   * have been handled. The command is fired the number of <code>times</code>
   * specified or less if the <code>cmd.execute()</code> returns 
   * <code>false</code>.
   * 
   * @param cmd the command to be fired
   * @param times maximum number of times the command is executed
   * @param delayMillis time between execution in milliseconds
   */
  public static void addCommand(final IncrementalCommand cmd, final int times,
      final int delayMillis) {
    new Timer() {
      private int t = times; 

      public void run() {
        addCommand(new IncrementalCommand() {

          public boolean execute() {
            try {
              if (0 >= t && !cmd.execute()) {
                cancel();
              }
              --t;
            } catch (Exception e) {
              cancel();
            }
            return false;
          }
        });
      }
    }.scheduleRepeating(delayMillis);
  }
}
