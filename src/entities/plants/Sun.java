package src.entities.plants;

public class Sun extends Exception{
    private static int jumlah = 25;

    public Sun(){
        
    }

    public int getJumlah(){
        return jumlah;
    }

    public void sunGenerate(){
        jumlah += 25;
    }

    public void sunConsume(int cost) throws Exception{
        if(cost > jumlah){
            System.out.println("You are broke.");
        }
        jumlah = jumlah - cost;
    }
} 
