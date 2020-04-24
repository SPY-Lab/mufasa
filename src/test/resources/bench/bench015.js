
stations = new {st1: "MANabc;Manchester"; st2:"GNFgef;Greenfield"};

result = new {};

for (st in stations) {
  input = stations[st];
  code = input.substring(0,3);
  semiC = input.indexOf(';');
  name = input.substring(semiC + 1, input.length);
  result[st] = code + ': ' + name;
}