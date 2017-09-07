
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        System.out.println("All Entries");
        printEntries(entries);
        System.out.println("All Tuesdays");
        printTuesdays(entries);
        System.out.println("Total Tuesdays, Wednesdays, and Thursdays");
        countTueWedThur(entries);
        System.out.println("Weekend Entries List");
        weekendList(entries);
        System.out.println();
        weekdaySet(entries);
//        printDurationGreaterThan10(entries);
//        findMaxDuration(entries);
//        listGreaterThan50(entries);
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.stream().forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {

        System.out.println("*********************************");
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            if (entry.getDay() == Day.TUESDAY) {
                System.out.println(entry + " , ");
            }
        }
        System.out.println("*********************************\n");
        System.out.println("*********************************");
        System.out.println("Stream, filter, forEach:");
        entries.stream()
                .filter(d -> d.getDay() == Day.TUESDAY)
                .forEach(d -> System.out.println(d));
        System.out.println("*********************************\n");
    }

    public static void countTueWedThur(List<Entry> entries) {
        System.out.println("*********************************");
        System.out.println("For Loop:");
        int count = 0;
        for (Entry entry: entries) {
            if(entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY) {
                count++;
            }
        }
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
        System.out.println("*********************************\n");
        System.out.println("*********************************");
        System.out.println("Stream, filter, count: ");
        long count1 = entries.stream()
                //stuck here
                .filter(d -> d.getDay() == Day.TUESDAY || d.getDay() == Day.WEDNESDAY || d.getDay() == Day.THURSDAY)
                .count();
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println("*********************************\n");

    }

    public static void weekendList(List<Entry> entries) {
        System.out.println("*********************************");
        System.out.println("For Loop:");
        List<Entry> weekends = new ArrayList<>();
        for (Entry entry: entries) {
            if(entry.getDay() == Day.SATURDAY || entry.getDay() == Day.SUNDAY) {
                weekends.add(entry);
            }
        }
        System.out.println(weekends);
        System.out.println("*********************************\n");
        System.out.println("*********************************");
        System.out.println("Stream, filter, collect:");
        weekends = entries.stream()
                        .filter(d -> d.getDay() == Day.SATURDAY || d.getDay() == Day.SUNDAY)
                        .collect(Collectors.toList());
        System.out.println(weekends);
         System.out.println("*********************************\n");

    }

    //COLLECTS THE WRONG DAYS
    public static void weekdaySet(List<Entry> entries) {
        //Create a SET of weekday entries
        System.out.println("For Loop:");
        System.out.println("*********************************");
        Set<String> weekdays = new HashSet<>();
        for (Entry entry: entries) {
            if(entry.getDay() != Day.SATURDAY && entry.getDay() != Day.SUNDAY) {
                weekdays.add(entry.getDay().toString());
            }
        }
        System.out.println(weekdays);
        System.out.println("*********************************\n");
        System.out.println("*********************************");
        System.out.println("Stream, filter, map, collect:");
        weekdays = entries.stream()
                .filter(d -> d.getDay() != Day.SATURDAY)
                .filter(d -> d.getDay() != Day.SUNDAY)
                .map(d -> d.getDay().toString())
                .collect(Collectors.toSet());
        System.out.println(weekdays);
        System.out.println("*********************************\n");
    }
//
//    public static void printDurationGreaterThan10(List<Entry> entries){
//        System.out.println("For Loop:");
//        // write for loop
//        System.out.println("Stream, filter, forEach:");
//        // write stream
//        System.out.println();
//    }
//
//    public static void findMaxDuration(List<Entry> entries){
//        System.out.println("For Loop:");
//        int temp = 0;
//        // write for loop
//        System.out.println("The Max Duration is: " + temp);
//        System.out.println("Stream, mapToInt, max, getAsInt:");
//        temp = // write stream use mapToInt then max the getAsInt
//        System.out.println("The Max Duration is: " + temp);
//        System.out.println();
//    }
//
//    public static void listGreaterThan50(List<Entry> entries){
//        System.out.println("For Loop:");
//        List<Entry> greaterThan50 = new ArrayList<>();
//        // write for looop
//        System.out.println(greaterThan50);
//        System.out.println("Stream, filter, collect:");
//        // write stream
//        System.out.println(greaterThan50);
//        System.out.println();
//    }
}
