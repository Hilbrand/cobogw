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
package org.cobogw.gwt.user.client;

/**
 * This class defines a set of color keywords as a typesafe enumeration as 
 * defined in the CSS 2.1 Specification.
 * <a href="http://www.w3.org/TR/2007/CR-CSS21-20070719/">
 * http://www.w3.org/TR/2007/CR-CSS21-20070719/</a>  
 * 
 * <p>The list of 17 color keywords is: aqua, black, blue, fuchsia, gray, green, 
 * lime, maroon, navy, olive, orange, purple, red, silver, teal, white, and 
 * yellow. See also: Cascading Style Sheets Level 2 Revision 1 (CSS 2.1) 
 * Specification on Colors:
 * <a href="http://www.w3.org/TR/2007/CR-CSS21-20070719/syndata.html#color-units">
 * http://www.w3.org/TR/2007/CR-CSS21-20070719/syndata.html#color-units</a>.
 *
 * <p>The class also provides a list of the X11 colors supported by popular 
 * browsers. The resulting list is precisely the same as the 
 * <a href="http://www.w3.org/TR/SVG/types.html#ColorKeywords">
 * SVG 1.0 color keyword names</a>. These colors are defined in this class by 
 * their respective numeric color value.
 * See also: 
 * <a href="http://www.w3.org/TR/2003/CR-css3-color-20030514/#svg-color">  
 * http://www.w3.org/TR/2003/CR-css3-color-20030514/#svg-color</a>.
 */
public class Color {

  /* color keywords */

  /**
   * Aqua (#00FFFF)
   */
  public static final String AQUA = "aqua";

  /**
   * Black (#000000)
   */
  public static final String BLACK = "black";

  /**
   * Blue (#0000FF)
   */
  public static final String BLUE = "blue";

  /**
   * Fuchsia (#FF00FF)
   */
  public static final String FUCHSIA = "fuchsia";

  /**
   * Gray (#808080)
   */
  public static final String GRAY = "gray";

  /**
   * Green (#008000)
   */
  public static final String GREEN = "green";

  /**
   * Lime (#00FF00)
   */
  public static final String LIME = "lime";

  /**
   * Maroon (#800000)
   */
  public static final String MAROON = "maroon";

  /**
   * Navy (#000080)
   */
  public static final String NAVY = "navy";

  /**
   * Olive (#808000)
   */
  public static final String OLIVE = "olive";

  /**
   * Orange (#FFA500)
   */
  public static final String ORANGE = "orange";

  /**
   * Purple (#800080)
   */
  public static final String PURPLE = "purple";

  /**
   * Red (#FF0000)
   */
  public static final String RED = "red";

  /**
   * Silver (#C0C0C0)
   */
  public static final String SILVER = "silver";

  /**
   * Teal (#008080)
   */
  public static final String TEAL = "teal";

  /**
   * White (#FFFFFF)
   */
  public static final String WHITE = "white";

  /**
   * Yellow (#FFFF00)
   */
  public static final String YELLOW = "yellow";

  /* SVG color keywords */

  /**
   * AliceBlue (#F0F8FF)
   */
  public static final String ALICEBLUE = "#f0f8ff";

  /**
   * AntiqueWhite (#FAEBD7)
   */
  public static final String ANTIQUEWHITE = "#faebd7";

  /**
   * Aquamarine (#7FFFD4)
   */
  public static final String AQUAMARINE = "#7fffd4";

  /**
   * Azure (#F0FFFF)
   */
  public static final String AZURE = "#f0ffff";

  /**
   * Beige (#F5F5DC)
   */
  public static final String BEIGE = "#f5f5dc";

  /**
   * Bisque (#FFE4C4)
   */
  public static final String BISQUE = "#ffe4c4";

  /**
   * BlanchedAlmond (#FFEBCD)
   */
  public static final String BLANCHEDALMOND = "#ffebcd";

  /**
   * BlueViolet (#8A2BE2)
   */
  public static final String BLUEVIOLET = "#8a2be2";

  /**
   * Brown (#A52A2A)
   */
  public static final String BROWN = "#a52a2a";

  /**
   * BurlyWood (#DEB887)
   */
  public static final String BURLYWOOD = "#deb887";

  /**
   * CadetBlue (#5F9EA0)
   */
  public static final String CADETBLUE = "#5f9ea0";

  /**
   * Chartreuse (#7FFF00)
   */
  public static final String CHARTREUSE = "#7fff00";

  /**
   * Chocolate (#D2691E)
   */
  public static final String CHOCOLATE = "#d2691e";

  /**
   * Coral (#FF7F50)
   */
  public static final String CORAL = "#ff7f50";

  /**
   * CornflowerBlue (#6495ED)
   */
  public static final String CORNFLOWERBLUE = "#6495ed";

  /**
   * Cornsilk (#FFF8DC)
   */
  public static final String CORNSILK = "#fff8dc";

  /**
   * Crimson (#DC143C)
   */
  public static final String CRIMSON = "#dc143c";

  /**
   * Cyan (#00FFFF)
   */
  public static final String CYAN = "#00ffff";

  /**
   * DarkBlue (#00008B)
   */
  public static final String DARKBLUE = "#00008b";

  /**
   * DarkCyan (#008B8B)
   */
  public static final String DARKCYAN = "#008b8b";

  /**
   * DarkGoldenRod (#B8860B)
   */
  public static final String DARKGOLDENROD = "#b8860b";

  /**
   * DarkGray (#A9A9A9)
   */
  public static final String DARKGRAY = "#a9a9a9";

  /**
   * DarkGrey (#A9A9A9)
   */
  public static final String DARKGREY = "#a9a9a9";

  /**
   * DarkGreen (#006400)
   */
  public static final String DARKGREEN = "#006400";

  /**
   * DarkKhaki (#BDB76B)
   */
  public static final String DARKKHAKI = "#bdb76b";

  /**
   * DarkMagenta (#8B008B)
   */
  public static final String DARKMAGENTA = "#8b008b";

  /**
   * DarkOliveGreen (#556B2F)
   */
  public static final String DARKOLIVEGREEN = "#556b2f";

  /**
   * Darkorange (#FF8C00)
   */
  public static final String DARKORANGE = "#ff8c00";

  /**
   * DarkOrchid (#9932CC)
   */
  public static final String DARKORCHID = "#9932cc";

  /**
   * DarkRed (#8B0000)
   */
  public static final String DARKRED = "#8b0000";

  /**
   * DarkSalmon (#E9967A)
   */
  public static final String DARKSALMON = "#e9967a";

  /**
   * DarkSeaGreen (#8FBC8F)
   */
  public static final String DARKSEAGREEN = "#8fbc8f";

  /**
   * DarkSlateBlue (#483D8B)
   */
  public static final String DARKSLATEBLUE = "#483d8b";

  /**
   * DarkSlateGray (#2F4F4F)
   */
  public static final String DARKSLATEGRAY = "#2f4f4f";

  /**
   * DarkSlateGrey (#2F4F4F)
   */
  public static final String DARKSLATEGREY = "#2f4f4f";

  /**
   * DarkTurquoise (#00CED1)
   */
  public static final String DARKTURQUOISE = "#00ced1";

  /**
   * DarkViolet (#9400D3)
   */
  public static final String DARKVIOLET = "#9400d3";

  /**
   * DeepPink (#FF1493)
   */
  public static final String DEEPPINK = "#ff1493";

  /**
   * DeepSkyBlue (#00BFFF)
   */
  public static final String DEEPSKYBLUE = "#00bfff";

  /**
   * DimGray (#696969)
   */
  public static final String DIMGRAY = "#696969";

  /**
   * DimGrey (#696969)
   */
  public static final String DIMGREY = "#696969";

  /**
   * DodgerBlue (#1E90FF)
   */
  public static final String DODGERBLUE = "#1e90ff";

  /**
   * FireBrick (#B22222)
   */
  public static final String FIREBRICK = "#b22222";

  /**
   * FloralWhite (#FFFAF0)
   */
  public static final String FLORALWHITE = "#fffaf0";

  /**
   * ForestGreen (#228B22)
   */
  public static final String FORESTGREEN = "#228b22";

  /**
   * Gainsboro (#DCDCDC)
   */
  public static final String GAINSBORO = "#dcdcdc";

  /**
   * GhostWhite (#F8F8FF)
   */
  public static final String GHOSTWHITE = "#f8f8ff";

  /**
   * Gold (#FFD700)
   */
  public static final String GOLD = "#ffd700";

  /**
   * GoldenRod (#DAA520)
   */
  public static final String GOLDENROD = "#daa520";

  /**
   * Grey (#808080)
   */
  public static final String GREY = "#808080";

  /**
   * GreenYellow (#ADFF2F)
   */
  public static final String GREENYELLOW = "#adff2f";

  /**
   * HoneyDew (#F0FFF0)
   */
  public static final String HONEYDEW = "#f0fff0";

  /**
   * HotPink (#FF69B4)
   */
  public static final String HOTPINK = "#ff69b4";

  /**
   * IndianRed (#CD5C5C)
   */
  public static final String INDIANRED = "#cd5c5c";

  /**
   * Indigo (#4B0082)
   */
  public static final String INDIGO = "#4b0082";

  /**
   * Ivory (#FFFFF0)
   */
  public static final String IVORY = "#fffff0";

  /**
   * Khaki (#F0E68C)
   */
  public static final String KHAKI = "#f0e68c";

  /**
   * Lavender (#E6E6FA)
   */
  public static final String LAVENDER = "#e6e6fa";

  /**
   * LavenderBlush (#FFF0F5)
   */
  public static final String LAVENDERBLUSH = "#fff0f5";

  /**
   * LawnGreen (#7CFC00)
   */
  public static final String LAWNGREEN = "#7cfc00";

  /**
   * LemonChiffon (#FFFACD)
   */
  public static final String LEMONCHIFFON = "#fffacd";

  /**
   * LightBlue (#ADD8E6)
   */
  public static final String LIGHTBLUE = "#add8e6";

  /**
   * LightCoral (#F08080)
   */
  public static final String LIGHTCORAL = "#f08080";

  /**
   * LightCyan (#E0FFFF)
   */
  public static final String LIGHTCYAN = "#e0ffff";

  /**
   * LightGoldenRodYellow (#FAFAD2)
   */
  public static final String LIGHTGOLDENRODYELLOW = "#fafad2";

  /**
   * LightGray (#D3D3D3)
   */
  public static final String LIGHTGRAY = "#d3d3d3";

  /**
   * LightGrey (#D3D3D3)
   */
  public static final String LIGHTGREY = "#d3d3d3";

  /**
   * LightGreen (#90EE90)
   */
  public static final String LIGHTGREEN = "#90ee90";

  /**
   * LightPink (#FFB6C1)
   */
  public static final String LIGHTPINK = "#ffb6c1";

  /**
   * LightSalmon (#FFA07A)
   */
  public static final String LIGHTSALMON = "#ffa07a";

  /**
   * LightSeaGreen (#20B2AA)
   */
  public static final String LIGHTSEAGREEN = "#20b2aa";

  /**
   * LightSkyBlue (#87CEFA)
   */
  public static final String LIGHTSKYBLUE = "#87cefa";

  /**
   * LightSlateGray (#778899)
   */
  public static final String LIGHTSLATEGRAY = "#778899";

  /**
   * LightSlateGrey (#778899)
   */
  public static final String LIGHTSLATEGREY = "#778899";

  /**
   * LightSteelBlue (#B0C4DE)
   */
  public static final String LIGHTSTEELBLUE = "#b0c4de";

  /**
   * LightYellow (#FFFFE0)
   */
  public static final String LIGHTYELLOW = "#ffffe0";

  /**
   * LimeGreen (#32CD32)
   */
  public static final String LIMEGREEN = "#32cd32";

  /**
   * Linen (#FAF0E6)
   */
  public static final String LINEN = "#faf0e6";

  /**
   * Magenta (#FF00FF)
   */
  public static final String MAGENTA = "#ff00ff";

  /**
   * MediumAquaMarine (#66CDAA)
   */
  public static final String MEDIUMAQUAMARINE = "#66cdaa";

  /**
   * MediumBlue (#0000CD)
   */
  public static final String MEDIUMBLUE = "#0000cd";

  /**
   * MediumOrchid (#BA55D3)
   */
  public static final String MEDIUMORCHID = "#ba55d3";

  /**
   * MediumPurple (#9370D8)
   */
  public static final String MEDIUMPURPLE = "#9370d8";

  /**
   * MediumSeaGreen (#3CB371)
   */
  public static final String MEDIUMSEAGREEN = "#3cb371";

  /**
   * MediumSlateBlue (#7B68EE)
   */
  public static final String MEDIUMSLATEBLUE = "#7b68ee";

  /**
   * MediumSpringGreen (#00FA9A)
   */
  public static final String MEDIUMSPRINGGREEN = "#00fa9a";

  /**
   * MediumTurquoise (#48D1CC)
   */
  public static final String MEDIUMTURQUOISE = "#48d1cc";

  /**
   * MediumVioletRed (#C71585)
   */
  public static final String MEDIUMVIOLETRED = "#c71585";

  /**
   * MidnightBlue (#191970)
   */
  public static final String MIDNIGHTBLUE = "#191970";

  /**
   * MintCream (#F5FFFA)
   */
  public static final String MINTCREAM = "#f5fffa";

  /**
   * MistyRose (#FFE4E1)
   */
  public static final String MISTYROSE = "#ffe4e1";

  /**
   * Moccasin (#FFE4B5)
   */
  public static final String MOCCASIN = "#ffe4b5";

  /**
   * NavajoWhite (#FFDEAD)
   */
  public static final String NAVAJOWHITE = "#ffdead";

  /**
   * OldLace (#FDF5E6)
   */
  public static final String OLDLACE = "#fdf5e6";

  /**
   * OliveDrab (#6B8E23)
   */
  public static final String OLIVEDRAB = "#6b8e23";

  /**
   * OrangeRed (#FF4500)
   */
  public static final String ORANGERED = "#ff4500";

  /**
   * Orchid (#DA70D6)
   */
  public static final String ORCHID = "#da70d6";

  /**
   * PaleGoldenRod (#EEE8AA)
   */
  public static final String PALEGOLDENROD = "#eee8aa";

  /**
   * PaleGreen (#98FB98)
   */
  public static final String PALEGREEN = "#98fb98";

  /**
   * PaleTurquoise (#AFEEEE)
   */
  public static final String PALETURQUOISE = "#afeeee";

  /**
   * PaleVioletRed (#D87093)
   */
  public static final String PALEVIOLETRED = "#d87093";

  /**
   * PapayaWhip (#FFEFD5)
   */
  public static final String PAPAYAWHIP = "#ffefd5";

  /**
   * PeachPuff (#FFDAB9)
   */
  public static final String PEACHPUFF = "#ffdab9";

  /**
   * Peru (#CD853F)
   */
  public static final String PERU = "#cd853f";

  /**
   * Pink (#FFC0CB)
   */
  public static final String PINK = "#ffc0cb";

  /**
   * Plum (#DDA0DD)
   */
  public static final String PLUM = "#dda0dd";

  /**
   * PowderBlue (#B0E0E6)
   */
  public static final String POWDERBLUE = "#b0e0e6";

  /**
   * RosyBrown (#BC8F8F)
   */
  public static final String ROSYBROWN = "#bc8f8f";

  /**
   * RoyalBlue (#4169E1)
   */
  public static final String ROYALBLUE = "#4169e1";

  /**
   * SaddleBrown (#8B4513)
   */
  public static final String SADDLEBROWN = "#8b4513";

  /**
   * Salmon (#FA8072)
   */
  public static final String SALMON = "#fa8072";

  /**
   * SandyBrown (#F4A460)
   */
  public static final String SANDYBROWN = "#f4a460";

  /**
   * SeaGreen (#2E8B57)
   */
  public static final String SEAGREEN = "#2e8b57";

  /**
   * SeaShell (#FFF5EE)
   */
  public static final String SEASHELL = "#fff5ee";

  /**
   * Sienna (#A0522D)
   */
  public static final String SIENNA = "#a0522d";

  /**
   * SkyBlue (#87CEEB)
   */
  public static final String SKYBLUE = "#87ceeb";

  /**
   * SlateBlue (#6A5ACD)
   */
  public static final String SLATEBLUE = "#6a5acd";

  /**
   * SlateGray (#708090)
   */
  public static final String SLATEGRAY = "#708090";

  /**
   * SlateGrey (#708090)
   */
  public static final String SLATEGREY = "#708090";

  /**
   * Snow (#FFFAFA)
   */
  public static final String SNOW = "#fffafa";

  /**
   * SpringGreen (#00FF7F)
   */
  public static final String SPRINGGREEN = "#00ff7f";

  /**
   * SteelBlue (#4682B4)
   */
  public static final String STEELBLUE = "#4682b4";

  /**
   * Tan (#D2B48C)
   */
  public static final String TAN = "#d2b48c";

  /**
   * Thistle (#D8BFD8)
   */
  public static final String THISTLE = "#d8bfd8";

  /**
   * Tomato (#FF6347)
   */
  public static final String TOMATO = "#ff6347";

  /**
   * Transparent
   */
  public static final String TRANSPARENT = "transparent";

  /**
   * Turquoise (#40E0D0)
   */
  public static final String TURQUOISE = "#40e0d0";

  /**
   * Violet (#EE82EE)
   */
  public static final String VIOLET = "#ee82ee";

  /**
   * Wheat (#F5DEB3)
   */
  public static final String WHEAT = "#f5deb3";

  /**
   * WhiteSmoke (#F5F5F5)
   */
  public static final String WHITESMOKE = "#f5f5f5";

  /**
   * YellowGreen (#9ACD32)
   */
  public static final String YELLOWGREEN = "#9acd32";
}
