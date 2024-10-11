package org.davi.tddproject.teste03;

import org.davi.tddproject.exercicio03.CalculadoraSalario;
import org.davi.tddproject.exercicio03.Funcionario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraSalarioTest {

        @Test
        public void testSalarioDesenvolvedorMaiorOuIgual3000() {
            Funcionario desenvolvedor = new Funcionario("Dev", "dev@exemplo.com", 3000.00, "DESENVOLVEDOR");
            CalculadoraSalario calculadora = new CalculadoraSalario();
            double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
            assertEquals(2400.00, salarioLiquido);
        }

        @Test
        public void testSalarioDesenvolvedorMenor3000() {
            Funcionario desenvolvedor = new Funcionario("Dev", "dev@exemplo.com", 2500.00, "DESENVOLVEDOR");
            CalculadoraSalario calculadora = new CalculadoraSalario();
            double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
            assertEquals(2250.00, salarioLiquido);
        }

        @Test
        public void testSalarioDBAMaiorOuIgual2000() {
            Funcionario dba = new Funcionario("Dba", "dba@exemplo.com", 2000.00, "DBA");
            CalculadoraSalario calculadora = new CalculadoraSalario();
            double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
            assertEquals(1500.00, salarioLiquido);
        }

        @Test
        public void testSalarioDBAMenor2000() {
            Funcionario dba = new Funcionario("Dba", "dba@exemplo.com", 1500.00, "DBA");
            CalculadoraSalario calculadora = new CalculadoraSalario();
            double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
            assertEquals(1275.00, salarioLiquido);
        }

        @Test
        public void testSalarioGerenteMaiorOuIgual5000() {
            Funcionario gerente = new Funcionario("Gerente", "gerente@exemplo.com", 5000.00, "GERENTE");
            CalculadoraSalario calculadora = new CalculadoraSalario();
            double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
            assertEquals(3500.00, salarioLiquido);
        }

        @Test
        public void testSalarioGerenteMenor5000() {
            Funcionario gerente = new Funcionario("Gerente", "gerente@exemplo.com", 4500.00, "GERENTE");
            CalculadoraSalario calculadora = new CalculadoraSalario();
            double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
            assertEquals(3600.00, salarioLiquido);
        }
}

