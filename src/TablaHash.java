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
}