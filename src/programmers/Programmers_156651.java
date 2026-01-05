package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_156651 {
    public class Time implements Comparable<Time> {
        int startHour;
        int startMinute;
        int endHour;
        int endMinute;

        public Time(String[] bookTime) {
            String[] startSplit = bookTime[0].split(":");
            String[] endSplit = bookTime[1].split(":");
            this.startHour = Integer.parseInt(startSplit[0]);
            this.startMinute = Integer.parseInt(startSplit[1]);
            this.endHour = Integer.parseInt(endSplit[0]);
            this.endMinute = Integer.parseInt(endSplit[1]);
        }

        @Override
        public int compareTo(Time o) {
            if (startHour != o.startHour) return startHour - o.startHour;
            if (startMinute != o.startMinute) return startMinute - o.startMinute;
            if (endHour != o.endHour) return endHour - o.endHour;
            return endMinute - o.endMinute;
        }
    }

    public int solution(String[][] book_time) {
        Time[] times = new Time[book_time.length];
        for (int i = 0; i < book_time.length; i++) {
            times[i] = new Time(book_time[i]);
        }
        Arrays.sort(times);

        List<Time> rooms = new ArrayList<>();
        loop: for (int i = 0; i < times.length; i++) {
            Time time = times[i];
            for (int j = 0; j < rooms.size(); j++) {
                Time roomTime = rooms.get(j);
                if (canMatchRoom(roomTime, time)) {
                    roomTime.startHour = time.startHour;
                    roomTime.startMinute = time.startMinute;
                    roomTime.endHour = time.endHour;
                    roomTime.endMinute = time.endMinute;
                    continue loop;
                }
            }
            rooms.add(time);
        }
        return rooms.size();
    }

    public boolean canMatchRoom(Time roomTime, Time time) {
        if (roomTime.endHour == time.startHour) {
            return roomTime.endMinute <= time.startMinute - 10;
        }
        if (roomTime.endHour + 1 == time.startHour) {
            return roomTime.endMinute - 60 <= time.startMinute - 10;
        }
        return roomTime.endHour < time.startHour;
    }
}
