function f(p1, p2) {
	if (true) {
		p1 = p1 + 1;
		return p1;
	} else {
		p1 = p1 + 1;
		return p2;
	}
	
	p1 = p2;
}

x = f(1,2);