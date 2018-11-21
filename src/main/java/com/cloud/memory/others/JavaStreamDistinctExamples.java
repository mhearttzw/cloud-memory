package com.cloud.memory.others;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamDistinctExamples
{
    public static void main(String[] args)
    {
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Lokesh", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");

        //Add some random persons
        Collection<Person> list = Arrays.asList(lokesh,brian,alex,lokesh,brian,lokesh);

        // Get distinct objects by key
        List<Person> distinctElements = list.stream()
                .filter( distinctByKey(p -> p.getId()) )
                .collect( Collectors.toList() );

        // Let's verify distinct elements
        System.out.println( distinctElements );

        // Map implement
        // 对象转Map
        Collection<Person> personList = Arrays.asList(lokesh, brian);
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> modifiedM = oMapper.convertValue(lokesh, Map.class);
        Map<String, Object> primitiveM = oMapper.convertValue(brian, Map.class);


        Map<String, Object> streamResult = modifiedM.entrySet().stream().filter(entry -> !primitiveM.get(entry.getKey()).equals(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        JSONObject result = new JSONObject();
        modifiedM.entrySet().stream().filter(entry -> !primitiveM.get(entry.getKey()).equals(entry.getValue()))
                .forEach(entry -> result.put(entry.getKey(), entry.getValue()));
        System.out.println("=============================");
        System.out.println(streamResult);
        System.out.println(result);
    }

    //Utility function
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

//Model class
@Data
class Person
{
    public Person(Integer id, String fname, String lname) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    private Integer id;
    private String fname;
    private String lname;

    //Getters and Setters

    @Override
    public String toString() {
        return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
    }
}