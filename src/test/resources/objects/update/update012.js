x = new {a:2};

i = 0;
while (i < 100) {
	i = i + 1;
}

if (i == 10) {
	y = new {a:5};
	y["a"] = 10;
} else {
	y = x;
	y["a"] = 10;
}
