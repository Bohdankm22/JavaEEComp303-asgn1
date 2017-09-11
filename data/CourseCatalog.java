package bohdan.sharipov.asgn1.data;


import bohdan.sharipov.asgn1.dto.Course;
import bohdan.sharipov.asgn1.exceptions.CourseNotFoundException;
import bohdan.sharipov.asgn1.exceptions.DuplicateCourseException;

public interface CourseCatalog{

    public Course getCourse(String courseCode) throws CourseNotFoundException;
    public Course addCourse(Course course) throws DuplicateCourseException;
    public Course deleteCourse(String courseCode)throws CourseNotFoundException;
    public Course updateCourse(Course course) throws CourseNotFoundException;

}