import java.util.ArrayList;

public class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private ArrayList<ItemTransaksi> daftarItem = new ArrayList<>();

    public Transaksi(String idTransaksi, Pelanggan pelanggan) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
    }

    public void tambahBarang(Barang barang, int jumlah) {
        daftarItem.add(new ItemTransaksi(barang, jumlah));
        barang.ubahStok(jumlah);
    }

    public double hitungTotal() {
        double total = 0;
        for (ItemTransaksi item : daftarItem) {
            total += item.hitungSubtotal();
        }
        return total;
    }

    public String getIdTransaksi() { return idTransaksi; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public ArrayList<ItemTransaksi> getDaftarItem() { return daftarItem; }
}
