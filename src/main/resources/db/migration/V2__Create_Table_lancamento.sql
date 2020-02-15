CREATE TABLE lancamento (
  id INTEGER PRIMARY KEY,
  conta_origem INTEGER,
  valor INTEGER,
  conta_destino INTEGER,
  FOREIGN KEY  (conta_origem) REFERENCES  conta_corrente (numero),
  FOREIGN KEY  (conta_destino) REFERENCES  conta_corrente (numero)
);