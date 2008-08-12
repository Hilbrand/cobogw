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
package java.sql;

public class Date extends java.util.Date {

  static final long serialVersionUID = 1511598038487230103L;

  public static Date valueOf(String s) {
    int year;
    int month;
    int day;
    int firstDash;
    int secondDash;

    if (s == null) throw new java.lang.IllegalArgumentException();

    firstDash = s.indexOf('-');
    secondDash = s.indexOf('-', firstDash+1);
    if ((firstDash > 0) & (secondDash > 0) & (secondDash < s.length()-1)) {
      year = Integer.parseInt(s.substring(0, firstDash)) - 1900;
      month = Integer.parseInt(s.substring(firstDash+1, secondDash)) - 1;
      day = Integer.parseInt(s.substring(secondDash+1));
    } else {
      throw new java.lang.IllegalArgumentException();
    }
    return new Date(year, month, day);
  }

  /**
   * @deprecated
   */
  public Date(int year, int month, int day) {
    super(year, month, day);
  }

  public Date(long date) {
    super(date);
  }

  /**
   * @deprecated
   */
  public int getHours() {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public int getMinutes() {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public int getSeconds() {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public void setHours(int i) {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public void setMinutes(int i) {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public void setSeconds(int i) {
    throw new IllegalArgumentException();
  }

  public void setTime(long date) {
    super.setTime(date);
  }

  public String toString() {
    int month = getMonth() + 1;
    int date = getDate();

    return
      (getYear() + 1900) + "-" +
      (month < 10 ? "0" : "") + month + "-" +
      (date < 10 ? "0" : "") + date;
  }
}
