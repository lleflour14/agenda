package agenda;

import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class RepetitiveEvent extends Event {

    protected ChronoUnit frequency;
    protected HashSet<LocalDate> lesRepEvents;



    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
        this.lesRepEvents = new HashSet<LocalDate>();
    }

    public void addException(LocalDate date) {
        lesRepEvents.add(date);
    }

    public HashSet<LocalDate> getException() {
        return this.lesRepEvents;
    }
    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency () {
        return frequency;
    }
    public boolean isInDay(LocalDate aDay) {
        if(this.lesRepEvents.contains(aDay)){
            return false;
        }
        if(this.frequency == ChronoUnit.DAYS){
            return true;
        }
        if((aDay.getDayOfYear() == getStart().getDayOfYear() &&  aDay.getYear() == getStart().getYear()) || (aDay.getDayOfYear() == getStart().plus(getDuration()).getDayOfYear() && aDay.getYear() == getStart().plus(getDuration()).getYear()) || (aDay.isAfter(ChronoLocalDate.from(getStart())) && aDay.isBefore(ChronoLocalDate.from(getStart().plus(getDuration()))))
        ){
            return true;
        }
        return false;
    }

}
