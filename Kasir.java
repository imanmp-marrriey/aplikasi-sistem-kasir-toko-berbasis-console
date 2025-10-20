public class Kasir extends Pengguna {
    private String username;
    private String password;
    private boolean statusLogin = false;

    public Kasir(String id, String nama, String username, String password) {
        super(id, nama);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            statusLogin = true;
        } else {
            statusLogin = false;
        }
        return statusLogin;
    }

    public void tampilkanMenu() {
        System.out.println("====================================");
        System.out.println("         MENU UTAMA KASIR           ");
        System.out.println("====================================");
        System.out.println("1. Kelola Barang");
        System.out.println("2. Kelola Pelanggan");
        System.out.println("3. Transaksi Penjualan");
        System.out.println("4. Lihat Struk Transaksi");
        System.out.println("5. Keluar");
    }

    public void logout() {
        statusLogin = false;
        System.out.println("Kasir berhasil logout.");
    }
}
