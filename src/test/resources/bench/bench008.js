function coerceLocalScriptURL(scriptURL){
    if (scriptURL.startsWith("assets://")) {
        return "null";
    }
    else {
        scriptURL = scriptURL.substring(scriptURL.indexOf("/") + 1, scriptURL.length);
        if (!scriptURL.includes("://")) {
            scriptURL = "file://" + scriptURL;
        } else {}

        return scriptURL;
    }
}

x = coerceLocalScriptURL("assets://123");
y = coerceLocalScriptURL("12/12345");
z = coerceLocalScriptURL("123:/Robbie");

