o = new {a:true;b:4;c:5};

while(true){
	o["a"] = !o["a"];
	o["b"] = o["b"] + o["c"];
	o["c"] = o["c"] - 1;
}
