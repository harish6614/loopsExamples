package loops;

/**
 * Student class contains fields to hold student's data like name ,course and 
 * section which can be accessed and mutated using methods defined in this 
 * class.
 * 
 * @author Harish Bondalapati
 */
public class Student {
    private String firstName;
    private String lastName;
    private String StudentID;
    private String course;
    private int section;
    
    /**
     * Initializes a Student object by initializing the first name and 
     * student id fields.
     * 
     * @param firstName First Name of the student
     * @param studentID Unique ID of the student
     */
    public Student(String firstName,String studentID){
        this.firstName=firstName;
        this.StudentID=studentID;
    }
    
    /**
     * Returns the first name of the student
     * @return first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name of the student.
     * @param firstName First name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the student
     * @return last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name of the student.
     * @param lastName Last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns Unique ID of the student.
     * @return Id of the student
     */
    public String getStudentID() {
        return StudentID;
    }

    /**
     * Sets Unique Id of the student
     * @param StudentID Unique ID of the student
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    /**
     * Returns course enrolled by the student
     * @return Course enrolled by the student
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets course enrolled by the student
     * @param course Course enrolled by the student
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Returns section of course enrolled by the student
     * @return Section of course enrolled by the student
     */
    public int getSection() {
        return section;
    }

    /**
     * Sets section of course enrolled by the student
     * @param section of course enrolled by the student
     */
    public void setSection(int section) {
        this.section = section;
    }
}
