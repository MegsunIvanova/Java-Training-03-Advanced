package Exam_Paractice.P03_Workout.workout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        List<Exercise> newList = exercises.stream()
                .filter(exercise -> !(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)))
                .collect(Collectors.toList());
        if (newList.size() < exercises.size()) {
            exercises = newList;
            return true;
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max((e1, e2) -> Integer.compare(e1.getBurnedCalories(), e2.getBurnedCalories()))
                .orElse(null);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(this.type).append(System.lineSeparator());
        sb.append(exercises.stream().map(Exercise::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();

    }


}
