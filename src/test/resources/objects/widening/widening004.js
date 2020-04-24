o = new {a:1};
i = 0;

while(i < 10){
	if (i == 3) {
		o["a"] = o["a"] * -1;
	} else {
		o["a"] = o["a"] * 2;
	}
	i = i + 1;
}
