package com.features.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	@SuppressWarnings("unchecked")
	public void convertNumbersIntoStream() {
		Stream stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		// using double colon
		stream.forEach(System.out::print);
		// using lambda
		stream.forEach(x -> System.out.print(x));
	}

	public void FunctionalInterface() {
		Consumer<Integer> c = (a) -> System.out.println(a);

		c.accept(100);
		c.andThen(c).accept(200);
	}

	public void mapInStream() {
		List<Employees> e = new ArrayList<Employees>();
		e.add(new Employees("emp1", 25, 2000));
		e.add(new Employees("emp2", 30, 1000));
		e.add(new Employees("emp3", 18, 900));
		e.add(new Employees("emp4", 35, 5000));

		List<String> list = e.stream().filter(emp -> emp.getSalary() <= 1000).map(Employees::getName)
				.collect(Collectors.toList());
//		List<Employees> list = e.stream().map(emp -> new Employees(emp.name, emp.getAge(), emp.getSalary()))
//				.collect(Collectors.toList());
		list.stream().forEach(System.out::println);

		// Increment salary by 1000
//		e.stream().map(emp -> emp.getSalary() + 1000).forEach(System.out::print);
	}

	public void square() {
		List<Integer> squareList = Stream.of(6, 5, 4, 6, 7, 4, 7, 4, 7, 3).map(a -> a * a).collect(Collectors.toList());
//		squareList.stream().forEach(System.out::print);

//		squareList = squareList.stream().sorted().collect(Collectors.toList());
//		squareList = squareList.stream().sorted((x, x1) -> x1.compareTo(x)).collect(Collectors.toList());
//		squareList = squareList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(squareList);
	}

	public void maptolist() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "value1");
		map.put(2, "value2");
		map.put(3, "value3");
		map.put(4, "value4");

		List<Integer> keys = map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(keys);
	}

	public void stirngListTOintList() {
		List<Integer> list = Stream.of("1", "2", "3", "4", "5", "6").map(x -> Integer.valueOf(x))// .filter(null)
				.collect(Collectors.toList());

		System.out.println(list);
//		IntStream stream = IntStream.range(1, 100);
	}

	public void count() {
		long count = IntStream.range(1, 100).count();
		System.out.println(count);
	}

	public void reduce() {
		OptionalInt count = IntStream.range(1, 100).reduce((a, b) -> a > b ? a : b);
		count = IntStream.range(1, 100).reduce((a, b) -> a + b);
		System.out.println(count);
		List<String> list = new ArrayList<String>();
		// Adding elements in the List
		list.add("Mango");
		list.add("Apple");
		list.add("Banana");
		list.add("Grapes");
		Optional<String> s = list.stream().reduce((a, b) -> a + " " + b);
		System.out.println(s.get());
	}

	public void limitAndSkip() {
		IntStream.range(1, 100).skip(30).limit(20).forEach(System.out::print);
	}

	public void iterateAndGenerate() {
		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());
		list.forEach(System.out::println);
		list = Stream.generate(new Random()::nextInt).limit(5).collect(Collectors.toList());
		list.forEach(System.out::println);
		Optional<Integer> l = list.stream().max(Integer::compare);
		l = list.stream().max((a, b) -> a > b ? a : b);
	}

	public void terminalOperations() {
		List<Employees> e = new ArrayList<Employees>();
		e.add(new Employees("emp1", 25, 2000));
		e.add(new Employees("emp2", 18, 1000));
		e.add(new Employees("emp3", 18, 900));
		e.add(new Employees("emp4", 35, 5000));

		Collection<Integer> sets = e.stream().map(Employees::getAge).distinct()
				.collect(Collectors.toCollection(TreeSet::new));
		sets.forEach(System.out::println);
		Long count = e.stream().map(Employees::getName).collect(Collectors.counting());// count();
		System.out.println(count);

		List<String> list = new ArrayList<String>();
		// Adding elements in the List
		list.add("Mango");
		list.add("Apple");
		list.add("Banana");
		list.add("Grapes");

		String s = list.stream().collect(Collectors.joining(","));
		System.out.println(s);
		s = list.stream().collect(Collectors.joining(",", "chinna ", " reddy"));
		System.out.println(s);

		Map<Integer, List<Employees>> emp = e.stream().collect(Collectors.groupingBy(Employees::getAge));
		emp.entrySet().forEach(System.out::println);

		e.stream().collect(Collectors.mapping(Employees::getName, Collectors.toList()));
	}

	public void revision() {

		String s = "chinna reddy";
		Set ser = new TreeSet<Character>();

		s.chars().filter(a -> s.lastIndexOf(a) == s.indexOf(a)).limit(1)
				.forEach(a -> System.out.println(Character.toString(a)));
	}

	public void dateAndTime() {
		System.out.println("the current year is " + LocalDateTime.now().getYear());
		System.out.println("the current date is " + LocalDate.now());
		System.out.println("the current time is " + LocalTime.now());
		System.out.println("the current date and time  is " + LocalDateTime.now());
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println("the current time is " + LocalDateTime.now().format(formate));
		System.out.println(LocalDateTime.now().getMonth() + " " + LocalDateTime.now().getMonth().getValue());
		System.out.println(LocalDateTime.now().getDayOfWeek() + " " + LocalDateTime.now().getDayOfWeek().getValue());
		System.out.println(ZonedDateTime.now().getZone());

	}

	public void QuickSort() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.stream().map(x -> Integer.toString(x)).filter(x -> x.contains("1")).forEach(System.out::println);
	}

}
