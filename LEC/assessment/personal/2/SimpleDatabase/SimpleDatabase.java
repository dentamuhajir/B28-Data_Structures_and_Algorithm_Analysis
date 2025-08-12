//  javac .\SimpleDatabase.java
import java.util.Scanner;

public class SimpleDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalData;

        // Validasi input jumlah mahasiswa (maksimal 5)
        while (true) {
            System.out.print("Masukkan jumlah mahasiswa yang ingin diinput: ");
            totalData = scanner.nextInt();
            scanner.nextLine();
            if (totalData > 0 && totalData < 6) {
                break;
            }
            System.out.println("Jumlah input data mahasiswa maksimal 5");
        }

        long nim;
        String name;
        String major;

        StudentLinkedList studentList = new StudentLinkedList();

        for (int i = 1; i <= totalData; i++) {
            System.out.println("------------------------------------------------");

            // Validasi input NIM
            while (true) {
                System.out.print("Masukkan NIM mahasiswa ke-" + i + ": ");
                String nimInput = scanner.nextLine();
                if (nimInput.length() < 10) {
                    nim = Long.parseLong(nimInput);
                    break;
                } else {
                    System.out.println("(info) Maksimal NIM adalah 10 Digit");
                }
            }

            // Validasi input nama
            while (true) {
                System.out.print("Masukkan nama mahasiswa ke-" + i + ": ");
                name = scanner.nextLine();
                if (name.length() < 30) {
                    break;
                } else {
                    System.out.println("(info) Maksimal nama adalah 30 karakter");
                }
            }

            // Validasi input jurusan
            while (true) {
                System.out.print("Masukkan jurusan mahasiswa ke-" + i + ": ");
                major = scanner.nextLine();
                if (major.length() < 50) {
                    break;
                } else {
                    System.out.println("(info) Maksimal jurusan adalah 50 karakter");
                }
            }

            // Tambahkan ke linked list
            studentList.add(nim, name, major);
        }

        scanner.close();

        studentList.sortList();  // Urutkan berdasarkan NIM
        studentList.printList(); // Tampilkan data mahasiswa
    }
}

// Node untuk menyimpan data mahasiswa
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

// Struktur data single linked list
class StudentLinkedList {
    StudentNode head;

    // Tambah data ke linked list
    void add(long id, String name, String major) {
        StudentNode newStudentNode = new StudentNode(id, name, major);
        if (head == null) {
            head = newStudentNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudentNode;
        }
    }

    // Mengurutkan data berdasarkan NIM (selection sort)
    public void sortList() {
        StudentNode current = head;

        while (current != null) {
            StudentNode index = current.next;
            StudentNode min = current;

            while (index != null) {
                if (index.id < min.id) {
                    min = index;
                }
                index = index.next;
            }

            // Tukar data antar node
            long tempId = current.id;
            current.id = min.id;
            min.id = tempId;

            String tempName = current.name;
            current.name = min.name;
            min.name = tempName;

            String tempMajor = current.major;
            current.major = min.major;
            min.major = tempMajor;

            current = current.next;
        }
    }

    // Menampilkan seluruh isi linked list
    void printList() {
        StudentNode current = head;
        int no = 1;

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-30s %-50s\n", "No", "NIM", "Nama", "Jurusan");
        System.out.println("--------------------------------------------------------------------------");

        while (current != null) {
            System.out.printf("%-5d %-10d %-30s %-50s\n", no, current.id, current.name, current.major);
            current = current.next;
            no++;
        }

        System.out.println("--------------------------------------------------------------------------");
    }
}
