import java.util.Scanner;
import java.util.function.LongConsumer;

public class SimpleDatabase {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int totalData;
        
        while (true) {
            System.out.print("Enter the number of students to input: ");
            totalData = scanner.nextInt();
            scanner.nextLine(); 
            if (totalData > 0 && totalData < 6) {
                break;
            }
            System.out.println("Maximum number of students is 5");
        }

        long nim;
        String name;
        String major;

        StudentLinkedList studentList = new StudentLinkedList();
        
        for (int i = 1; i <= totalData; i++) {
            System.out.println("-----------------------------------------------");
            
            while (true) {
                System.out.print("Enter student ID (NIM) for student " + i + ": ");
                String nimInput = scanner.nextLine();
                if(nimInput.length() < 10) {
                    nim = Long.parseLong(nimInput);
                    break;
                } else {
                    System.out.println("(info) Max input NIM is 10 character");
                }
            }
            
            while (true) {
                System.out.print("Enter name for student " + i + ": ");
                name = scanner.nextLine();
                if(name.length() < 30) {
                    break;
                } else {
                    System.out.println("(info) Max input name is 30 character");
                }
            }

            while (true) {
                System.out.print("Enter major for student " + i + ": ");
                major = scanner.nextLine();
            
                if(major.length() < 50) {
                    break;
                } else {
                    System.out.println("(info) Max input major is 10 character");
                }
            }



            studentList.add(nim, name, major);
        }

        scanner.close();

        studentList.sortList();
        studentList.printList();               
    }
}

class StudentNode {
    long id;
    String name;
    String major;
    StudentNode next;

    public StudentNode(long id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.next = null;
    }
}

class StudentLinkedList {
    StudentNode head;

    void add(long id, String name, String major) {
        StudentNode newStudentNode = new StudentNode(id, name, major);
        if(head == null) {
            head = newStudentNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudentNode;
        }
    }
    // sortList() will sort nodes of the list in ascending order using Selection Sort
    public void sortList() {
        StudentNode current = head;

        // Traverse through the list
        while (current != null) {
            StudentNode index = current.next;
            StudentNode min = current;

            // Find the minimum element in the unsorted part of the list
            while (index != null) {
                if (index.id < min.id) {
                    min = index;
                }
                index = index.next;
            }

            // Swap the minimum element with the current element
            long tempId = current.id;
            current.id = min.id;
            min.id = tempId;

            String tempName = current.name;
            current.name = min.name;
            min.name = tempName;

            String tempMajor = current.major;
            current.major = min.major;
            min.major = tempMajor;

            // Move to the next node
            current = current.next;
        }
    }

    void printList() {
        StudentNode current = head;
        int no = 1;

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-30s %-50s\n", "No", "NIM", "Name", "Major");
        System.out.println("---------------------------------------------------------------");

        while (current != null) {
            System.out.printf("%-5d %-10d %-30s %-50s\n", no, current.id, current.name, current.major);
            current = current.next;
            no++;
        }

        System.out.println("---------------------------------------------------------------");
    }

    
}
