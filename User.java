import java.io.Serializable;

class User implements Serializable
{
    private String address;
    private String Name;
    private int userId;
    private String password;
    private String emailId;
    private String phoneNo;
    public int age;
    public int vaccinateddoses;
    public String covidstatus;
    private boolean admin = false;

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String Name() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return this.Name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setCovidstatus (String covidstatus  ) {
        this.covidstatus  =covidstatus ;
    }
    public String covidstatus () {
        return covidstatus ;
    }
    
    public int getVaccinateddoses() {
        return vaccinateddoses;
    }
    public void setVaccinateddoses(int vaccinateddoses) {
        this.vaccinateddoses = vaccinateddoses;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserID(int userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public boolean isAdmin()
    {
        return this.admin;
    }
    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    } 
    @Override
    public String toString() {
		String details = "\nName: " + Name + "\nUserID: " + userId +"\nAddress: " + address 
		+ "\nEmailID: " + emailId + "\nCovid Status: "+covidstatus +" \nVaccinated Doses: " +
		vaccinateddoses + "\nAge: " + age + "\nPhone No: " + phoneNo ; 
		if(Menu.user.isAdmin()) details += "\nPassword: " + password;
        return details; 
    }
}