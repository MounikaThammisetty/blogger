package com.blog;


import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.ArrayList;

import java.util.Collections;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainUtil {
    // Practice Stream Api
    //predicate interface is method that method is boolean it can take any data type
   public static void main(String[] args) {
       Movie m1 = new Movie("Darling",10,2012);
       Movie m2 = new Movie("Animal",8,2023);
       Movie m3 = new Movie("MAD",10,2022);

       ArrayList<Movie> list = new ArrayList<Movie>();
       list.add(m1);
       list.add(m2);
       list.add(m3);
       MovieRating movierating = new MovieRating();
       Collections.sort(list,movierating);
       for(Movie m:list){
           System.out.println(m.getName());
           System.out.println(m.getYear());
           System.out.println(m.getRating());
       }


//        Predicate<String> condition = x->x.equals("mouni");
//        boolean val = condition.test("mouni");
//       System.out.println(val);
//        List<Integer> data = Arrays.asList(10, 20, 30, 5, 50, 100);
//        List<Integer> newData = data.stream().filter(x -> x > 20).collect(Collectors.toList());
//        Employee emp1 = new Employee();
//        emp1.setName("mike");
//        emp1.setCity("Bengalore");
//        emp1.setSalary(10000);
//
//        Employee emp2 = new Employee();
//        emp2.setName("stallin");
//        emp2.setCity("chennai");
//        emp2.setSalary(5000);
//
//        Employee emp3 = new Employee();
//        emp3.setName("smith");
//        emp3.setCity("Delhi");
//        emp3.setSalary(10000);
//
//        Employee emp4 = new Employee();
//        emp4.setName("adam");
//        emp4.setCity("Bengalore");
//        emp4.setSalary(8000);
//
//        List<Employee> data = Arrays.asList(emp1,emp2,emp3,emp4);
//        List<Employee> newData = data.stream().filter(e->e.getSalary()==10000).collect(Collectors.toList());
//        List<Employee> newData = data.stream().filter(e->e.getCity().equalsIgnoreCase("delhi")).collect(Collectors.toList());
//        for(Employee employee:newData){
//            System.out.println(employee.getName());
//            System.out.println(employee.getCity());
//            System.out.println(employee.getSalary());
//        }
//        List<String> data = Arrays.asList("mike", "stallin", "mithin", "mike", "smith", "michael");
//       List<String> newData = data.stream().filter(x->x .startsWith("m")).collect(Collectors.toList());
        //List<String> newData = data.stream().filter(x->x .endsWith("n")).collect(Collectors.toList());
//        List<String> newData = data.stream().filter(x->x .equals("mike")).collect(Collectors.toList());
//        System.out.println(newData.size());
// }

    }
}
