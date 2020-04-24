function f(a) {
	if (a == 0) {
		return 0;
	} else {
		return f(a - 1);
	}
}



x = f(100);