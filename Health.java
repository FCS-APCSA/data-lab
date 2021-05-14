import core.data.*;
import java.util.ArrayList;
public class Health {
    private WorldBank[] allstates;
    public Health(String filename){
        //loads information from the csv
        DataSource ds = DataSource.connect(filename);
        ds.load();
        //initializes the allstates Array to contain WorldBank Objects with information from the csv
        allstates= ds.fetchArray("WorldBank","Country_Region","World_Bank_Name","Health_exp_pct_GDP_2016","Health_exp_per_capita_USD_2016");
    }
    public void lowestPercentGDP(){
        //sets the first object as the minimum percent GDP
        double minimum=allstates[0].getPercentGDP();
        String minimumName=allstates[0].getName();
        //for loop iterates through the WorldBank objects in the array and gets their % GDP expenditure values
        //if that value is smaller than that of the object in highest, the smaller object replaces the old object 
        //as the highest (replaces the name as well)
        for(int i=0; i<allstates.length; i++){
            if(allstates[i].getPercentGDP()<minimum){
                minimum=allstates[i].getPercentGDP();
                minimumName=allstates[i].getName();
            }   
        }
        //prints out results
        System.out.print("The World Bank that spends the least money on health expenditures in proportion to their GDP (total money made by a country in a year through imports and exports) is ");
        System.out.println(minimumName+" where medical expenditures are "+minimum+"% of the GDP.");
    }
    
    public void lowestPerCapita(){
        //sets the first object as the minimum per capita
        double minimum=allstates[0].getperCapita();
        String minimumName=allstates[0].getName();
        //for loop iterates through the WorldBank objects in the array and gets their per capita expenditure values
        //if that value is smaller than that of the object in highest, the smaller object replaces the old object 
        //as the highest (replaces the name as well)
        for(int i=0; i<allstates.length; i++){
            if(allstates[i].getperCapita()<minimum){
                minimum=allstates[i].getperCapita();
                minimumName=allstates[i].getName();
            }   
        }
        //prints results
        System.out.print("The World Bank that spends the least on medical expenditures per person is ");
        System.out.println(minimumName+" where medical expenditures per person are "+minimum+" per person");
    }
    // the findPerCapita and findPercentGDP takes an input from the user and checks to see if an object in 
    // the arraylist has the same name as the input. If it does, then it prints out the appropriate information
    // otherwise, it informs the user that the value is not found
    public void findPerCapita(String input){
        boolean hasName=false;
        int index=0;
        //iterates through the arraylist objects and checks if their names equal the string input
        for(int i=0; i<allstates.length; i++){
            if(allstates[i].getName().equals(input)){
                hasName=true;
                index=i;
            }
        }
        if(hasName){
            System.out.println("The world bank of "+allstates[index].getName()+" reports that each citizen spends around $"+allstates[index].getperCapita()+" USD for medical expenditures.");
        }else{
            System.out.println("The country/region you searched for does not exist in this dataset.");
        }
    }
    
    public void findPercentGDP(String input){
        boolean hasName=false;
        int index=0;
        for(int i=0; i<allstates.length; i++){
            if(allstates[i].getName().equals(input)){
                hasName=true;
                index=i;
            }
        }
        if(hasName){
            System.out.println("The world bank of "+allstates[index].getName()+" has medical expenditures that are "+allstates[index].getPercentGDP()+"% of the total GDP.");
        }
    }
}
