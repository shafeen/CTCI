#include <iostream>
#include <string.h>
using namespace std;

// [1.2] helper 
void reverse(char *str) {
	int len = strlen(str);
	char *buffer = new char[len+1];
	strcpy(buffer, str);
	for (int i = 0; i < len; ++i) {
		str[i] = buffer[len-1-i];
	}
	str = buffer;
	delete[] buffer;
}

// 1.2 Implement a function void reverse(char* str) in C or C++ 
//     which reverses a nullterminated string.
void q1_2(char *str) {
	cout << str << " in reverse is ";
	reverse(str);
	cout << str;
}

int main(int argc, char const *argv[]) {	
	char str[12];
	strcpy(str, "hello world");

	q1_2(str);
	
	return 0;
}
