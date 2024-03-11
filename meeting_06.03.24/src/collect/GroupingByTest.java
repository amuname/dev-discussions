package collect;

import entities.XCase;
import entities.XClient;
import entities.XTopic;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByTest {
    public static void main(String[] args) {
        List<XCase> cases = prepareTestSet1();

        //groupingBy
        //counting()
        //List/Set
        //distinct or Set
        //mapping

        // если бы хотели выяснить сколько всего операторов работает, то сделали бы так
        List<String> list1 = cases.stream().map(XCase::getUser).distinct().toList();
        Set<String> set2 = cases.stream().map(XCase::getUser).collect(Collectors.toSet());

        //группируем в список просто все задания(именно сущности заданий)
        Map<XClient, List<XCase>> map1 = cases.stream().collect(Collectors.groupingBy(XCase::getClient));
        Map<String, List<XCase>> map2 = cases.stream().collect(Collectors.groupingBy(XCase::getClientInfo));

        //посмотрим количество заданий по абонентам
        Map<XClient, Long> map3 = cases.stream().collect(Collectors.groupingBy(XCase::getClient, Collectors.counting()));
        //по пользователям
        Map<String, Long> map4 = cases.stream().collect(Collectors.groupingBy(XCase::getUser, Collectors.counting()));

        //поиск уникальных клиентов через дистинкт
        List<XClient> list2 = cases.stream().map(XCase::getClient).distinct().toList();
        //поиск уникальных клиентов через сет
        Map<String, Set<XClient>> set1 = cases.stream().map(XCase::getClient).collect(Collectors.groupingBy(XClient::getInfo, Collectors.toSet()));

        //Группируем номера заданий+имя клиента по операторам
        Map<String, Map<String, String>> map5 = cases.stream().collect(Collectors.groupingBy(XCase::getUser, Collectors.toMap(xCase -> xCase.getNumber(), XCase::getClientInfo)));
        // Группируем всех уникальных клиентов, которые работают с конкретным сотрудником
        Map<String, Set<XClient>> mapSet =  cases.stream().collect(Collectors.groupingBy(XCase::getUser, Collectors.mapping(XCase::getClient, Collectors.toSet())));

        //группируем абонтентов и все их задания
        Map<String, Set<String>> mapSet2 = cases.stream().collect(Collectors.groupingBy(XCase::getClientInfo, Collectors.mapping(XCase::getNumber, Collectors.toSet())));

        // пример поиска максимального значения
        Map<String, Optional<Integer>> map6 =  cases.stream().collect(Collectors.groupingBy(XCase::getUser, Collectors.mapping(xCase -> Integer.parseInt(xCase.getNumber()), Collectors.maxBy(Integer::compareTo))));


        return;

    }

    private static List<XCase> prepareTestSet1() {
        List<XCase> cases  = new ArrayList<>();
        XClient client1 = new XClient("Журавлева", "Людмила", "9261261166");
        XClient client2 = new XClient("Андреев", "Андрей", "9998881010");
        XClient client3 = new XClient("Антонов", "Сергей", "9161230909");

        XTopic topic1 = new XTopic("Нет связи", "В квартире", "Прочее");
        XTopic topic2 = new XTopic("Нет связи", "Сотовой", "Прочее");
        XTopic topic3 = new XTopic("Аварийные работы", "Городские", "Ночью");

        cases.add(new XCase(topic1, client1, "antoshikhina"));
        cases.add(new XCase(topic1, client2, "antoshikhina"));
        cases.add(new XCase(topic1, client3, "antoshikhina"));
        cases.add(new XCase(topic2, client1, "antoshikhina"));
        cases.add(new XCase(topic2, client2, "antoshikhina"));
        cases.add(new XCase(topic2, client3, "antoshikhina"));
        cases.add(new XCase(topic3, client1, "antoshikhina"));
        cases.add(new XCase(topic3, client2, "sirotkina"));
        cases.add(new XCase(topic3, client3, "sirotkina"));

        return cases;
    }
}
