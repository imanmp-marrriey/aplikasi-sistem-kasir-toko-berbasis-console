public class Kasir {
    private String username;
    private String password;

    // Constructor sesuai dengan pemanggilan di AplikasiKasir.java
    public Kasir(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method login
    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }

    public String getUsername() {
        return username;
    }
}
