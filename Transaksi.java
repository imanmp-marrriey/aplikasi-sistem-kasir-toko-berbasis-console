import java.util.ArrayList;

public class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private ArrayList<Barang> barangList = new ArrayList<>();
    private ArrayList<Integer> jumlahList = new ArrayList<>();

    public Transaksi(String idTransaksi, Pelanggan pelanggan) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
    }

    public void tambahBarang(Barang b, int jumlah) {
        barangList.add(b);
        jumlahList.add(jumlah);
    }

    public int getTotalHarga() {
        int total = 0;
        for (int i = 0; i < barangList.size(); i++) {
            total += barangList.get(i).getHarga() * jumlahList.get(i);
        }
        return total;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public ArrayList<Barang> getBarangList() {
        return barangList;
    }

    public ArrayList<Integer> getJumlahList() {
        return jumlahList;
    }
}
