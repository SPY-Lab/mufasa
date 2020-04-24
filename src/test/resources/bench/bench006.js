MAXLENGTH = 5;

function truncateTag(tag){
    if(tag.length > MAXLENGTH){
        return tag.substring(0, MAXLENGTH - 1);
    }else{
        return tag;
    }
}

x = truncateTag("123456789");
y = truncateTag("12345");