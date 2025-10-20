import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiKasir {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    public AplikasiKasir() {
        // data awal (dummy) agar bisa langsung diuji sesuai laporan
        daftarBarang.add(new Barang("B001", "Snack", 5000, 20));
        daftarBarang.add(new Barang("B002", "Minuman", 8000, 15));
        daftarPelanggan.add(new Pelanggan("P001", "Iman"));
        daftarPelanggan.add(new Pelanggan("P002", "Dinda"));
    }

    public void jalankanProgram(Scanner scanner) {
        Kasir kasir = new Kasir("K001", "Operator", "iman", "123"); // sample kasir

        // LOGIN
        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.print("Masukkan username: ");
            String user = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String pass = scanner.nextLine();

            if (kasir.login(user, pass)) {
                System.out.println("\nLogin berhasil! Selamat datang, " + kasir.nama);
                loginBerhasil = true;
            } else {
                System.out.println("\nUsername atau password salah! Coba lagi.\n");
            }
        }

        // MENU UTAMA
        int pilihan = 0;
        do {
            kasir.tampilkanMenu();
            System.out.print("Pilih menu: ");
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                pilihan = 0;
            }

            switch (pilihan) {
                case 1: menuKelolaBarang(scanner); break;
                case 2: menuKelolaPelanggan(scanner); break;
                case 3: menuTransaksiPenjualan(scanner); break;
                case 4: menuLihatStruk(scanner); break;
                case 5: kasir.logout(); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    // === Kelola Barang ===
    private void menuKelolaBarang(Scanner scanner) {
        System.out.println("\n========== KELOLA BARANG ==========");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Ubah Stok Barang");
        System.out.println("3. Tampilkan Daftar Barang");
        System.out.println("4. Kembali");
        System.out.print("Pilih menu: ");
        int pilih = Integer.parseInt(scanner.nextLine());

        switch (pilih) {
            case 1:
                System.out.print("Masukkan ID Barang: ");
                String id = scanner.nextLine();
                System.out.print("Masukkan Nama Barang: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan Harga Barang: ");
                double harga = Double.parseDouble(scanner.nextLine());
                System.out.print("Masukkan Stok Barang: ");
                int stok = Integer.parseInt(scanner.nextLine());
                daftarBarang.add(new Barang(id, nama, harga, stok));
                System.out.println("Barang berhasil ditambahkan!");
                break;
            case 2:
                System.out.print("Masukkan ID Barang yang akan diubah stoknya: ");
                String idCari = scanner.nextLine();
                Barang b = cariBarang(idCari);
                if (b != null) {
                    System.out.println("Stok sekarang: " + b.getStok());
                    System.out.print("Masukkan stok baru: ");
                    int stokBaru = Integer.parseInt(scanner.nextLine());
                    b.ubahStok(stokBaru);
                    System.out.println("Stok berhasil diperbarui!");
                } else {
                    System.out.println("Barang tidak ditemukan!");
                }
                break;
            case 3:
                System.out.println("\nDAFTAR BARANG:");
                System.out.println("ID    | Nama            | Harga     | Stok");
                for (Barang barang : daftarBarang) barang.tampilkanBarang();
                break;
            default:
                // kembali
        }
    }

    // === Kelola Pelanggan ===
    private void menuKelolaPelanggan(Scanner scanner) {
        System.out.println("\n========== KELOLA PELANGGAN ==========");
        System.out.println("1. Tambah Pelanggan");
        System.out.println("2. Tampilkan Daftar Pelanggan");
        System.out.println("3. Kembali");
        System.out.print("Pilih menu: ");
        int pilih = Integer.parseInt(scanner.nextLine());

        switch (pilih) {
            case 1:
                System.out.print("Masukkan ID Pelanggan: ");
                String idP = scanner.nextLine();
                System.out.print("Masukkan Nama Pelanggan: ");
                String namaP = scanner.nextLine();
                daftarPelanggan.add(new Pelanggan(idP, namaP));
                System.out.println("Pelanggan berhasil ditambahkan!");
                break;
            case 2:
                System.out.println("\nDAFTAR PELANGGAN:");
                System.out.println("ID     | Nama");
                for (Pelanggan pl : daftarPelanggan) pl.tampilkanPelanggan();
                break;
            default:
                // kembali
        }
    }

    // === Transaksi Penjualan ===
    private void menuTransaksiPenjualan(Scanner scanner) {
        System.out.println("\n========== TRANSAKSI PENJUALAN ==========");
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

        String lagi;
        do {
            System.out.println("\nDAFTAR BARANG:");
            System.out.println("ID    | Nama            | Harga     | Stok");
            for (Barang barang : daftarBarang) barang.tampilkanBarang();

            System.out.print("Masukkan ID Barang: ");
            String idBarang = scanner.nextLine();
            Barang barangDipilih = cariBarang(idBarang);
            if (barangDipilih == null) {
                System.out.println("Barang tidak ditemukan!");
            } else {
                System.out.print("Jumlah: ");
                int jumlah = Integer.parseInt(scanner.nextLine());
                if (jumlah <= 0) {
                    System.out.println("Jumlah tidak valid!");
                } else if (jumlah > barangDipilih.getStok()) {
                    System.out.println("Stok tidak cukup!");
                } else {
                    transaksi.tambahBarang(barangDipilih, jumlah);
                    System.out.println("Barang berhasil ditambahkan!");
                }
            }

            System.out.print("Tambah barang lagi? (y/n): ");
            lagi = scanner.nextLine();
        } while (lagi.equalsIgnoreCase("y"));

        daftarTransaksi.add(transaksi);
        System.out.println("Transaksi berhasil disimpan!");
    }

    // === Lihat Struk Transaksi ===
    private void menuLihatStruk(Scanner scanner) {
        System.out.println("\n========== LIHAT STRUK TRANSAKSI ==========");
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
            StrukTransaksi st = new StrukTransaksi(ditemukan);
            st.tampilkanStruk();
        } else {
            System.out.println("Transaksi tidak ditemukan!");
        }
    }

    // === Pencarian bantu ===
    private Barang cariBarang(String id) {
        for (Barang b : daftarBarang) if (b.getIdBarang().equalsIgnoreCase(id)) return b;
        return null;
    }

    private Pelanggan cariPelanggan(String id) {
        for (Pelanggan p : daftarPelanggan) if (p.getIdPelanggan().equalsIgnoreCase(id)) return p;
        return null;
    }
}
