/**
 * Matala 12 - Using a class to represent a given date in the Gregorian Calendar
 *
 * @author Jonathan Levi
 * @version 2019
 */
public class Date {
    private int _day; //num between 1-31 only
    private int _month; //num between 1-12 only
    private int _year; //only 4 decimal places

    //Default values
    private final int _DAY = 1;
    private final int _MONTH = 1;
    private final int _YEAR = 2000;

    private final int ZERO = 0;
    private final int ONE = 1;

    //Years range
    private final int _START_YEAR = 1000;
    private final int _END_YEAR = 9999;

    //Months numbers
    private final int _JAN = 1;
    private final int _FEB = 2;
    private final int _MAR = 3;
    private final int _APR = 4;
    private final int _MAY = 5;
    private final int _JUN = 6;
    private final int _JUL = 7;
    private final int _AUG = 8;
    private final int _SEP = 9;
    private final int _OCT = 10;
    private final int _NOV = 11;
    private final int _DEC = 12;

    private final int _28DAYS = 28; // in a common year _FEB
    private final int _29DAYS = 29; // in a leap year _FEB
    private final int _30DAYS = 30; // _APR, _JUN, _SEP, _NOV
    private final int _31DAYS = 31; //_JAN , _MAR, _MAY, _JUL, _AUG, _OCT, _DEC

    //constructors:

    /**
     * creates a new Date object
     *
     * @param day   the day in the month(1-31)
     * @param month the month in the year
     * @param year  the year (in 4 digits)
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     */
    public Date(int day, int month, int year) {
        final boolean _MONTHS_WITH_30DAYS = ((month == _APR) || (month == _JUN) || (month == _SEP) || (month == _NOV)) && (day <= _30DAYS);
        final boolean _MONTHS_WITH_31DAYS = (month == _JAN) || (month == _MAR) || (month == _MAY) || (month == _JUL) || (month == _AUG) || (month == _OCT) || (month == _DEC);
        if (day < ONE || day > _31DAYS || month < ONE || month > _DEC || year < _START_YEAR || year > _END_YEAR) {
            day = _DAY;
            month = _MONTH;
            year = _YEAR;
        } else {
            if (leapYear()) {
                if (month == _FEB && day <= _29DAYS) {
                    _day = day;
                    _month = month;
                    _year = year;
                } else if (_MONTHS_WITH_30DAYS) {
                    _day = day;
                    _month = month;
                    _year = year;
                } else if (_MONTHS_WITH_31DAYS) {
                    _day = day;
                    _month = month;
                    _year = year;
                } else {
                    day = _DAY;
                    month = _MONTH;
                    year = _YEAR;
                }
            } else {
                if (month == _FEB && day <= _28DAYS) {
                    _day = day;
                    _month = month;
                    _year = year;
                } else if (_MONTHS_WITH_30DAYS) {
                    _day = day;
                    _month = month;
                    _year = year;
                } else if (_MONTHS_WITH_31DAYS) {
                    _day = day;
                    _month = month;
                    _year = year;
                } else {
                    day = _DAY;
                    month = _MONTH;
                    year = _YEAR;
                }
            }
        }
    }

    /**
     * Copy Constructor
     *
     * @param other other date  to be copied
     */
    public Date(Date other) {
        if (other != null) {
            _day = other._day;
            _month = other._month;
            _year = other._year;
        } else {
            _day = _DAY;
            _month = _MONTH;
            _year = _YEAR;
        }
    }

    /**
     * leap year calculator method
     */
    private boolean leapYear() {
        if (((_year % 4 == ZERO) && (_year % 100 != ZERO) || (_year % 400 == ZERO)) && (_year <= _END_YEAR) && (_year >= _START_YEAR)) {
            return true;
        }
        return false;
    }

    /**
     * gets the Day
     */
    public int getDay() {
        return _day;
    }

    /**
     * gets the month
     */
    public int getMonth() {
        return _month;
    }

    /**
     * gets the year
     */
    public int getYear() {
        return _year;
    }

    /**
     * sets the day
     *
     * @param dayToSet refers to the day to be set
     */
    public void setDay(int dayToSet) {
        if (dayToSet >= ONE && dayToSet <= _31DAYS && leapYear()) {
            if (dayToSet <= _29DAYS && _month == _FEB) {
                _day = dayToSet;
            } else if (((_month == _APR) || (_month == _JUN) || (_month == _SEP) || (_month == _NOV)) && (dayToSet <= _30DAYS))
                _day = dayToSet;
            else if (_month == _JAN || _month == _MAR || _month == _MAY || _month == _JUL || _month == _AUG || _month == _OCT || _month == _DEC) {
                _day = dayToSet;
            }
        } else if (dayToSet >= ONE && dayToSet <= _31DAYS && !leapYear()) {
            if (dayToSet <= _28DAYS && _month == _FEB) {
                _day = dayToSet;
            } else if (((_month == _APR) || (_month == _JUN) || (_month == _SEP) || (_month == _NOV)) && (dayToSet <= _30DAYS))
                _day = dayToSet;
            else if (_month == _JAN || _month == _MAR || _month == _MAY || _month == _JUL || _month == _AUG || _month == _OCT || _month == _DEC) {
                _day = dayToSet;
            }
        }
    }

    /**
     * set the month
     *
     * @param monthToSet refers to the month to be set
     */
    public void setMonth(int monthToSet) {
        if (_day >= ONE && _day <= _31DAYS && monthToSet <= _DEC && monthToSet > ZERO && leapYear()) {
            if (_day <= _29DAYS && monthToSet == _FEB) {
                _month = monthToSet;
            } else if ((_day <= _30DAYS) && monthToSet == _APR || monthToSet == _JUN || monthToSet == _SEP || monthToSet == _NOV)
                _month = monthToSet;
            else if ((monthToSet == _JAN || monthToSet == _MAR || monthToSet == _MAY || monthToSet == _JUL || monthToSet == _AUG || monthToSet == _OCT || monthToSet == _DEC) && (_day <= _31DAYS)) {
                _month = monthToSet;
            }

        } else if (monthToSet <= _DEC && monthToSet > ZERO && !leapYear()) {
            if (_day <= _28DAYS && monthToSet == _FEB) {
                _month = monthToSet;
            } else if (((monthToSet == _APR) || (monthToSet == _JUN) || (monthToSet == _SEP) || (monthToSet == _NOV)) && (_day <= _30DAYS))
                _month = monthToSet;
            else if ((monthToSet == _JAN || monthToSet == _MAR || monthToSet == _MAY || monthToSet == _JUL || monthToSet == _AUG || monthToSet == _OCT || monthToSet == _DEC) && (_day <= _31DAYS)) {
                _month = monthToSet;
            }
        }
    }

    /**
     * sets the year
     *
     * @param yearToSet refers to the year to be set
     */
    public void setYear(int yearToSet) {
        if (yearToSet <= _END_YEAR && yearToSet >= _START_YEAR) {//checks if the year is valid year
            if (leapYear()) {
                if (_day <= _29DAYS && _month == _FEB) {
                    _year = yearToSet;
                } else if (((_month == _APR) || (_month == _JUN) || (_month == _SEP) || (_month == _NOV)) && (_day <= _30DAYS))
                    _year = yearToSet;
                else if (_month == _JAN || _month == _MAR || _month == _MAY || _month == _JUL || _month == _AUG || _month == _OCT || _month == _DEC) {
                    _year = yearToSet;
                }
            } else {
                if (_day <= _28DAYS && _month == _FEB) {
                    _year = yearToSet;
                } else if (((_month == _APR) || (_month == _JUN) || (_month == _SEP) || (_month == _NOV)) && (_day <= _30DAYS))
                    _year = yearToSet;
                else if (_month == _JAN || _month == _MAR || _month == _MAY || _month == _JUL || _month == _AUG || _month == _OCT || _month == _DEC) {
                    _year = yearToSet;
                }
            }
        }
    }

    /**
     * equals calculator method
     * 
     * @param a_date the given date
     * @return true if this equals other date
     */
    public boolean equals(Date other) {
        return (_day == other._day && _month == other._month && _year == other._year);
    }

    /**
     * check if this date is before other date
     *
     * @param other the given date
     * 
     */
    public boolean before(Date other) {
        return ((_year < other._year) || (_year == other._year && _month < other._month) || (_year == other._year && _month == other._month && _day < other._day)); 
    }

    /**
     * after calculator method
     * check if this date is after other date
     * @param a_date the given date
     * 
     * 
     */
    public boolean after(Date other) {
        return !before(other) && (_day != other._day && _month != other._month && _year != other._year);
    }

    /**
     * difference calculator method
     * to calculate the different days between two given dates
     * 
     * 
     * @return the difference between dates in days.
     */
    public int difference(Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }

    /**
     * tomorrow calculator method
     * to calculate the tomorrow date.
     */
    public Date tomorrow() {
        if (leapYear()) {
            if (_month == _DEC && _day == _31DAYS) {//first calculate if the given date is in the end of the year
                return new Date(ONE, ONE, _year + ONE);
            } else if (_month == _FEB && _day == _29DAYS) {//second calculate if the given date is in the end of February
                return new Date(ONE, _month + ONE, _year);
            } else if ((_month == _APR || _month == _JUN || _month == _SEP || _month == _NOV) && _day == _30DAYS) {//third calculate if the given date is the months with 30 days 
                return new Date(ONE, _month + ONE, _year);
            } else if ((_month == _JAN || _month == _MAR || _month == _MAY || _month == _JUL || _month == _AUG || _month == _OCT || _month == _DEC) && _day == _31DAYS) {//fourth same with months with 31  
                return new Date(ONE, _month + ONE, _year);
            }
            return new Date(_day + ONE, _month, _year);//in case that the date is not in the end of any month
        } else { //in case that is not leap year
            if (_month == _DEC && _day == _31DAYS) { //first calculate if the given date is in the end of the year
                return new Date(ONE, ONE, _year + ONE);
            } else if (_month == _FEB && _day == _28DAYS) { //second calculate if the given date is in the end of February
                return new Date(ONE, _month + ONE, _year);
            } else if ((_month == _APR || _month == _JUN || _month == _SEP || _month == _NOV) && _day == _30DAYS) { //third calculate if the given date is the months with 30 days 
                return new Date(ONE, _month + ONE, _year);
            } else if ((_month == _JAN || _month == _MAR || _month == _MAY || _month == _JUL || _month == _AUG || _month == _OCT || _month == _DEC) && _day == _31DAYS) { //fourth same with months with 31  
                return new Date(ONE, _month + ONE, _year);
            }
            return new Date(_day + ONE, _month, _year); //in case that the date is not in the end of any month
        }
    }

    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }

    /**
     * returns a String that represents this date
     * in the following format:
     * day.month.year (01/01/2000)
     */
    public String toString() {

        final String dayWithLeading0 = String.format("%02d", _day);
        final String monthWithLeading0 = String.format("%02d", _month);

        if (_day < 10 && _month > 10) {
            return dayWithLeading0 + "/" + _month + "/" + _year;
        } else if (_day > 10 && _month < 10) {
            return _day + "/" + monthWithLeading0 + "/" + _year;
        } else if (_day < 10 && _month < 10) {
            return dayWithLeading0 + "/" + monthWithLeading0 + "/" + _year;
        }
        return _day + "/" + _month + "/" + _year;
    }

    /**
     * dayInWeek calculator method
     * 
     * @return number that represents the day in the week
     */
    public int dayInWeek() {

        if (_month > 2 && _month <= 12) {

            int Y = _year % 100;
            int C = _year / 100;
            int D = _day;
            int M = _month;
            return (D + (26 * (M + 1)) / 10 + Y + Y / 4 + C / 4 - 2 * C) % 7;

        } else if (_month == 2) {
            int Y = _year % 100;
            int C = _year / 100;
            int D = _day;
            int M = _month + 13;
            return (D + (26 * (M + 1)) / 10 + Y + Y / 4 + C / 4 - 2 * C) % 7;
        } else {
            int Y = _year % 100;
            int C = _year / 100;
            int D = _day;
            int M = _month + 12;
            return (D + (26 * (M + 1)) / 10 + Y + Y / 4 + C / 4 - 2 * C) % 7;
        }

    }
}

