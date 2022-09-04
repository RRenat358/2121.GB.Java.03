import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class OtherMetodApp {
    public static void main(String[] args) {

        //Устаревший немного метод, т.к. медленно синхронизтолван
        //только один поток може обращаться
        Vector<String> vector = new Vector<>();


        //Требует много памяти, т.к. для каждодго потока создаётся копия всего массива
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();


        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


        //одним патоком блокируется только один бакет,
        //другому патоку, можно работать с другим бакетом
        Map<String, String> map2 = Collections.synchronizedMap(new HashMap<>());



    }


}
