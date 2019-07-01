import java.util.*;

public class ValidateHooks {

    public static Set<String> validate(String input) {
        Set<String> ans = new HashSet<String>();
        if (input == null || input.length() == 0) {
            ans.add("");
            return ans;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add(input);
        boolean flag = false;
        Set<String> tested = new HashSet<String>();

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                String top = queue.poll();
                if (tested.contains(top)) {
                    continue;
                }
                if (sequenceBracket(top)) {
                    flag = true;
                    ans.add(top);
                }

                if (!flag) {
                    tested.add(top);
                    for (int j = 0; j < top.length(); j++) {
                        String add = top.substring(0, j) + top.substring(j + 1, top.length());
                        queue.add(add);
                    }
                }
            }
            if (flag) break;
        }
        return ans;
    }

    private static boolean sequenceBracket(String input) {
        int balanceIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '{') {
                balanceIndex++;
            }

            if (current == '}') {
                if (balanceIndex == 0) {
                    return false;
                }
                balanceIndex--;
            }
        }

        if (balanceIndex == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}

