import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InvalidNameException;
public class IOFile {
    private String Part;
    private Container Current;
    private List<Container> Customer    = new ArrayList<>();
    //____________________________________________________________________________________________________
    private int to_Int(String str) {
        int val = 0;
        try {
            val = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Not Valid Format");
        }
        return val;
    }
    private boolean IsSpecialCase(char ch) {
        return (!Character.isDigit(ch) && !Character.isLetter(ch));
    }
    private boolean Container(String str) {
        for(int i = 0; i < str.length(); i++) {
            if(IsSpecialCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    private boolean Read(String File) {
        BufferedReader Read = null;
        try {
            Read = new BufferedReader(new FileReader(File));
            String Line;
            Container newCustomer;
            int ID              = 0;
            String Predetail    = "";
            String Username     = "";
            String Password     = "";
            String Name         = "";
            String Phone        = "";
            String Description  = "";
            String Role         = "";

            while((Line = Read.readLine()) != null) {
                String [] Part = Line.split("\\s+");
                if(Part[0].equals("ID:")) {
                    try {
                        if(Part.length > 2) throw new InvalidNameException("Invalid Format");
                        ID = to_Int(Part[1]);    
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                        Read.close();
                        return false;
                    }
                }
                else if (Part[0].equals("Username:")) {
                    try {
                        Username = Part[1];
                        if(Container(Username)) 
                            {throw new InvalidNameException("Username mustn't contain the specal Character!");} 

                        if(Part.length > 2) throw new InvalidNameException("Invalid Format");
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                        Read.close();
                        return false;
                    }
                }
                else if (Part[0].equals("Password:")) {
                    try {
                        Password = Part[1];
                        if(Container(Password)) 
                            {throw new InvalidNameException("Password mustn't contain the specal Character!");} 

                        if(Part.length > 2) throw new InvalidNameException("Invalid Format");
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                        Read.close();
                        return false;
                    }
                }
                else if (Part[0].equals("Name:")) {
                    try {
                        for(int i = 1; i < Part.length - 1; i++) {
                            for(int j = 0; j < Part[i].length(); j++) {
                                if(!Character.isAlphabetic(Part[i].charAt(j))) 
                                    throw new InvalidNameException("Name is not valid format!!!");
                            }
                            Name += (Part[i] + ' ');
                        }
                        for(int j = 0; j < Part[Part.length - 1].length(); j++) {
                            if(!Character.isAlphabetic(Part[Part.length - 1].charAt(j))) 
                                throw new InvalidNameException("Name is not valid format!!!");
                        }
                        Name += Part[Part.length - 1];
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                        Read.close();
                        return false;
                    }
                }
                else if (Part[0].equals("Phone:")) {
                    try {
                        if(Part.length > 2) throw new InvalidNameException("Invalid Format");
                        Phone = Part[1];
                        for(int j = 0; j < Phone.length(); j++) {
                            if(!Character.isDigit(Phone.charAt(j))) 
                                throw new InvalidNameException("Phone is not valid format!!!");
                        }
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                        Read.close();
                        return false;
                    }
                }
                else if (Part[0].equals("Description:")) {
                    for (int i = 1; i < Part.length - 1; i++) {
                        Description += (Part[i] + " ");
                    }
                    Description += Part[Part.length - 1];
                }
                else if (Part[0].equals("Role:")) {
                    try {
                        if(Part.length > 2) throw new InvalidNameException("Invalid Format");
                        Role = Part[1];
                        for(int j = 0; j < Role.length(); j++) {
                            if(!Character.isAlphabetic(Role.charAt(j))) 
                                throw new InvalidNameException("Role is not valid format!!!");
                        }
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                        Read.close();
                        return false;
                    }
                }
                else {
                    try {
                        if(!Predetail.equals("Description:")) throw new InvalidNameException("Not Valid Format");
                        Description += '\n';
                        for(int i = 0; i < Part.length - 1; i++) {
                            Description += (Part[i] + ' ');
                        }
                        Description += Part[Part.length - 1];
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                        Read.close();
                        return false;
                    }
                }
                Predetail = Part[0];
            }
            newCustomer = new Container(ID, Username, Password, Name, Phone, Description, Role);
            Customer.add(newCustomer);
            Read.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public void ImportData(String Link) {
        Part = new String(Link);
        int Number = 0;
        while(Read(Part + "//Customer"+ Number + ".text")) {
            Number++;
        }
    }
    
    public boolean Find(String user, String pass) {
        for (int i = 0; i < Customer.size(); i++) {
            if(Customer.get(i).GetUsername().equals(user) && Customer.get(i).getPassword().equals(pass)) {
                Current = Customer.get(i);
                return true;
            }
        }
        return false;
    }
    public Container getUser() {
        try {
            if(Current == null) throw new Error("User doesn't found!!!");
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        return Current;
    }
    public void Print_Info() {
        System.out.println("Name: "+ Current.getName() + "\nID: " + Current.GetID()
            + "\nPhone: " + Current.getPhone() + "\nDescription: " + Current.Description());
    }
}
