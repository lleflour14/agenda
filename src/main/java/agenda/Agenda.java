package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 *
 */
public class Agenda {
    private ArrayList<Event> thoseEvents;

    public Agenda(){
        this.thoseEvents = new ArrayList<>();
    }
public void addEvent(Event e) {
        thoseEvents.add(e);

}


    /**
     * Computes the events that occur on a given day
     *
     * @param day the day to i test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsIntDay(LocalDate day) {
        List<Event> thoseEventsDay = new ArrayList<Event>();
        for (int i = 0; i < thoseEvents.size(); i ++){
            if (thoseEvents.get(i).isInDay(day)){
                thoseEventsDay.add(thoseEvents.get(i));
            }
        }
        //
        return thoseEventsDay;
    }
}