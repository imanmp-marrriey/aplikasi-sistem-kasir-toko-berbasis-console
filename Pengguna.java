public class Pengguna {
    protected String id;
    protected String nama;

    public Pengguna(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public void tampilkanInfo() {
        System.out.println("ID   : " + id);
        System.out.println("Nama : " + nama);
    }
}
