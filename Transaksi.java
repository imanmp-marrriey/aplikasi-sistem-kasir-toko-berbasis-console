import java.util.ArrayList;

public class Transaksi {
    private String idTransaksi;
    private String tanggal; // bisa diisi manual atau menggunakan util date (sederhana: String)
    private Pelanggan pelanggan;
    private ArrayList<ItemTransaksi> daftarItem = new ArrayList<>();

    public Transaksi(String idTransaksi, Pelanggan pelanggan) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.tanggal = java.time.LocalDate.now().toString();
    }

    public void tambahBarang(Barang barang, int jumlah) {
        daftarItem.add(new ItemTransaksi(barang, jumlah));
        barang.kurangiStok(jumlah); // kurangi stok saat ditambahkan ke transaksi
    }

    public double hitungTotal() {
        double total = 0;
        for (ItemTransaksi it : daftarItem) total += it.hitungSubtotal();
        return total;
    }

    public String getIdTransaksi() { return idTransaksi; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public ArrayList<ItemTransaksi> getDaftarItem() { return daftarItem; }
    public String getTanggal() { return tanggal; }
}
