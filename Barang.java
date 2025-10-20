public class Barang {
    private String idBarang;
    private String namaBarang;
    private double harga;
    private int stok;

    // Constructor
    public Barang(String idBarang, String namaBarang, double harga, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Tampilkan data barang
    public void tampilkanBarang() {
        System.out.printf("%-5s %-10s %-8.0f %-5d%n", idBarang, namaBarang, harga, stok);
    }
}
