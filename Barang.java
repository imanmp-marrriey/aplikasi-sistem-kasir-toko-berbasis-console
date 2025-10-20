public class Barang {
    private String idBarang;
    private String namaBarang;
    private int harga;
    private int stok;

    public Barang(String idBarang, String namaBarang, int harga, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stokBaru) {
        this.stok = stokBaru;
    }

    @Override
    public String toString() {
        return idBarang + "\t" + namaBarang + "\t" + harga + "\t" + stok;
    }
}
