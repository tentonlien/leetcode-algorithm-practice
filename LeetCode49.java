import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {

    private Map<String, List<String>> map = new HashMap<>();

    private String sortStr(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            for (int k = i; k < arr.length; k ++) {
                if (arr[i] > arr[k]) {
                    char swap = arr[i];
                    arr[i] = arr[k];
                    arr[k] = swap;
                }
            }
        }
        return new String(arr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < strs.length; i ++) {
            String sortedStr = sortStr(strs[i]);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(strs[i]);
            } else {
                List<String> val = new ArrayList<>();
                val.add(strs[i]);
                map.put(sortedStr, val);
            }
        }
        for (Map.Entry<String, List<String>> item: map.entrySet()) {
            results.add(item.getValue());
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new LeetCode49().groupAnagrams(new String[]{""}));
        System.out.println(new LeetCode49().groupAnagrams(new String[]{"", ""}));
    }
}