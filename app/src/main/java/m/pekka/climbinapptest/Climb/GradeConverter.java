package m.pekka.climbinapptest.Climb;

import android.util.ArrayMap;

/**
 * Created by Pekka Melgin on 24.10.2015.
 */
public class GradeConverter {

    private ArrayMap<Integer, String[]> grades;

    public GradeConverter() {
        grades = new ArrayMap<>();
        grades.put(0, new String[] {"4A-", "4--", "4-+", "4A+"});
        grades.put(1, new String[] {"4B-", "4B+"});
        grades.put(2, new String[] {"4C-", "4C+"});
        grades.put(3, new String[] {"5A-", "5--", "5-+", "5A+"});
        grades.put(4, new String[] {"5B-", "5B+"});
        grades.put(5, new String[] {"5C-", "5C+"});
        grades.put(6, new String[] {"6A-", "6--", "6-+"});
        grades.put(7, new String[] {"6A+"});
        grades.put(8, new String[] {"6B-"});
        grades.put(9, new String[] {"6B+"});
        grades.put(10, new String[] {"6C-"});
        grades.put(11, new String[] {"6C+"});
        grades.put(12, new String[] {"7A-", "7--", "7-+"});
        grades.put(13, new String[] {"7A+"});
        grades.put(14, new String[] {"7B-"});
        grades.put(15, new String[] {"7B+"});
        grades.put(16, new String[] {"7C-"});
        grades.put(17, new String[] {"7C+"});
        grades.put(18, new String[] {"8A-", "8--", "8-+"});
        grades.put(19, new String[] {"8A+"});
        grades.put(20, new String[] {"8B-"});
        grades.put(21, new String[] {"8B+"});
        grades.put(22, new String[] {"8C-"});
        grades.put(23, new String[] {"8C+"});
        grades.put(24, new String[] {"9A-", "9--", "9-+"});
        grades.put(25, new String[] {"9A+"});
        grades.put(26, new String[] {"9B-"});
        grades.put(27, new String[] {"9B+"});
        grades.put(28, new String[] {"9C-"});
        grades.put(29, new String[] {"9C+"});
    }

    public int gradeToInt(String grade) {
        for (int i = 0; i < this.grades.size(); i++) {
            for (int j = 0; j < this.grades.get(i).length; j++) {
                if (this.grades.get(i)[j].equals(grade)) {
                    return this.grades.keyAt(i);
                }
            }
        }
        return -1;
    }

    public String intToGrade(int grade) {
        try {
            return this.grades.get(grade)[0];
        } catch (Exception e) {
            return "";
        }
    }
}
