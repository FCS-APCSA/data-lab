import java.util.Scanner;
public class MyProgram
{
    static String filename= "2.12_Health_systems.csv";
    public static void main(String[] args)
    {
        Health worldbank= new Health(filename);
        //asks user whether he/she wants information regarding a certain country's medical expenditure infomation
        //or if they want to see which countries has the highest medical expenditure in terms of per Capita/%GDP (type 'all')
        Scanner input = new Scanner(System.in);
        System.out.println("Type in the country you are interested in to see their medical expenditures in terms of % GDP and per capita (type 'all' to compare all countries in the list): ");
        String country= input.nextLine();
        //if the user types all, the program compares all WorldBank objects in the arraylist in Health.java and finds the WorldBank object
        //with the highest medical expenditures in terms of % GDP and per capita.
        if(country.equals("all")){
            worldbank.lowestPercentGDP();
            worldbank.lowestPerCapita();
        }else{
        //otherwise, the program runs these methods to see if there is a WorldBank object with the specified name and returns its value.
            worldbank.findPercentGDP(country);
            worldbank.findPerCapita(country);
        }
    }
}
