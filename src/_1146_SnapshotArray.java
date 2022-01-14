import java.util.TreeMap;

public class _1146_SnapshotArray {
    class SnapshotArray {

        TreeMap<Integer, Integer>[] treemap;
        int snapid;
        public SnapshotArray(int length) {
            treemap = new TreeMap[length];
            snapid = 0;
            for(int i = 0; i < length; i++) {
                treemap[i] = new TreeMap<>();
                treemap[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            treemap[index].put(snapid, val);
        }

        public int snap() {
            return snapid++;
        }

        public int get(int index, int snap_id) {
            return treemap[index].floorEntry(snap_id).getValue();
        }
    }
}
