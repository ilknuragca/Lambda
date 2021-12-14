package teamlambda;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeRunner {
	public static void main (String args[]) {
	Employee employee1= new Employee("Jane", 15);
    Employee employee5= new Employee("Jake", 18);
    Employee employee3= new Employee("John", 37);
    Employee employee2= new Employee("Jake", 22);
    Employee employee4= new Employee("Joanna", 17);
    Employee employee6= new Employee("Jane", 19);

List<Employee> list = Arrays.asList(employee1, employee2,employee3,employee4,employee5, employee6);

// 1st Question:Given a list of employees, you need to filter all the employee whose age is greater than 20 and print the employee names.   

List <String> filteredList= list.stream().filter(e->e.getAge()>20).map(Employee::getName).collect(Collectors.toList());
   System.out.println(filteredList);
   
//2nd Question: Given the list of employees, count number of employees with age 25?

    long count= list.stream().filter(e->e.getAge()>37).count();
    System.out.println(count);

//3rd Question: Given the list of employees, find the employee with name “Jane”.

    Employee name= list.stream().filter(e->e.getName().equalsIgnoreCase("Jane")).findAny().get();
 
  
    //4th Question: Given a list of employee, find maximum age of employee?
  int max = list.stream().mapToInt(Employee::getAge).max().getAsInt();
    System.out.println(max);
    
    
    //5th Question: Select particular names and print in the console

    List <Employee> names5= list.stream().filter(e->e.getName().equalsIgnoreCase("joanna")).collect(Collectors.toList());
    System.out.println(names5);

    // 6th Question: Given a list of employees, sort all the employee on the basis of age?
   List<Employee> sortedList= list.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList());
    System.out.println(sortedList);
    
//7th Question: Join the all employee names with “,” using java 8?
    List<String> names= list.stream().map(Employee::getName).collect(Collectors.toList());
    System.out.println(names);

    String names2= String.join(",",names);
    System.out.println(names2);
    
   //8th Question: Given the list of employee, group them by employee name?   
    Map <String, List<Employee>> groupBy= list.stream().collect(Collectors.groupingBy(Employee::getName));

    groupBy.forEach((nameFromMap, listFromMap)->System.out.println("Name: "+nameFromMap+ "===>"+listFromMap ));
}
}