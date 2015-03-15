The official cobogw Issue Tracker & Source Code.

This project contains 2 separate libraries: a widget library and GWT specific extensions.

## Widget Library ##

The cobogw widget library consists of a number widgets and tools that extend the widgets present in the GWT library itself. Among others the library contains a RoundedPanel and a Button widget that use only CSS to render. The Button is based on the CSS button as can be found in some Google products, like GMail. Other widgets are a Rating widget and a VerticalTabPanel. The list of available widgets is shown below and are also shown in the demo.

## [demo](http://cobogw.googlecode.com/svn/demo/WidgetsDemo.html) ##

All widgets and tools are created to be easy to use and are very well documented.

Version 1.3.2 is for GWT 2.0 till 2.3

The widget library contains the following widgets:

  * Button - A CSS styled widget, using only CSS to create a shading effect: ([demo](http://cobogw.googlecode.com/svn/demo/WidgetsDemo.html#Button). Specific for the Button a ([configurator](http://cobogw.googlecode.com/svn/demo/WidgetsDemo.html#ButtonConfigurator) is available to easily create your own CSS style for a button).
  * ButtonBar - A panel to horizontally align the Button widgets.
  * RoundedPanel - A widget to create similar rounded corners as found in several google web applications ([demo](http://cobogw.googlecode.com/svn/demo/WidgetsDemo.html#RoundedPanel)).
  * RoundedLinePanel - An extension to the RoundedPanel that adds a single pixel line around your rounded widget.
  * Rating - A widget that allows users to set ratings ([demo](http://cobogw.googlecode.com/svn/demo/WidgetsDemo.html#RatingWidget)).
  * Span/TextNode - Widgets to add span and a text node tags to other widgets without overhead of additional div tags ([demo](http://cobogw.googlecode.com/svn/demo/WidgetsDemo.html#Tags)).
  * VerticalTabPanel - TabPanel that displays tabs stacked on the TabBar which is positioned on the left side of the tabPanel.
  * CSS - A helper class to help with CSS properties.
  * And some other simple widgets and helper classes...

For more information on how to add the jar file to your project, see the wiki page [UsingJarFile](UsingJarFile.md) or the README.txt in the zip.

[Release Notes](ReleaseNotes.md)

You can also read the [javadoc](http://cobogw.googlecode.com/svn/trunk/widgets/doc/javadoc/index.html) online or find it in the zip.

### Maven2 Support ###

The libraries are also supported for maven2. The repository is located at http://cobogw.googlecode.com/svn/maven2/. Add the repository to your pom.xml file:
```
  <repository>
    <id>cobogw</id>
    <name>Cobogw repository at googlecode</name>
    <url>http://cobogw.googlecode.com/svn/maven2</url>
  </repository>
```
And add the following dependency to get the library:
```
 <dependency>
    <groupId>org.cobogw.gwt</groupId>
    <artifactId>cobogw</artifactId>
    <version>1.3.2</version>
  </dependency>
```


### gwt.bouwkamp.com ###
This project was original released at gwt.bouwkamp.com, but has been moved to a new name which better reflects the open source nature of this project. It's still released under the Apache 2.0 license. To update your project add the org.cobogw.gwt.jar to your project and remove the com.bouwkamp.gwt jar file and update your imports. This project has the same interface as the gwt.bouwkamp project, but only has a different package structure.

## GWT emulation of java.sql ##

A long time ago GWT didn't support the sql time classes. At that time I created a GWT compatible implementation. Since then GWT has added implementations for these classes.
At the current moment (GWT 2.0 release) the GWT implementation for Timestamp is workable, it only fails on some border cases on the nano part: inserting negative long numbers as time, compare returns other value as java, but the value is correct according to the specification, and the toString for a 0 value nano returns instead of 1 zero, 9 zero's.

**This means for GWT 2.0 you probably don't not need this patch anymore**, unless you encounter those specific use cases. For older version of GWT it is recommended. But in case you need it a version is available.
To use:
| GWT 2.0 | [cobogw.gwt-patch-2.0.zip](http://cobogw.googlecode.com/files/cobogw-gwt-patch-2.0.zip) (zip) |
|:--------|:----------------------------------------------------------------------------------------------|
| Older GWT versions | [cobogw.sql.java-1.1.zip](http://cobogw.googlecode.com/files/cobogw.java.sql-1.1.1.zip) (zip) |

GWT relevant issues (in the GWT issue tracker):
[GWT issue 87](http://code.google.com/p/google-web-toolkit/issues/detail?id=87),
[GWT issue 3731](http://code.google.com/p/google-web-toolkit/issues/detail?id=3731),
[GWT issue 3806](http://code.google.com/p/google-web-toolkit/issues/detail?id=3806) and
[GWT issue 4048](http://code.google.com/p/google-web-toolkit/issues/detail?id=4048).

Test results of [the Timestamp implementation in GWT 1.7](http://code.google.com/p/cobogw/source/browse/trunk/gwt-patches/reports/gwt%201.7/webmode.gwt/TEST-com.google.gwt.emultest.client.TimestampTestCase.txt) using this [JUnit test case](http://code.google.com/p/cobogw/source/browse/trunk/gwt-patches/test/com/google/gwt/emultest/client/TimestampTestCase.java). The results of the same test when running in [hosted mode](http://code.google.com/p/cobogw/source/browse/trunk/gwt-patches/reports/gwt%201.7/hostedmode/TEST-com.google.gwt.emultest.client.TimestampTestCase.txt) (this uses the native Java implementation) and the results with the [implementation provided by the cobowg.sql library](http://code.google.com/p/cobogw/source/browse/trunk/gwt-patches/reports/gwt%201.7/webmode/TEST-com.google.gwt.emultest.client.TimestampTestCase.txt) running in web mode.

Test results of [the Timestamp implementation in GWT 2.0.2](http://code.google.com/p/cobogw/source/browse/trunk/gwt-patches/reports/gwt%202.0.2/webmode.gwt/TEST-com.google.gwt.emultest.client.TimestampTestCase.txt) using this [JUnit test case](http://code.google.com/p/cobogw/source/browse/trunk/gwt-patches/test/com/google/gwt/emultest/client/TimestampTestCase.java).