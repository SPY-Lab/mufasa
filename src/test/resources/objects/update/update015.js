x = new { a : 1 };
y = new { a : 2 };

if (randInt()) { 
	z = x;
} else { 
	z = y;
}

z["a"] = 3;