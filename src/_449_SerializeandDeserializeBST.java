public class _449_SerializeandDeserializeBST {


    public class Codec1 {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if(root == null) {
                return;
            }
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] strs = data.split(",");
            return build(strs, new int[1], Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode build(String[] strs, int[] pos, int min, int max) {
            if(pos[0] >= strs.length ||
                    Integer.valueOf(strs[pos[0]]) < min ||
                    Integer.valueOf(strs[pos[0]]) > max) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(strs[pos[0]++]));
            root.left = build(strs, pos, min, root.val);
            root.right = build(strs, pos, root.val, max);
            return root;
        }
    }


    public class Codec2 {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if(root == null) {
                return;
            }
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] strs = data.split(",");
            return build(strs, new int[1], Integer.MAX_VALUE);
        }

        private TreeNode build(String[] strs, int[] pos, int max) {
            if(pos[0] >= strs.length || Integer.valueOf(strs[pos[0]]) > max) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(strs[pos[0]++]));
            root.left = build(strs, pos, root.val);
            root.right = build(strs, pos, max);
            return root;
        }
    }
}
