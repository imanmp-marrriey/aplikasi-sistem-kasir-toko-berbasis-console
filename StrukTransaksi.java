public class StrukTransaksi {
    private Transaksi transaksi;

    public StrukTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public void tampilkanStruk() {
        System.out.println();
        System.out.println("========== STRUK TRANSAKSI ==========");
        System.out.println("ID Transaksi : " + transaksi.getIdTransaksi());
        System.out.println("Tanggal      : " + transaksi.getTanggal());
        System.out.println("Nama Pelanggan : " + transaksi.getPelanggan().getNamaPelanggan());
        System.out.println("------------------------------------");
        System.out.println("Daftar Barang :");
        for (ItemTransaksi it : transaksi.getDaftarItem()) {
            Barang b = it.getBarang();
            System.out.printf("- %s (%d x Rp %.0f) = Rp %.0f\n",
                    b.getNamaBarang(), it.getJumlah(), b.getHarga(), it.hitungSubtotal());
        }
        System.out.println("------------------------------------");
        System.out.printf("Total Bayar : Rp %.0f\n", transaksi.hitungTotal());
        System.out.println("Terima kasih telah berbelanja!");
        System.out.println("====================================");
    }
}
