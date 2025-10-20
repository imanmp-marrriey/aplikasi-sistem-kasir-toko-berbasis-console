public class Pengguna {
    private String username;
    private String password;

    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }

    public String getUsername() {
        return username;
    }
}
