function g(a) {
	return a + 1;
}

function f(a,b,c) {
	return g(a) + g(b) + g(c);
}

x = f(1,2,3);
