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

    public V buscar(int key) {
        int indice = hash(key);
        Nodo<V> actual = tabla[indice];
        while (actual != null) {
            if (actual.key == key) {
                System.out.println(key + " -> " + actual.value);
                return actual.value;
            }
            actual = actual.siguiente;
        }
        System.out.println(key + " -> NOT_FOUND");
        return null;
    }

    public void eliminar(int key) {
        int indice = hash(key);
        Nodo<V> actual = tabla[indice];
        Nodo<V> previo = null;
        while (actual != null) {
            if (actual.key == key) {
                if (previo == null) {
                    tabla[indice] = actual.siguiente;
                } else {
                    previo.siguiente = actual.siguiente;
                }
                numElementos--;
                System.out.println("Se eliminó la llave " + key);
                return;
            }
            previo = actual;
            actual = actual.siguiente;
        }
        System.out.println("No se encontró ninguna llave " + key + " para eliminar");
    }

    public void imprimirTabla() {
        System.out.println("--------------------------------------");
        for (int i = 0; i < 7; i++) {
            System.out.print(i + " -> ");
            Nodo<V> actual = tabla[i];
            if (actual == null) {
                System.out.print("");
            }
            while (actual != null) {
                System.out.print("(" + actual.key + ", " + actual.value + ")");
                if (actual.siguiente != null) {
                    System.out.print(" -> ");
                }
                actual = actual.siguiente;
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }
}