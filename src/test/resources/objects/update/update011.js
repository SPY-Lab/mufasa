x = new {a:1};
y = new {a:2};

i = 10;
if (i == 10) {
	z = x;
} else {
	z = y;
}
z["a"] = 3;