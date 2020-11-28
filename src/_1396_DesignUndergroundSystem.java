import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class _1396_DesignUndergroundSystem {
    class UndergroundSystem {

        Map<Integer, Pair<String, Integer>> checkInMap;  // Uid - {StationName, Time}
        Map<String, Pair<Integer, Integer>> checkoutMap; // Route - {TotalTime, Count}
        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            checkoutMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> checkIn = checkInMap.get(id);
            String route = checkIn.getKey() + "_" + stationName;
            int totalTime = t - checkIn.getValue();
            Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0, 0));
            checkoutMap.put(route, new Pair<>(checkout.getKey() + totalTime, checkout.getValue() + 1));
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "_" + endStation;
            Pair<Integer, Integer> checkout = checkoutMap.get(route);
            return (double) checkout.getKey() / checkout.getValue();
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}

