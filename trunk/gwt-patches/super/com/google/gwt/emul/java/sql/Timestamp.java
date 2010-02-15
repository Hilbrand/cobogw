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

import java.util.Date;

public class Timestamp extends Date {

  private int nanos;

  static final long serialVersionUID = 2745179027874758501L;

  // s = yyyy-mm-dd hh:mm:ss.fffffffff
  public static Timestamp valueOf(String s) {
    int year, month, day, hour, minute, second, nano;
    final String formatError =
        "Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]";

    if (s == null) throw new java.lang.IllegalArgumentException("null string");
    final int space = s.indexOf(' ');

    if (space < 0) throw new java.lang.IllegalArgumentException(formatError);
    final String date[] = s.substring(0, space).split("-");
    final int dot = s.indexOf('.');
    final String time[] = s.substring(space+1, dot<0?s.length():dot).split(":");

    if (date.length != 3 && time.length != 3)
        throw new java.lang.IllegalArgumentException(formatError);   
    year = Integer.parseInt(date[0]) - 1900;
    month = Integer.parseInt(date[1]) - 1;
    day = Integer.parseInt(date[2]);
    hour = Integer.parseInt(time[0]);
    minute = Integer.parseInt(time[1]);
    second = Integer.parseInt(time[2]);
    nano = dot<0 ? 0 :(int) (Double.parseDouble(s.substring(dot)) * 1000000000);
    return new Timestamp(year, month, day, hour, minute, second, nano);
  }

  /**
   * @deprecated
   */
  public Timestamp(int year, int month, int date, int hour, int minute,
      int second, int nano) {
    super(year, month, date, hour, minute, second);
    setNanos(nano);
  }

  public Timestamp(long time) {
    super(0);
    setTime(time);
  }

  public boolean after(Timestamp ts) {
    return compareTo(ts) > 0;
  }

  public boolean before(Timestamp ts) {
    return compareTo(ts) < 0;
  }

  public int compareTo(Timestamp ts) {
    final int d = super.compareTo((Date)ts);

    return d == 0 ? getNanos() - ts.getNanos() : d;
  }

  // This implementation has changed in Java 1.6. In previous versions (=< 1.5)
  // it always throws a ClassCastException.
  public int compareTo(Date d) {
    return
        d instanceof Timestamp ?
        compareTo((Timestamp)d) :
        compareTo(new Timestamp(d.getTime()));
  }

  public boolean equals(Timestamp ts) {
    return getTime() == ts.getTime() && getNanos() == ts.getNanos();
  }

  public boolean equals(Object obj) {
    return obj instanceof Timestamp ? equals((Timestamp)obj) : false;
  }

  public int getNanos() {
    return nanos;
  }

  public long getTime() {
    return super.getTime() + (nanos / 1000000);
  }

  public void setNanos(int n) {
    if (n > 999999999 || n < 0) {
      throw new IllegalArgumentException();
    }
    nanos = n;
  }

  public void setTime(long time) {
    super.setTime(time);
    nanos = (int)((time%1000) * 1000000);
    if(nanos < 0) {
      nanos = 1000000000 + nanos;
      super.setTime(time);
    }
    //Instead of dividing we make use of the Javascript milliseconds methods
    //to set the milliseconds part of the long time variable.
    setMilliseconds(0);
  }

  // yyyy-mm-dd hh:mm:ss.fffffffff format
  public String toString() {
    return nativeToString(nanos);
  }

  private native String nativeToString(int nanos) /*-{
    var m = this.@java.util.Date::jsdate.getMonth()+1;
    var d = this.@java.util.Date::jsdate.getDate();
    var h = this.@java.util.Date::jsdate.getHours();
    var i = this.@java.util.Date::jsdate.getMinutes();
    var s = this.@java.util.Date::jsdate.getSeconds();

    return this.@java.util.Date::jsdate.getFullYear() + '-' + (m < 10 ? '0' + m : m) +
        '-' + (d < 10 ? '0' + d : d) + ' ' + (h < 10 ? '0' + h : h) + ':' +
        (i < 10 ? '0' + i : i) + ':' + (s < 10 ? '0' + s : s) + '.' +
        (nanos ? ('000000000' + nanos).slice(-9) : 0);
  }-*/;

  private native void setMilliseconds(int millis) /*-{
    this.@java.util.Date::jsdate.setMilliseconds(millis);
  }-*/;
}
