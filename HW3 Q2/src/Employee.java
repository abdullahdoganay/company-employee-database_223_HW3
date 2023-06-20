//-----------------------------------------------------
// Title: Employee class
// Author: Abdullah Doğanay
// ID: 10549887192
// Section: 2
// Assignment: 3
// Description: This class contains the constructor method of employee class.
// -----------------------------------------------------
public class Employee {
    public int count;
    String name;
    int id;
    String gender;

    Employee left;
    Employee right;

    public Employee(int id, String name, String gender)
    //--------------------------------------------------------
    // Summary: Constructor method of employee class
    // Precondition: takes id, name, gender
    // Postcondition: object created.
    // --------------------------------------------------------
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
