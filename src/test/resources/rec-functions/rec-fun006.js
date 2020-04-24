function foo(n) {
	if (n == 0) {
		return 0;
	} else {
		return foo(n - 1);
	}
}


x = foo(5);