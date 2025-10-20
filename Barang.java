public class Barang {
    private String idBarang;
    private String namaBarang;
    private double harga;
    private int stok;

    public Barang(String idBarang, String namaBarang, double harga, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }

    public String getIdBarang() { return idBarang; }
    public String getNamaBarang() { return namaBarang; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void ubahStok(int jumlahBaru) {
        this.stok = jumlahBaru;
    }

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
        if (this.stok < 0) this.stok = 0;
    }

    public void tampilkanBarang() {
        System.out.printf("%-6s | %-15s | Rp %-8.0f | stok: %d\n", idBarang, namaBarang, harga, stok);
    }
}
