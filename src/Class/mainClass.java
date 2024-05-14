/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import HRAssistantLogin.HRAssistantLogin;
import HRManagerLogin.HRManagerLogin;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;

public class mainClass {
public static void readUserAccounts(String userName, String password, String selectedUserType, JFrame mainDashboard) {
        boolean loginSuccess = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\EMP System\\Admin\\CreatedAccounts.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String txtUserName = fields[2].trim(); // Assuming username is at index 0
                String txtPassword = fields[3].trim(); // Assuming password is at index 1
                String userType = fields[4].trim(); // Assuming user type is at index 2
                
                if (userName.equals(txtUserName) && password.equals(txtPassword) && selectedUserType.equals(userType)) {
                    JOptionPane.showMessageDialog(null, userType + ", Login Successful");
                    loginSuccess = true;
                    if (selectedUserType.equals("HR Manager")) {
                        openHRManagerWindow(mainDashboard);
                    } else if (selectedUserType.equals("HR Assistant")) {
                        openHRAssistantWindow(mainDashboard);
                    }
                    break;
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (!loginSuccess) {
            JOptionPane.showMessageDialog(null, "Wrong username or password for " + selectedUserType, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void openHRManagerWindow(JFrame mainDashboard) {
        HRManagerLogin HRManagerWindow = new HRManagerLogin();
        HRManagerWindow.setVisible(true);
        mainDashboard.dispose(); // Close the main dashboard window
    }

    private static void openHRAssistantWindow(JFrame mainDashboard) {
        HRAssistantLogin HRAssistantWindow = new HRAssistantLogin();
        HRAssistantWindow.setVisible(true);
        mainDashboard.dispose(); // Close the main dashboard window
    }
}
