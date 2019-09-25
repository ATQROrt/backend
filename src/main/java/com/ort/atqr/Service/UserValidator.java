package com.ort.atqr.Service;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Model.User;

import java.util.Date;

public class UserValidator {

    public static void validateFields(User user){
        if(user.getFirstName() == null || user.getFirstName().isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_NAME_EMPTY);
        }

        if(user.getLastName() == null || user.getLastName().isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_LAST_NAME_EMPTY);
        }

        if(user.getDocument() == null || user.getDocument() < 1){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_DOCUMENT);
        }

        if(user.getBirth() == null || user.getBirth().before(new Date(111900)) || user.getBirth().after(new Date())){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_BIRTHDATE);
        }

        if(user.getMail() == null){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_MAIL);
        }

        if(user.getPassword() == null || user.getPassword().length() < 8 || user.getPassword().length() > 16){
            throw new IllegalArgumentException(ErrorMessage.STUDENT_INVALID_PASSWORD);
        }
    }
}
