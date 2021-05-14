public class WorldBank {
    private String country;
    private String name;
    private double percentGDP;
    private double perCapita;
    
    //WorldBank constructor with parameters country, name, percent GDP of medical expenditure, and per capita medical expenditures 
    public WorldBank(String country, String name, double percentGDP, double perCapita){
        this.name=name;
        this.country=country;
        this.percentGDP=percentGDP;
        this.perCapita=perCapita;
    }
    //getter methods returns the value of each parameter/instance variable
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    
    public double getPercentGDP(){
        return percentGDP;
    }
    
    public double getperCapita(){
        return perCapita;
    }
}
