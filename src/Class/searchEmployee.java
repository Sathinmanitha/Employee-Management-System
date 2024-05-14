/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class searchEmployee {
    interface SearchCriteria {
    boolean matches(String searchTerm, String[] fields);
}


    class EmpIDSearchCriteria implements SearchCriteria {
    @Override
    public boolean matches(String searchTerm, String[] fields) {
        String empID = fields[0].trim();
        return searchTerm.equalsIgnoreCase(empID) || searchTerm.equalsIgnoreCase(fields[1].trim());
    }
}


    class DepartmentSearchCriteria implements SearchCriteria {
    @Override
    public boolean matches(String searchTerm, String[] fields) {
        return searchTerm.equalsIgnoreCase(fields[5].trim());
    }
}


    class NameSearchCriteria implements SearchCriteria {
    @Override
    public boolean matches(String searchTerm, String[] fields) {
        return searchTerm.equalsIgnoreCase(fields[2].trim());
    }
}


    class DesignationSearchCriteria implements SearchCriteria {
    @Override
    public boolean matches(String searchTerm, String[] fields) {
        return searchTerm.equalsIgnoreCase(fields[4].trim());
    }
}

public class EmployeeSearch {

    private static final String FILE_PATH = "D:\\EMP System\\Admin\\EmployeeDetails.txt";

    public List<String> searchEmployees(String searchTerm, SearchCriteria searchCriteria) {
        List<String> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                
                // Check if the search criteria matches the search term
                if (searchCriteria.matches(searchTerm, fields)) {
                    results.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
  }
}

