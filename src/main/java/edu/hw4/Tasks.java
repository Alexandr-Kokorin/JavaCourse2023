package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class Tasks {

    private Tasks() {}

    public static List<Animal> task1(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        if (Objects.isNull(animals) || k <= 0) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparingInt(Animal::weight).reversed()).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, typeLongEntry -> typeLongEntry.getValue().intValue()));
    }

    public static Animal task4(List<Animal> animals) {
        if (Objects.isNull(animals) || animals.size() == 0) {
            return null;
        }
        return animals.stream().max(Comparator.comparingInt(o -> o.name().length())).orElseThrow();
    }

    public static Animal.Sex task5(List<Animal> animals) {
        if (Objects.isNull(animals) || animals.size() == 0) {
            return null;
        }
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet().stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .orElseThrow().getKey();
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type,
                Collectors.maxBy(Comparator.comparingInt(Animal::weight))))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey,
                typeOptionalEntry -> typeOptionalEntry.getValue().orElseThrow()));
    }

    public static Animal task7(List<Animal> animals, int k) {
        if (Objects.isNull(animals) || animals.size() == 0 || k >= animals.size() - 1 || k <= 0) {
            return null;
        }
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1).toList().get(0);
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        if (Objects.isNull(animals)) {
            return Optional.empty();
        }
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer task9(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> task10(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream().filter(animal -> animal.age() != animal.paws()).toList();
    }

    private static final int HEIGHT = 100;

    public static List<Animal> task11(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream().filter(animal -> animal.bites() && animal.height() > HEIGHT).toList();
    }

    public static Integer task12(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return Math.toIntExact(animals.stream().filter(animal -> animal.weight() > animal.height()).count());
    }

    public static List<Animal> task13(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream().filter(animal -> animal.name().split(" ").length > 2).toList();
    }

    public static Boolean task14(List<Animal> animals, int k) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream().anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        if (Objects.isNull(animals) || k > l) {
            return null;
        }
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingLong(Animal::weight)))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, typeLongEntry -> typeLongEntry.getValue().intValue()));
    }

    public static List<Animal> task16(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .toList();
    }

    public static Boolean task17(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        long dog = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG).count();
        long dogBites = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites()).count();
        long spider = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER).count();
        long spiderBites = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites()).count();
        return (float) spiderBites / spider > (float) dogBites / dog;
    }

    @SafeVarargs
    public static Animal task18(List<Animal>... lists) {
        if (Objects.isNull(lists)) {
            return null;
        }
        List<Animal> maxFishes = new ArrayList<>();
        for (List<Animal> animals: lists) {
            maxFishes.add(animals.stream().filter(animal -> animal.type() == Animal.Type.FISH)
                .max(Comparator.comparingInt(Animal::weight)).orElseThrow());
        }
        return maxFishes.stream().max(Comparator.comparingInt(Animal::weight)).orElseThrow();
    }

    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream()
            .filter(animal -> Validator.validate(animal).size() > 0)
            .collect(Collectors.toMap(Animal::name, Validator::validate));
    }

    public static Map<String, String> task20(List<Animal> animals) {
        if (Objects.isNull(animals)) {
            return null;
        }
        return animals.stream()
            .filter(animal -> Validator.validate(animal).size() > 0)
            .collect(Collectors.toMap(Animal::name, Validator::validate))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey,
                stringSetEntry -> Validator.toString(stringSetEntry.getValue())));
    }
}
