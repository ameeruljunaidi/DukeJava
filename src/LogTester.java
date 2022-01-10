
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class LogTester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);

        System.out.println(le);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("input/UniqueIPData/short-test_log");
        la.printAll();
    }

    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("input/UniqueIPData/short-test_log");
        System.out.println(la.countUniqueIPs());
    }

    public void testPrintFilterByNum() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("input/UniqueIPData/weblog-short_log");
        la.printAllHigherThanNum(400);
    }

    public void testPrintFilterByDate() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("input/UniqueIPData/weblog1_log");

        ArrayList<String> ipAddresses = la.uniqueIPVisitsOnDay("Mar 17");

        for (String ipAddress : ipAddresses) {
            System.out.println(ipAddress);
        }

        System.out.println("Count: " + ipAddresses.size());
    }

    public void testUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("input/UniqueIPData/weblog1_log");

        System.out.println(la.countUniqueIPsInRange(200, 299));
    }
}
