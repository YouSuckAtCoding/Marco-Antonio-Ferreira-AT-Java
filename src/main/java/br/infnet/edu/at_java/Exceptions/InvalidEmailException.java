package br.infnet.edu.at_java.Exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}
