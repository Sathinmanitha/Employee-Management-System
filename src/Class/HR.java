/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

public class HR {
    private String fullName;
    private String email;
    private String userName;
    private String password;
    private String userType;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public HR() {
    }

    public HR(String fullName, String email, String userName, String password, String userType) {
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }
    
}
