package org.davi.tddproject.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Email> emails = new ArrayList<>();
        emails.add(new Email(1, "email@exemplo.com"));

        Person person = new Person(1, "Pessoa Valida", 25, emails);
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        if (errors.isEmpty()) {
            System.out.println("A pessoa é válida.");
        } else {
            System.out.println("Erros encontrados: " + errors);
        }
    }
}
