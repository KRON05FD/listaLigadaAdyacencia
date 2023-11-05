
import java.util.LinkedList; //Clase para administrar listas
import java.util.Queue; //Clase para administrar colas en memoria
import javax.swing.JOptionPane;

//Clase para hacer el recorrido BFS
public class bfs {

    private int numVertices;
    private LinkedList<Integer>[] listaAdyacente;
    private char[] vertices;  // Arreglo de etiquetas de vertices

    public bfs(int numVertices, char[] vertices) {
        this.numVertices = numVertices;
        this.vertices = vertices;  // Inicializa las etiquetas de los vertices
        this.listaAdyacente = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            listaAdyacente[i] = new LinkedList<>();
        }
    }

    public void agregaBorde(int origen, int destino) {
        listaAdyacente[origen].add(destino);  // Agregamos las aristas al grafo mediante la lista ligada de adyacencia
    }

    //Clase que recorre el grafo hacemos uso de la clase Queue que sirve para administrar colas, con ciclo while vamos agregando los vertices para mostrar
    //el recorrido que tendra el grafo en la variable resultadoado,
    public void bfsTraversal(int inicioVertice) {
        boolean[] recorrido = new boolean[numVertices];
        StringBuilder resultado = new StringBuilder();
        Queue<Integer> cola = new LinkedList<>();

        recorrido[inicioVertice] = true;
        cola.add(inicioVertice);

        while (!cola.isEmpty()) {
            int verticeActual = cola.poll();
            resultado.append(vertices[verticeActual]).append(" ");  // Agrega la etiqueta del vertice al resultadoado

            for (int adyacente : listaAdyacente[verticeActual]) {
                if (!recorrido[adyacente]) {
                    recorrido[adyacente] = true;
                    cola.add(adyacente);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Recorrido BFS desde el vertice " + vertices[inicioVertice] + ":\n" + resultado.toString());
    }

    public static void main(String[] args) {
        int numVertices = 6;
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F'};
        bfs graficaLista = new bfs(numVertices, vertices);  // Crear una instancia de la clase bfs

        graficaLista.agregaBorde(0, 1);
        graficaLista.agregaBorde(0, 2);
        graficaLista.agregaBorde(1, 3);
        graficaLista.agregaBorde(1, 4);
        graficaLista.agregaBorde(2, 5);
        graficaLista.agregaBorde(3, 2);
        graficaLista.agregaBorde(0, 4);
        graficaLista.agregaBorde(1, 5);

        

        StringBuilder listaAdyacenteString = new StringBuilder("Lista ligada de adyacencia:\n");
        for (int i = 0; i < numVertices; i++) {
            listaAdyacenteString.append(vertices[i]).append(" -> ");
            for (int adyacente : graficaLista.listaAdyacente[i]) {
                listaAdyacenteString.append(vertices[adyacente]).append(" -> ");  // Muestra las etiquetas de los vértices en la lista ligada
            }
            listaAdyacenteString.append("null\n");
        }

        JOptionPane.showMessageDialog(null, listaAdyacenteString.toString());  // Muestra la lista ligada de adyacencia

        graficaLista.bfsTraversal(0);  // Realiza el recorrido bfs desde el vértice 0 y muestra el resultadoado
    }
}
