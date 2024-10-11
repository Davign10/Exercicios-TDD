package org.davi.tddproject.teste02;

import org.davi.tddproject.exercicio02.Email;
import org.davi.tddproject.exercicio02.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.davi.tddproject.exercicio02.PersonDAO;

public class PersonDAOTest {

        private PersonDAO personDAO;
        private List<Email> validEmails;

        @BeforeEach
        public void setUp() {
            personDAO = new PersonDAO();
            validEmails = new ArrayList<>();
            validEmails.add(new Email(1, "email.valido@exemplo.com"));
        }

        @Test
        public void testValidPerson() {
            Person validPerson = new Person(1, "Pessoa Valida", 25, validEmails);
            List<String> errors = personDAO.isValidToInclude(validPerson);
            assertTrue(errors.isEmpty());
        }

        @Test
        public void testInvalidNameWithOnePart() {
            Person invalidPerson = new Person(1, "Pessoa", 25, validEmails);
            List<String> errors = personDAO.isValidToInclude(invalidPerson);
            assertTrue(errors.contains("O nome deve ter pelo menos duas partes."));
        }

        @Test
        public void testInvalidNameWithNonLetterCharacters() {
            Person invalidPerson = new Person(1, "Pessoa123 Teste", 25, validEmails);
            List<String> errors = personDAO.isValidToInclude(invalidPerson);
            assertTrue(errors.contains("O nome deve conter apenas letras."));
        }

        @Test
        public void testInvalidAgeTooLow() {
            Person invalidPerson = new Person(1, "Pessoa Invalida", 0, validEmails);
            List<String> errors = personDAO.isValidToInclude(invalidPerson);
            assertTrue(errors.contains("A idade deve estar no intervalo entre 1 e 200."));
        }

        @Test
        public void testInvalidAgeTooHigh() {
            Person invalidPerson = new Person(1, "Pessoa Invalida", 300, validEmails);
            List<String> errors = personDAO.isValidToInclude(invalidPerson);
            assertTrue(errors.contains("A idade deve estar no intervalo entre 1 e 200."));
        }

        @Test
        public void testInvalidEmailFormat() {
            List<Email> invalidEmails = new ArrayList<>();
            invalidEmails.add(new Email(1, "invalid-email"));
            Person invalidPerson = new Person(1, "Pessoa Invalida", 25, invalidEmails);
            List<String> errors = personDAO.isValidToInclude(invalidPerson);
            assertTrue(errors.contains("O email deve estar no formato correto (___@___.___)."));
        }

        @Test
        public void testMissingEmail() {
            Person invalidPerson = new Person(1, "Pessoa Invalida", 25, new ArrayList<>());
            List<String> errors = personDAO.isValidToInclude(invalidPerson);
            assertTrue(errors.contains("A pessoa deve ter pelo menos um email."));
        }

        @Test
        public void testMultipleErrors() {
            List<Email> invalidEmails = new ArrayList<>();
            invalidEmails.add(new Email(1, "invalid-email"));
            Person invalidPerson = new Person(1, "John123", 0, invalidEmails);

            List<String> errors = personDAO.isValidToInclude(invalidPerson);
            assertTrue(errors.contains("O nome deve ter pelo menos duas partes."));
            assertTrue(errors.contains("O nome deve conter apenas letras."));
            assertTrue(errors.contains("A idade deve estar no intervalo entre 1 e 200."));
            assertTrue(errors.contains("O email deve estar no formato correto (___@___.___)."));
        }
}

