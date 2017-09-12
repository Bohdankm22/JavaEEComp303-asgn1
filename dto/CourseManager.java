package bohdan.sharipov.asgn1.dto;

import bohdan.sharipov.asgn1.data.CourseCatalog;
import bohdan.sharipov.asgn1.exceptions.CourseNotFoundException;
import bohdan.sharipov.asgn1.exceptions.DuplicateCourseException;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class CourseManager implements CourseCatalog {

    private Set<Course> courseSet = new ConcurrentSkipListSet<>();

    private static CourseManager courseManager = new CourseManager();

    private CourseManager() {
    }

    public static CourseManager getInstance() {
        return courseManager;
    }

    public Collection<Course> getAllCourses() {
        return courseSet;
    }

    @Override
    public Course getCourse(String courseCode) throws CourseNotFoundException {
        for(Course course: courseSet) {
            if(course.getCourseCode().equals(courseCode) ) {
                return course;
            }
        }
        throw new CourseNotFoundException(String.format("Could not found a course with code %s", courseCode));
    }

    @Override
    public Course addCourse(Course course) throws DuplicateCourseException {
        if (courseSet.add(course)) {
            return course;
        }
        throw new DuplicateCourseException(String.format("Course %s is already exist!", course.getCourseCode()));
    }

    @Override
    public Course deleteCourse(String courseCode) throws CourseNotFoundException {
        for(Course course: courseSet) {
            if(course.getCourseCode().equals(courseCode) ) {
                courseSet.remove(course);
                return course;
            }
        }
        throw new CourseNotFoundException(String.format("Could not found a course with code %s", courseCode));
    }

    @Override
    public Course updateCourse(Course course) throws CourseNotFoundException {
        for(Course courseObj: courseSet) {
            if(courseObj.getCourseCode().equals(course.getCourseCode())) {
                courseSet.remove(courseObj);
                courseSet.add(course);
                return course;
            }
        }
        throw new CourseNotFoundException(String.format("Could not found a course with code %s", course.getCourseCode()));
    }
}
