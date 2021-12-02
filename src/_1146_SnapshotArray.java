import java.util.TreeMap;

public class _1146_SnapshotArray {
    class SnapshotArray {
        TreeMap<Integer, Integer>[] mapArr;
        int snapId;
        public SnapshotArray(int length) {
            mapArr = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                mapArr[i] = new TreeMap<Integer, Integer>();
                mapArr[i].put(0, 0);
            }
            snapId = 0;
        }

        public void set(int index, int val) {
            mapArr[index].put(snapId, val);
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return mapArr[index].floorEntry(snap_id).getValue();
        }
    }
}
