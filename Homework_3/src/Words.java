import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Words {

    public static void main(String[] args) {

        Integer counter;
        ArrayList<String> list = new ArrayList<>(11);

        list.add("Каждый");
        list.add("Охотник");
        list.add("Желает");
        list.add("Желает");
        list.add("Желает");
        list.add("Знать");
        list.add("Где");
        list.add("Сидит");
        list.add("Фазан");
        list.add("Сидит");
        list.add("Охотник");

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < list.size(); i++)
        {
           counter = hm.get(list.get(i));
           if (counter == null) hm.put(list.get(i), 1);
           else hm.put(list.get(i), counter +1);
        }

        System.out.println("Cписок уникальных слов, из которых состоит массив:  " + hm.size());
        System.out.println("Каждое слово встречается: " + hm);

        System.out.println("\n-------------------------------------------------");

        Phonebook phone_1 = new Phonebook("Пирожков", 8911111);
        Phonebook phone_2 = new Phonebook("Пугачева", 8922222);
        Phonebook phone_3 = new Phonebook("Трамп", 8933333);
        Phonebook phone_4 = new Phonebook("Собчак", 8944444);
        Phonebook phone_5 = new Phonebook("Антонов", 8955555);
        Phonebook phone_6 = new Phonebook("Пугачева", 8966666);


        ArrayList<Phonebook> list_2 = new ArrayList<>();
        list_2.add(phone_1);
        list_2.add(phone_2);
        list_2.add(phone_3);
        list_2.add(phone_4);
        list_2.add(phone_5);
        list_2.add(phone_6);

        add("Киркоров", 8977777, list_2);   // добавление записи

        System.out.println(get("Пугачева", list_2));    // поиск номера по фамилии

    }

    //------------------------------------------------------------

    public static String get(String name, ArrayList<Phonebook> list)
    {
        String finder = "";
        for (Phonebook ph : list)
        {
            if (ph.getName().equalsIgnoreCase(name))
            {
                finder += "\n"+ ph.getNumber();
            }

        }   return finder;
    }

    public static void add(String name, int number, ArrayList<Phonebook> list)
    {
        Phonebook phone = new Phonebook(name, number);
        list.add(phone);
    }
}

