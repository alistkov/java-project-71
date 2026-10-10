package hexlet.code;

import java.util.*;

public class DiffTree {
    public static Map<String, Map<String, Object>> build(Map<String, Object> content1, Map<String, Object> content2) {
        Map<String, Map<String, Object>> result = new LinkedHashMap<>();
        var keys = new HashSet<>(content1.keySet());
        keys.addAll(content2.keySet());
        var keysList = new ArrayList<>(keys);
        Collections.sort(keysList);

        for (var key : keysList) {
            var keyInfo = new HashMap<String, Object>();
            var hasInFirst = content1.containsKey(key);
            var hasInSecond = content2.containsKey(key);
            var valueInFirst = content1.get(key);
            var valueInSecond = content2.get(key);

            if (hasInFirst && !hasInSecond) {
                keyInfo.put("status", "deleted");
                keyInfo.put("oldValue", valueInFirst);
            } else if (!hasInFirst && hasInSecond) {
                keyInfo.put("status", "added");
                keyInfo.put("newValue", valueInSecond);
            } else if (valueInFirst.equals(valueInSecond)) {
                keyInfo.put("status", "not changed");
                keyInfo.put("value", valueInFirst);
            } else {
                keyInfo.put("status", "updated");
                keyInfo.put("oldValue", valueInFirst);
                keyInfo.put("newVAlue", valueInSecond);
            }
            result.put(key, keyInfo);
        }
        return result;
    }
}
