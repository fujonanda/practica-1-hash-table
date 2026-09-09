public class Pruebas{

    public static void main(String[] args){
        TablaHash<String> tabla = new TablaHash<>();
        tabla.buscar(10);
        tabla.imprimirTabla();
        System.out.println();
        tabla.insertar(18, "Ana");
        tabla.insertar(10, "Luis");
        tabla.insertar(23, "Elena");
        tabla.buscar(18);
        tabla.buscar(10);
        tabla.buscar(23);
        tabla.imprimirTabla();
        System.out.println();
        tabla.insertar(24, "Maria");
        tabla.insertar(31, "Carlos");
        tabla.buscar(10);
        tabla.buscar(24);
        tabla.buscar(31);
        tabla.imprimirTabla();
        System.out.println();
        tabla.eliminar(24);
        tabla.buscar(24);
        tabla.buscar(10);
        tabla.buscar(31);
        tabla.imprimirTabla();
        System.out.println();
        tabla.eliminar(999);
        System.out.println();
        tabla.insertar(18, "Ana Maria");
        tabla.buscar(18);
        tabla.imprimirTabla();
        System.out.println("Factor de carga: " + tabla.factorCarga());
    }
}