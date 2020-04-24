HEADINGPREFIX = "";
squashedPrefix = "a";
inProgressReport = true;

function apply(line){
    if (line.startsWith("\r\u001b")) {
        line = line.substring(2, line.length);
        if ("[K" == line) {
            inProgressReport = true;
        }else{}
        return "null";
    }else {

        if (line.startsWith(squashedPrefix)) {
            line = line.substring(squashedPrefix.length, line.length);
            inProgressReport = false;
            lastLine = line;
            if (line.startsWith(HEADINGPREFIX)) {
                line = line.substring(HEADINGPREFIX.length, line.length);
                heading = line + " > ";
            } else {
                line = line;
            }
        } else {
            if (inProgressReport) {
                inProgressReport = false;
                line = lastLine + line;
            } else {
                return "null";
            }
        }
    }
    return line;
}

x = apply("\r\u001b12345");