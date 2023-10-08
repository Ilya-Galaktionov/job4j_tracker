package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int scoreSum = 0;
        double count = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreSum += subject.score();
                count++;
            }
        }
        return scoreSum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int scoreSum = 0;
            double count = 0D;
            for (Subject subject : pupil.subjects()) {
                scoreSum += subject.score();
                count++;
            }
            rsl.add(new Label(pupil.name(), scoreSum / count));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue() * 1D / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int scoreSum = 0;
            for (Subject subject : pupil.subjects()) {
                scoreSum += subject.score();
            }
            rsl.add(new Label(pupil.name(), scoreSum));
            rsl.sort(Comparator.naturalOrder());
        }
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue()));
            rsl.sort(Comparator.naturalOrder());
        }
        return rsl.get(rsl.size() - 1);
    }
}
