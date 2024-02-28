import java.util.UUID;

public class User {
  protected UUID userID;
  protected String firstName;
  protected String lastName;
  protected String middleName;
  protected String age;
  protected String email;
  protected String password;

  //new account
  public User(UUID userID, String firstName, String middleName, String lastName, String age, String email, String password){
    this.userID = UUID.randomUUID();
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.age = age;
    this.email = email;
    this.password = password;
  }
    
  public String getEmail() {
    return email;
  }

  public String getUserAge(){
    return age;
  }

  public String getFirstName(){
    return firstName;
  }

  public String getMiddleName(){
    return middleName;
  }

  
  public String getLastName() {
    return lastName;
  }

  public String getPassword() {
    return password;
  }
  
  public UUID getUserID(){
    return userID;
  }
}