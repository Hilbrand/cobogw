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
package org.cobogw.gwt.user.client;

/**
 * This class contains JavaScript string object methods that generate specific
 * HTML tags around a String. e.g. the JavaScript method <code>big()</code>
 * wraps a string into the &lt;big&gt; tag.
 *
 * <p>The style created by the HTML tags, made available through the methods in
 * this class, can also be created via CSS style elements. This latter technique
 * is preferred as it better separates code from layout. Therefore be careful
 * when using the methods to set specific style effects.
 *
 * <p>Additional 2 useful JavaScript methods are also made accessible:
 * {@link #split(String, String, int)} and {@link #substr(String, int, int)}.
 * These methods provide functionality not available in the Java String class.
 * 
 * <p>This class would have been an extension of {@link String} if that class
 * hadn't been final.
 */
public class JSString {

  /**
   * Wraps a string in the <code>big</code> tag.
   */
  public static native String big(String s) /*-{
    return s.big();
  }-*/;

  /**
   * Wraps the string in the <code>b</code> tag. Displaying the string bold.
   */
  public static native String bold(String s) /*-{
    return s.bold();
  }-*/;

  /**
   * Returns the Unicode of the character at a specified position.
   *
   * @param index A number representing a position in the string.
   */
  public static native Character charCodeAt(String s, int index) /*-{
    return s.charCodeAt(index);
  }-*/;

  /**
   * Joins two or more strings.
   *
   * @param stringX One or more string objects to be joined to a string.
   */
  public static native String concat(String s, String... stringX) /*-{
    return s.concat(stringX);
  }-*/;

  /**
   * Wraps the string in the <code>fixed</code> tag. Displaying the string in a
   * teletype font.
   */
  public static native String fixed(String s) /*-{
    return s.fixed();
  }-*/;

  /**
   * Wraps the string in the <code>font</code> tag with the <code>color</code>
   * attribute set.
   *
   * @param color Specifies a font-color for the string. The value can be a
   *              color name (red), an RGB value (rgb(255,0,0)), or a hex
   *              number (#FF0000).
   */
  public static native String fontcolor(String s, String color) /*-{
    return s.fontcolor(color);
  }-*/;

  /**
   * Wraps the string in the <code>font</code> tag with the <code>size</code>
   * attribute set.
   *
   * @param size A number that specifies the font size.
   */
  public static native String fontsize(String s, int size) /*-{
    return s.fontsize(size);
  }-*/;

  /**
   * Takes the specified Unicode values and returns a string.
   *
   * @param numX One or more Unicode values.
   */
  public static native String fromCharCode(Integer... numX) /*-{
    return String.fromCharCode(numX);
  }-*/;

  /**
   * Wraps the string in the <code>i</code> tag. Displaying the string in
   * italics.
   */
  public static native String italics(String s) /*-{
    return s.italics();
  }-*/;

  /**
   * Wraps the string in the <code>small</code> tag.
   */
  public static native String small(String s) /*-{
    return s.small();
  }-*/;

  /**
   * Splits a string into an array of strings.
   *
   * @param separator Specifies the character, regular expression, or substring
   *        that is used to determine where to split the string.
   */
  public static native String split(String s, String separator) /*-{
    return s.split(separator);
  }-*/;

  /**
   * Splits a string into an array of strings.
   *
   * @param separator Specifies the character, regular expression, or substring
   *        that is used to determine where to split the string.
   * @param howmany Specify how many times split should occur.
   */
  public static native String split(String s, String separator, int howmany) /*-{
    return s.split(separator, howmany);
  }-*/;

  /**
   * Wraps the string in the <code>strike</code> tag.
   */
  public static native String strike(String s) /*-{
    return s.strike();
  }-*/;

  /**
   * Wraps the string in the <code>sub</code> tag. Displaying the string as
   * subscript.
   */
  public static native String sub(String s) /*-{
    return s.sub();
  }-*/;

  /**
   * Extracts a specified number of characters in a string, from a start index.
   */
  public static native String substr(String s, int start, int length) /*-{
    return s.substr(start, length);
  }-*/;

  /**
   * Wraps the string in the <code>sup</code> tag. Displaying the string as
   * superscript.
   */
  public static native String sup(String s) /*-{
    return s.sup();
  }-*/;
}
