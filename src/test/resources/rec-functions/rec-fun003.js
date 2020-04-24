function f(n) {
 	if (n == 0) {
		return 1;
	} 	else {
		return n * f(n - 1);
	}
}

x = f(3);
y = f(3);