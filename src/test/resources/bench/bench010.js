function translateFuture(output) {
    time = output;
    if(!output.indexOf("jaj") == -1){
        time = time.slice(0, -3) + "leS";
    }else{
        if(!output.indexOf("jar") == -1){
            time = time.slice(0, -3) + "waQ";
        }else{
            if(!output.indexOf("DIS") == -1){
                time = time.slice(0, -3) + "nem";
            }else{
                time = time + " pId";
            }
        }
    }

    return time;
}

x = translateFuture("jaj123");
y = translateFuture("jar123");
z = translateFuture("DIS123");
w = translateFuture("123");