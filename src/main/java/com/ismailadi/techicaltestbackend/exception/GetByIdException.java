package com.ismailadi.techicaltestbackend.exception;

public class GetByIdException extends RuntimeException{
    public GetByIdException(Long id, String model) {
        super("Could not find "+model+" by id : "+ id);
    }
}
