public class StrukTransaksi {
    public static void tampilkanStruk(Transaksi transaksi) {
        System.out.println("=========== STRUK TRANSAKSI ===========");
        System.out.println("ID Transaksi : " + transaksi.getIdTransaksi());
        System.out.println("Nama Pelanggan : " + transaksi.getPelanggan().getNamaPelanggan());
        System.out.println("--------------------------------------");
        System.out.println("Daftar Barang:");
        for (int i = 0; i < transaksi.getBarangList().size(); i++) {
            Barang b = transaksi.getBarangList().get(i);
            int jumlah = transaksi.getJumlahList().get(i);
            System.out.println("- " + b.getNamaBarang() + " (" + jumlah + " x " + b.getHarga() + ") = " + (jumlah * b.getHarga()));
        }
        System.out.println("--------------------------------------");
        System.out.println("Total Bayar : Rp " + transaksi.getTotalHarga());
        System.out.println("Terima kasih telah berbelanja!");
        System.out.println("======================================");
    }
}
