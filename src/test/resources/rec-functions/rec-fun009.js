// Bad recursion

function bad(i) {
	return bad(i + 1);
}


x = bad(100);