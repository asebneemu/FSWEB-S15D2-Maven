package org.example.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String type) {
        switch (type.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default:
                return new HashSet<>();
        }
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : sets) {
            union.addAll(set);
        }
        return union;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        return set1.stream().filter(set2::contains).collect(Collectors.toSet());
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        return set1.stream().filter(task -> !set2.contains(task)).collect(Collectors.toSet());
    }
}
