package org.davi.tddproject.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person person){
        System.out.println("Person name: ");
    }

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        if (p.getName() == null || p.getName().trim().isEmpty()) {
            errors.add("O nome não pode ser vazio.");
        } else {
            String[] nameParts = p.getName().split(" ");
            if (nameParts.length < 2) {
                errors.add("O nome deve ter pelo menos duas partes.");
            }
            for (String part : nameParts) {
                if (!part.matches("[a-zA-Z]+")) {
                    errors.add("O nome deve conter apenas letras.");
                    break;
                }
            }
        }

        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("A idade deve estar no intervalo entre 1 e 200.");
        }

        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            errors.add("A pessoa deve ter pelo menos um email.");
        } else {
            for (Email email : p.getEmails()) {
                if (!email.getName().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                    errors.add("O email deve estar no formato correto (___@___.___).");
                }
            }
        }

        return errors;
    }
}
