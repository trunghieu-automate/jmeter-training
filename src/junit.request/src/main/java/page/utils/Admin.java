package page.utils;

public class Admin {
    private String name;
    private String pass;
    private Admin(){
        this.name = "utils.Admin";
        this.pass = "admin123";
    }
    private static Admin instance;
    public static Admin getInstance(){
        if(instance == null){
            return new Admin();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
