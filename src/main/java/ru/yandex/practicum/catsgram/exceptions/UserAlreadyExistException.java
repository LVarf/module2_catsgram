package ru.yandex.practicum.catsgram.exceptions;

public class UserAlreadyExistException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "Пользователь с таким e-mail уже существует:(";
    }
}
