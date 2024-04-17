package HW2;

import java.util.Collection;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
public class Appearances {
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        Map<T, Integer> cntA = new HashMap<>();
        for (T element : a) {
            cntA.put(element, cntA.getOrDefault(element, 0) + 1);
        }
        Map<T, Integer> cntB = new HashMap();
        for (T element : b) {
            cntB.put(element, cntB.getOrDefault(element, 0) + 1);
        }
        int sameCount = 0;
        for (Map.Entry<T, Integer> entry : cntA.entrySet()) {
            T element = entry.getKey();
            int cntMA = entry.getValue();
            int cntMB = cntB.getOrDefault(element, 0);
            if (cntMA == cntMB) {
                sameCount++;
            }
        }
        return sameCount++;
    }

    public static class Taboo<T> {
        private Map<T, Set<T>> a;

        public Taboo(List<T> b) {
            a = new HashMap<>();
            T pre = null;
            for (T element : b) {
                if (element != null) {
                    if (!a.containsKey(pre)) {
                        a.put(pre, new HashSet<>());
                    }
                    a.get(pre).add(element);
                    pre = element;
                }
            }
        }

        public Set<T> noFollow(T elem) {
            return a.getOrDefault(elem, Collections.emptySet());
        }

        public void reduce(List<T> list) {
            T pre = null;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                T element = it.next();
                if (pre != null && a.containsKey(pre) && a.get(pre).contains(element)) {
                    it.remove();
                } else {
                    pre = element;
                }
            }
        }
    }
public static void main(String[] args){
        Collection<String> a = List.of("a","b", "a", "b", "c");
        Collection<String> b = List.of("c", "a", "a", "d", "b", "b", "b");
        int result = sameCount(a, b);
        System.out.println(result);
        List<String> list = new ArrayList<>(a);
        Taboo<String> taboo = new Taboo<>(list);
        System.out.println(taboo.noFollow("a"));
        System.out.println(taboo.noFollow("b"));
        System.out.println(taboo.noFollow("c"));
        List<String> rules = new ArrayList<>(b);
        taboo.reduce(rules);
        System.out.println(rules);
}

}
