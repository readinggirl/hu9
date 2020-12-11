package hausuebung9;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtilPro {

    public static void main(String[] args) {
        System.out.println(intToLocalDate(20040216));
        System.out.println(longToLocalDate(200402161530L));
        System.out.println(dateToLocalDate(new Date()));
        System.out.println(calendarToLocalDate(new GregorianCalendar()));
        System.out.println(intToLocalDateTime(20040216));
        System.out.println(longToLocalDateTime(200402161530L));
        System.out.println(dateToLocalDateTime(new Date()));
        System.out.println(calendarToLocalDateTime(new GregorianCalendar()));
        System.out.println(localDateToInt(LocalDate.of(2004, 2, 16)));
        System.out.println(localDateTimeToInt(LocalDateTime.of(2004, 02, 16, 15, 30)));
        System.out.println(localDateToLong(LocalDate.of(2004, 02, 16)));
        System.out.println(localDateTimeToLong(LocalDateTime.of(2004, 2, 16, 15, 30)));
        System.out.println(localDateToDate(LocalDate.of(2004, 02, 16)));
        System.out.println(localDateTimeToDate(LocalDateTime.of(2004, 2, 16, 15, 30)));
        System.out.println(localDateToCalendar(LocalDate.of(2004, 2, 16)));
        System.out.println(localDateTimeToCalendar(LocalDateTime.of(2004, 2, 16, 15, 30)));
    }

    private TimeUtilPro() {
    }

    // ########## LOCALDATE METHODS ##########
    public static LocalDate intToLocalDate(int date) {
        String datum = Integer.toString(date);
        int year = Integer.parseInt(datum.substring(0, 4));
        int month = Integer.parseInt(datum.substring(4, 6));
        int day = Integer.parseInt(datum.substring(6, 8));
        if (month < 13 && month > 0 && day > 0 && day < 32) {
            if ((month == 2 || month == 4 || month == 6 || month == 9 || month == 11) && day < 31) {
                if (month == 2 && day < 29) {
                    return LocalDate.of(year, month, day);
                }
                return LocalDate.of(year, month, day);
            }
            return LocalDate.of(year, month, day);
        }
        throw new DateTimeException("Error");
    }

    public static LocalDate longToLocalDate(long dateTime) {
        String datum = Long.toString(dateTime);
        int year = Integer.parseInt(datum.substring(0, 4));
        int month = Integer.parseInt(datum.substring(4, 6));
        int day = Integer.parseInt(datum.substring(6, 8));
        int hour = Integer.parseInt(datum.substring(8, 10));
        int minutes = Integer.parseInt(datum.substring(10, 12));

        if (hour > -1 && hour < 24 && minutes > -1 && minutes < 60) {
            if (month < 13 && month > 0 && day > 0 && day < 32) {
                if ((month == 2 || month == 4 || month == 6 || month == 9 || month == 11) && day < 31) {
                    if (month == 2 && day < 29) {
                        return LocalDate.of(year, month, day).atTime(hour, minutes).toLocalDate();
                    }
                    return LocalDate.of(year, month, day).atTime(hour, minutes).toLocalDate();
                }
                return LocalDate.of(year, month, day).atTime(hour, minutes).toLocalDate();
            }
        }
        throw new DateTimeException("Error");
    }

    public static LocalDate dateToLocalDate(Date dateTime) {
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate calendarToLocalDate(Calendar dateTime) {
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // ########## LOCALDATETIME METHODS ##########
    public static LocalDateTime intToLocalDateTime(int date) {
        String datum = Integer.toString(date);
        int year = Integer.parseInt(datum.substring(0, 4));
        int month = Integer.parseInt(datum.substring(4, 6));
        int day = Integer.parseInt(datum.substring(6, 8));
        if (month < 13 && month > 0 && day > 0 && day < 32) {
            if ((month == 2 || month == 4 || month == 6 || month == 9 || month == 11) && day < 31) {
                if (month == 2 && day < 29) {
                    return LocalDateTime.of(year, month, day, 0, 0);
                }
                return LocalDateTime.of(year, month, day, 0, 0);
            }
            return LocalDateTime.of(year, month, day, 0, 0);
        }
        throw new DateTimeException("Error");
    }

    public static LocalDateTime longToLocalDateTime(long dateTime) {
        String datum = Long.toString(dateTime);
        int year = Integer.parseInt(datum.substring(0, 4));
        int month = Integer.parseInt(datum.substring(4, 6));
        int day = Integer.parseInt(datum.substring(6, 8));
        int hour = Integer.parseInt(datum.substring(8, 10));
        int minutes = Integer.parseInt(datum.substring(10, 12));

        if (hour > -1 && hour < 24 && minutes > -1 && minutes < 61) {
            if (month < 13 && month > 0 && day > 0 && day < 32) {
                if ((month == 2 || month == 4 || month == 6 || month == 9 || month == 11) && day < 31) {
                    if (month == 2 && day < 29) {
                        return LocalDateTime.of(year, month, day, hour, minutes);
                    }
                    return LocalDateTime.of(year, month, day, hour, minutes);
                }
                return LocalDateTime.of(year, month, day, hour, minutes);
            }
        }
        throw new DateTimeException("Error");
    }

    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    // ########## INT METHODS ##########
    public static int localDateToInt(LocalDate date) {
        String[] val = date.toString().split("-");
        String res = "";
        for (int i = 0; i < val.length; i++) {
            res = res + val[i];
        }
        return Integer.parseInt(res);
    }

    public static int localDateTimeToInt(LocalDateTime dateTime) {
        String[] val = dateTime.toString().split("-");
        String res = "";
        String[] temp = val[2].split("T");
        val[2] = temp[0];
        for (int i = 0; i < val.length; i++) {
            res = res + val[i];
        }
        return Integer.parseInt(res);
    }

    // ########## LONG METHODS ##########
    public static long localDateToLong(LocalDate date) {
        String[] val = date.toString().split("-");
        String res = "";
        String[] temp = val[2].split("T");
        val[2] = temp[0];
        for (int i = 0; i < val.length; i++) {
            res = res + val[i];
        }
        return Long.parseLong(res + "0000");
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        String[] val = dateTime.toString().split("-");
        String res = "";
        String[] temp = val[2].split("T");
        val[2] = temp[0];
        String[] time = temp[1].split(":");
        for (int i = 0; i < val.length; i++) {
            res = res + val[i];
        }
        return Long.parseLong(res + time[0] + time[1]);
    }

    // ########## DATE METHODS ##########
    @SuppressWarnings("deprecation")
    public static Date localDateToDate(LocalDate date) {
        return new Date(date.getYear() - 1900, date.getMonthValue() - 1, date.getDayOfMonth());
    }

    @SuppressWarnings("deprecation")
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return new Date(dateTime.getYear() - 1900, dateTime.getMonthValue() - 1, dateTime.getDayOfMonth(), dateTime.getHour(), dateTime.getMinute());
    }

    // ########## CALENDAR METHODS ##########
    public static Calendar localDateToCalendar(LocalDate date) {
        return new GregorianCalendar(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        return new GregorianCalendar(dateTime.getYear(), dateTime.getMonthValue() - 1, dateTime.getDayOfMonth(), dateTime.getHour(), dateTime.getMinute());
    }

}
