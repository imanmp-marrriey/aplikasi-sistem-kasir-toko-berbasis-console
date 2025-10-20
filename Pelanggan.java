public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;

    // Constructor
    public Pelanggan(String idPelanggan, String namaPelanggan) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
    }

    // Getter
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    // Tampilkan data pelanggan
    public void tampilkanPelanggan() {
        System.out.printf("%-5s %-10s%n", idPelanggan, namaPelanggan);
    }
}
