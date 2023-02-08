package AssistantPrograms;

import java.util.Scanner;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan Nelson
 */
public class GameRun {

	static HashMap<String, Character> Characters;

	public static void main(String[] args) {

		Characters = new HashMap<String, Character>();
		Scanner sIn = new Scanner(System.in);
		boolean infinite = false;

		System.out.println("Welcome to Primordium!\n");

		do {

			System.out.println("Main Menu\n--------------------\n");
			System.out.println("1. Character Menu");
			System.out.println("2. Combat");

			System.out.println("\nPlease enter a command");
			String choice = sIn.nextLine();

			switch (choice) {
			case "1":
				userPromptCharacterMenu();
				break;

			case "2":
				userPromptCombat();
				break;

			}

		} while (!infinite);

	}

	private static void userPromptCharacterCreation() {

		Scanner sIn = new Scanner(System.in);

		String cName = "";
		String choice = "";
		int Strength;
		int Agility;
		int Attack;
		int MaxHealth;

		System.out.println("Please enter the character's Name.");
		cName = sIn.nextLine();
		System.out.println("Please enter the character's Strength.");
		choice = sIn.nextLine();
		Strength = Integer.parseInt(choice);
		System.out.println("Please enter the character's Agility.");
		choice = sIn.nextLine();
		Agility = Integer.parseInt(choice);
		System.out.println("Please enter the character's Attack.");
		choice = sIn.nextLine();
		Attack = Integer.parseInt(choice);
		System.out.println("Please enter the character's Max Health.");
		choice = sIn.nextLine();
		MaxHealth = Integer.parseInt(choice);

		Character newCharacter = new Character(cName, Strength, Agility, Attack, MaxHealth);
		Characters.put(cName, newCharacter);

	}

	private static void userPromptCharacterMenu() {

		Scanner sIn = new Scanner(System.in);
		boolean infinite = false;

		do {
			System.out.println("Character Menu\n--------------------\n");

			System.out.println("1. Character Creation");
			System.out.println("2. Character Editor");

			System.out.println("\nPlease enter a command or press 'enter' to go back");
			String choice = sIn.nextLine();

			switch (choice) {
			case "1":
				userPromptCharacterCreation();
				break;

			case "2":
				userPromptCharacterEditor();
				break;

			case "":
				infinite = true;
				break;

			}

		} while (!infinite);

	}

	private static void userPromptCharacterEditor() {

		Scanner sIn = new Scanner(System.in);
		String cName = "";
		String choice = "";
		int input;
		boolean infinite = false;
		boolean valid;

		do {

			valid = false;
			System.out.println("Which Character do you want to edit?");
			choice = sIn.nextLine();
			if (Characters.containsKey(choice)) {
				cName = Characters.get(choice).getName();
				valid = true;
			} else {
				System.out.println("Character: " + choice + " is not a valid choice. Please enter a valid character.");

			}
		} while (!valid);

		System.out.println("Character: " + Characters.get(choice).getName());

		System.out.println("Current Health: " + Characters.get(choice).getHealthCurrent() + "/"
				+ Characters.get(choice).getHealthMax());
		System.out.println("Strength: " + Characters.get(choice).getStrength());
		System.out.println("Agility: " + Characters.get(choice).getAgility());
		System.out.println("Attack: " + Characters.get(choice).getAttack());

		do {
			System.out.println("\nEditing Menu\n--------------------\n");
			System.out.println("1: Edit Max Health");
			System.out.println("2: Edit Current Health");
			System.out.println("3: Edit Strength");
			System.out.println("4: Edit Agility");
			System.out.println("5: Edit Attack\n");

			System.out.println("What aspect would you like to edit? (press enter when done)");
			choice = sIn.nextLine();

			switch (choice) {
			case "1":
				System.out.println("What would you like to change " + cName + "'s max health to?");
				choice = sIn.nextLine();
				input = Integer.parseInt(choice);
				Characters.get(cName).setHealthMax(input);
				System.out.println(cName + "'s new max health is " + input);
				break;

			case "2":
				System.out.println("What would you like to change " + cName + "'s current health to?");
				choice = sIn.nextLine();
				input = Integer.parseInt(choice);
				Characters.get(cName).setHealthCurrent(input);
				System.out.println(cName + "'s new current health is " + input);
				break;

			case "3":
				System.out.println("What would you like to change " + cName + "'s current strength to?");
				choice = sIn.nextLine();
				input = Integer.parseInt(choice);
				Characters.get(cName).setStrength(input);
				System.out.println(cName + "'s new current strength is " + input);
				break;

			case "4":
				System.out.println("What would you like to change " + cName + "'s current agility to?");
				choice = sIn.nextLine();
				input = Integer.parseInt(choice);
				Characters.get(cName).setAgility(input);
				System.out.println(cName + "'s new current agility is " + input);
				break;

			case "5":
				System.out.println("What would you like to change " + cName + "'s current attack to?");
				choice = sIn.nextLine();
				input = Integer.parseInt(choice);
				Characters.get(cName).setStrength(input);
				System.out.println(cName + "'s new current attack is " + input);
				break;

			case "":
				infinite = true;
				break;

			}

		} while (!infinite);
	}

	private static void userPromptCombat() {

		Scanner sIn = new Scanner(System.in);
		String cName = "";
		String choice = "";
		//int input;
		int damage;
		boolean infinite = true;
		//boolean valid;

		do {
		
			System.out.println("\nWhich Character is in combat? (Press enter if done)");
			choice = sIn.nextLine();

			if (Characters.containsKey(choice)) {
				cName = Characters.get(choice).getName();

				System.out.println("Character: " + Characters.get(choice).getName() + "\n");
				damage = userPromptAttackCalculator(choice);
				System.out.println("Character: " + Characters.get(choice).getName() + " did " + damage + " damage.");
			} else if (choice.equals("")) {
				infinite = false;
			} else {
				System.out.println("Character: " + choice + " is not a valid choice. Please enter a valid character.\n");
			}

		} while (infinite);
	}

	private static int userPromptAttackCalculator(String choice) {
		Scanner sIn = new Scanner(System.in);
		//boolean infinite = true;
		boolean valid = false;
		boolean rolling = true;
		double multiplier = 1 + ((double) Characters.get(choice).getAttack() / 10);
		int armor = 0;
		int roll = 0;
		int damage = 0;
		String input;

		do {
			System.out.println("Is the character using Strength or Agility? (S or A)");
			input = sIn.nextLine();
			if (input.equalsIgnoreCase("a")) {
				valid = true;
				multiplier += ((double) Characters.get(choice).getAgility() / 10);
			} else if (input.equalsIgnoreCase("s")) {
				valid = true;
				multiplier += ((double) Characters.get(choice).getStrength() / 10);
			} else {
				System.out.println("Invalid Response. Please enter A for agility or S for Strength");
			}
		} while (!valid);

		System.out.println("\nWhat is the targets non-negated armor?");
		armor = Integer.parseInt(sIn.nextLine());
		do {
			System.out.println("\nWhat was the player's roll? (press enter if done)");
			input = sIn.nextLine();
			if (input.equals("")) {
				rolling = false;
			} else {
				roll = Integer.parseInt(input);
				if (roll * multiplier > armor) {
					damage += (int) (roll * multiplier) - armor;
				}

			}
		} while (rolling);

		return damage;

	}

}
