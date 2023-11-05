package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TasksTest {

    @Test
    void Task1Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 27, 70, 25, false));

        List<Animal> sortedList = List.of(
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 27, 70, 25, false));

        List<Animal> result = Tasks.task1(list);

        assertThat(result).isEqualTo(sortedList);
    }

    @Test
    void Task1Test2() {
        List<Animal> list = List.of();

        List<Animal> result = Tasks.task1(list);

        assertThat(result).isEqualTo(List.of());
    }

    @Test
    void Task1Test3() {
        List<Animal> result = Tasks.task1(null);

        assertThat(result).isEqualTo(null);
    }

    @Test
    void Task2Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 27, 70, 25, false));

        List<Animal> sortedList = List.of(
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        List<Animal> result = Tasks.task2(list, 3);

        assertThat(result).isEqualTo(sortedList);
    }

    @Test
    void Task2Test2() {
        List<Animal> list = List.of(
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false));

        List<Animal> sortedList = List.of(
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true));

        List<Animal> result = Tasks.task2(list, 3);

        assertThat(result).isEqualTo(sortedList);
    }

    @Test
    void Task2Test3() {
        List<Animal> list = List.of(
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false));


        List<Animal> result = Tasks.task2(list, -1);

        assertThat(result).isEqualTo(null);
    }

    @Test
    void Task3Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 22, 64, 15, false));

        Map<Animal.Type, Integer> map = Map.of(
            Animal.Type.FISH, 1,
            Animal.Type.BIRD, 2,
            Animal.Type.CAT, 1,
            Animal.Type.DOG, 2);

        Map<Animal.Type, Integer> result = Tasks.task3(list);

        assertThat(result).isEqualTo(map);
    }

    @Test
    void Task4Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dtew", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 22, 64, 15, false));

        Animal animal = new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true);

        Animal result = Tasks.task4(list);

        assertThat(result).isEqualTo(animal);
    }

    @Test
    void Task5Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 27, 70, 25, false));

        Animal.Sex result = Tasks.task5(list);

        assertThat(result).isEqualTo(Animal.Sex.M);
    }

    @Test
    void Task6Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 22, 64, 15, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        Map<Animal.Type, Animal> map = Map.of(
            Animal.Type.FISH, new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            Animal.Type.BIRD, new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            Animal.Type.CAT, new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            Animal.Type.DOG, new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        Map<Animal.Type, Animal> result = Tasks.task6(list);

        assertThat(result).isEqualTo(map);
    }

    @Test
    void Task7Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dtew", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        Animal animal = new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true);

        Animal result = Tasks.task7(list, 2);

        assertThat(result).isEqualTo(animal);
    }

    @Test
    void Task7Test2() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dtew", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        Animal result = Tasks.task7(list, 20);

        assertThat(result).isEqualTo(null);
    }

    @Test
    void Task7Test3() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dtew", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        Animal result = Tasks.task7(list, -1);

        assertThat(result).isEqualTo(null);
    }

    @Test
    void Task8Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dtew", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        Optional<Animal> animal = Optional.of(new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true));

        Optional<Animal> result = Tasks.task8(list, 30);

        assertThat(result).isEqualTo(animal);
    }

    @Test
    void Task8Test2() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dtew", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        Optional<Animal> animal = Optional.empty();

        Optional<Animal> result = Tasks.task8(list, 0);

        assertThat(result).isEqualTo(animal);
    }

    @Test
    void Task9Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bfgsdg", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("dtew", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        Integer result = Tasks.task9(list);

        assertThat(result).isEqualTo(16);
    }

    @Test
    void Task10Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false));

        List<Animal> correctList = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        List<Animal> result = Tasks.task10(list);

        assertThat(result).isEqualTo(correctList);
    }

    @Test
    void Task11Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false),
            new Animal("f", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        List<Animal> correctList = List.of(
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("f", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        List<Animal> result = Tasks.task11(list);

        assertThat(result).isEqualTo(correctList);
    }

    @Test
    void Task12Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false),
            new Animal("f", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        Integer result = Tasks.task12(list);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void Task13Test1() {
        List<Animal> list = List.of(
            new Animal("a v d", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("bss d", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("cs", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("df gr d f", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("es", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false),
            new Animal("fs e", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        List<Animal> correctList = List.of(
            new Animal("a v d", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("df gr d f", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true));

        List<Animal> result = Tasks.task13(list);

        assertThat(result).isEqualTo(correctList);
    }

    @Test
    void Task14Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false),
            new Animal("f", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        Boolean result = Tasks.task14(list, 100);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void Task14Test2() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false),
            new Animal("f", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        Boolean result = Tasks.task14(list, 150);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void Task15Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 12, 30, 72, false),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 22, 64, 15, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        Map<Animal.Type, Integer> map = Map.of(
            Animal.Type.FISH, 13,
            Animal.Type.BIRD, 56,
            Animal.Type.DOG, 15);

        Map<Animal.Type, Integer> result = Tasks.task15(list, 20, 60);

        assertThat(result).isEqualTo(map);
    }

    @Test
    void Task15Test2() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 12, 30, 72, false),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 22, 64, 15, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        Map<Animal.Type, Integer> result = Tasks.task15(list, 60, 20);

        assertThat(result).isEqualTo(null);
    }

    @Test
    void Task16Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 27, 70, 25, false),
            new Animal("f", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("g", Animal.Type.FISH, Animal.Sex.M, 22, 43, 13, false));

        List<Animal> sortedList = List.of(
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("f", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("g", Animal.Type.FISH, Animal.Sex.M, 22, 43, 13, false),
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 27, 70, 25, false));

        List<Animal> result = Tasks.task16(list);

        assertThat(result).isEqualTo(sortedList);
    }

    @Test
    void Task17Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("g", Animal.Type.DOG, Animal.Sex.F, 8, 13, 43, false),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false),
            new Animal("r", Animal.Type.SPIDER, Animal.Sex.F, 5, 2, 54, true),
            new Animal("t", Animal.Type.SPIDER, Animal.Sex.M, 2, 7, 25, true),
            new Animal("f", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        Boolean result = Tasks.task17(list);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void Task17Test2() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.CAT, Animal.Sex.M, 4, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 120, 34, true),
            new Animal("g", Animal.Type.DOG, Animal.Sex.F, 8, 13, 43, false),
            new Animal("e", Animal.Type.SPIDER, Animal.Sex.M, 8, 70, 25, false),
            new Animal("r", Animal.Type.SPIDER, Animal.Sex.F, 5, 2, 54, true),
            new Animal("f", Animal.Type.FISH, Animal.Sex.F, 22, 150, 13, true));

        Boolean result = Tasks.task17(list);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void Task18Test1() {
        List<Animal> list1 = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("bb", Animal.Type.BIRD, Animal.Sex.F, 46, 13, 12, true),
            new Animal("cad", Animal.Type.CAT, Animal.Sex.M, 23, 30, 72, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        List<Animal> list2 = List.of(
            new Animal("t", Animal.Type.FISH, Animal.Sex.F, 22, 43, 23, false),
            new Animal("e", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("dr", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        List<Animal> list3 = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, 43, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("y", Animal.Type.FISH, Animal.Sex.F, 22, 43, 32, false),
            new Animal("d", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true),
            new Animal("q", Animal.Type.FISH, Animal.Sex.F, 22, 43, 16, false),
            new Animal("dd", Animal.Type.DOG, Animal.Sex.M, 24, 64, 15, false));

        Animal animal = new Animal("y", Animal.Type.FISH, Animal.Sex.F, 22, 43, 32, false);

        Animal result = Tasks.task18(list1, list2, list3);

        assertThat(result).isEqualTo(animal);
    }

    @Test
    void Task19Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, -35, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.BIRD, Animal.Sex.F, -1, 13, 12, true),
            new Animal("d", Animal.Type.CAT, Animal.Sex.M, 12, 30, 72, false),
            new Animal("e", Animal.Type.DOG, Animal.Sex.M, -22, 64, 150000, false),
            new Animal("f", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        Map<String, Set<ValidationError>> map = Map.of(
            "a", Set.of(new ValidationError("height")),
            "c", Set.of(new ValidationError("age")),
            "e", Set.of(new ValidationError("age"), new ValidationError("weight")));

        Map<String, Set<ValidationError>> result = Tasks.task19(list);

        assertThat(result).isEqualTo(map);
    }

    @Test
    void Task20Test1() {
        List<Animal> list = List.of(
            new Animal("a", Animal.Type.FISH, Animal.Sex.F, 22, -35, 13, false),
            new Animal("b", Animal.Type.BIRD, Animal.Sex.M, 55, 21, 44, true),
            new Animal("c", Animal.Type.BIRD, Animal.Sex.F, -1, 13, 12, true),
            new Animal("d", Animal.Type.CAT, Animal.Sex.M, 12, 30, 72, false),
            new Animal("e", Animal.Type.DOG, Animal.Sex.M, -22, 64, 150000, false),
            new Animal("f", Animal.Type.DOG, Animal.Sex.F, 16, 12, 34, true));

        Map<String, String> map = Map.of(
            "a", "height",
            "c", "age",
            "e", "weight age");

        Map<String, String> result = Tasks.task20(list);

        assertThat(result).isEqualTo(map);
    }

}
