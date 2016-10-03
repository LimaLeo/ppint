class FilaCircular {
      private int vet[];
      private int inicio, fim, quantidade;
   
       public FilaCircular(int tamanho)
      {
         vet = new int[tamanho];
         inicio = fim = quantidade = 0;
      }
   
      public void enfileirar(int x)
      {
         vet[fim] = x;
         fim++;
         quantidade++;
         if (fim == vet.length)
            fim = 0;
      }
   
       public int desenfileirar()
      {
         int resp = vet[inicio];
         inicio++;
         quantidade--;
         if (inicio == vet.length)
            inicio = 0;
         return resp;
      }
   
       public boolean vazia()
      {
         if (quantidade == 0) 
            return true;
         else 
            return false;
      }
   
       public boolean cheia()
      {
         if (quantidade == vet.length) 
            return true;
         else 
            return false;
      }
       
       public boolean valida(int valor)
       {
    	   for(int i=0;i<vet.length;i++)
    	   {
    		   if(vet[i]==valor)
    		   {
    			   return true;
    		   }
    	   }
    	   return false;
       }
       
       public int geraItemFila()
       {
    	   int valor=0;
    	   boolean aux=true;
    	   do
    	   {
	    	   valor = (int) (Math.random()*999)+1;
	    	   if(!valida(valor))
	    	   {
	    		   enfileirar(valor);
	    		   return valor;
	    	   }
    	   }while(aux);
    	   return -1;
       }
       
       public String getFilaCircular()
       {
    	   String fila="";
    	   for(int i=0;i<vet.length;i++)
    	   {
    		   fila += " "+ vet[i];
    	   }
    	   return fila;
       }
   }
