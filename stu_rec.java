import java.util.*;

class doB {
    int date;
    int month;
    int year;

    doB() {
        date = 10;
        month = 06;
        year = 1991;
    }

    doB(int d, int m, int y) {
        date = d;
        month = m;
        year = y;
    }
}

public class stu_rec {
    static Scanner in = new Scanner(System.in);
    int prn;
    String name;
    doB dob;
    int marks;

    stu_rec() {
        prn = 0;
        name = " ";
        marks = 0;
        dob = new doB();
    }

    stu_rec(int s_prn, String s_name, int d, int m, int y, int s_marks) {
        prn = s_prn;
        name = s_name;
        dob = new doB(d, m, y);
        marks = s_marks;
    }

    public static stu_rec getDetails() {
        System.out.print("Enter student PRN: ");
        int prn = in.nextInt();
        System.out.print("Enter student Name: ");
        String name = in.next();
        System.out.print("Enter student DOB (DD MM YYYY): ");
        int d = in.nextInt();
        int m = in.nextInt();
        int y = in.nextInt();
        System.out.println("Enter student Marks: ");
        int marks = in.nextInt();
        in.nextLine();

        return new stu_rec(prn, name, d, m, y, marks);
    }

    String grade() {
        if (marks > 90)
            return "A";
        else if (marks > 80)
            return "B+";
        else if (marks > 70)
            return "B";
        else if (marks >= 40)
            return "C";
        else
            return "F";
    }

    public static void add_record(ArrayList<stu_rec> students, stu_rec stu) {
        students.add(stu);
    }

    public static void display(ArrayList<stu_rec> students) {
        Iterator<stu_rec> it = students.iterator();
        while (it.hasNext()) {
            stu_rec s_obj = it.next();
            System.out.println("Student PRN: " + s_obj.prn);
            System.out.println("Student Name: " + s_obj.name);
            System.out
                    .println("Student Date of Birth: " + s_obj.dob.date + "/" + s_obj.dob.month + "/" + s_obj.dob.year);
            System.out.println("Student Marks: " + s_obj.marks);
            System.out.println("Student Grade: " + s_obj.grade());
            System.out.println("\n");
        }
    }

    public static void search_by_pos(ArrayList<stu_rec> students, stu_rec stu) {
        ArrayList<stu_rec> temp = new ArrayList<>();
        System.out.print("Enter position to be searched : ");
        int pos = in.nextInt();

        if (pos <= students.size()) {

            temp.add(students.get(pos - 1));
        } else {
            System.out.println("Record not found!\n");
        }
        display(temp);
    }

    public static void search_by_prn(ArrayList<stu_rec> students, stu_rec stu) {
        ArrayList<stu_rec> temp = new ArrayList<>();
        Iterator<stu_rec> it = students.iterator();
        while (it.hasNext()) {
            stu_rec obj = it.next();
            if (obj.prn == stu.prn) {
                temp.add(obj);
            }
        }
        display(temp);
    }

    public static void search_by_name(ArrayList<stu_rec> students, stu_rec stu) {
        ArrayList<stu_rec> temp = new ArrayList<>();
        Iterator<stu_rec> it = students.iterator();
        while (it.hasNext()) {
            stu_rec obj = it.next();
            if (obj.name.equals(stu.name)) {
                temp.add(obj);
            }
        }
        display(temp);
    }

    public static void edit_rec(ArrayList<stu_rec> students, int e_prn) {
        int flag = -1;
        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).prn == e_prn) {
                flag = i;
                break;
            }
        }
        if (flag != -1) {
            students.set(flag, getDetails());
        } else {
            System.out.println("Record not found!");
        }
    }

    public static void del_rec(ArrayList<stu_rec> students, int d_prn) {
        int flag = -1;
        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).prn == d_prn) {
                flag = i;
                break;
            }
        }
        if (flag != -1) {
            students.remove(flag);
        } else {
            System.out.println("Record not found!");
        }
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); // Clear output screen
        ArrayList<stu_rec> students = new ArrayList<>();

        int ch = 0;
        while (ch != 7) {
            System.out.println("\n1) Add student record");
            System.out.println("2) Display student records");
            System.out.println("3) Search student record");
            System.out.println("4) Edit student record");
            System.out.println("5) Delete student record");
            System.out.println("6) Display number of students sorted by grade");
            System.out.println("7) Exit\n");
            ch = in.nextInt();

            stu_rec temp = new stu_rec();
            int t_prn;

            switch (ch) {
            case 1:
                stu_rec stu_rec = getDetails();
                add_record(students, stu_rec);
                break;
            case 2:
                display(students);
                break;
            case 3:
                System.out.println("1) to Search by PRN");
                System.out.println("2) to Search by Name");
                System.out.println("3) to Search by Position");
                int choice = in.nextInt();
                switch (choice) {
                case 1:
                    System.out.print("Enter PRN to search: ");
                    temp.prn = in.nextInt();
                    search_by_prn(students, temp);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    temp.name = in.next();
                    search_by_name(students, temp);
                    break;
                case 3:
                    search_by_pos(students, temp);
                    break;
                }
                break;
            case 4:
                System.out.print("Enter PRN of student edit record: ");
                t_prn = in.nextInt();
                edit_rec(students, t_prn);
                break;
            case 5:
                System.out.print("Enter PRN of student to delete record: ");
                t_prn = in.nextInt();
                del_rec(students, t_prn);
                break;
            case 6:
                Collections.sort(students, new Comparator<stu_rec>() {
                    @Override
                    public int compare(stu_rec o1, stu_rec o2) {
                        {
                            return o2.marks - o1.marks;
                        }
                    }
                });
                System.out.println("View sorted list of student by marks by Entering 2 i.e. display. \n");
                System.out.println("Grade wise student count:");
                int tot_count = 0, countA = 0, countB = 0, countC = 0, countB1 = 0, countF = 0;
                Iterator<stu_rec> it = students.iterator();
                while (it.hasNext()) {
                    String grade = it.next().grade();
                    switch (grade) {
                    case "A":
                        countA++;
                        break;
                    case "B":
                        countB++;
                        break;
                    case "B+":
                        countB1++;
                        break;
                    case "C":
                        countC++;
                        break;
                    case "F":
                        countF++;
                        break;
                    }
                    tot_count = countA + countB + countB1 + countC + countF;
                }
                System.out.println("Total students in record is: " + tot_count);
                System.out.println("Grade A = " + countA);
                System.out.println("Grade B = " + countB);
                System.out.println("Grade B+ = " + countB1);
                System.out.println("Grade C = " + countC);
                System.out.println("Grade F = " + countF);
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input!");
                break;
            }
        }

    }
}
