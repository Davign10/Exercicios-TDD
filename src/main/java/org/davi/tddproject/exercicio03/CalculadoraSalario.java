package org.davi.tddproject.exercicio03;

public class CalculadoraSalario {

    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        String cargo = funcionario.getCargo();

        if (cargo.equals("DESENVOLVEDOR")) {
            return calcularSalarioDesenvolvedor(salarioBase);
        } else if (cargo.equals("DBA") || cargo.equals("TESTADOR")) {
            return calcularSalarioDBAeTestador(salarioBase);
        } else if (cargo.equals("GERENTE")) {
            return calcularSalarioGerente(salarioBase);
        } else {
            throw new IllegalArgumentException("Cargo desconhecido: " + cargo);
        }
    }

    private double calcularSalarioDesenvolvedor(double salarioBase) {
        if (salarioBase >= 3000) {
            return salarioBase * 0.8;
        } else {
            return salarioBase * 0.9;
        }
    }

    private double calcularSalarioDBAeTestador(double salarioBase) {
        if (salarioBase >= 2000) {
            return salarioBase * 0.75;
        } else {
            return salarioBase * 0.85;
        }
    }

    private double calcularSalarioGerente(double salarioBase) {
        if (salarioBase >= 5000) {
            return salarioBase * 0.7;
        } else {
            return salarioBase * 0.8;
        }
    }
}
