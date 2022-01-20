package Matrix;

import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int line, column;
        line = 3;
        column = 3;

        Matriz matrix1 = new Matriz(line, column);
        matrix1.insert(line, column);
        Matriz matrix2 = new Matriz(line, column);
        matrix2.insert(line, column);
        matrix1.showMainDiagonal();
        matrix1.showSecondDiagonal();
        matrix1.sum(matrix2);
        Matriz multi = new Matriz(line, column);
        multi = matrix1.multiplication(matrix2);
        multi.print();

    }
}

class CelulaMatriz {

    public int element;
    public CelulaMatriz bottom, above, left, right;

    public CelulaMatriz() {
        this(0, null, null, null, null);
    }

    public CelulaMatriz(int element) {
        this(element, null, null, null, null);
    }

    public CelulaMatriz(int element, CelulaMatriz inf, CelulaMatriz sup, CelulaMatriz esq, CelulaMatriz dir) {
        this.element = element;
        this.bottom = inf;
        this.above = sup;
        this.left = esq;
        this.right = dir;
    }

}

class Matriz {

    private CelulaMatriz begin;
    private int line;
    private int collumn;

    Matriz() {
        this(3, 3);
    }

    Matriz(int line, int collumn) {

        this.line = line;
        this.collumn = collumn;
        this.begin = new CelulaMatriz(0);
        CelulaMatriz pointer = begin;
        CelulaMatriz pointerAux = begin;
        CelulaMatriz pointerAuxcollumn = begin;

        int j = 1;

        // Primeiro criação das collumns
        for (int i = 1; i < collumn; i++) { // i inicia-se com o valor 1, uma vez que já temos nossa primeira celula
            pointer.right = new CelulaMatriz(0);
            pointer.right.left = pointer;
            pointer = pointer.right;
        }

        // Criação das lines
        pointer = begin;
        for (int i = 1; i < line; i++) {
            pointer.bottom = new CelulaMatriz(0);
            pointer.bottom.above = pointer;
            pointer = pointer.bottom;
        }

        // Preencher a matriz
        CelulaMatriz pointercollumn = begin.right;
        CelulaMatriz pointerline = begin.bottom;
        pointerAux = pointerline;
        pointerAuxcollumn = pointercollumn;
        for (int i = 1; i < line; i++) {
            for (int k = 1; k < collumn; k++) {
                pointerline.right = new CelulaMatriz(0);
                pointercollumn.bottom = pointerline.right;
                pointerline.right.left = pointerline;
                pointerline.right.above = pointercollumn;
                pointerline = pointerline.right;
                if (pointercollumn.right != null)
                    pointercollumn = pointercollumn.right;
            }
            pointercollumn = pointerAuxcollumn;
            pointerline = pointerAux;
            if (i + 1 < line) {
                pointerline = pointerline.bottom;
                pointercollumn = pointerAuxcollumn.bottom;
                pointerAux = pointerAux.bottom;
                pointerAuxcollumn = pointerAuxcollumn.bottom;
            }
        }

    }// Fim construtor

    void print() {

        CelulaMatriz pointer = begin;
        CelulaMatriz pointerAux = begin;

        while (pointer != null) {
            pointerAux = pointer;
            for (int i = 0; i < collumn; i++) {
                System.out.print(pointer.element + " ");
                pointer = pointer.right;
            }
            System.out.println("");
            pointer = pointerAux;
            pointer = pointer.bottom;
        }

    }

    void insertelement(int line, int collumn, int element) {

        CelulaMatriz pointer = begin;

        for (int i = 1; i < line; i++) {
            pointer = pointer.bottom;
        }

        for (int i = 1; i < collumn; i++) {
            pointer = pointer.right;
        }

        pointer.element = element;
    }

    void insert(int line, int collumn) {

        String valores = "";
        int k = 1;

        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= collumn; j++) {
                insertelement(i, j, i + 2);
            }
        }
        // print();
    }

    public boolean isQuadrada() {
        return (this.line == this.collumn);
    }

    void showMainDiagonal() {

        CelulaMatriz pointer = begin;

        for (int i = 0; i < collumn; i++) {
            System.out.print(pointer.element + " ");
            if (pointer.right != null)
                pointer = pointer.right.bottom;
        }
        System.out.println(" ");
    }

    void showSecondDiagonal() {

        CelulaMatriz pointer = begin;

        for (int i = 0; i < collumn; i++) {
            if (pointer.right != null)
                pointer = pointer.right;
        }

        for (int i = 0; i < collumn; i++) {
            System.out.print(pointer.element + " ");
            if (pointer.left != null)
                pointer = pointer.left.bottom;
        }

        System.out.println(" ");
    }

    void sum(Matriz matriz2) {

        CelulaMatriz pointer1 = begin;
        CelulaMatriz pointer2 = matriz2.begin;
        CelulaMatriz pointer1Aux = pointer1;
        CelulaMatriz pointer2Aux = pointer2;
        Matriz sum = new Matriz();
        int valor = 0;

        if (this.line == matriz2.line && this.collumn == matriz2.collumn) {
            sum = new Matriz(this.line, this.collumn);
            for (int k = 1; k <= line; k++) {
                for (int i = 1; i <= collumn; i++) {
                    valor = pointer1.element + pointer2.element;
                    sum.insertelement(k, i, valor);
                    if (pointer1.right != null && pointer2.right != null) {
                        pointer1 = pointer1.right;
                        pointer2 = pointer2.right;
                    }
                }
                // completar segunda line
                pointer1 = pointer1Aux;
                pointer2 = pointer2Aux;
                if (k + 1 <= line) {
                    pointer1 = pointer1.bottom;
                    pointer2 = pointer2.bottom;
                    pointer1Aux = pointer1;
                    pointer2Aux = pointer2;
                }
            }
        }
        sum.print();

    }// Fim sum

    void multi(Matriz matriz2) {

        CelulaMatriz pointer1 = begin;
        CelulaMatriz pointer2 = matriz2.begin;
        CelulaMatriz pointer1Aux = pointer1;
        CelulaMatriz pointer2Aux = pointer2;
        Matriz multiplication = new Matriz();
        int valor1 = 0;
        int valor2 = 0;
        int col = 1;

        if (this.line == matriz2.line && this.collumn == matriz2.collumn) {
            multiplication = new Matriz(this.line, this.collumn);
            for (int k = 1; k <= line; k++) {
                valor1 = 0;
                for (int i = 1; i <= collumn; i++) {
                    valor1 += pointer1.element * pointer2.element;
                    if (pointer1.right != null && pointer2.bottom != null) {
                        pointer1 = pointer1.right;
                        pointer2 = pointer2.bottom;
                    }
                    multiplication.insertelement(k, col, valor1);
                } // fim fo for collumn
                col++;
                pointer2 = pointer2Aux;
                if (pointer2.right != null) {
                    pointer2 = pointer2.right;
                }
            } // fim do for line

        } // fim do if

        multiplication.print();

    }

    public Matriz multiplication(Matriz matriz2) throws Exception {

        Matriz multiplication = new Matriz(this.line, this.collumn);

        if (this.line == matriz2.line && this.collumn == matriz2.collumn) {
            for (CelulaMatriz i = begin, x = multiplication.begin; x != null; i = i.bottom, x = x.bottom) {
                for (CelulaMatriz lin = matriz2.begin, y = x; y != null; lin = lin.right, y = y.right) {
                    CelulaMatriz jin = lin;
                    CelulaMatriz hpri = i;

                    while (jin != null) {
                        y.element += jin.element * hpri.element;
                        jin = jin.bottom;
                        hpri = hpri.right;
                    }
                }
            }
        }
        return multiplication;
    }

}