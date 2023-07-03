#include <iostream>
#include <vector>

using namespace std;

class Graph {
public:
    int nodes;
    vector<vector<int>> matrix;

public:
    Graph(int numNodes) : nodes(numNodes), matrix(numNodes, vector<int>(numNodes, 0)) {}

    void tmbGraf(int src, int dest) {
        if (src >= 0 && src < nodes && dest >= 0 && dest < nodes) {
            matrix[src][dest] = 1;
            matrix[dest][src] = 1;
        }
    }

    void ctkgraf() {
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                cout << matrix[i][j] << " ";
            }
            cout << endl;
        }
    }
};

int main() {
    Graph graph(5);

    graph.tmbGraf(1, 0);
    graph.tmbGraf(1, 2);
    graph.tmbGraf(1, 3);
    graph.tmbGraf(1, 2);
    graph.tmbGraf(2, 4);

    graph.ctkgraf();

    return 0;
}
