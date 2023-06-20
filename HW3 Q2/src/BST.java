//-----------------------------------------------------
// Title: BST class
// Author: Abdullah Doğanay
// ID: 10549887192
// Section: 2
// Assignment: 3
// Description: This class contains the methods of binary search tree.
// -----------------------------------------------------
public class BST{
    private Employee root;


    public int size()
    //--------------------------------------------------------
    // Summary: caller method of size method
    // Precondition: -no precondition
    // Postcondition: size method called
    // --------------------------------------------------------
    {  return size(root);  }

    private int size(Employee x)
    //--------------------------------------------------------
    // Summary: Returns the number of employees in the subtree rooted at node x.
    // Precondition: method takes employee as a root of previous's subtree
    // Postcondition: Returns the number of employees in the subtree.
    // --------------------------------------------------------
    {
        if (x == null) return 0;
        return x.count;
    }

    public void list()
    //--------------------------------------------------------
    // Summary: caller method of inorderTraversal method
    // Precondition: -no precondition
    // Postcondition: inorderTraversal method called
    // --------------------------------------------------------
    {
        inorderTraversal(root);
    }

    private void inorderTraversal(Employee root)
    //--------------------------------------------------------
    // Summary: This method is recursive, and it goes down on the tree and start to print elements of tree from the bottom to root that ve provide.
    // Precondition: method takes employee as a root.
    // Postcondition: printed all the children of children of root.
    // --------------------------------------------------------
    {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.id+ " " + root.name +" " + root.gender);
            inorderTraversal(root.right);
        }
    }


    public void search(int id)
    //--------------------------------------------------------
    // Summary: This method looks for the person whose id is given.
    // Precondition: method takes integer value as an id
    // Postcondition: method prints the name of the person who what we looking for.
    // --------------------------------------------------------
    {
        if(get(id) == null){
            System.out.println("No record found.");
        }
        else{
            System.out.println(get(id).name);
        }
    }


    public void listWRange(int a, int b)
    //--------------------------------------------------------
    // Summary: This method looks for the people between provided ids
    // Precondition: method takes two integer values as an id for being a boundaries.
    // Postcondition: method prints the name of the people between the provided ids.
    // --------------------------------------------------------
    {
        int counter = 0;
        for(int i = a; i<=b; i++){
            if (get(i) != null){
                counter++;
                System.out.print(get(i).id + " ");
                System.out.print(get(i).name+ " ");
                System.out.print(get(i).gender+ " ");
                System.out.println();
            }
        }
        if (counter == 0){
            System.out.println("No record found.");
        }
    }



    public Employee get(int id)
    //--------------------------------------------------------
    // Summary: caller method of get method
    // Precondition: takes the id
    // Postcondition: get method called
    // --------------------------------------------------------
    {
        return get(root, id);
    }

    private Employee get(Employee x, int id)
    //--------------------------------------------------------
    // Summary: This method is the getter method of bst. it returns the person that we provided he's id.
    // Precondition: method takes integer value as an id. and root for recursive structure.
    // Postcondition: method returns the person we know the id's
    // --------------------------------------------------------
    {
        if (x == null) return null;
        if      (x.id > id) return get(x.left, id);
        else if (x.id < id) return get(x.right, id);
        else              return x;
    }

    public void put(int id, String name, String gender)
    //--------------------------------------------------------
    // Summary: caller method of put(insertion) method
    // Precondition: method takes id, name, gender to pass them to the put method.
    // Postcondition: method called.
    // --------------------------------------------------------
    {  root = put(root, id, name, gender);  }

    private Employee put(Employee x, int id, String name, String gender)
    //--------------------------------------------------------
    // Summary: This method create an object with the information that we provide. and put(insert) the object to the bst.
    // Precondition: method takes id, name, gender to pass them to create an object
    // Postcondition: object(employee) created.
    // --------------------------------------------------------
    {
        if (x == null) return new Employee(id, name, gender);
        if (x.id > id)
            x.left  = put(x.left,  id, name, gender);
        else if (x.id < id)
            x.right = put(x.right, id, name, gender);
        else if (x.id == id)
            x.name = name;
        return x;
    }


    private Employee deleteMin(Employee x)
    //--------------------------------------------------------
    // Summary: Deletes the employee with the smallest ID from the subtree rooted x.
    // Precondition: The subtree rooted x is a valid binary search tree.
    // Postcondition: Removes the employee with the smallest ID from the subtree rooted x. Returns the root of the modified subtree.
    // --------------------------------------------------------
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(int id)
    {  root = delete(root, id);  }
    private Employee delete(Employee x, int id) {
        //--------------------------------------------------------
        // Summary: Deletes an employee with the given ID from the subtree rooted at employee x.
        // Precondition: The subtree rooted at x.
        // Postcondition: If an employee with the given ID is found in the subtree, it is deleted. Returns the root of the modified subtree.
        // --------------------------------------------------------
        if (x == null) return null;
        if (x.id > id) x.left = delete(x.left, id);
        else if (x.id < id) x.right = delete(x.right, id);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Employee t = x;
            x = deleteMin(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }


}

