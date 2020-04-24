function normalizeLoGLine(line) {
    if (line.includes("ERROR")) {
        return line.substring(line.indexOf("ERROR"), line.length);
    }else{
            if (line.includes("WARN")) {
                return line.substring(line.indexOf("WARN"), line.length);
            } else {
                return line;
            }
        }
}

x = normalizeLoGLine("1234ERROR1234");
y = normalizeLoGLine("1234WARN1234");
