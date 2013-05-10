/*
 * Copyright 2013 Kay Stenschke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kstenschke.dummytext.dictionaries;

public class DictionaryCookery extends Dictionary {

	/**
	 * Constructor
	 */
	public DictionaryCookery() {

	}

	/**
	 * @param   amountWords
	 * @param   amountSentences
	 * @return  One line of random text, consisting from the given amount of words and sentences
	 */
	public String getRandomLine(Integer amountWords, Integer amountSentences) {
		String sentence   = "";

		for(Integer i =0; i< amountSentences; i++) {
			sentence = sentence.concat( (i > 0 ? " " : "") + getSentenceStructure(amountWords) );
		}

		while( sentence.matches(".*[0-9].*") ) {
			while(sentence.contains("1")) sentence = sentence.replaceFirst("1", getIngredient() );
			while(sentence.contains("2")) sentence = sentence.replaceFirst("2", getFluid() );
			while(sentence.contains("3")) sentence = sentence.replaceFirst("3", getVerbTransitive() );
			while(sentence.contains("4")) sentence = sentence.replaceFirst("4", getVerbIntransitive() );
			while(sentence.contains("5")) sentence = sentence.replaceFirst("5", getAdjective() );
			while(sentence.contains("6")) sentence = sentence.replaceFirst("6", getAdverb() );
			while(sentence.contains("7")) sentence = sentence.replaceFirst("7", getSeasonings() );
			while(sentence.contains("8")) sentence = sentence.replaceFirst("8", getContainer() );
			while(sentence.contains("9")) sentence = sentence.replaceFirst("9", getAmount() );
		}

		sentence = fixIndefiniteArticles(sentence);

		sentence = sentence.replaceAll("berriess",      "berries");
		sentence = sentence.replaceAll("choping",       "chopping");
		sentence = sentence.replaceAll("eggss",         "eggs");
		sentence = sentence.replaceAll("meatballss",    "meatballs");
		sentence = sentence.replaceAll("nachoss",       "nachos");
		sentence = sentence.replaceAll("peanutss",      "peanuts");
		sentence = sentence.replaceAll("s tastes ",      "s taste ");
		sentence = sentence.replaceAll("seedss",        "seeds");
		sentence = sentence.replaceAll("shreding",      "shredding");
		sentence = sentence.replaceAll("shrimpss",      "shrimps");
		sentence = sentence.replaceAll("sliceing",      "slicing");
		sentence = sentence.replaceAll("spinachs",      "spinach");
		sentence = sentence.replaceAll("breatss",       "breasts");


		return ucfirst(sentence);
	}

	/**
	 * @param   amountWords
	 * @return  Random sentence structure with numbers as word type placeholders
	 */
	private static String getSentenceStructure(Integer amountWords) {
		if( amountWords != null && amountWords == 1 ) {
			String[] structures  = {"1", "2", "8"};
			return pickRandomString(structures);
		}

		String[] structures  = {
			"1 tastes best with 2 and lots of 7.",
			"3 each side of the 1 with 9 of 1.",
			"4 1 6, then mix with 2 and serve 6 in 8.",
			"To the 5 1 add 1, 1, 2 and 5 1.",
			"before 4ing 1s, 3 1, 1 and 2 in a 8.",
		   "3 9 of 1 in 9 of 2.",
		   "5, 5 pudding is best 3ed with 5 2.",
		   "per guest prepare 9 of 2 with 4ed 1 for dessert."
		};

		return pickRandomString(structures, amountWords);
	}

	/**
	 * @return  Word of group 1: ingredients
	 */
	private static String getIngredient() {
		String[] words ={
			"blueberries", "butter", "carrots", "celery", "chicken", "chicken breasts", "chili", "chocolate", "cracker crumps",
			"eggs", "garlic", "ginger", "ground beef", "herring", "leek", "lettuce", "meatballs", "meatloaf", "nachos", "noodles", "onion", "peanut butter", "peanuts",
			"pork butt", "pork shoulder", "pumpkin seeds", "ramen", "raspberries", "rhubarb", "rice", "shrimps", "spinach",
			"steak", "strawberries", "tofu", "turkey", "white bread"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 2:  fluid
	 */
	private static String getFluid() {
		String[] words ={
			"BBQ sauce", "bourbon", "adobo sauce", "beer", "emeril\'s essence", "fish sauce", "gold tequila", "honey",
			"joghurt", "ketchup",
			"lemon juice", "milk", "olive oil", "orange juice", "oyster sauce", "peanut sauce", "plain vinegar", "red wine",
			"rice vinegar", "rum",
			"salsa verde", "soy sauce", "tabasco", "triple sec", "vinegar", "water", "white wine"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 3:  transitive verb
	 */
	private static String getVerbTransitive() {
		String[] words = {
			"cover", "garnish", "mix", "season"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 4:  intransitive verb
	 */
	private static String getVerbIntransitive() {
		String[] words = {
			"break", "chop", "cook", "crush", "cut", "grill", "heat", "roast", "shred", "slice", "smash"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 5:  adjective
	 */
	private static String getAdjective() {
		String[] words = {
			"chopped", "cold", "crushed", "delicious", "divided", "dried", "fresh", "heated", "heated", "hot", "juicy",
			"large", "large", "mild", "minced", "old", "packaged", "ripe", "roasted", "salted", "salty", "sliced", "small",
			"smashed", "smooth", "sour", "springy", "squeezed", "sun-dried", "sweet", "tasty", "warm"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 6:  adverb
	 */
	private static String getAdverb() {
		String[] words = {
			"carefully", "fast", "freshly", "smoothly"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 7:  interjection
	 */
	private static String getSeasonings() {
		String[] words ={
			"flower", "sugar", "black pepper", "cumin", "curry", "cinamon", "basil leafs", "black cardamon",
			"mustard", "celery", "dill", "garlic", "chocolate", "marmalade", "parsley", "pepper", "vodka", "jasmine", "lime",
		   "green curry", "rosemary", "szechuan pepper", "wasabi", "woodruff", "za\'atar"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 8: abstract place (usable w/o article: "going to 8")
	 */
	private static String getContainer() {
		String[] words ={
			"bowl", "cooker", "grinder", "ice blender", "pan", "saucepan", "wok"
		};

		return pickRandomString(words);
	}

	/**
	 * @return  Word of group 9: ingredients
	 */
	private static String getAmount() {
		String[] words ={
			"five peaces", "four pounds", "four teaspoons", "half a kilo", "one container", "one cup", "one jar", "one package",
			"one quarter cup", "one whole", "two oz", "two pounds", "two tablespoons"
		};

		return pickRandomString(words);
	}

}