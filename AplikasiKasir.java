import java.util.*;

public class AplikasiKasir {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private Pengguna admin = new Pengguna("iman", "123");

    public void start() {
        boolean loginSukses = false;
        while (!loginSukses) {
            System.out.println("======================================");
            System.out.println("     APLIKASI SISTEM KASIR TOKO       ");
            System.out.println("======================================");
            System.out.print("Masukkan Username : ");
            String user = input.nextLine();
            System.out.print("Masukkan Password : ");
            String pass = input.nextLine();

            if (admin.login(user, pass)) {
                System.out.println("\nLogin berhasil!");
                System.out.println("Selamat datang, " + admin.getUsername() + ".");
                loginSukses = true;
                menuUtama();
            } else {
                System.out.println("\nUsername atau password salah! Coba lagi.");
            }
        }
    }

    private void menuUtama() {
        int pilihan;
        do {
            System.out.println("======================================");
            System.out.println("             MENU UTAMA               ");
            System.out.println("======================================");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Pelanggan");
            System.out.println("3. Transaksi Penjualan");
            System.out.println("4. Lihat Struk Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 1 -> kelolaBarang();
                case 2 -> kelolaPelanggan();
                case 3 -> transaksiPenjualan();
                case 4 -> lihatStrukTransaksi();
                case 5 -> System.out.println("Keluar dari aplikasi...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    // =========================================
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
                case 2 -> ubahStokBarang();
                case 3 -> tampilkanDaftarBarang();
            }
        } while (pilih != 4);
    }

    private void tambahBarang() {
        System.out.print("Masukkan ID Barang: ");
        String id = input.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Harga: ");
        int harga = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan Stok: ");
        int stok = Integer.parseInt(input.nextLine());

        daftarBarang.add(new Barang(id, nama, harga, stok));
        System.out.println("Barang berhasil ditambahkan!");
    }

    private void ubahStokBarang() {
        System.out.print("Masukkan ID Barang: ");
        String id = input.nextLine();
        for (Barang b : daftarBarang) {
            if (b.getIdBarang().equals(id)) {
                System.out.print("Masukkan Jumlah Baru: ");
                int baru = Integer.parseInt(input.nextLine());
                b.setStok(baru);
                System.out.println("Stok barang berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    private void tampilkanDaftarBarang() {
    System.out.println("======================================");
    System.out.println("========== DAFTAR BARANG =============");
    System.out.println("======================================");
    System.out.printf("%-8s %-15s %-10s %-5s%n", "ID", "Nama Barang", "Harga", "Stok");
    System.out.println("--------------------------------------");

    if (daftarBarang.isEmpty()) {
        System.out.println("Belum ada data barang!");
    } else {
        for (Barang b : daftarBarang) {
            System.out.printf("%-8s %-15s %-10d %-5d%n",
                    b.getIdBarang(), b.getNamaBarang(), b.getHarga(), b.getStok());
        }
    }
}

    // =========================================
    private void kelolaPelanggan() {
        int pilih;
        do {
            System.out.println("============ KELOLA PELANGGAN ============");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Tampilkan Daftar Pelanggan");
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
        System.out.print("Masukkan ID Pelanggan: ");
        String id = input.nextLine();
        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = input.nextLine();
        daftarPelanggan.add(new Pelanggan(id, nama));
        System.out.println("Data pelanggan berhasil ditambahkan!");
    }

    private void tampilkanDaftarPelanggan() {
        System.out.println("ID\tNama Pelanggan");
        for (Pelanggan p : daftarPelanggan) {
            System.out.println(p);
        }
    }

    // =========================================
    private void transaksiPenjualan() {
        System.out.print("Masukkan ID Transaksi: ");
        String idTransaksi = input.nextLine();
        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = input.nextLine();

        Pelanggan pelanggan = daftarPelanggan.stream()
                .filter(p -> p.getIdPelanggan().equals(idPelanggan))
                .findFirst()
                .orElse(null);

        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan!");
            return;
        }

        Transaksi transaksi = new Transaksi(idTransaksi, pelanggan);

        System.out.print("Masukkan ID Barang: ");
        String idBarang = input.nextLine();
        Barang barang = daftarBarang.stream()
                .filter(b -> b.getIdBarang().equals(idBarang))
                .findFirst()
                .orElse(null);

        if (barang == null) {
            System.out.println("Barang tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan Jumlah Barang: ");
        int jumlah = Integer.parseInt(input.nextLine());
        transaksi.tambahBarang(barang, jumlah);
        daftarTransaksi.add(transaksi);
        System.out.println("Transaksi berhasil disimpan!");
    }

    private void lihatStrukTransaksi() {
        System.out.print("Masukkan ID Transaksi: ");
        String id = input.nextLine();
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equals(id)) {
                StrukTransaksi.tampilkanStruk(t);
                return;
            }
        }
        System.out.println("Transaksi tidak ditemukan!");
    }
}
