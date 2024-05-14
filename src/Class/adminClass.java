/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class adminClass {
    private File file;

    public adminClass(String filePath) {
        this.file = new File(filePath);
    }

    public void createNewFunction() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(adminClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int countLine() {
        int lineCount = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.readLine() != null) {
                lineCount++;
            }
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCount;
    }

    public void addData(HR hr) {
        int lineCount = countLine();
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            for (int i = 1; i <= lineCount; i++) {
                raf.readLine();
            }
            raf.writeBytes(hr.getFullName() + " , " + hr.getEmail() + " , " + hr.getUserName() + " , " + hr.getPassword() + " , " + hr.getUserType());
            JOptionPane.showMessageDialog(null, "Data Added Successful");
            raf.writeBytes(System.lineSeparator());
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
