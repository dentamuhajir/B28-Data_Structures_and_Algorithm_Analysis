// Sistem Manajemen Perpustakaan
import java.util.Scanner;

class Buku {
    String judul;
    String penulis;
    boolean tersedia;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
        this.tersedia = true;
    }

    public void tampilkanInfo() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis + ", Tersedia: " + (tersedia ? "Ya" : "Tidak"));
    }
}

abstract class User {
    String username;
    String nama;

    public User(String username, String nama) {
        this.username = username;
        this.nama = nama;
    }

    public abstract void interact();
}

class Admin extends User {
    Buku[] daftarBuku;
    int jumlahBuku;

    public Admin(String username, String nama, Buku[] daftarBuku, int jumlahBuku) {
        super(username, nama);
        this.daftarBuku = daftarBuku;
        this.jumlahBuku = jumlahBuku;
    }

    @Override
    public void interact() {
        System.out.println(nama + " (Admin) mengelola buku.");
    }

    public void tambahBuku(String judul, String penulis) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku++] = new Buku(judul, penulis);
            System.out.println("Buku berhasil ditambahkan.");
        }
    }

    public void hapusBuku(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].judul.equalsIgnoreCase(judul)) {
                for (int j = i; j < jumlahBuku - 1; j++) {
                    daftarBuku[j] = daftarBuku[j + 1];
                }
                daftarBuku[--jumlahBuku] = null;
                System.out.println("Buku berhasil dihapus.");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public void cariBuku(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].judul.equalsIgnoreCase(judul)) {
                daftarBuku[i].tampilkanInfo();
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public void tampilkanBuku() {
        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < jumlahBuku; i++) {
            System.out.print((i + 1) + ". ");
            daftarBuku[i].tampilkanInfo();
        }
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }
}

class Member extends User {
    Buku[] daftarBuku;
    int jumlahBuku;

    public Member(String username, String nama, Buku[] daftarBuku, int jumlahBuku) {
        super(username, nama);
        this.daftarBuku = daftarBuku;
        this.jumlahBuku = jumlahBuku;
    }

    @Override
    public void interact() {
        System.out.println(nama + " (Member) menggunakan layanan perpustakaan.");
    }

    public void pinjamBuku(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].judul.equalsIgnoreCase(judul) && daftarBuku[i].tersedia) {
                daftarBuku[i].tersedia = false;
                System.out.println("Buku berhasil dipinjam.");
                return;
            }
        }
        System.out.println("Buku tidak tersedia.");
    }

    public void kembalikanBuku(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].judul.equalsIgnoreCase(judul) && !daftarBuku[i].tersedia) {
                daftarBuku[i].tersedia = true;
                System.out.println("Buku berhasil dikembalikan.");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan atau belum dipinjam.");
    }
}

public class PerpustakaanApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buku[] bukuArray = new Buku[100];
        int jumlahBuku = 0;

        Admin admin = new Admin("admin01", "Siti", bukuArray, jumlahBuku);
        admin.interact();

        System.out.print("Masukkan jumlah buku yang ingin ditambah: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Judul buku: ");
            String judul = scanner.nextLine();
            System.out.print("Penulis buku: ");
            String penulis = scanner.nextLine();
            admin.tambahBuku(judul, penulis);
        }

        admin.tampilkanBuku();

        System.out.print("\nMasukkan judul buku yang ingin dicari: ");
        String cari = scanner.nextLine();
        admin.cariBuku(cari);

        System.out.print("\nMasukkan judul buku yang ingin dihapus: ");
        String hapus = scanner.nextLine();
        admin.hapusBuku(hapus);
        admin.tampilkanBuku();

        int jumlahBukuSekarang = admin.getJumlahBuku();
        Member member = new Member("member01", "Rudi", bukuArray, jumlahBukuSekarang);
        member.interact();

        System.out.print("\nMasukkan judul buku yang ingin dipinjam: ");
        String pinjam = scanner.nextLine();
        member.pinjamBuku(pinjam);

        System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
        String kembali = scanner.nextLine();
        member.kembalikanBuku(kembali);

        admin.tampilkanBuku();
        scanner.close();
    }
}