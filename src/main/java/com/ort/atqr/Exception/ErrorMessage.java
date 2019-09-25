package com.ort.atqr.Exception;

public interface ErrorMessage {
    String STUDENT_NAME_EMPTY = "Student's name can't be null or empty";
    String STUDENT_LAST_NAME_EMPTY = "Student's last name can't be null or empty";
    String STUDENT_INVALID_DOCUMENT = "Student's document can't be null and must be a valid number";
    String STUDENT_INVALID_BIRTHDATE = "Student's birth date can't be null and must be a valid date";
    String STUDENT_INVALID_MAIL = "Student's mail can't be null";
    String STUDENT_INVALID_PASSWORD = "Student's password can't be null and must be between 8 an 16 characters";


}
