public class ItemTransaksi {
    private Barang barang;
    private int jumlah;

    public ItemTransaksi(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public double hitungSubtotal() {
        return barang.getHarga() * jumlah;
    }

    public Barang getBarang() { return barang; }
    public int getJumlah() { return jumlah; }
}
