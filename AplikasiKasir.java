import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiKasir {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private Kasir kasirAktif = new Kasir("iman", "123");

    private Scanner input = new Scanner(System.in);

    public void start() {
        login();
        menuUtama();
    }

    private void login() {
        System.out.println("======================================");
        System.out.println("      APLIKASI SISTEM KASIR TOKO");
        System.out.println("======================================");

        boolean sukses = false;
        while (!sukses) {
            System.out.print("Masukkan Username : ");
            String user = input.nextLine();
            System.out.print("Masukkan Password : ");
            String pass = input.nextLine();

            if (kasirAktif.login(user, pass)) {
                System.out.println("\nLogin berhasil!");
                System.out.println("Selamat datang, admin.\n");
                sukses = true;
            } else {
                System.out.println("\nUsername atau password salah! Coba lagi.\n");
            }
        }
    }

    private void menuUtama() {
        int pilih;
        do {
            System.out.println("======================================");
            System.out.println("            MENU UTAMA");
            System.out.println("======================================");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Pelanggan");
            System.out.println("3. Transaksi Penjualan");
            System.out.println("4. Lihat Struk Transaksi");
            System.out.println("5. Keluar");
            System.out.println("--------------------------------------");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(input.nextLine());

            switch (pilih) {
                case 1 -> kelolaBarang();
                case 2 -> kelolaPelanggan();
                case 3 -> menuTransaksi();
                case 4 -> lihatStruk();
                case 5 -> System.out.println("Terima kasih telah menggunakan aplikasi kasir!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 5);
    }

    private void kelolaBarang() {
        int pilih;
        do {
            System.out.println("============ KELOLA BARANG ============");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Ubah Stok Barang");
            System.out.println("3. Tampilkan Daftar Barang");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(input.nextLine());

            switch (pilih) {
                case 1 -> tambahBarang();
                case 2 -> ubahStok();
                case 3 -> tampilkanDaftarBarang();
            }
        } while (pilih != 4);
    }

    private void tambahBarang() {
        System.out.println("=========== TAMBAH BARANG ===========");
        System.out.print("Masukkan ID Barang : ");
        String id = input.nextLine();
        System.out.print("Masukkan Nama Barang : ");
        String nama = input.nextLine();
        System.out.print("Masukkan Harga : ");
        double harga = Double.parseDouble(input.nextLine());
        System.out.print("Masukkan Stok : ");
        int stok = Integer.parseInt(input.nextLine());

        daftarBarang.add(new Barang(id, nama, harga, stok));
        System.out.println("Barang berhasil ditambahkan!\n");
    }

    private void ubahStok() {
        System.out.println("=========== UBAH STOK BARANG ===========");
        System.out.print("Masukkan ID Barang : ");
        String id = input.nextLine();
        Barang b = cariBarang(id);

        if (b != null) {
            System.out.print("Masukkan Jumlah Baru : ");
            int stokBaru = Integer.parseInt(input.nextLine());
            b.setStok(stokBaru);
            System.out.println("Stok barang berhasil diperbarui!\n");
        } else {
            System.out.println("Barang tidak ditemukan!\n");
        }
    }

    private void tampilkanDaftarBarang() {
        System.out.println("=========== DAFTAR BARANG ===========");
        System.out.printf("%-8s %-15s %-10s %-5s%n", "ID", "Nama Barang", "Harga", "Stok");
        System.out.println("--------------------------------------");
        for (Barang b : daftarBarang) {
            System.out.printf("%-8s %-15s %-10.0f %-5d%n", b.getIdBarang(), b.getNamaBarang(), b.getHarga(), b.getStok());
        }
        System.out.println();
    }

    private void kelolaPelanggan() {
        int pilih;
        do {
            System.out.println("=========== KELOLA PELANGGAN ===========");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Lihat Daftar Pelanggan");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(input.nextLine());

            switch (pilih) {
                case 1 -> tambahPelanggan();
                case 2 -> tampilkanDaftarPelanggan();
            }
        } while (pilih != 3);
    }

    private void tambahPelanggan() {
        System.out.println("=========== TAMBAH PELANGGAN ===========");
        System.out.print("Masukkan ID Pelanggan : ");
        String id = input.nextLine();
        System.out.print("Masukkan Nama Pelanggan : ");
        String nama = input.nextLine();
        daftarPelanggan.add(new Pelanggan(id, nama));
        System.out.println("Data pelanggan berhasil ditambahkan!\n");
    }

    private void tampilkanDaftarPelanggan() {
        System.out.println("=========== DAFTAR PELANGGAN ===========");
        System.out.printf("%-8s %-15s%n", "ID", "Nama Pelanggan");
        System.out.println("--------------------------------------");
        for (Pelanggan p : daftarPelanggan) {
            System.out.printf("%-8s %-15s%n", p.getIdPelanggan(), p.getNamaPelanggan());
        }
        System.out.println();
    }

    private void menuTransaksi() {
        int pilih;
        do {
            System.out.println("======================================");
            System.out.println("         TRANSAKSI PENJUALAN");
            System.out.println("======================================");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Lihat Daftar Transaksi");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.println("--------------------------------------");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(input.nextLine());

            switch (pilih) {
                case 1 -> tambahTransaksi();
                case 2 -> tampilkanDaftarTransaksi();
            }
        } while (pilih != 3);
    }

    private void tambahTransaksi() {
        System.out.println("=========== TAMBAH TRANSAKSI ===========");
        System.out.print("Masukkan ID Transaksi : ");
        String id = input.nextLine();
        System.out.print("Masukkan ID Pelanggan : ");
        String idPelanggan = input.nextLine();
        Pelanggan p = cariPelanggan(idPelanggan);

        if (p == null) {
            System.out.println("Pelanggan tidak ditemukan!\n");
            return;
        }

        System.out.print("Masukkan ID Barang : ");
        String idBarang = input.nextLine();
        Barang b = cariBarang(idBarang);

        if (b == null) {
            System.out.println("Barang tidak ditemukan!\n");
            return;
        }

        System.out.print("Jumlah Barang : ");
        int jumlah = Integer.parseInt(input.nextLine());
        double total = b.getHarga() * jumlah;

        Transaksi t = new Transaksi(id, p, b, jumlah, total);
        daftarTransaksi.add(t);
        System.out.println("--------------------------------------");
        System.out.println("Total Harga : Rp " + total);
        System.out.println("Transaksi berhasil disimpan!\n");
    }

    private void tampilkanDaftarTransaksi() {
        System.out.println("=========== DAFTAR TRANSAKSI ===========");
        System.out.printf("%-8s %-15s %-15s %-10s%n", "ID", "Pelanggan", "Barang", "Total Harga");
        System.out.println("--------------------------------------------");
        for (Transaksi t : daftarTransaksi) {
            System.out.printf("%-8s %-15s %-15s Rp %-10.0f%n",
                    t.getIdTransaksi(), t.getPelanggan().getNamaPelanggan(),
                    t.getBarang().getNamaBarang(), t.getTotal());
        }
        System.out.println();
    }

    private void lihatStruk() {
        System.out.println("=========== STRUK TRANSAKSI ===========");
        for (Transaksi t : daftarTransaksi) {
            System.out.println("ID Transaksi : " + t.getIdTransaksi());
            System.out.println("Nama Pelanggan : " + t.getPelanggan().getNamaPelanggan());
            System.out.println("--------------------------------------");
            System.out.println("Barang : " + t.getBarang().getNamaBarang());
            System.out.println("Jumlah : " + t.getJumlah());
            System.out.println("Total : Rp " + t.getTotal());
            System.out.println("======================================\n");
        }
    }

    private Barang cariBarang(String id) {
        for (Barang b : daftarBarang) {
            if (b.getIdBarang().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }

    private Pelanggan cariPelanggan(String id) {
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
