package AssistantPrograms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matth
 */
public class Character {
    //Attributes
    private String cName;
    private int Strength;
    private int Agility;
    private int Attack;
    private int HealthMax;
    private int HealthCurrent;
   
    
    
    //Constructor
    
    public Character() {
        this.cName = "name";
        this.Strength = 0;
        this.Agility = 0;
        this.Attack = 0;
        this.HealthMax = 0;
        this.HealthCurrent = HealthMax;
        
    }
    
    public Character(String cName, int Strength, int Agility, int Attack, int HealthMax) {
        this.cName = cName;
        this.Strength = Strength;
        this.Agility = Agility;
        this.Attack = Attack;
        this.HealthMax = HealthMax;
        this.HealthCurrent = HealthMax;
        
    }
    
    //Getters
    
    public String getName(){
        
        return this.cName;
        
    }
    
    public int getStrength(){
        
        return this.Strength;
    }
    
    public int getAgility(){
        
        return this.Agility;
    }
    
    public int getAttack(){
        
        return this.Attack;
    }
    
    public int getHealthMax() {
        
        return this.HealthMax;
    }
    
    public int getHealthCurrent() {
        
        return this.HealthCurrent;
    }
    
    //Setters
    
    public void setName(String n){
    
    this.cName = n;
}
    
    public void setStrength(int s){
        
        this.Strength = s;
    }
    
    public void setAgility(int a){
        
        this.Agility = a;
    }
    
    public void setAttack(int at){
        
        this.Attack = at;
    }
    
    public void setHealthMax(int hm) {
        
        this.HealthMax = hm;
    }
    
    public void setHealthCurrent(int hc) {
        
        this.HealthCurrent = hc;       
    }
}
