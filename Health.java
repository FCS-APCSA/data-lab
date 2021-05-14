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
    public void highestPercentGDP(){
        //sets the first object as the highest percent GDP
        double highest=allstates[0].getPercentGDP();
        String highestName=allstates[0].getName();
        //for loop iterates through the WorldBank objects in the array and gets their % GDP expenditure values
        //if that value is bigger than that of the object in highest, the bigger object replaces the old object 
        //as the highest (replaces the name as well)
        for(int i=0; i<allstates.length; i++){
            if(allstates[i].getPercentGDP()>highest){
                highest=allstates[i].getPercentGDP();
                highestName=allstates[i].getName();
            }   
        }
        //prints out results
        System.out.print("The World Bank that spends the most money in proportion to their GDP (total money made by a country made in a year through imports and exports) is ");
        System.out.println(highestName+" where medical expenditures are "+highest+"% of the GDP.");
    }
    
    public void highestPerCapita(){
        //sets the first object as the highest per capita
        double highest=allstates[0].getperCapita();
        String highestName=allstates[0].getName();
        //for loop iterates through the WorldBank objects in the array and gets their per capita expenditure values
        //if that value is bigger than that of the object in highest, the bigger object replaces the old object 
        //as the highest (replaces the name as well)
        for(int i=0; i<allstates.length; i++){
            if(allstates[i].getperCapita()>highest){
                highest=allstates[i].getperCapita();
                highestName=allstates[i].getName();
            }   
        }
        //prints results
        System.out.print("The World Bank that spends the most on medical expenditures per person is ");
        System.out.println(highestName+" where medical expenditures per person are "+highest+" per person");
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
            System.out.println("The world bank of "+allstates[index].getName()+" spends $"+allstates[index].getperCapita()+" USD per citizen.");
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
