import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiKasir {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kasir kasir = new Kasir("K001", "Iman", "iman", "123");

        // data awal
        daftarBarang.add(new Barang("B001", "Snack", 5000, 20));
        daftarBarang.add(new Barang("B002", "Minuman", 8000, 15));
        daftarPelanggan.add(new Pelanggan("P001", "Jidan"));
        daftarPelanggan.add(new Pelanggan("P002", "Iman"));

        // proses login
        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.print("Masukkan username: ");
            String user = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String pass = scanner.nextLine();

            if (kasir.login(user, pass)) {
                System.out.println("Login berhasil!\n");
                loginBerhasil = true;
            } else {
                System.out.println("Username atau password salah, coba lagi!\n");
            }
        }

        // menu utama
        int pilihan;
        do {
            kasir.tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> kelolaBarang(scanner);
                case 2 -> kelolaPelanggan(scanner);
                case 3 -> tambahTransaksi(scanner);
                case 4 -> lihatStruk(scanner);
                case 5 -> kasir.logout();
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void kelolaBarang(Scanner scanner) {
        System.out.println("=== KELOLA BARANG ===");
        for (Barang b : daftarBarang) {
            b.tampilkanBarang();
        }
    }

    private static void kelolaPelanggan(Scanner scanner) {
        System.out.println("=== DAFTAR PELANGGAN ===");
        for (Pelanggan p : daftarPelanggan) {
            p.tampilkanPelanggan();
        }
    }

    private static void tambahTransaksi(Scanner scanner) {
        System.out.print("Masukkan ID Transaksi: ");
        String idTransaksi = scanner.nextLine();
        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();

        Pelanggan pelanggan = cariPelanggan(idPelanggan);
        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan!");
            return;
        }

        Transaksi transaksi = new Transaksi(idTransaksi, pelanggan);

        String tambah;
        do {
            System.out.println("\nDaftar Barang:");
            for (Barang b : daftarBarang) {
                b.tampilkanBarang();
            }

            System.out.print("Masukkan ID Barang: ");
            String idBarang = scanner.nextLine();
            Barang barang = cariBarang(idBarang);

            if (barang != null) {
                System.out.print("Jumlah: ");
                int jumlah = scanner.nextInt();
                scanner.nextLine();

                transaksi.tambahBarang(barang, jumlah);
                System.out.println("Barang berhasil ditambahkan!");
            } else {
                System.out.println("Barang tidak ditemukan!");
            }

            System.out.print("Tambah barang lagi? (y/n): ");
            tambah = scanner.nextLine();
        } while (tambah.equalsIgnoreCase("y"));

        daftarTransaksi.add(transaksi);
        System.out.println("Transaksi berhasil disimpan!");
    }

    private static void lihatStruk(Scanner scanner) {
        System.out.print("Masukkan ID Transaksi: ");
        String id = scanner.nextLine();

        Transaksi ditemukan = null;
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equalsIgnoreCase(id)) {
                ditemukan = t;
                break;
            }
        }

        if (ditemukan != null) {
            new StrukTransaksi(ditemukan).tampilkanStruk();
        } else {
            System.out.println("Transaksi tidak ditemukan!");
        }
    }

    private static Barang cariBarang(String id) {
        for (Barang b : daftarBarang)
            if (b.getIdBarang().equalsIgnoreCase(id)) return b;
        return null;
    }

    private static Pelanggan cariPelanggan(String id) {
        for (Pelanggan p : daftarPelanggan)
            if (p.getIdPelanggan().equalsIgnoreCase(id)) return p;
        return null;
    }
}
