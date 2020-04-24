function removeCurlies(input){
    result = "";
    skip = false;
    i = 0;
    while(input.length > i + 1){
        c = input.charAt(i);
        if(c == "{"){
            skip = true;
        }else{}
        if (!skip) {
            result = result + c;
        }else{}
        if (c == "}") {
            skip = false;
        }else{}

        i = i + 1;
    }

    return result;
}

x = removeCurlies("Robbie{Robbie}12345");
