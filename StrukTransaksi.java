public class StrukTransaksi {
    private Transaksi transaksi;

    public StrukTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public void tampilkanStruk() {
        System.out.println("========== STRUK TRANSAKSI ==========");
        System.out.println("ID Transaksi : " + transaksi.getIdTransaksi());
        System.out.println("Nama Pelanggan : " + transaksi.getPelanggan().getNamaPelanggan());
        System.out.println("------------------------------------");
        System.out.println("Daftar Barang :");

        for (ItemTransaksi item : transaksi.getDaftarItem()) {
            Barang b = item.getBarang();
            System.out.println("- " + b.getNamaBarang() + " (" + item.getJumlah() + " x " + b.getHarga() + ") = " + item.hitungSubtotal());
        }

        System.out.println("------------------------------------");
        System.out.println("Total Bayar : Rp " + transaksi.hitungTotal());
        System.out.println("Terima kasih telah berbelanja!");
        System.out.println("====================================");
    }
}
