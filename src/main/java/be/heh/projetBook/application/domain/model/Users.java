package be.heh.projetBook.application.domain.model;

public class Users {
    private String username;
    private String mail;
    private String role;

    public Users(String username,String mail) {
        this.username = username;
        this.mail=mail;
        this.role="normal";
    }
    public Users(String username,String mail,String role) {
        this.username = username;
        this.mail=mail;
        this.role=role;
    }



    public String getUsername() {
        return username;
    }
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String newRole){
        this.role=newRole;
    }
    public String getMail() {
        return mail;

    }
    public void setMail(String newMail){
        this.mail=newMail;
    }
}

