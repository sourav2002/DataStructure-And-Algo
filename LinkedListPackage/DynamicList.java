public class DynamicList {

    public static void main(String[] args) throws Exception {

        List list = new List();

        list.insertEnd(1);
        list.insertEnd(11);
        list.insertEnd(4);
        list.insertEnd(5);
        list.insertEnd(7);
        list.mostrar();

        list.removeEnd();
        list.remove(2);

        list.mostrar();
    }

}

class Cell {

    public int element; // element inserido na Cell.
    public Cell next; // Aponta a Cell next.

    public Cell() {
        // this(element);
    }

    public Cell(int element) {
        this.element = element;
        this.next = null;
    }
}

class List {

    private Cell first;
    private Cell last;

    /**
     * Construtor da classe que cria uma List sem elements (somente no cabeca).
     */
    public List() {
        first = new Cell();
        last = first;
    }

    /**
     * Insere um element na primeira position da List.
     * 
     * @param x int element a ser inserido.
     */
    public void insertBegin(int x) {
        Cell tmp = new Cell(x);
        tmp.next = first.next;
        first.next = tmp;
        if (first == last) {
            last = tmp;
        }
        tmp = null;
    }

    public void insertEnd(int x) {
        last.next = new Cell(x);
        last = last.next;
    }

    public int removeBegin() throws Exception {

        if (first == last) {
            throw new Exception("Erro ao remove (vazia)!");
        }

        Cell tmp = first;
        first = first.next;
        int resp = first.element;
        tmp.next = null;
        tmp = null;

        return resp;
    }

    public int removeEnd() throws Exception {

        if (first == last) {
            throw new Exception("Erro ao remove (vazia)!");
        }

        Cell i;
        for (i = first; i.next != last; i = i.next)
            ;

        int resp = last.element;
        last = i;
        i = last.next = null;

        return resp;
    }

    public void inserir(int x, int pos) throws Exception {

        int size = size();

        if (pos < 0 || pos > size) {
            throw new Exception("Erro ao inserir position (" + pos + " / size = " + size + ") invalida!");
        } else if (pos == 0) {
            insertBegin(x);
        } else if (pos == size) {
            insertEnd(x);
        } else {
            Cell i = first;
            for (int j = 0; j < pos; j++, i = i.next)
                ;

            Cell tmp = new Cell(x);
            tmp.next = i.next;
            i.next = tmp;
            tmp = i = null;
        }
    }

    public int remove(int pos) throws Exception {

        int resp;
        int size = size();

        if (first == last) {
            throw new Exception("Empty list!");

        } else if (pos < 0 || pos >= size) {
            throw new Exception("Invalid position");
        } else if (pos == 0) {
            resp = removeBegin();
        } else if (pos == size - 1) {
            resp = removeEnd();
        } else {
            Cell i = first;
            for (int j = 0; j < pos; j++, i = i.next)
                ;

            Cell tmp = i.next;
            resp = tmp.element;
            i.next = tmp.next;
            tmp.next = null;
            i = tmp = null;
        }

        return resp;
    }

    public void mostrar() {

        int position = 0;

        for (Cell i = first.next; i != null; i = i.next) {

            System.out.print("[" + position + "] " + i.element + " \n");
            position++;
        }
    }

    public int size() {
        int size = 0;
        for (Cell i = first; i != last; i = i.next, size++)
            ;
        return size;
    }
}