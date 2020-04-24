o = new {a:1};
b = true;
i = 0;

while(true){
	if (b) {
		o["a"] = o["a"] + i;
	} else {
		o["a"] = o["a"] - i;
	}
	b = !b;
	i = i + 1;
}
