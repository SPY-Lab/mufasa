function parseHost(input){
    input = input.trim();
    input = input.toLowerCase();
    if (!input.startsWith("https://")){
        r = new {a: "null"};
    }else{
        if(input.charAt(0) == "["){
            r = new {a: "null"};
        }else {
            input = input.substring(8, input.length);
            if (!input.startsWith("www.")) {
                r = new {a: "null"};
            } else {
                if (input.endsWith(".it")) {
                    domain = input.substring(4, input.length - 3);
                    r = new {a: "https"; b: "www"; c: domain; d: "it"};
                } else {
                    r = new {a: "null"};
                }
            }
        }
    }
    return r;
}

function parseFirstDomain(s){
    stop = false;
    while(!stop){
        if(s.length == 0){
            stop = true;
            result = new {a: "null"};
        }else{
            index = s.indexOf("|");
            if(index == -1){
                sub = s.substring(0, s.length);
                s = "";
            }else{
                sub = s.substring(0, index);
                s = s.substring(index, s.length);
            }

            result = parseHost(sub);
            if(!result["a"] == "null"){
                stop = true;
            }else{}
        }

    }

    return result;
}

x = parseFirstDomain("a|https://www.c.it");