package ru.yandex.practicum.catsgram.exceptions;

public class InvalidEmailException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "Введён некрректный e-mail";
    }
}
