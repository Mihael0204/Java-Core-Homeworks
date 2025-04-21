package school.sorokin.javacore;

public enum DayOfWeek {
    ПОНЕДЕЛЬНИК,
    ВТОРНИК,
    СРЕДА,
    ЧЕТВЕРГ,
    ПЯТНИЦА,
    СУББОТА,
    ВОСКРЕСЕНЬЕ;

    public static boolean isValidDay(String day) {
        for (DayOfWeek d : DayOfWeek.values()) {
            if (d.name().equalsIgnoreCase(day)) {
                return true;
            }
        }
        return false;
    }
}
