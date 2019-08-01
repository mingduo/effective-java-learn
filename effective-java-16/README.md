在公共类中使用访问方法而不是公共属性

如果一个类是包级私有的，或者是一个私有的内部类，那么暴露它的数据属性就没有什么本质上的错误

    // Public class with exposed immutable fields - questionable
    
    public final class Time {
        private static final int HOURS_PER_DAY    = 24;
        private static final int MINUTES_PER_HOUR = 60;
        public final int hour;
        public final int minute;
    
    ```
    public Time(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY)
           throw new IllegalArgumentException("Hour: " + hour);
        if (minute < 0 || minute >= MINUTES_PER_HOUR)
           throw new IllegalArgumentException("Min: " + minute);
        this.hour = hour;
        this.minute = minute;
    }
    ```
    
       // Remainder omitted
    }


