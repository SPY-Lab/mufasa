function countLine(s, kdx){
    c = 1;
    i = kdx;
    while(i > -1){
        if(s.charAt(i) == "\n"){
            c = c + 1;
        }else{}
        i = i - 1;
    }
    return c;
}

x = countLine("abcd", 7);
y = countLine("abcd\nabcd\nabcd",20);