package uas.java;

/**
 * 1. hapus kabeh seng public class seng pakage karo autor ditokne
 * 
 */

 // iki kabeh dicopy
 // uasmatriks iki dihanti karo jeneng file mu contone BinaryTree kemau gede cilik e podo

public class uasmatriks {
    private int nodes;
    private int[][] matrix;

    // uasmatriks iki diganti podo karo jeneng file
    public uasmatriks(int numNodes) {
        nodes = numNodes;
        matrix = new int[numNodes][numNodes];
    }

    public void tmbGraf(int asal, int tujuan) {
        if (asal >= 0 && asal < nodes && tujuan >= 0 && tujuan < nodes) {
            matrix[asal][tujuan] = 1;
            matrix[tujuan][asal] = 1;
        }
    }

    public void cetak() {
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // uasmatriks iki diganti podo karo jeneng file
        uasmatriks graph = new uasmatriks(5);

            graph.tmbGraf(1, 0);
            graph.tmbGraf(1, 2);
            graph.tmbGraf(1, 3);
            graph.tmbGraf(1, 2);
            graph.tmbGraf(2, 4);

            graph.cetak();
    }
}

