import java.util.*;

public class HashTable {
  public static class Tuple {
    public final Integer first;
    public final String second;
    public Tuple(Integer first, String second) {
      this.first = first;
      this.second = second;
    }
  }

  public static class HashMapV {
    private HashMap<Integer, ArrayList<Tuple>> map;
    public HashMapV() {
      map = new HashMap<Integer, ArrayList<Tuple>>();
    }
    public void put(Integer key, String value, Integer version) {
      ArrayList<Tuple> list = map.get(key);
      if (list == null) {
        list = new ArrayList<Tuple>();
      }
      list.add(0, new Tuple(version, value));
      map.put(key, list);
    }
    public String get(Integer key) {
      return get(key, null);
    }
    public String get(Integer key, Integer version) {
      ArrayList<Tuple> list = map.get(key);
      if (list == null) {
        return null;
      }
      if (version == null) return list.get(0).second;
      for (Tuple t : list) {
        if (version >= t.first) return t.second;
      }
      return list.get(0).second;
    }
  }

  // just for debug
  public static void printMap(Map<Integer, ArrayList<Tuple>> map) {
    for (Map.Entry<Integer, ArrayList<Tuple>> entry : map.entrySet()) {
      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().get(0).second + " (version " + entry.getValue().get(0).first + ")");
    }
  }

  public static void main(String[] args) {
    HashMapV map = new HashMapV();
    map.put(123, "myvalue", 0);
    map.put(123, "mynewvalue", 3);
    System.out.println(map.get(123, 2));
    System.out.println(map.get(123, 4));
  }
}
