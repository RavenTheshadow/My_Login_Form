public class Container {
    private int ID;
    private String Username;
    private String Password;
    private String Name;
    private String Phone;
    private String Description;
    private String Role;

    public int      GetID()         { return ID;}
    public String   GetUsername()   { return Username;}
    public String   getPassword()   { return Password;}
    public String   getName()       { return Name;}
    public String   getPhone()      { return Phone;}
    public String   Description()   { return Description;}
    public String   Role()          { return Role;}

    Container(int ID, String Username, 
                String Password, String Name, String Phone, String Description, String Role) {
                    this.ID         = ID;
                    this.Username   = Username;
                    this.Password   = Password;
                    this.Name       = Name;
                    this.Phone      = Phone;
                    this.Description= Description;
                    this.Role       = "Normal";
                }
}
