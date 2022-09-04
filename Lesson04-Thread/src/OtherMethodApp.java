import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class OtherMethodApp {
    public static void main(String[] args) {

        //Устаревший немного метод, т.к. медленно синхронизтолван
        //только один поток може обращаться
        Vector<String> vector = new Vector<>();


        //Требует много памяти, т.к. для каждодго потока создаётся копия всего массива
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();


        ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
        Map<String, String> map2 = new ConcurrentHashMap<>();

        //одним патоком блокируется только один бакет,
        //другому патоку, можно работать с другим бакетом
        Map<String, String> map3 = Collections.synchronizedMap(new HashMap<>());
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());



    }


}
