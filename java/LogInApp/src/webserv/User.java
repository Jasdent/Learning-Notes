package webserv;
public class User {

    private String lastname, firstname,email,username,password;
    private int id;

    public User(String lastname,
                String firstname,
                String email,
                String username,
                String password,
                int id){
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.id = id;
        this.username = username;
    }

    public User(String email,
                String password){
        this.email= email;
        this.password = password;
    }

    public String getLastname(){
        return this.lastname;
    }
    public String getFirstname(){
        return this.firstname;
    }
    public String getEmail(){
        return this.email;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public int getId(){
        return this.id;
    }

}
