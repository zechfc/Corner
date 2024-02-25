import java.util.UUID;

public class User {
    private UUID userID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String age;
    private String email;
    private String userType;
    private String password;


    //exisitng accounts loaded form JSON
    public User(UUID userID, String firstName,String middleName, String lastName, String age, String email, String userType, String password){
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.middleName = middleName;

    }

      //new account
      public User(String email, String firstName,String middleName, String lastName, String age, String userType, String password){
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.middleName = middleName;

    }
    public String getUserName() {
		return email;
	}

    public String getUserType() {
		return userType;
	}

    public String getUserAge() {
		return age;
	}
	public String getFirstName() {
		return firstName;
	}
	
  
	public String getLastName() {
		return lastName;
	}

  public String getMiddleName() {
		return lastName;
	}
    public String getPassword() {
		return password;
	}

    public UUID getUserID() {
		return userID;
	}

}
