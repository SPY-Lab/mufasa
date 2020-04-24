function translateFuture(output) {
    time = output;
    if(!output.indexOf("jaj") == -1){
        time = time.slice(0, -3) + "Hu";
    }else{
        if(!output.indexOf("jar") == -1){
            time = time.slice(0, -3) + "wen";
        }else{
            if(!output.indexOf("DIS") == -1){
                time = time.slice(0, -3) + "ben";
            }else{
                time = time + " ret";
            }
        }
    }

    return time;
}

x = translateFuture("jaj123");
y = translateFuture("jar123");
z = translateFuture("DIS123");
w = translateFuture("123");
