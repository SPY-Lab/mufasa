x = new {a:1};
y = new {a:2};

i = 0;
while (true) {
	i = i + 1;
}

if (i < 10) {
	z = x;
} else {
	z = y;
}
z["a"] = 3;