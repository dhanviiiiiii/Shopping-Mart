import java.io.*;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;


public class EShoppingCart {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection mycon = null;
        Statement stmt = null;
        
        try {
            // Establishing the connection
            mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "sneha29");
            stmt = mycon.createStatement();
            
            System.out.println("********E-Shopping Cart*********");
            System.out.println("");
            System.out.println("----------- The place that fits your needs---------------");
            System.out.println("");
            System.out.println("******USER*******");
            System.out.println("");
            System.out.println("1.LOGIN");
            System.out.println("");
            System.out.println("2.CREATE ACCOUNT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline
            
            if (choice == 1) {
                System.out.print("Enter Username: ");
                String username = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();
                
                String query = "SELECT * FROM userid_pwd WHERE User_id='" + username + "' AND Pwd='" + password + "'";
                ResultSet rs = stmt.executeQuery(query);
                
                if (rs.next()) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Invalid Credentials");
                    return;
                }
            } else if (choice == 2)     {
                System.out.println("To Create Your Account, Kindly Fill In The Details");
                System.out.print("Enter your Name: ");
                String name = sc.nextLine();
                System.out.print("Enter the Password: ");
                String password = sc.nextLine();
                System.out.print("Confirm your Password: ");
                String confirmPassword = sc.nextLine();
                
                if (!password.equals(confirmPassword)) {
                    System.out.println("Passwords do not match!");
                    return;
                }
                
                String insertQuery = "INSERT INTO userid_pwd (User_id, Pwd) VALUES ('" + name + "', '" + password + "')";
                stmt.executeUpdate(insertQuery);
                System.out.println("Account Created Successfully!");
            } else {
                System.out.println("Wrong Choice");
                return;
            }
            
            System.out.println("-----------------------------------------------------------");
            System.out.println("");
            System.out.println("**************M E N U*****************");
            System.out.println("");
            System.out.println("1. Fresh Produce");
            System.out.println("2. Toys and Games");
            System.out.println("3. CLothing");
            System.out.println("4. Pet Supplies");
            System.out.println("5. Beauty");
            System.out.println("6. Home Decor");
            System.out.println("7. Home Appliances");
            System.out.println("8. Office Supplies");
            System.out.println("9. Kitchen Supplies");
            
            while (true) {
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine(); // consume newline
                
                if (ch == 1) {
                    System.out.println("***FRESH PRODUCE***");
                    System.out.println("1. Fruits");
                    System.out.println("2. Vegetables");
                    System.out.print("Enter your choice for groceries: ");
                    int groceryChoice = sc.nextInt();
                    sc.nextLine(); // consume newline
                    
                    if (groceryChoice == 1) {
                        System.out.println("FRUITS");
                        String query = "SELECT * FROM fruits";
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            System.out.println(rs.getString("pname"));
                        }
                        
                        String ans = "y";
                        while (ans.equalsIgnoreCase("y")) {
                            System.out.print("Enter Fruit Name: ");
                            String fruitName = sc.nextLine();
                            String cartQuery = "INSERT INTO add_to_cart SELECT * FROM fruits WHERE pname='" + fruitName + "'";
                            stmt.executeUpdate(cartQuery);
                            System.out.println("Items successfully added to cart!");
                            System.out.print("Want to select more items? (y/n): ");
                            ans = sc.nextLine();
                        }
                    } else if (groceryChoice == 2) {
                        System.out.println("VEGETABLES");
                        String query = "SELECT * FROM vegetables";
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            System.out.println(rs.getString("pname"));
                        }
                        
                        String ans = "y";
                        while (ans.equalsIgnoreCase("y")) {
                            System.out.print("Enter Vegetable Name: ");
                            String vegName = sc.nextLine();
                            String cartQuery = "INSERT INTO add_to_cart SELECT * FROM vegetables WHERE pname='" + vegName + "'";
                            stmt.executeUpdate(cartQuery);
                            System.out.println("Items successfully added to cart!");
                            System.out.print("Want to select more items? (y/n): ");
                            ans = sc.nextLine();
                        }
                    } else {
                        System.out.println("Wrong Choice");
                    }
                } else if (ch == 2) {
                    System.out.println("***CLOTHING***");
                    System.out.println("1. TShirts");
                    System.out.println("2. Pants");
                    System.out.print("Enter your choice for clothing: ");
                    int clothingChoice = sc.nextInt();
                    sc.nextLine(); // consume newline
                    
                    if (clothingChoice == 1) {
                        System.out.println("TShirts");
                        String query = "SELECT * FROM tshirts";
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            System.out.println(rs.getString("pname"));
                        }
                        
                        String ans = "y";
                        while (ans.equalsIgnoreCase("y")) {
                            System.out.print("Enter Tshirt Name: ");
                            String tshirtName = sc.nextLine();
                            String cartQuery = "INSERT INTO add_to_cart SELECT * FROM tshirts WHERE pname='" + tshirtName + "'";
                            stmt.executeUpdate(cartQuery);
                            System.out.println("Items successfully added to cart!");
                            System.out.print("Want to select more items? (y/n): ");
                            ans = sc.nextLine();
                        }
                    } else if (clothingChoice == 2) {
                        System.out.println("Pants");
                        String query = "SELECT * FROM pants";
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            System.out.println(rs.getString("pname"));
                        }
                        
                        String ans = "y";
                        while (ans.equalsIgnoreCase("y")) {
                            System.out.print("Enter Pant Name: ");
                            String pantName = sc.nextLine();
                            String cartQuery = "INSERT INTO add_to_cart SELECT * FROM pants WHERE pname='" + pantName + "'";
                            stmt.executeUpdate(cartQuery);
                            System.out.println("Items successfully added to cart!");
                            System.out.print("Want to select more items? (y/n): ");
                            ans = sc.nextLine();
                        }
                    } else {
                        System.out.println("Wrong Choice");
                    }
                }
                // Additional cases for other categories (Home Appliances, Beauty, Stationary, etc.)
                else {
                    System.out.println("Wrong Choice");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (mycon != null) mycon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
