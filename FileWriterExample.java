class FileWriterExample { 
    void Save(float i){  
        try{    
        FileWriter fw=new FileWriter("Output.txt");    
        String simp = String.valueOf(i);
        }
    }
    public static void main (String[] args) {
    
            fw.write(simp);    
            fw.close();    
            }catch(Exception e){System.out.println(e);}    
            System.out.println("Yuhu~~ Suksess di save");    
        
      
}