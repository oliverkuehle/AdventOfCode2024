package adventofcode.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import adventofcode.utils.FileReaderUtil;

public class Day01 {
 
    public int solvePart1() {
        String input = new FileReaderUtil().readFile("/day01.txt");
        String[] lines = input.split("\n");
            
        int[] list1 = new int[lines.length];
        int[] list2 = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] lineNumbers = lines[i].split("   ");
            list1[i] = Integer.parseInt(lineNumbers[0]);
            list2[i] = Integer.parseInt(lineNumbers[1]);
        }
          
        Arrays.sort(list1);
        Arrays.sort(list2);
        
        int result = 0;
        for (int i = 0; i < list1.length; i++) {
            result += Math.abs(list1[i] - list2[i]);
        }

        return result; // 1258579
    }

    public int solvePart2() { 
        String input = new FileReaderUtil().readFile("/day01.txt");
        String[] lines = input.split("\n");
            
        Map<Integer, Integer> list1Counts = new HashMap<>();
        Map<Integer, Integer> list2Counts = new HashMap<>();

        for (String line : lines) {
            String[] numbers = line.split("   ");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);

            list1Counts.merge(num1, 1, Integer::sum);
            list2Counts.merge(num2, 1, Integer::sum);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> list1Entry : list1Counts.entrySet()) {
            int list1EntryNumber = list1Entry.getKey();
            int list1EntryCount = list1Entry.getValue();
            int list2EntryCount = list2Counts.getOrDefault(list1EntryNumber, 0);

            result += list1EntryNumber * list1EntryCount * list2EntryCount;
        }
        return result; // 23981443
    }
}
