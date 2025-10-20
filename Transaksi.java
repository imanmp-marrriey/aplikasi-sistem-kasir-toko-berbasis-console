public class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Barang barang;
    private int jumlah;
    private double total;

    // Constructor sesuai pemanggilan di AplikasiKasir
    public Transaksi(String idTransaksi, Pelanggan pelanggan, Barang barang, int jumlah, double total) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.barang = barang;
        this.jumlah = jumlah;
        this.total = total;
    }

    // Getter
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotal() {
        return total;
    }

    // Tampilkan data transaksi
    public void tampilkanTransaksi() {
        System.out.printf("%-5s %-10s %-10s Rp %.0f%n",
                idTransaksi, pelanggan.getNamaPelanggan(),
                barang.getNamaBarang(), total);
    }
}
