package app.domain;

public class Account {
    private int id;
    private int account;
    private int userId;

    public Account() {
    }

    public Account(int id, int account, int userId) {
        this.id = id;
        this.account = account;
        this.userId = userId;
    }

    public Account(int account, int userId) {
        this.account = account;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account=" + account +
                ", userId=" + userId +
                '}';
    }
}
