import sorting.QuickSort;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Challenge001 {

    public static List<Integer> parseEventsStringToEventsList(String eventsString, int line, List<String> errors) {
        String[] eventsStr = eventsString.split(" ");
        List<Integer> eventsInt = new ArrayList<>(eventsStr.length);
        try {
            for (String event : eventsStr) {
                if (!event.isEmpty()) {
                    eventsInt.add(Integer.valueOf(event));
                }
            }
            return eventsInt;
        } catch (NumberFormatException e) {
            errors.add(String.format("FAILURE => WRONG INPUT (LINE %d)", line));
            return new ArrayList<Integer>();
        }
    }

    public static int getTotalCases(String str) throws Exception {
        try {
            return Integer.valueOf(str);
        } catch (InputMismatchException | NumberFormatException e) {
            throw new Exception("FAILURE => WRONG INPUT (LINE 1)");
        }
    }

    public static List<String> compute(String casesStr, String[] eventByLine) {
        long start = System.nanoTime();
        List<String> errors = new ArrayList<>();
        try {
            int cases = getTotalCases(casesStr);
            int line = 0;
            while (cases > 0) {
                cases--;
                List<Integer> eventsList = parseEventsStringToEventsList(eventByLine[line], ++line, errors);
                if (eventsList.isEmpty()) {
                    continue;
                }
                QuickSort.sort(eventsList);
                int eventsTotal = eventsList.size();
                int expectedEvents = eventsList.get((eventsTotal - 1));
                if (expectedEvents == eventsTotal) {
                    errors.add(String.format("SUCCESS => RECEIVED: %d", eventsTotal));
                    continue;
                }
                errors.add(String.format("FAILURE => RECEIVED: %d, EXPECTED: %d", eventsTotal, expectedEvents));
            }
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        System.out.println("Time consume: " + (System.nanoTime() - start));
        return errors;
    }


}
