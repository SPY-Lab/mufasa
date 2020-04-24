
if (randInt() == 0) {
	x = new {a:1; b:2; c:3};
} else {
	x = new {d:4; e:5; f:6};
}

i = 0;
for (v in x) {
	i = i + x[v];
}