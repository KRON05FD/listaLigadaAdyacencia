
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

    public void bfsTraversal(int inicioVertice) {
        boolean[] recorrido = new boolean[numVertices];
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        recorrido[inicioVertice] = true;
        queue.add(inicioVertice);

        while (!queue.isEmpty()) {
            int verticeActual = queue.poll();
            result.append(vertices[verticeActual]).append(" ");  // Agrega la etiqueta del vértice al resultado

            for (int adyacente : listaAdyacente[verticeActual]) {
                if (!recorrido[adyacente]) {
                    recorrido[adyacente] = true;
                    queue.add(adyacente);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Recorrido bfs desde el vertice " + vertices[inicioVertice] + ":\n" + result.toString());
    }

    public static void main(String[] args) {
        int numVertices = 6;
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F'};
        bfs graph = new bfs(numVertices, vertices);  // Crear una instancia de la clase bfs

        graph.agregaBorde(0, 1);
        graph.agregaBorde(0, 2);
        graph.agregaBorde(1, 3);
        graph.agregaBorde(1, 4);
        graph.agregaBorde(2, 5);

        StringBuilder listaAdyacenteString = new StringBuilder("Lista Ligada de Adyacencia:\n");
        for (int i = 0; i < numVertices; i++) {
            listaAdyacenteString.append(vertices[i]).append(" -> ");
            for (int adyacente : graph.listaAdyacente[i]) {
                listaAdyacenteString.append(vertices[adyacente]).append(" -> ");  // Muestra las etiquetas de los vértices en la lista ligada
            }
            listaAdyacenteString.append("null\n");
        }

        JOptionPane.showMessageDialog(null, listaAdyacenteString.toString());  // Muestra la lista ligada de adyacencia

        graph.bfsTraversal(0);  // Realiza el recorrido bfs desde el vértice 0 y muestra el resultado
    }
}
