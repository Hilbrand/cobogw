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

/**
 * Event listener interface for Rating widget events.
 */
public interface RatingListener {

  /**
   * Called when user hovers over a {@link Rating} item with the rating
   * index. If the index is -1 it means the hover left the Rating widget, this 
   * can be used to remove anything that was displayed on hover. Index starts
   * with 1 for lowest value.
   * 
   * @param sender {@link Rating} being hovered
   * @param index Index of hovered item or -1 if left {@link Rating}
   */
  void onHover(Rating sender, int index);
  
  /**
   * Called when user selects a rating on a {@link Rating}. The selection
   * is in the index. The index starts with 1 for lowest value.
   * 
   * @param sender {@link Rating} being selected
   * @param index Index of selected item
   */
  void onSelect(Rating sender, int index);
  
}
