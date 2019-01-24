
# 算法

## 问题域

- 围绕数据结构的问题：
  - [Array](doc/Array.md)
  - [Matrix](doc/Matrix.md)
  - [String](doc/String.md)
  - [Linked List](doc/LinkedList.md)
  - [Tree](doc/Tree.md)
  - [Queue](doc/Queue.md)
  - [Stack](doc/Stack.md)
  - [Bit](doc/Bit.md)

  - [Graph](doc/Graph.md)
- 某种特定问题：
  - [Search](doc/Search.md)
  - [Sort](doc/Sort.md)
  - [Math](doc/Math.md)
  - [Permutation](doc/Permutation.md)
  - [Combination](doc/Combination.md)
  - [Big Data](doc/BigData.md)
  - [Single Number](doc/SingleNumber.md)
  - [Maze](doc/Maze.md)
  - [Probability](doc/Probability.md)

## 解域

- [Brute Force - bf](doc/BruteForce.md)

- [Dynamic Programing - dp](doc/DynamicPrograming.md)

- [Divide and Conque - dc](doc/DivideAndConque.md)

- [Greedy](doc/Greedy.md)

- [Backtracking](doc/Backtracking.md)

- [Bit Manipulation](doc/BitManipulation.md)

## Java

### 库
```
String
    length()
    charAt(int)
    substring(int, int)
    toCharArray()
    String(char[])
    
Set 实现: HashSet<T>等
	contains(o)
	add(o)
	remove(o)
	
Queue 实现:LinkedList等
	offer()
	poll()
	peek()

PriorityQueue 本身是类，实现了Queue接口
	构造函数传lambda expression
	offer()
	poll()
	peek()

Deque 实现:LinkedList等
	stack等价接口：
		push()
		pop()
		peek()

List 实现:LinkedList, ArrayList等

Map
	containsKey()
	get()
	put()
	
Sort
	Arrays.sort()
	
Collections
	Collections.reverse()
	
Character
	isLetter()
	toUpperCase()
	toLowerCase()

```

### Java惯用法

- 函数作为参数
	- java 8 lambda expressions [OddBeforeEven](./java/src/main/java/array/OddBeforeEven.java)

- 自定义实现Comparator接口对象的排序
	- Arrays.sort()的参数Comparator<T>中的T不能是int，所以不可以给int[]传Comparator<T>，一个方法是把int[]转成Integer[]
	- Comparator接口是一个@FunctionalInterface, 所以可以直接用lambda expression简化代码

## books

《算法》

《程序员代码面试指南》

《剑指offer》（第1版）

《算法导论》

《大话数据结构》

《挑战程序设计竞赛》

《编程之美》

《计算机程序设计艺术》

《灵机一动》

