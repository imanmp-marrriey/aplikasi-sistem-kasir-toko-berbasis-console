public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;

    public Pelanggan(String idPelanggan, String namaPelanggan) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
    }

    public String getIdPelanggan() { return idPelanggan; }
    public String getNamaPelanggan() { return namaPelanggan; }

    public void tampilkanPelanggan() {
        System.out.printf("%-6s | %s\n", idPelanggan, namaPelanggan);
    }
}
