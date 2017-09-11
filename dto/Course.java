package bohdan.sharipov.asgn1.dto;

import bohdan.sharipov.asgn1.exceptions.ImproperInputException;

public class Course {

    private String courseCode;
    private String courseTitle;
    private Professor professor;

    public Course(String courseCode) throws ImproperInputException {
        super();
        setCourseCode(courseCode);
    }

    public Course(String courseCode, String courseTitle) throws ImproperInputException {
        this(courseCode);
        setCourseTitle(courseTitle);
    }

    public Course(String code, String title, Professor professor) throws ImproperInputException {
        this(code, title);
        this.professor = professor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) throws ImproperInputException {
        if (courseCode == null || courseCode.isEmpty()) {
            throw new ImproperInputException("Course must have a course code");
        }
        courseCode.toUpperCase();
        if (!courseCode.matches("[A-Z]{3,4} ?[0-9]{3,4}")) {
            throw new ImproperInputException(
                    "Course code must be 3 or 4 letters followed by 3 or 4 digits");
        }
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        // assume a course can have an empty or null title
        this.courseTitle = courseTitle;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        // professor can be null when professor not assigned
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", professor=" + professor +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        Course course = (Course) o;

        if (courseCode != null ? !courseCode.equals(course.courseCode) : course.courseCode != null) return false;
        if (courseTitle != null ? !courseTitle.equals(course.courseTitle) : course.courseTitle != null) return false;
        return professor != null ? professor.equals(course.professor) : course.professor == null;
    }

}
