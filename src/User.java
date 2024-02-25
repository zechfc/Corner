public class User {
    private String userID;
    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String userType;
    private String password;


    public User(String userID, String firstName, String lastName, String age, String email, String userType, String password){
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.userType = userType;
        this.password = password;

    }
    public String getUserName() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
    public String getPassword() {
		return password;
	}

}
