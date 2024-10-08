package org.davi.tddproject.teste01;

import org.junit.Test;
import static org.junit.Assert.*;
import org.davi.tddproject.exercicio01.Triangulo;

public class TrianguloTest {

    // 1
    @Test
    public void testEscalenoValido() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Escaleno", triangulo.verificaTriangulo(3, 4, 5));
    }

    // 2
    @Test
    public void testIsoscelesValido() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Isósceles", triangulo.verificaTriangulo(5, 5, 8));
    }

    // 3
    @Test
    public void testEquilateroValido() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Equilátero", triangulo.verificaTriangulo(2, 2, 2));
    }

    // 4
    @Test
    public void testPermutacoesIsosceles() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Isósceles", triangulo.verificaTriangulo(3, 3, 2));
        assertEquals("Isósceles", triangulo.verificaTriangulo(3, 2, 3));
        assertEquals("Isósceles", triangulo.verificaTriangulo(2, 3, 3));
    }

    // 5
    @Test
    public void testUmValorZero() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Valores inválidos", triangulo.verificaTriangulo(0, 4, 5));
    }

    // 6
    @Test
    public void testUmValorNegativo() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Valores inválidos", triangulo.verificaTriangulo(-1, 4, 5));
    }

    // 7
    @Test
    public void testSomaDoisLadosIgualAoTerceiro() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.verificaTriangulo(5, 5, 10));
    }

    // 8
    @Test
    public void testPermutacoesSomaDoisLadosIgualAoTerceiro() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.verificaTriangulo(5, 10, 5));
        assertEquals("Não é um triângulo", triangulo.verificaTriangulo(10, 5, 5));
    }

    // 9
    @Test
    public void testSomaDoisLadosMenorQueTerceiro() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.verificaTriangulo(3, 4, 8));
    }

    // 10
    @Test
    public void testPermutacoesSomaDoisLadosMenorQueTerceiro() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Não é um triângulo", triangulo.verificaTriangulo(4, 8, 3));
        assertEquals("Não é um triângulo", triangulo.verificaTriangulo(8, 3, 4));
    }

    // 11
    @Test
    public void testTresValoresZero() {
        Triangulo triangulo = new Triangulo();
        assertEquals("Valores inválidos", triangulo.verificaTriangulo(0, 0, 0));
    }
}
