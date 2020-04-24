function stripCommentAndWhitespace(line){
    hash = line.indexOf("#");

    if(!hash == -1){
        line = line.substring(0, hash);
    }else{}

    return line.trim();

}

x = stripCommentAndWhitespace("#Bob   ");
y = stripCommentAndWhitespace("123#1 2 3 4");
z = stripCommentAndWhitespace("   abc d   ");