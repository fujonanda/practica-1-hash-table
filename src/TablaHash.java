public class TablaHash<V> {

    private static class Nodo<V> {
        int key;
        V value;
        Nodo<V> siguiente;
        public Nodo(int key, V value) {
            this.key = key;
            this.value = value;
            this.siguiente = null;
        }
    }

    private Nodo<V>[] tabla;
    private int numElementos;

    public TablaHash() {
        tabla = new Nodo[7];
        numElementos = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % 7;
    }

    public double factorCarga() {
        return (double) numElementos / tabla.length;
    }

    public void insertar(int key, V value) {
            if (key < 0) {
            System.out.println("No se permite insertar llaves negativas");
            return;
        }
        int indice = hash(key);
        Nodo<V> actual = tabla[indice];
        Nodo<V> previo = null;
        while (actual != null && actual.key < key) {
            previo = actual;
            actual = actual.siguiente;
        }
        if (actual != null && actual.key == key) {
            actual.value = value;
            System.out.println("Valor actualizado de " + key + " -> " + value);
            return;
        }
        Nodo<V> nuevoNodo = new Nodo<>(key, value);
        if (previo == null) {
            nuevoNodo.siguiente = tabla[indice];
            tabla[indice] = nuevoNodo;
        } else {
            nuevoNodo.siguiente = actual;
            previo.siguiente = nuevoNodo;
        }
        numElementos++;
        System.out.println("Llave " + key + " insertada en el índice " + indice);
    }
}