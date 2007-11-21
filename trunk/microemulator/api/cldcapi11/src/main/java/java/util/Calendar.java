/*
 *   
 *
 * Portions Copyright  2000-2007 Sun Microsystems, Inc. All Rights
 * Reserved.  Use is subject to license terms.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License version
 * 2 only, as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License version 2 for more details (a copy is
 * included at /legal/license.txt).
 * 
 * You should have received a copy of the GNU General Public License
 * version 2 along with this work; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA
 * 
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa
 * Clara, CA 95054 or visit www.sun.com if you need additional
 * information or have any questions.
 */

/*
 * (C) Copyright Taligent, Inc. 1996-1998 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996-1998 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */

package java.util;

/**
 * <code>Calendar</code> is an abstract base class for converting between
 * a <code>Date</code> object and a set of integer fields such as
 * <code>YEAR</code>, <code>MONTH</code>, <code>DAY</code>, <code>HOUR</code>,
 * and so on. (A <code>Date</code> object represents a specific instant in
 * time with millisecond precision. See
 * {@link Date}
 * for information about the <code>Date</code> class.)
 *
 * <p>
 * Subclasses of <code>Calendar</code> interpret a <code>Date</code>
 * according to the rules of a specific calendar system.
 *
 * <p>
 * Like other locale-sensitive classes, <code>Calendar</code> provides a
 * class method, <code>getInstance</code>, for getting a generally useful
 * object of this type.
 * <blockquote>
 * <pre>
 * Calendar rightNow = Calendar.getInstance();
 * </pre>
 * </blockquote>
 *
 * <p>
 * A <code>Calendar</code> object can produce all the time field values
 * needed to implement the date-time formatting for a particular language
 * and calendar style (for example, Japanese-Gregorian, Japanese-Traditional).
 *
 * <p>
 * When computing a <code>Date</code> from time fields,
 * there may be insufficient information to compute the
 * <code>Date</code> (such as only year and month but no day in the month).
 *
 * <p>
 * <strong>Insufficient information.</strong> The calendar will use default
 * information to specify the missing fields. This may vary by calendar; for
 * the Gregorian calendar, the default for a field is the same as that of the
 * start of the epoch: i.e., YEAR = 1970, MONTH = JANUARY, DATE = 1, etc.
 *
 * <strong>Note:</strong> The ambiguity in interpretation of what day midnight
 * belongs to, is resolved as so: midnight "belongs" to the following day.<br>
 * 23:59 on Dec 31, 1969 &lt; 00:00 on Jan 1, 1970.<br>
 * 12:00 PM is midday, and 12:00 AM is midnight.<br>
 * 11:59 PM on Jan 1 &lt; 12:00 AM on Jan 2 &lt; 12:01 AM on Jan 2.<br>
 * 11:59 AM on Mar 10 &lt; 12:00 PM on Mar 10 &lt; 12:01 PM on Mar 10.<br>
 * 24:00 or greater are invalid.
 * Hours greater than 12 are invalid in AM/PM mode.
 * Setting the time will never change the date.
 * <p>
 * If equivalent times are entered in AM/PM or 24 hour mode, equality will be
 * determined by the actual time rather than the entered time.
 * <p>
 *
 * This class has been subset for J2ME based on the JDK 1.3 Calendar class.
 * Many methods and variables have been pruned, and other methods
 * simplified, in an effort to reduce the size of this class.
 *
 * @see     java.util.Date
 * @see     java.util.TimeZone
 * @version CLDC 1.1 02/01/2002 (based on JDK 1.3)
 */
public abstract class Calendar {
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * year. This is a calendar-specific value.
     */
    public final static int YEAR = 1;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * month. This is a calendar-specific value.
     */
    public final static int MONTH = 2;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * day of the month. This is a synonym for <code>DAY_OF_MONTH</code>.
     * @see #DAY_OF_MONTH
     */
    public final static int DATE = 5;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * day of the month. This is a synonym for <code>DATE</code>.
     * @see #DATE
     */
    public final static int DAY_OF_MONTH = 5;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * day of the week.
     */
    public final static int DAY_OF_WEEK = 7;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating
     * whether the <code>HOUR</code> is before or after noon.
     * E.g., at 10:04:15.250 PM the <code>AM_PM</code> is <code>PM</code>.
     * @see #AM
     * @see #PM
     * @see #HOUR
     */
    public final static int AM_PM = 9;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * hour of the morning or afternoon. <code>HOUR</code> is used for the
     * 12-hour clock.
     * E.g., at 10:04:15.250 PM the <code>HOUR</code> is 10.
     * @see #AM_PM
     * @see #HOUR_OF_DAY
     */
    public final static int HOUR = 10;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * hour of the day. <code>HOUR_OF_DAY</code> is used for the 24-hour clock.
     * E.g., at 10:04:15.250 PM the <code>HOUR_OF_DAY</code> is 22.
     */
    public final static int HOUR_OF_DAY = 11;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * minute within the hour.
     * E.g., at 10:04:15.250 PM the <code>MINUTE</code> is 4.
     */
    public final static int MINUTE = 12;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * second within the minute.
     * E.g., at 10:04:15.250 PM the <code>SECOND</code> is 15.
     */
    public final static int SECOND = 13;
    /**
     * Field number for <code>get</code> and <code>set</code> indicating the
     * millisecond within the second.
     * E.g., at 10:04:15.250 PM the <code>MILLISECOND</code> is 250.
     */
    public final static int MILLISECOND = 14;
    /**
     * Value of the <code>DAY_OF_WEEK</code> field indicating
     * Sunday.
     */
    public final static int SUNDAY = 1;
    /**
     * Value of the <code>DAY_OF_WEEK</code> field indicating
     * Monday.
     */
    public final static int MONDAY = 2;
    /**
     * Value of the <code>DAY_OF_WEEK</code> field indicating
     * Tuesday.
     */
    public final static int TUESDAY = 3;
    /**
     * Value of the <code>DAY_OF_WEEK</code> field indicating
     * Wednesday.
     */
    public final static int WEDNESDAY = 4;
    /**
     * Value of the <code>DAY_OF_WEEK</code> field indicating
     * Thursday.
     */
    public final static int THURSDAY = 5;
    /**
     * Value of the <code>DAY_OF_WEEK</code> field indicating
     * Friday.
     */
    public final static int FRIDAY = 6;
    /**
     * Value of the <code>DAY_OF_WEEK</code> field indicating
     * Saturday.
     */
    public final static int SATURDAY = 7;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * first month of the year.
     */
    public final static int JANUARY = 0;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * second month of the year.
     */
    public final static int FEBRUARY = 1;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * third month of the year.
     */
    public final static int MARCH = 2;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * fourth month of the year.
     */
    public final static int APRIL = 3;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * fifth month of the year.
     */
    public final static int MAY = 4;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * sixth month of the year.
     */
    public final static int JUNE = 5;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * seventh month of the year.
     */
    public final static int JULY = 6;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * eighth month of the year.
     */
    public final static int AUGUST = 7;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * ninth month of the year.
     */
    public final static int SEPTEMBER = 8;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * tenth month of the year.
     */
    public final static int OCTOBER = 9;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * eleventh month of the year.
     */
    public final static int NOVEMBER = 10;
    /**
     * Value of the <code>MONTH</code> field indicating the
     * twelfth month of the year.
     */
    public final static int DECEMBER = 11;
    /**
     * Value of the <code>AM_PM</code> field indicating the
     * period of the day from midnight to just before noon.
     */
    public final static int AM = 0;
    /**
     * Value of the <code>AM_PM</code> field indicating the
     * period of the day from noon to just before midnight.
     */
    public final static int PM = 1;

    /**
     * The field values for the currently set time for this calendar.
     */
    protected int fields[];

    /**
     * The flags which tell if a specified time field for the calendar is set.
     * This is an array of <code>FIELD_COUNT</code> booleans,
     */
    protected boolean isSet[];

    /**
     * The currently set time for this calendar, expressed in milliseconds after
     * January 1, 1970, 0:00:00 GMT.
     */
    protected long time;

    /**
     * Constructs a Calendar with the default time zone.
     *
     * @see     TimeZone#getDefault
     */
    protected Calendar() {
        throw new RuntimeException("STUB");
    }

    /**
     * Gets this Calendar's current time.
     *
     * @return the current time.
     *
     * @see #setTime
     */
    public final Date getTime() {
        throw new RuntimeException("STUB");
    }

    /**
     * Sets this Calendar's current time with the given Date.
     * <p>
     * Note: Calling <code>setTime()</code> with
     * <code>Date(Long.MAX_VALUE)</code> or <code>Date(Long.MIN_VALUE)</code>
     * may yield incorrect field values from <code>get()</code>.
     *
     * @param date the given Date.
     *
     * @see #getTime
     */
    public final void setTime(Date date) {
        throw new RuntimeException("STUB");
    }

    /**
     * Gets a calendar using the default time zone.
     *
     * @return a Calendar.
     */

    /* <p>
     * The following is information for implementers. Applications
     * should not need to be aware of this or rely on it, because
     * each implementation may do it differently:
     * <p>
     * The Calendar class will look up a calendar implementation
     * class at runtime. The class name will take the form:
     * <p>
     * <code>{classRoot}.util.{platform}.CalendarImpl</code>
     * <p>
     * To simplify things, we use a hard-coded path name here.
     * Actual location of the implementation class may vary
     * from one implementation to another.
     */
    public static synchronized Calendar getInstance() {
        throw new RuntimeException("STUB");
    }

    /**
     * Gets a calendar using the specified time zone.
     * @param zone  the time zone to use
     * @return a Calendar.
     */
    public static synchronized Calendar getInstance(TimeZone zone) {
        throw new RuntimeException("STUB");
    }

    /**
     * Gets this Calendar's current time as a long expressed in milliseconds
     * after January 1, 1970, 0:00:00 GMT (the epoch).
     *
     * @return the current time as UTC milliseconds from the epoch.
     *
     * @see #setTimeInMillis
     */
    protected long getTimeInMillis() {
        throw new RuntimeException("STUB");
    }

    /**
     * Sets this Calendar's current time from the given long value.
     * @param millis the new time in UTC milliseconds from the epoch.
     *
     * @see #getTimeInMillis
     */
    protected void setTimeInMillis( long millis ) {
        throw new RuntimeException("STUB");
    }

    /**
     * Gets the value for a given time field.
     * @param field the given time field (either YEAR, MONTH, DATE, DAY_OF_WEEK,
     *                                    HOUR_OF_DAY, HOUR, AM_PM, MINUTE,
     *                                    SECOND, or MILLISECOND
     * @return the value for the given time field.
     * @exception ArrayIndexOutOfBoundsException if the parameter is not
     * one of the above.
     */
    public final int get(int field) {
        throw new RuntimeException("STUB");
    }

    /**
     * Sets the time field with the given value. 
     *
     * @param field the given time field.
     * @param value the value to be set for the given time field.
     *
     * @exception ArrayIndexOutOfBoundsException if an illegal field
     * parameter is received.
     */
    public final void set(int field, int value) {
        throw new RuntimeException("STUB");
    }

    /**
     * Compares this calendar to the specified object.
     * The result is <code>true</code> if and only if the argument is
     * not <code>null</code> and is a <code>Calendar</code> object that
     * represents the same calendar as this object.
     * @param obj the object to compare with.
     * @return <code>true</code> if the objects are the same;
     * <code>false</code> otherwise.
     */
    public boolean equals(Object obj) {
        throw new RuntimeException("STUB");
    }

    /**
     * Compares the time field records.
     * Equivalent to comparing result of conversion to UTC.
     * @param when the Calendar to be compared with this Calendar.
     * @return true if the current time of this Calendar is before
     * the time of Calendar when; false otherwise.
     */
    public boolean before(Object when) {
        throw new RuntimeException("STUB");
    }

    /**
     * Compares the time field records.
     * Equivalent to comparing result of conversion to UTC.
     * @param when the Calendar to be compared with this Calendar.
     * @return true if the current time of this Calendar is after
     * the time of Calendar when; false otherwise.
     */
    public boolean after(Object when) {
        throw new RuntimeException("STUB");
    }

    /**
     * Sets the time zone with the given time zone value.
     * @param value the given time zone.
     *
     * @see #getTimeZone
     */
    public void setTimeZone(TimeZone value) {
        throw new RuntimeException("STUB");
    }

    /**
     * Gets the time zone.
     * @return the time zone object associated with this calendar.
     *
     * @see #setTimeZone
     */
    public TimeZone getTimeZone() {
        throw new RuntimeException("STUB");
    }

    /**
     * Converts
     * the current millisecond time value
     * <code>time</code>
     * to field values in <code>fields[]</code>.
     * This allows you to sync up the time field values with
     * a new time that is set for the calendar.
     */
    protected abstract void computeFields();

    /**
     * Converts the current field values in <code>fields[]</code>
     * to the millisecond time value
     * <code>time</code>.
     */
    protected abstract void computeTime();
}