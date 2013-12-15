// CSVLexer.g  
lexer grammar Javathon;  
  
/* 
the rest of the file here 
*/  

  
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