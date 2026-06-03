#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    int flag = 0;

    for (char c : s) {
        if (c >= 'a' && c <= 'z') {
            flag |= (1 << (c - 'a'));
        }
    }

    if (flag == (1 << 26) - 1)
        cout << "yes";
    else
        cout << "no";

    return 0;
}
