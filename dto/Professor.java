package bohdan.sharipov.asgn1.dto;

import bohdan.sharipov.asgn1.exceptions.ImproperInputException;

public class Professor {
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;

    public Professor(String firstName, String lastName)
            throws ImproperInputException {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Professor(String firstName, String middleName, String lastName)
            throws ImproperInputException {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws ImproperInputException {
        if (firstName == null || firstName.isEmpty()) {
            throw new ImproperInputException("Proressor must have a first name");
        }
        this.firstName = firstName;
    }

    public String getmiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) throws ImproperInputException {
        // middle name can be null or empty String
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws ImproperInputException {
        if (lastName == null || lastName.isEmpty()) {
            throw new ImproperInputException("Proressor must have a last name");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        if (firstName != null ? !firstName.equals(professor.firstName) : professor.firstName != null) return false;
        if (middleName != null ? !middleName.equals(professor.middleName) : professor.middleName != null) return false;
        return lastName != null ? lastName.equals(professor.lastName) : professor.lastName == null;
    }
}
