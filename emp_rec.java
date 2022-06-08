import java.io.*;
import java.util.*;

public class emp_rec {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static int count = -1;
    int ID;
    String name;
    String sex;
    String job;
    String org;
    float salary;

    emp_rec() {
        ID = 0;
        name = " ";
        sex = " ";
        job = " ";
        org = " ";
        salary = 0.0f;
    }

    emp_rec(int ID, String name, String sex, String job, String org, float salary) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.job = job;
        this.org = org;
        this.salary = salary;
    }

    public int count(Vector<emp_rec> emp) {   //keeps a count of instances created for emp_rec class
        return emp.size();
    }

    public void add(Vector<emp_rec> emp) throws IOException {
        count++;
        System.out.print("\nEnter employee's Name : ");
        String name1 = r.readLine();
        System.out.print("Enter employee's ID : ");
        int id1 = sc.nextInt();
        System.out.print("Enter employee's Gender : ");
        String sex1 = r.readLine();
        System.out.print("Enter employee's Job title : ");
        String job1 = r.readLine();
        System.out.print("Enter employee's Organisation: ");
        String org1 = r.readLine();
        System.out.print("Enter employee's Salary : ");
        float salary1 = sc.nextFloat();
        emp.add(new emp_rec(id1, name1, sex1, job1, org1, salary1));
    }

    public void display(Vector<emp_rec> emp) {
        if (emp.size() > 0) {
            for (int i = 0; i < emp.size(); i++) {
                System.out.println("\nID           : " + emp.get(i).ID);
                System.out.println("Name         : " + emp.get(i).name);
                System.out.println("Sex          : " + emp.get(i).sex);
                System.out.println("Job          : " + emp.get(i).job);
                System.out.println("Organization : " + emp.get(i).org);
                System.out.println("Salary       : " + emp.get(i).salary);
            }
        } else {
            System.out.println("Employee Records Empty!");
        }
    }

    public void search(Vector<emp_rec> emp) throws IOException {
        emp_rec obj;
        if (emp.size() > 0) {
            System.out.println("\n1) Search by Name");
            System.out.println("2) Search by ID");
            System.out.print("Enter : ");
            int ch = sc.nextInt();
            Iterator itr = emp.iterator();
            switch (ch) {
            case 1:
                System.out.print("Enter named to be searched : ");
                String nam = r.readLine();
                int flag = 0;
                while (itr.hasNext()) {
                    obj = (emp_rec) itr.next();
                    if (obj.name.equals(nam)) {
                        flag = 1;
                        System.out.println("\nRecord exists!");
                        System.out.println("\nID           : " + obj.ID);
                        System.out.println("Name         : " + obj.name);
                        System.out.println("Gender       : " + obj.sex);
                        System.out.println("Job          : " + obj.job);
                        System.out.println("Organization : " + obj.org);
                        System.out.println("Salary       : " + obj.salary);
                        System.out.println("\n");
                        break;
                    }
                }
                if (flag == 0)
                    System.out.println("\nName not found!!!!");
                break;

            case 2:
                System.out.print("Enter ID to be searched : ");
                int id2 = sc.nextInt();
                int flag2 = 0;
                while (itr.hasNext()) {
                    obj = (emp_rec) itr.next();
                    if (obj.ID == id2) {
                        flag2 = 1;
                        System.out.println("\nRecord exists!");
                        System.out.println("\nID           : " + obj.ID);
                        System.out.println("Name         : " + obj.name);
                        System.out.println("Gender       : " + obj.sex);
                        System.out.println("Job          : " + obj.job);
                        System.out.println("Organization : " + obj.org);
                        System.out.println("Salary       : " + obj.salary);
                        System.out.println("\n");
                        break;
                    }
                }
                if (flag2 == 0)
                    System.out.println("\nID not found!!!!");
                break;
            default:
                System.out.println("Invalid Entry!!!");
            }
        } else {
            System.out.println("Employee Records Empty!");
        }
    }

    public void delete(Vector<emp_rec> vec) throws IOException {
        emp_rec obj;
        if (vec.size() > 0) {
            System.out.println("1) Delete by Name");
            System.out.println("2) Delete by ID");
            System.out.print("Enter : ");
            int ch = sc.nextInt();
            Iterator itr = vec.iterator();
            switch (ch) {
            case 1:
                System.out.print("Enter named to be searched : ");
                String nam = r.readLine();
                int flag = 0;
                while (itr.hasNext()) {
                    obj = (emp_rec) itr.next();
                    if (obj.name.equals(nam)) {
                        flag = 1;
                        System.out.println("\nRecord Deleted!!!");
                        itr.remove();
                        count--;
                        break;
                    }
                }
                if (flag == 0)
                    System.out.println("\nName not found!!!!");
                break;
            case 2:
                System.out.print("Enter ID to be searched : ");
                int id2 = sc.nextInt();
                int flag2 = 0;
                while (itr.hasNext()) {
                    obj = (emp_rec) itr.next();
                    if (obj.ID == id2) {
                        flag2 = 1;
                        System.out.println("Record Deleted!");
                        itr.remove();
                        count--;
                        break;
                    }
                }
                if (flag2 == 0)
                    System.out.println("\nID not found in records!");
                break;
            default:
                System.out.println("Invalid input!");
            }
        } else {
            System.out.println("Employee Records Empty!");
        }
    }

    public static Comparator<emp_rec> sortBySalary = new Comparator<emp_rec>() {
        @Override
        public int compare(emp_rec o1, emp_rec o2) {
            return (int) o2.salary - (int) o1.salary;
        }
    };

    public void compareEmp(Vector<emp_rec> vec) {
        Collections.sort(vec, emp_rec.sortBySalary);
        if (vec.size() > 0) {
            System.out.println("\nEmployees sorted Based on Salary : ");
            System.out.println("ID\t\tName\t\tSalary");
            for (int i = 0; i < vec.size(); i++) {
                System.out.println(vec.get(i).ID + "\t\t" + vec.get(i).name + "\t\t" + vec.get(i).salary + "\t\t");
            }
        } else {
            System.out.println("Employee Records Empty!");
        }
    }

    static int compSal(emp_rec e1, emp_rec e2) {
        if (e1.salary > e2.salary)
            return 1;
        else if (e1.salary < e2.salary)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("\033[H\033[2J"); // Clear output screen
        Vector<emp_rec> vec = new Vector<emp_rec>();
        emp_rec obj = new emp_rec();
        int ch = 0;
        while (ch != 7) {
            System.out.println("\n1) Add employee ");
            System.out.println("2) Display records");
            System.out.println("3) Search employee");
            System.out.println("4) Delete employee record");
            System.out.println("5) Compare employees (by Salary)");
            System.out.println("6) Sort employees (by Name)");
            System.out.println("7) Exit");
            System.out.print("Enter : ");
            ch = sc.nextInt();
            switch (ch) {
            case 1:
                obj.add(vec);
                break;
            case 2:
                System.out.print("\n############################\n");
                obj.display(vec);
                System.out.print("\n############################\n");
                break;
            case 3:
                obj.search(vec);
                break;
            case 4:
                obj.delete(vec);
                break;
            case 5:
                obj.compareEmp(vec);
                int id1, id2, e_id1 = -1, e_id2 = -1;
                System.out.print("Enter ID of E1 to compare from list: ");
                id1 = sc.nextInt();
                System.out.print("Enter ID of E2 to compare from list: ");
                id2 = sc.nextInt();
                sc.nextLine();
                boolean exist_1 = false, exist_2 = false;
                for (int i = 0; i < vec.size(); ++i) {

                    if (vec.get(i).ID == id1 && !exist_1) {
                        e_id1 = i;
                        exist_1 = true;
                    }

                    if (vec.get(i).ID == id2 && !exist_2) {
                        e_id2 = i;
                        exist_2 = true;
                    }
                }
                if (e_id1 != -1 && e_id2 != -1) {
                    int comp = compSal(vec.get(e_id1), vec.get(e_id2));
                    switch (comp) {
                    case -1:
                        System.out.println("\nEmployee 1 has less salary than Employee 2.");
                        break;
                    case 1:
                        System.out.println("\nEmployee 1 has more salary than Employee 2.");
                        break;
                    case 0:
                        System.out.println("\nBoth employees have equal salary.");
                    }
                } else {
                    System.out.println("\nRecords not found!");
                }
                break;

            case 6:
                if (emp_rec.count == -1) {
                    System.out.println("Employee Records empty!");
                    break;
                }
                Collections.sort(vec, new sortName());
                System.out.print("\n############################\n");
                obj.display(vec);
                System.out.print("\n############################\n");
                break;

            case 7:
                System.exit(0);
            }
        }
    }
}

class sortName implements Comparator<emp_rec> {
    public int compare(emp_rec a, emp_rec b) {
        return a.name.compareTo(b.name);
    }
}
