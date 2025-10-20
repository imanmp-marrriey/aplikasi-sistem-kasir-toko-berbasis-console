public class StrukTransaksi {
    private Transaksi transaksi;

    // Constructor
    public StrukTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    // Menampilkan struk transaksi
    public void tampilkanStruk() {
        System.out.println("======================================");
        System.out.println("           STRUK TRANSAKSI            ");
        System.out.println("======================================");
        System.out.println("ID Transaksi : " + transaksi.getIdTransaksi());
        System.out.println("Nama Pelanggan : " + transaksi.getPelanggan().getNamaPelanggan());
        System.out.println("--------------------------------------");
        System.out.println("Daftar Barang : ");
        System.out.println("- " + transaksi.getBarang().getNamaBarang() +
                            " (" + transaksi.getJumlah() + " x " +
                            transaksi.getBarang().getHarga() + ") = " + transaksi.getTotal());
        System.out.println("--------------------------------------");
        System.out.println("Total Bayar : Rp " + transaksi.getTotal());
        System.out.println("Terima kasih telah berbelanja!");
        System.out.println("======================================");
    }
}
