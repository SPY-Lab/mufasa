function propertyName(methodName){
    if(methodName.startsWith("is")){
        pn = methodName.substring("is".length, methodName.length);
    }else{
        if(methodName.startsWith("get")){
        	pn = methodName.substring("get".length, methodName.length);
        }else{
        	pn = methodName;
        }
    }
    
    x = pn.substring(0, 1).toLowerCase();
    y = pn.substring(1, pn.length + 1);
    return x + y;
}

x = propertyName("isRobbie");
y = propertyName("get123456");
z = propertyName("Bobby");