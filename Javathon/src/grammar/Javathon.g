grammar Javathon;

file  
  :  row+ EOF  
  ;  
  
row  
  :  value (Comma value)* (LineBreak | EOF)  
  ;  
  
value  
  :  SimpleValue  
  |  QuotedValue  
  ;  
  
Comma  
  :  ','  
  ;  
  
LineBreak  
  :  '\r'? '\n'  
  |  '\r'  
  ;  
  
SimpleValue  
  :  ~(',' | '\r' | '\n' | '"')+  
  ;  
  
QuotedValue  
  :  '"' ('""' | ~'"')* '"'  
  ;  