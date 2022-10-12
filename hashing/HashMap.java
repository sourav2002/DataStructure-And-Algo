import java.util.Map; 
import java.util.HashMap; 
class HashMapDemo { 
  public static void main(String[] args) { 
    Map<Integer, String> numbers = new HashMap<>(); 
        numbers.put(1, "One"); 
        numbers.put(2, "Two"); 
        numbers.put(3, "Three"); 
        System.out.println("Map: " + numbers); 
        System.out.println("Keys: " + numbers.keySet()); 
        System.out.println("Values: " + numbers.values()); 
        System.out.println("Entries: " + numbers.entrySet()); 
        String value = numbers.remove(2); 
        System.out.println("Removed Value: " + value); 
  }
}
