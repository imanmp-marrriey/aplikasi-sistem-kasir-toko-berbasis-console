import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiKasir {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    private String username = "iman";
    private String password = "123";

    public void jalankan() {
        Scanner scanner = new Scanner(System.in);
        if (login(scanner)) {
            int pilih;
            do {
                System.out.println("======================================");
                System.out.println("            MENU UTAMA               ");
                System.out.println("======================================");
                System.out.println("1. Kelola Barang");
                System.out.println("2. Kelola Pelanggan");
                System.out.println("3. Transaksi Penjualan");
                System.out.println("4. Lihat Struk Transaksi");
                System.out.println("5. Keluar");
                System.out.println("--------------------------------------");
                System.out.print("Pilih menu: ");
                pilih = Integer.parseInt(scanner.nextLine());

                switch (pilih) {
                    case 1 -> menuKelolaBarang(scanner);
                    case 2 -> menuKelolaPelanggan(scanner);
                    case 3 -> menuTransaksiPenjualan(scanner);
                    case 4 -> menuStrukTransaksi(scanner);
                    case 5 -> System.out.println("Keluar dari program...");
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } while (pilih != 5);
        }
    }

    private boolean login(Scanner scanner) {
        while (true) {
            System.out.println("======================================");
            System.out.println("      APLIKASI SISTEM KASIR TOKO      ");
            System.out.println("======================================");
            System.out.print("Masukkan Username : ");
            String user = scanner.nextLine();
            System.out.print("Masukkan Password : ");
            String pass = scanner.nextLine();

            if (user.equals(username) && pass.equals(password)) {
                System.out.println("\nLogin berhasil!");
                System.out.println("Selamat datang, admin.");
                return true;
            } else {
                System.out.println("\nUsername atau password salah! Coba lagi.\n");
            }
        }
    }

    // =================== MENU KELOLA BARANG ===================
    private void menuKelolaBarang(Scanner scanner) {
        int pilih;
        do {
            System.out.println("\n============ KELOLA BARANG ============");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Ubah Stok Barang");
            System.out.println("3. Tampilkan Daftar Barang");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(scanner.nextLine());

            switch (pilih) {
                case 1 -> tambahBarang(scanner);
                case 2 -> ubahStokBarang(scanner);
                case 3 -> tampilkanDaftarBarang(scanner);
                case 4 -> System.out.println("Kembali ke menu utama...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 4);
    }

    private void tambahBarang(Scanner scanner) {
        System.out.println("\n=========== TAMBAH BARANG ===========");
        System.out.print("Masukkan ID Barang : ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Barang : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga : ");
        double harga = Double.parseDouble(scanner.nextLine());
        System.out.print("Masukkan Stok : ");
        int stok = Integer.parseInt(scanner.nextLine());
        daftarBarang.add(new Barang(id, nama, harga, stok));
        System.out.println("Barang berhasil ditambahkan!");
        System.out.println("Tekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    private void ubahStokBarang(Scanner scanner) {
        System.out.println("\n=========== UBAH STOK BARANG ===========");
        System.out.print("Masukkan ID Barang : ");
        String id = scanner.nextLine();
        Barang barang = cariBarang(id);
        if (barang != null) {
            System.out.print("Masukkan Jumlah Baru : ");
            int jumlah = Integer.parseInt(scanner.nextLine());
            barang.setStok(jumlah);
            System.out.println("Stok barang berhasil diperbarui!");
        } else {
            System.out.println("Barang tidak ditemukan!");
        }
        System.out.println("Tekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    private void tampilkanDaftarBarang(Scanner scanner) {
        System.out.println("\n=========== DAFTAR BARANG ===========");
        System.out.printf("%-6s %-12s %-10s %-6s%n", "ID", "Nama Barang", "Harga", "Stok");
        for (Barang b : daftarBarang) {
            System.out.printf("%-6s %-12s %-10.0f %-6d%n", b.getIdBarang(), b.getNamaBarang(), b.getHarga(), b.getStok());
        }
        System.out.println("--------------------------------------");
        System.out.println("Tekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    // =================== MENU KELOLA PELANGGAN ===================
    private void menuKelolaPelanggan(Scanner scanner) {
        int pilih;
        do {
            System.out.println("\n============ KELOLA PELANGGAN ============");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Tampilkan Daftar Pelanggan");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(scanner.nextLine());

            switch (pilih) {
                case 1 -> tambahPelanggan(scanner);
                case 2 -> tampilkanDaftarPelanggan(scanner);
                case 3 -> System.out.println("Kembali ke menu utama...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 3);
    }

    private void tambahPelanggan(Scanner scanner) {
        System.out.println("\n=========== TAMBAH PELANGGAN ===========");
        System.out.print("Masukkan ID Pelanggan : ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Pelanggan : ");
        String nama = scanner.nextLine();
        daftarPelanggan.add(new Pelanggan(id, nama));
        System.out.println("Data pelanggan berhasil ditambahkan!");
        System.out.println("Tekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    private void tampilkanDaftarPelanggan(Scanner scanner) {
        System.out.println("\n=========== DAFTAR PELANGGAN ===========");
        System.out.printf("%-6s %-12s%n", "ID", "Nama Pelanggan");
        for (Pelanggan p : daftarPelanggan) {
            System.out.printf("%-6s %-12s%n", p.getIdPelanggan(), p.getNamaPelanggan());
        }
        System.out.println("--------------------------------------");
        System.out.println("Tekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    // =================== MENU TRANSAKSI PENJUALAN ===================
    private void menuTransaksiPenjualan(Scanner scanner) {
        int pilih = 0;
        do {
            System.out.println("\n======================================");
            System.out.println("         TRANSAKSI PENJUALAN          ");
            System.out.println("======================================");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Lihat Daftar Transaksi");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(scanner.nextLine());

            switch (pilih) {
                case 1 -> tambahTransaksi(scanner);
                case 2 -> lihatDaftarTransaksi(scanner);
                case 3 -> {}
                default -> System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 3);
    }

    private void tambahTransaksi(Scanner scanner) {
        System.out.println("\n=========== TAMBAH TRANSAKSI ===========");
        System.out.print("Masukkan ID Transaksi : ");
        String idTransaksi = scanner.nextLine();
        System.out.print("Masukkan ID Pelanggan : ");
        String idPelanggan = scanner.nextLine();

        Pelanggan pelanggan = cariPelanggan(idPelanggan);
        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan!");
            System.out.println("Tekan ENTER untuk kembali ke menu...");
            scanner.nextLine();
            return;
        }

        Transaksi transaksi = new Transaksi(idTransaksi, pelanggan);

        System.out.print("Masukkan ID Barang : ");
        String idBarang = scanner.nextLine();
        Barang barang = cariBarang(idBarang);
        if (barang == null) {
            System.out.println("Barang tidak ditemukan!");
            System.out.println("Tekan ENTER untuk kembali ke menu...");
            scanner.nextLine();
            return;
        }

        System.out.print("Jumlah Barang : ");
        int jumlah = Integer.parseInt(scanner.nextLine());
        transaksi.tambahBarang(barang, jumlah);
        daftarTransaksi.add(transaksi);

        System.out.println("--------------------------------------");
        System.out.printf("Total Harga : Rp %.0f%n", transaksi.hitungTotal());
        System.out.println("Transaksi berhasil disimpan!");
        System.out.println("\nTekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    private void lihatDaftarTransaksi(Scanner scanner) {
        System.out.println("\n=========== DAFTAR TRANSAKSI ===========");
        System.out.printf("%-6s %-12s %-12s %-12s%n", "ID", "Pelanggan", "Barang", "Total Harga");
        System.out.println("--------------------------------------------");

        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi!");
        } else {
            for (Transaksi t : daftarTransaksi) {
                if (t.getDaftarItem().isEmpty()) continue;
                ItemTransaksi item = t.getDaftarItem().get(0);
                System.out.printf("%-6s %-12s %-12s Rp %-10.0f%n",
                        t.getIdTransaksi(),
                        t.getPelanggan().getNamaPelanggan(),
                        item.getBarang().getNamaBarang(),
                        t.hitungTotal());
            }
        }

        System.out.println("--------------------------------------------");
        System.out.println("Tekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    // =================== MENU STRUK TRANSAKSI ===================
    private void menuStrukTransaksi(Scanner scanner) {
        System.out.println("\n=========== STRUK TRANSAKSI ===========");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi!");
        } else {
            Transaksi t = daftarTransaksi.get(daftarTransaksi.size() - 1);
            System.out.println("ID Transaksi : " + t.getIdTransaksi());
            System.out.println("Nama Pelanggan : " + t.getPelanggan().getNamaPelanggan());
            System.out.println("--------------------------------------");
            System.out.println("Daftar Barang :");
            for (ItemTransaksi item : t.getDaftarItem()) {
                System.out.printf("- %s (x %d) = %.0f%n", item.getBarang().getNamaBarang(),
                        item.getJumlah(), item.hitungSubtotal());
            }
            System.out.println("--------------------------------------");
            System.out.printf("Total Bayar : Rp %.0f%n", t.hitungTotal());
            System.out.println("Terima kasih telah berbelanja!");
        }
        System.out.println("======================================");
        System.out.println("Tekan ENTER untuk kembali ke menu...");
        scanner.nextLine();
    }

    // =================== PENCARIAN DATA ===================
    private Barang cariBarang(String id) {
        for (Barang b : daftarBarang) {
            if (b.getIdBarang().equalsIgnoreCase(id)) return b;
        }
        return null;
    }

    private Pelanggan cariPelanggan(String id) {
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan().equalsIgnoreCase(id)) return p;
        }
        return null;
    }
}
