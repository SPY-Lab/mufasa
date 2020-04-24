function g(b) {
	return b;
}


function f(a) {
	while (true) {
		a = g(a) + 1;
	}
	
	return a;
}

x = f(1);