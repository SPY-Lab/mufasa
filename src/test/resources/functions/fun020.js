function f(p1, p2) {
	if (true) {
		return p1;
		p1 = p1 + 1;
	} else {
		return p2;
		p1 = p1 + 1;
	}
	
	p1 = p2;
}

x = f(1,2);