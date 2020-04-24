function parseHost(input){
    input = input.trim();
    if (!input.startsWith("https://")){
        return "null";
    }else{
        input = input.substring(8, input.length);
        if(input.charAt(0) == "["){
            return "null";
        }else{
            index = input.indexOf(":");
            if(!index == -1){
                return "null";
            }else{
                index = input.indexOf("/");
                hostName = input.substring(0, index).toLowerCase();
                if(isValidDomain(hostName)){
                    return hostName + "\n";
                }else{
                    return false;
                }

            }
        }
    }
}

function isValidDomain(input){
    if(!input.startsWith("www.")){
        return false;
    }else{
        if(input.endsWith(".it")){
            return true;
        }else{}
    }

    return false;
}

//parse dei primi 3 domini .it che usano https
function parseFirst3(s){
    i = 0;
    domains = "";
    while(i < 1){
        if(s.length == 0){
            return "null";
        }else{
            index = s.indexOf("\n");
            if(index == -1){
                sub = s.substring(0, s.length);
                s = "";
            }else{
                sub = s.substring(0, index);
                s = s.substring(index + 1, s.length);
            }
            result = parseHost(sub);
            if(! result == "null"){
                domains = domains + result;
                i = i + 1;
            }else{}
        }

    }

    return domains;
}

x = parseFirst3("https://google.it\nhttps://google.it\nhttps://google.it\n");