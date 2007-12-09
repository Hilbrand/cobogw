/*
 * Copyright 2007 Hilbrand Bouwkamp, hs@bouwkamp.com
 * * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * * http://www.apache.org/licenses/LICENSE-2.0
 * * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package java.sql;

import java.util.Date;

public class Time extends Date {
   static final long serialVersionUID = 8397324403548013681L;

   public static Time valueOf(String s) {
    int hour;
    int minute;
    int second;
    int firstColon;
    int secondColon;

    if (s == null) throw new java.lang.IllegalArgumentException();

    firstColon = s.indexOf(':');
    secondColon = s.indexOf(':', firstColon+1);
    if ((firstColon > 0) & (secondColon > 0) & (secondColon < s.length()-1)) {
        hour = Integer.parseInt(s.substring(0, firstColon));
        minute = Integer.parseInt(s.substring(firstColon+1, secondColon));
        second = Integer.parseInt(s.substring(secondColon+1));         
    } else {
        throw new java.lang.IllegalArgumentException();
    }
    return new Time(hour, minute, second);
  }

  /**
   * @deprecated
   */
  public Time(int hour, int minute, int second) {
    super(70, 0, 1, hour, minute, second);    
  }

  public Time(long date) {
    super(date);
  }

  /**
   * @deprecated
   */
  public int getDate() {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public int getDay() {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public int getMonth() {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public int getYear() {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public void setDate(int arg0) {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public void setMonth(int arg0) {
    throw new IllegalArgumentException();
  }

  public void setTime(long arg0) {
    super.setTime(arg0);
  }

  /**
   * @deprecated
   */
  public void setYear(int arg0) {
    throw new IllegalArgumentException();
  }

  public String toString() {
    int hour = getHours();
    int minute = getMinutes();
    int second = getSeconds();

    return
        (hour < 10 ? "0" : "") + hour + ":" +
        (minute < 10 ? "0" : "") + minute + ":" +
        (second < 10 ? "0" : "") + second;
  }
}
