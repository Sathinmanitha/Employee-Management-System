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


public class HRManager extends addEmployees{


    class FileDataHandler {
    protected File file;

    public FileDataHandler(String filePath) {
        this.file = new File(filePath);
    }

    public void createNewFileIfNotExists() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileDataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int countLines() {
        int lineCount = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.readLine() != null) {
                lineCount++;
            }
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCount;
    }

    public void appendData(String data) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(raf.length());
            raf.writeBytes(data + System.lineSeparator());
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
        public HRManager(String txtEmployeeID, String txtEpfNo, String txtFullName, String txtAge, String txtDesignation, String txtDepartment) {
        super(txtEmployeeID, txtEpfNo, txtFullName, txtAge, txtDesignation, txtDepartment);
    }
}
