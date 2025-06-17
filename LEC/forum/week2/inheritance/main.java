class University {
    private String name;
    private String address;

    public University(String name,String address){
        this.name =  name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void showInfoUniversity() {
        System.out.println("Univerity name :" + getName());
        System.out.println("University address:" + getAddress());
    }
}

class Faculty extends University {
    private String facultyName;

    public Faculty(String universityName, String universityAddress, String facultyName) {
        super(universityName, universityAddress);
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }
    
    public void showInfoFaculty() {
        System.out.println("Faculty name" + getFacultyName());
    }

}

public class main {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Binus", "West Jakarta", "Co,puter Science");
        faculty.showInfoUniversity();
        faculty.showInfoFaculty(); 
    }
}
