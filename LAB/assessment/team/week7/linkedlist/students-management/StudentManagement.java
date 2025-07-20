import java.util.Scanner;

class Node {
    private Student data;
    private Node next;
    private Node prev; // ini bagian doubly

    public Node(Student data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Student getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

class Student {
    private String nim;
    private String name;
    private int score;

    public Student(String nim, String name, int score) {
        this.nim = nim;
        this.name = name;
        this.score = score;
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }

    public String toString() {
        return "NIM: " + nim + ", Nama: " + name + ", Nilai: " + score;
    }
}

public class StudentManagement {
    private Node head = null;
    private Node tail = null;

    public void addStudent(String nim, String name, int score) {
        long startTime = System.nanoTime();

        Student newStudent = new Student(nim, name, score);
        Node newNode = new Node(newStudent);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail); // koneksi doubly
            tail = newNode;
        }

        long endTime = System.nanoTime();
        System.out.println("Mahasiswa berhasil ditambahkan. Waktu eksekusi: " + (endTime - startTime) + " ns");
    }

    public void deleteStudent(String nim) {
        long startTime = System.nanoTime();

        if (head == null) {
            System.out.println("Daftar kosong. Tidak ada mahasiswa untuk dihapus.");
            return;
        }

        Node current = head;
        while (current != null && !current.getData().getNim().equals(nim)) {
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        if (current == head && current == tail) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = current.getNext();
            if (head != null) head.setPrev(null);
        } else if (current == tail) {
            tail = current.getPrev();
            if (tail != null) tail.setNext(null);
        } else {
            Node prev = current.getPrev();
            Node next = current.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }

        System.out.println("Mahasiswa dengan NIM " + nim + " telah dihapus.");
        long endTime = System.nanoTime();
        System.out.println("Waktu eksekusi penghapusan: " + (endTime - startTime) + " ns");
    }

    public void updateScore(String nim, int newScore) {
        long startTime = System.nanoTime();
        Node current = head;
        while (current != null) {
            if (current.getData().getNim().equals(nim)) {
                current.getData().setScore(newScore);
                System.out.println("Nilai mahasiswa dengan NIM " + nim + " berhasil diperbarui.");
                long endTime = System.nanoTime();
                System.out.println("Waktu eksekusi update: " + (endTime - startTime) + " ns");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    public void displayStudents() {
        long startTime = System.nanoTime();

        if (head == null) {
            System.out.println("Daftar mahasiswa kosong.");
            return;
        }

        System.out.println("Daftar Mahasiswa:");
        Node current = head;
        int number = 1;
        while (current != null) {
            System.out.println(number + ". " + current.getData());
            current = current.getNext();
            number++;
        }

        long endTime = System.nanoTime();
        System.out.println("Waktu eksekusi tampilkan data: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Sistem Manajemen Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    int score = scanner.nextInt();
                    sm.addStudent(nim, name, score);
                    break;
                case 2:
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String deleteNim = scanner.nextLine();
                    sm.deleteStudent(deleteNim);
                    break;
                case 3:
                    System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
                    String updateNim = scanner.nextLine();
                    System.out.print("Masukkan nilai baru: ");
                    int newScore = scanner.nextInt();
                    sm.updateScore(updateNim, newScore);
                    break;
                case 4:
                    sm.displayStudents();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
