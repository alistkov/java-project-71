package hexlet.code;

import java.util.*;

public class DiffTree {
    public static ArrayList<DiffNode> build(
            Map<String, Object> content1, Map<String, Object> content2) {
        var result = new ArrayList<DiffNode>();
        var keys = new HashSet<>(content1.keySet());
        keys.addAll(content2.keySet());
        var keysList = new ArrayList<>(keys);
        Collections.sort(keysList);

        for (var key : keysList) {
            var hasInFirst = content1.containsKey(key);
            var hasInSecond = content2.containsKey(key);
            var valueInFirst = content1.get(key);
            var valueInSecond = content2.get(key);

            if (hasInFirst && !hasInSecond) {
                result.add(new DiffNode(key, Status.DELETED, valueInFirst, null));
            } else if (!hasInFirst && hasInSecond) {
                result.add(new DiffNode(key, Status.ADDED, null, valueInSecond));
            } else if (Objects.deepEquals(valueInFirst, valueInSecond)) {
                result.add(new DiffNode(key, Status.UNCHANGED, valueInFirst, valueInSecond));
            } else {
                result.add(new DiffNode(key, Status.CHANGED, valueInFirst, valueInSecond));
            }
        }
        return result;
    }
}
