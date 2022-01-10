/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

import edu.duke.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        this.records = new ArrayList<>();
    }

    /**
     * Read a file line by line and add all the log entries into the array
     *
     * @param filename the name of the file to read from
     */
    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);

        for (String line : fr.lines()) {
            LogEntry le = WebLogParser.parseEntry(line);
            this.records.add(le);
        }
    }

    /**
     * Print all the LogEntry in the log entry ArrayList
     */
    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    /**
     * Get the number of unique IP addresses, assumes member variable records already filled in
     *
     * @return size of a local ArrayList within method
     */
    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<>();

        for (LogEntry logEntry : records) {
            if (!uniqueIPs.contains(logEntry.getIpAddress())) {
                uniqueIPs.add(logEntry.getIpAddress());
            }
        }

        return uniqueIPs.size();
    }

    /**
     * Examine all the web log entries in records and print those LogEntry that have a status code greater than num
     *
     * @param num the lowe bound (non-inclusive)
     */
    public void printAllHigherThanNum(int num) {
        for (LogEntry logEntry : records) {
            if (logEntry.getStatusCode() > num) {
                System.out.println(logEntry);
            }
        }
    }

    /**
     * Access the web logs in records and return an ArrayList of Strings of unique IP address
     * that has had access on any given day
     *
     * @param someday format is "MMM DD" where
     *                MMM is the first three characters of the month with the first letter capitalized
     *                DD is the day in two digits
     *                <p>
     *                Example: "Dec 05" and "Apr 22"
     * @return the ArrayList of unique IP visits
     */
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPs = new ArrayList<>();

        for (LogEntry logEntry : records) {
            if (logEntry.getAccessTime().toString().contains(someday) && !uniqueIPs.contains(logEntry.getIpAddress())) {
                uniqueIPs.add(logEntry.getIpAddress());
            }
        }

        return uniqueIPs;
    }

    /**
     * Ge the number of unique IP addresses in records that have a status code in the range from low to high, inclusive
     *
     * @param low  the left boundary, inclusive
     * @param high the  right boundary, inclusive
     * @return the size of the local ArrayList
     */
    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPs = new ArrayList<>();

        for (LogEntry logEntry : records) {
            if (logEntry.getStatusCode() >= low && logEntry.getStatusCode() <= high &&
                    !uniqueIPs.contains(logEntry.getIpAddress())) {
                uniqueIPs.add(logEntry.getIpAddress());
            }
        }

        return uniqueIPs.size();
    }
}
