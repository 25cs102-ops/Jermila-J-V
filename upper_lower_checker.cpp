#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    int lower = 0, upper = 0;

    for (char c : s) {
        if (c >= 'a' && c <= 'z') {
            lower |= (1 << (c - 'a'));
        } else if (c >= 'A' && c <= 'Z') {
            upper |= (1 << (c - 'A'));
        }
    }

    if (lower == (1 << 26) - 1 && upper == (1 << 26) - 1)
        cout << "yes";
    else
        cout << "no";

    return 0;
}
