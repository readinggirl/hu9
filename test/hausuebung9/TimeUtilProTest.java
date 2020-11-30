/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hausuebung9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Teresa
 */
public class TimeUtilProTest {

    public TimeUtilProTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of intToLocalDate method, of class TimeUtilPro.
     */
    @Test
    public void testIntToLocalDate() {
        System.out.println("intToLocalDate");
        int date = 20040216;
        LocalDate expResult = LocalDate.of(2004, 02, 16);
        LocalDate result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);

        //monat falsch
        date = 20042016;
        expResult = LocalDate.of(2004, 20, 16);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = 20042036;
        expResult = LocalDate.of(2004, 20, 36);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);

        //tag falsch
        date = 20040236;
        expResult = LocalDate.of(2004, 02, 36);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);

        //0
        date = 00000000;
        expResult = LocalDate.of(0000, 00, 00);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of longToLocalDate method, of class TimeUtilPro.
     */
    @Test
    public void testLongToLocalDate() {
        System.out.println("longToLocalDate");
        long dateTime = 200402161530L;
        LocalDate expResult = LocalDate.of(2004, 02, 16).atTime(15, 30).toLocalDate();
        LocalDate result = TimeUtilPro.longToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat falsch
        dateTime = 200420161530L;
        expResult = LocalDate.of(2004, 20, 16).atTime(15, 30).toLocalDate();
        result = TimeUtilPro.longToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = 200420361530L;
        expResult = LocalDate.of(2004, 20, 36).atTime(15, 30).toLocalDate();
        result = TimeUtilPro.longToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat tag und stunden falsch
        dateTime = 200420363030L;
        expResult = LocalDate.of(2004, 20, 36).atTime(30, 30).toLocalDate();
        result = TimeUtilPro.longToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat tag stunden und minuten falsch
        dateTime = 200420363070L;
        expResult = LocalDate.of(2004, 20, 36).atTime(30, 70).toLocalDate();
        result = TimeUtilPro.longToLocalDate(dateTime);
        assertEquals(expResult, result);

        //0
        dateTime = 000000000000L;
        expResult = LocalDate.of(0000, 00, 00).atTime(00, 00).toLocalDate();
        result = TimeUtilPro.longToLocalDate(dateTime);
        assertEquals(expResult, result);

    }

    /**
     * Test of dateToLocalDate method, of class TimeUtilPro.
     */
    @Test
    public void testDateToLocalDate() {
        System.out.println("dateToLocalDate");
        Date dateTime = new Date(104, 1, 16);
        LocalDate expResult = LocalDate.of(2003, 2, 16);
        LocalDate result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //jahr vor 1900
        dateTime = new Date(-247, 1, 16);
        expResult = LocalDate.of(1653, 2, 16);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat falsch
        dateTime = new Date(104, 16, 16);
        expResult = LocalDate.of(2003, 17, 16);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //tag falsch
        dateTime = new Date(104, 1, 35);
        expResult = LocalDate.of(2003, 2, 35);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = new Date(104, 16, 35);
        expResult = LocalDate.of(2003, 17, 35);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //0
        dateTime = new Date(0, 0, 0);
        expResult = LocalDate.of(0, 0, 0);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of calendarToLocalDate method, of class TimeUtilPro.
     */
    @Test
    public void testCalendarToLocalDate() {
        System.out.println("calendarToLocalDate");
        Calendar dateTime = new GregorianCalendar(2004, 1, 16);
        LocalDate expResult = LocalDate.of(2004, 2, 16);
        LocalDate result = TimeUtilPro.calendarToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat falsch
        dateTime = new GregorianCalendar(2004, -6, 16);
        expResult = LocalDate.of(2004, -5, 16);
        result = TimeUtilPro.calendarToLocalDate(dateTime);
        assertEquals(expResult, result);

        //tag falsch
        dateTime = new GregorianCalendar(2004, 1, 50);
        expResult = LocalDate.of(2004, 2, 50);
        result = TimeUtilPro.calendarToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = new GregorianCalendar(2004, 19, 50);
        expResult = LocalDate.of(2004, 20, 50);
        result = TimeUtilPro.calendarToLocalDate(dateTime);
        assertEquals(expResult, result);

        //0
        dateTime = new GregorianCalendar(0, 0, 0);
        expResult = LocalDate.of(0, 0, 0);
        result = TimeUtilPro.calendarToLocalDate(dateTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of intToLocalDateTime method, of class TimeUtilPro.
     */
    @Test
    public void testIntToLocalDateTime() {
        System.out.println("intToLocalDateTime");
        int date = 0;
        LocalDateTime expResult = null;
        LocalDateTime result = TimeUtilPro.intToLocalDateTime(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of longToLocalDateTime method, of class TimeUtilPro.
     */
    @Test
    public void testLongToLocalDateTime() {
        System.out.println("longToLocalDateTime");
        long dateTime = 0L;
        LocalDateTime expResult = null;
        LocalDateTime result = TimeUtilPro.longToLocalDateTime(dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateToLocalDateTime method, of class TimeUtilPro.
     */
    @Test
    public void testDateToLocalDateTime() {
        System.out.println("dateToLocalDateTime");
        Date dateTime = null;
        LocalDateTime expResult = null;
        LocalDateTime result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calendarToLocalDateTime method, of class TimeUtilPro.
     */
    @Test
    public void testCalendarToLocalDateTime() {
        System.out.println("calendarToLocalDateTime");
        Calendar dateTime = null;
        LocalDateTime expResult = null;
        LocalDateTime result = TimeUtilPro.calendarToLocalDateTime(dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateToInt method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToInt() {
        System.out.println("localDateToInt");
        LocalDate date = null;
        int expResult = 0;
        int result = TimeUtilPro.localDateToInt(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateTimeToInt method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToInt() {
        System.out.println("localDateTimeToInt");
        LocalDateTime dateTime = null;
        int expResult = 0;
        int result = TimeUtilPro.localDateTimeToInt(dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateToLong method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToLong() {
        System.out.println("localDateToLong");
        LocalDate date = null;
        long expResult = 0L;
        long result = TimeUtilPro.localDateToLong(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateTimeToLong method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToLong() {
        System.out.println("localDateTimeToLong");
        LocalDateTime dateTime = null;
        long expResult = 0L;
        long result = TimeUtilPro.localDateTimeToLong(dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateToDate method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToDate() {
        System.out.println("localDateToDate");
        LocalDate date = null;
        Date expResult = null;
        Date result = TimeUtilPro.localDateToDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateTimeToDate method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToDate() {
        System.out.println("localDateTimeToDate");
        LocalDateTime dateTime = null;
        Date expResult = null;
        Date result = TimeUtilPro.localDateTimeToDate(dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateToCalendar method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToCalendar() {
        System.out.println("localDateToCalendar");
        LocalDate date = null;
        Calendar expResult = null;
        Calendar result = TimeUtilPro.localDateToCalendar(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateTimeToCalendar method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToCalendar() {
        System.out.println("localDateTimeToCalendar");
        LocalDateTime dateTime = null;
        Calendar expResult = null;
        Calendar result = TimeUtilPro.localDateTimeToCalendar(dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
