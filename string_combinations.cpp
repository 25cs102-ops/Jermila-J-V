#include <iostream>
#include <string>
using namespace std;

int main() {
    string ch;
    cin >> ch;
    int l = ch.length();

    for (int i = 1; i < (1 << l); i++) {
        string combi = "";
        for (int j = 0; j < l; j++) {
            if (i & (1 << j)) {
                combi += ch[j];
            }
        }
        cout << combi << endl;
    }
    return 0;
}
