import java.util.ArrayList;

public class Decrease_and_conquer_algorithm {

    public static void main(String[] args) {
        System.out.println("Generating all patterns of a given length:");
        System.out.println("Length 1 produces " + AllPatterns(1).size() + " patterns");
        System.out.println("Length 2 produces " + AllPatterns(2).size() + " patterns");
        System.out.println("Length 3 produces " + AllPatterns(3).size() + " patterns");
        System.out.println("Length 4 produces " + AllPatterns(4).size() + " patterns");
        System.out.println("Length 5 produces " + AllPatterns(5).size() + " patterns");
        System.out.println("Length 1 produces " + AllPatterns(6).size() + " patterns");
        System.out.println("Length 2 produces " + AllPatterns(7).size() + " patterns");
        System.out.println("Length 3 produces " + AllPatterns(8).size() + " patterns");
        System.out.println("Length 4 produces " + AllPatterns(9).size() + " patterns");
        System.out.println("Length 5 produces " + AllPatterns(10).size() + " patterns");


        System.out.println("\n\nGenerating patterns without double-digits:");
        System.out.println("Length 1 produces " + Patterns2(1).size() + " patterns");
        System.out.println("Length 2 produces " + Patterns2(2).size() + " patterns");
        System.out.println("Length 3 produces " + Patterns2(3).size() + " patterns");
        System.out.println("Length 4 produces " + Patterns2(4).size() + " patterns");
        System.out.println("Length 5 produces " + Patterns2(5).size() + " patterns");
        System.out.println("Length 1 produces " + Patterns2(6).size() + " patterns");
        System.out.println("Length 2 produces " + Patterns2(7).size() + " patterns");
        System.out.println("Length 3 produces " + Patterns2(8).size() + " patterns");
        System.out.println("Length 4 produces " + Patterns2(9).size() + " patterns");
        System.out.println("Length 5 produces " + Patterns2(10).size() + " patterns");
    }

    public static ArrayList<String> AllPatterns(int n) {
        ArrayList<String> answers = new ArrayList<>();
        char[] arr = {'0', '1', '2'};
        AllPatternsHelper(answers, new ArrayList<>(), arr, n);
        return answers;
    }

    public static ArrayList<String> Patterns2(int n) {
        ArrayList<String> answers = new ArrayList<>();
        char[] arr = {'0', '1', '2'};
        PatternsTwoHelper(answers, new ArrayList<>(), arr, n);
        return answers;
    }


    private static void AllPatternsHelper(ArrayList<String> answers, ArrayList<String> temp, char[] arr, int n) {
        if (n != 1) {
            AllPatternsHelper(answers, temp, arr, n - 1);
        }

        if (answers.isEmpty()) {
            for (char i : arr) {
                answers.add(String.valueOf(i));
            }
        } else {
            temp.clear();
            for (int i = 0; i < answers.size(); i++) {
                temp.add(answers.get(i));
            }
            answers.clear();
            for (int t = 0; t < temp.size(); t++) {
                for (char i : arr) {
                    String a1 = temp.get(t);
                    a1 += i;
                    answers.add(a1);
                    a1.substring(0, a1.length() - 1);
                }
            }
        }
    }

    private static void PatternsTwoHelper(ArrayList<String> answers, ArrayList<String> temp, char[] arr, int n) {
        if (n != 1) {
            PatternsTwoHelper(answers, temp, arr, n - 1);
        }

        if (answers.isEmpty()) {
            for (char i : arr) {
                answers.add(String.valueOf(i));
            }
        } else {
            temp.clear();
            for (int i = 0; i < answers.size(); i++) {
                temp.add(answers.get(i));
            }
            answers.clear();
            for (int t = 0; t < temp.size(); t++) {
                for (char i : arr) {
                    String a1 = temp.get(t);
                    if (a1.charAt(a1.length() - 1) != i) {
                        a1 += i;
                        answers.add(a1);
                        a1.substring(0, a1.length() - 1);
                    }
                }
            }
        }
    }
}
