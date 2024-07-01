package afternoon.lang.immutable.ex;

public class ImmutableDate {
    private final int year;
    private final int month;
    private final int day;

    public ImmutableDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public ImmutableDate setYear(int newYear) {
        return new ImmutableDate(newYear, month, day);
    }

    public ImmutableDate setMonth(int newMonth) {
        return new ImmutableDate(year, newMonth, day);
    }

    public ImmutableDate setDay(int newDay) {
        return new ImmutableDate(year, month, newDay);
    }

    @Override
    public String toString() {
        return "ImmutableDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
