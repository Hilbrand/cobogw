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
package org.cobogw.gwt.user.client.rpc;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Interface used by {@link DataEventService} to communicate data in an abstract
 * way with the server. Extend this interface with an interface that contains
 * data fields, which are handled by subclass implementations of the 
 * {@link DataEventService} class.
 */
public interface DataEvent extends IsSerializable {}