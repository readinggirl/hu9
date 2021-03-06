/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hausuebung9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        System.out.println("done");

        //monat falsch
        date = 20042016;
        expResult = LocalDate.of(2004, 20, 16);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);
        System.out.println("done");

        //monat und tag falsch
        date = 20042036;
        expResult = LocalDate.of(2004, 20, 36);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);
        System.out.println("done");

        //tag falsch
        date = 20040236;
        expResult = LocalDate.of(2004, 02, 36);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);
        System.out.println("done");

        //0
        date = 00000000;
        expResult = LocalDate.of(0000, 00, 00);
        result = TimeUtilPro.intToLocalDate(date);
        assertEquals(expResult, result);
        System.out.println("done");

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
        LocalDate expResult = LocalDate.of(2004, 2, 16);
        LocalDate result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //jahr vor 1900
        dateTime = new Date(-247, 1, 16);
        expResult = LocalDate.of(1653, 2, 16);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat falsch
        dateTime = new Date(104, 16, 16);
        expResult = LocalDate.of(2004, 17, 16);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //tag falsch
        dateTime = new Date(104, 1, 35);
        expResult = LocalDate.of(2004, 2, 35);
        result = TimeUtilPro.dateToLocalDate(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = new Date(104, 16, 35);
        expResult = LocalDate.of(2004, 17, 35);
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
        int date = 20040216;
        LocalDateTime expResult = LocalDateTime.of(2004, 02, 16, 0, 0);
        LocalDateTime result = TimeUtilPro.intToLocalDateTime(date);
        assertEquals(expResult, result);
        System.out.println("done");

        //monat falsch
        date = 20042016;
        expResult = LocalDateTime.of(2004, 20, 16, 0, 0);
        result = TimeUtilPro.intToLocalDateTime(date);
        assertEquals(expResult, result);
        System.out.println("done");

        //monat und tag falsch
        date = 20042036;
        expResult = LocalDateTime.of(2004, 20, 36, 0, 0);
        result = TimeUtilPro.intToLocalDateTime(date);
        assertEquals(expResult, result);
        System.out.println("done");

        //tag falsch
        date = 20040236;
        expResult = LocalDateTime.of(2004, 02, 36, 0, 0);
        result = TimeUtilPro.intToLocalDateTime(date);
        assertEquals(expResult, result);
        System.out.println("done");

        //0
        date = 00000000;
        expResult = LocalDateTime.of(0000, 00, 00, 0, 0);
        result = TimeUtilPro.intToLocalDateTime(date);
        assertEquals(expResult, result);
        System.out.println("done");
    }

    /**
     * Test of longToLocalDateTime method, of class TimeUtilPro.
     */
    @Test
    public void testLongToLocalDateTime() {
        System.out.println("longToLocalDateTime");
        long dateTime = 200402161530L;
        LocalDateTime expResult = LocalDateTime.of(2004, 02, 16, 15, 30);
        LocalDateTime result = TimeUtilPro.longToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat falsch
        dateTime = 200420161530L;
        expResult = LocalDateTime.of(2004, 20, 16, 15, 30);
        result = TimeUtilPro.longToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = 200420361530L;
        expResult = LocalDateTime.of(2004, 20, 36, 15, 30);
        result = TimeUtilPro.longToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat tag und stunden falsch
        dateTime = 200420363030L;
        expResult = LocalDateTime.of(2004, 20, 36, 30, 30);
        result = TimeUtilPro.longToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat tag stunden und minuten falsch
        dateTime = 200420363070L;
        expResult = LocalDateTime.of(2004, 20, 36, 30, 70);
        result = TimeUtilPro.longToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //0
        dateTime = 000000000000L;
        expResult = LocalDateTime.of(0000, 00, 00, 0, 0);
        result = TimeUtilPro.longToLocalDateTime(dateTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of dateToLocalDateTime method, of class TimeUtilPro.
     */
    @Test
    public void testDateToLocalDateTime() {
        System.out.println("dateToLocalDateTime");
        Date dateTime = new Date(104, 1, 16, 15, 30);
        LocalDateTime expResult = LocalDateTime.of(2004, 2, 16, 15, 30);
        LocalDateTime result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //jahr vor 1900
        dateTime = new Date(-247, 1, 16, 15, 30);
        expResult = LocalDateTime.of(1653, 2, 16, 15, 30);
        result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat falsch
        dateTime = new Date(104, 16, 16, 15, 30);
        expResult = LocalDateTime.of(2004, 17, 16, 15, 30);
        result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //tag falsch
        dateTime = new Date(104, 1, 35, 15, 30);
        expResult = LocalDateTime.of(2004, 2, 35, 15, 30);
        result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = new Date(104, 16, 35, 15, 30);
        expResult = LocalDateTime.of(2004, 17, 35, 15, 30);
        result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat tag stunden und minuten falsch
        dateTime = new Date(104, 1, 35, 30, 70);
        expResult = LocalDateTime.of(2004, 2, 35, 30, 70);
        result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //0
        dateTime = new Date(0, 0, 0, 0, 0);
        expResult = LocalDateTime.of(0, 0, 0, 0, 0);
        result = TimeUtilPro.dateToLocalDateTime(dateTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of calendarToLocalDateTime method, of class TimeUtilPro.
     */
    @Test
    public void testCalendarToLocalDateTime() {
        System.out.println("calendarToLocalDateTime");
        Calendar dateTime = new GregorianCalendar(2004, 1, 16, 15, 30);
        LocalDateTime expResult = LocalDateTime.of(2004, 2, 16, 15, 30);
        LocalDateTime result = TimeUtilPro.calendarToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat falsch
        dateTime = new GregorianCalendar(2004, -6, 16, 15, 30);
        expResult = LocalDateTime.of(2004, -5, 16, 15, 30);
        result = TimeUtilPro.calendarToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //tag falsch
        dateTime = new GregorianCalendar(2004, 1, 50, 15, 30);
        expResult = LocalDateTime.of(2004, 2, 50, 15, 30);
        result = TimeUtilPro.calendarToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = new GregorianCalendar(2004, 19, 50, 15, 30);
        expResult = LocalDateTime.of(2004, 20, 50, 15, 30);
        result = TimeUtilPro.calendarToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //monat tag stunden und minuten falsch
        dateTime = new GregorianCalendar(104, 1, 35, 30, 70);
        expResult = LocalDateTime.of(2004, 2, 35, 30, 70);
        result = TimeUtilPro.calendarToLocalDateTime(dateTime);
        assertEquals(expResult, result);

        //0
        dateTime = new GregorianCalendar(0, 0, 0, 0, 0);
        expResult = LocalDateTime.of(0, 0, 0, 0, 0);
        result = TimeUtilPro.calendarToLocalDateTime(dateTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateToInt method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToInt() {
        System.out.println("localDateToInt");
        LocalDate date = LocalDate.of(2004, 2, 16);
        int expResult = 20040216;
        int result = TimeUtilPro.localDateToInt(date);
        assertEquals(expResult, result);

        //monat falsch
        date = LocalDate.of(2004, -6, 16);
        expResult = -1;
        result = TimeUtilPro.localDateToInt(date);
        assertEquals(expResult, result);

        //tag falsch
        date = LocalDate.of(2004, 2, 50);
        expResult = -1;
        result = TimeUtilPro.localDateToInt(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = LocalDate.of(2004, -6, 50);
        expResult = -1;
        result = TimeUtilPro.localDateToInt(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateTimeToInt method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToInt() {
        System.out.println("localDateTimeToInt");
        LocalDateTime date = LocalDateTime.of(2004, 2, 16, 15, 30);
        int expResult = 20040216;
        int result = TimeUtilPro.localDateTimeToInt(date);
        assertEquals(expResult, result);

        //monat falsch
        date = LocalDateTime.of(2004, -6, 16, 15, 30);
        expResult = -1;
        result = TimeUtilPro.localDateTimeToInt(date);
        assertEquals(expResult, result);

        //tag falsch
        date = LocalDateTime.of(2004, 2, 50, 15, 30);
        expResult = -1;
        result = TimeUtilPro.localDateTimeToInt(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = LocalDateTime.of(2004, -6, 50, 15, 30);
        expResult = -1;
        result = TimeUtilPro.localDateTimeToInt(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateToLong method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToLong() {
        System.out.println("localDateToLong");
        LocalDate date = LocalDate.of(2004, 2, 16).atTime(15, 30).toLocalDate();
        long expResult = 200402160000L;
        long result = TimeUtilPro.localDateToLong(date);
        assertEquals(expResult, result);

        //monat falsch
        date = LocalDate.of(2004, 90, 16).atTime(15, 30).toLocalDate();
        expResult = -1;
        result = TimeUtilPro.localDateToLong(date);
        assertEquals(expResult, result);

        //tag falsch
        date = LocalDate.of(2004, 2, 100).atTime(15, 30).toLocalDate();
        expResult = -1;
        result = TimeUtilPro.localDateToLong(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = LocalDate.of(2004, 60, 35).atTime(15, 30).toLocalDate();
        expResult = -1;
        result = TimeUtilPro.localDateToLong(date);
        assertEquals(expResult, result);

        //monat tag stunden und minuten falsch
        date = LocalDate.of(2004, 60, 35).atTime(-3, 75).toLocalDate();
        expResult = -1;
        result = TimeUtilPro.localDateToLong(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateTimeToLong method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToLong() {
        System.out.println("localDateTimeToLong");
        LocalDateTime date = LocalDateTime.of(2004, 2, 16, 15, 30);
        long expResult = 200402161530L;
        long result = TimeUtilPro.localDateTimeToLong(date);
        assertEquals(expResult, result);

        //monat falsch
        date = LocalDateTime.of(2004, -6, 16, 15, 30);
        expResult = -1;
        result = TimeUtilPro.localDateTimeToLong(date);
        assertEquals(expResult, result);

        //tag falsch
        date = LocalDateTime.of(2004, 2, 50, 15, 30);
        expResult = -1;
        result = TimeUtilPro.localDateTimeToLong(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = LocalDateTime.of(2004, -6, 50, 15, 30);
        expResult = -1;
        result = TimeUtilPro.localDateTimeToLong(date);
        assertEquals(expResult, result);

        //monat tag stunden und minuten falsch
        date = LocalDateTime.of(2004, -6, 50, 50, -13);
        expResult = -1;
        result = TimeUtilPro.localDateTimeToLong(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateToDate method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToDate() {
        System.out.println("localDateToDate");
        LocalDate date = LocalDate.of(2004, 2, 16);
        Date expResult = new Date(104, 1, 16);
        Date result = TimeUtilPro.localDateToDate(date);
        assertEquals(expResult, result);

        //monat falsch
        date = LocalDate.of(2004, 0, 16);
        expResult = new Date();
        result = TimeUtilPro.localDateToDate(date);
        assertEquals(expResult, result);

        //tag falsch
        date = LocalDate.of(2004, 2, -10);
        expResult = new Date();
        result = TimeUtilPro.localDateToDate(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = LocalDate.of(2004, 25, -10);
        expResult = new Date();
        result = TimeUtilPro.localDateToDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateTimeToDate method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToDate() {
        System.out.println("localDateTimeToDate");
        LocalDateTime date = LocalDateTime.of(2004, 2, 16, 15, 30);
        Date expResult = new Date(104, 1, 16, 15, 30);
        Date result = TimeUtilPro.localDateTimeToDate(date);
        assertEquals(expResult, result);

        //monat falsch
        date = LocalDateTime.of(2004, 0, 16, 15, 30);
        expResult = new Date(2004, 0, 16, 15, 30);
        result = TimeUtilPro.localDateTimeToDate(date);
        assertEquals(expResult, result);

        //tag falsch
        date = LocalDateTime.of(2004, 2, 39, 15, 30);
        expResult = new Date(2004, 2, 39, 15, 30);
        result = TimeUtilPro.localDateTimeToDate(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = LocalDateTime.of(2004, 0, 39, 15, 30);
        expResult = new Date(2004, 0, 39, 15, 30);
        result = TimeUtilPro.localDateTimeToDate(date);
        assertEquals(expResult, result);

        //monat tag stunde und minute falsch
        date = LocalDateTime.of(2004, 0, 39, 30, 70);
        expResult = new Date(2004, 0, 39, 30, 70);
        result = TimeUtilPro.localDateTimeToDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateToCalendar method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateToCalendar() {
        System.out.println("localDateToCalendar");
        LocalDate date = LocalDate.of(2004, 2, 16);
        Calendar expResult = new GregorianCalendar(2004, 1, 16);
        Calendar result = TimeUtilPro.localDateToCalendar(date);
        assertEquals(expResult, result);

        //monat falsch
        date = LocalDate.of(2004, 20, 16);
        expResult = new GregorianCalendar(2004, 19, 16);
        result = TimeUtilPro.localDateToCalendar(date);
        assertEquals(expResult, result);

        //tag falsch
        date = LocalDate.of(2004, 2, 37);
        expResult = new GregorianCalendar(2004, 1, 37);
        result = TimeUtilPro.localDateToCalendar(date);
        assertEquals(expResult, result);

        //monat und tag falsch
        date = LocalDate.of(2004, 20, 37);
        expResult = new GregorianCalendar(2004, 19, 37);
        result = TimeUtilPro.localDateToCalendar(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of localDateTimeToCalendar method, of class TimeUtilPro.
     */
    @Test
    public void testLocalDateTimeToCalendar() {
        System.out.println("localDateTimeToCalendar");
        LocalDateTime dateTime = LocalDateTime.of(2004, 2, 16, 15, 30);
        Calendar expResult = new GregorianCalendar(2004, 1, 16, 15, 30);
        Calendar result = TimeUtilPro.localDateTimeToCalendar(dateTime);
        assertEquals(expResult, result);

        //monat und tag falsch
        dateTime = LocalDateTime.of(2004, 20, 95, 15, 30);
        expResult = new GregorianCalendar(2004, 19, 95, 15, 30);
        result = TimeUtilPro.localDateTimeToCalendar(dateTime);
        assertEquals(expResult, result);

        //monat tag stunde und minute falsch
        dateTime = LocalDateTime.of(2004, 20, 95, 35, 300);
        expResult = new GregorianCalendar(2004, 19, 95, 35, 300);
        result = TimeUtilPro.localDateTimeToCalendar(dateTime);
        assertEquals(expResult, result);

        //stunde und minute falsch
        dateTime = LocalDateTime.of(2004, 2, 16, 35, 300);
        expResult = new GregorianCalendar(2004, 1, 16, 35, 300);
        result = TimeUtilPro.localDateTimeToCalendar(dateTime);
        assertEquals(expResult, result);
    }

}
