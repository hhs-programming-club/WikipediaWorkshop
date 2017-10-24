

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.security.auth.login.LoginException;

import org.wikipedia.Wiki;

public class WikipediaExample {

	public static void main(String[] args) throws LoginException {
		Wiki wiki = new Wiki("en.wikipedia.org");
		try {
			wiki.login("alistairgray42", "ProClub");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			String initial = "Stack Overflow"; //Starting article
			String end = "World War II"; //Ending article
			ArrayList<String> str = new ArrayList<String>(Arrays.asList(wiki.getLinksOnPage(initial))); //Initial ArrayList of articles
			
			for(int i = 0; i < str.size(); i++) { //Removes all non-articles
				if(str.get(i).contains(":")) {
					str.remove(i);
					i--;
				}
			}
			
			boolean gate = true;
			String currentArticle = initial;
			int currentIndex = 0;
			
			while(gate) {
				ArrayList<String> currentArticleStrings = new ArrayList<String>(Arrays.asList(wiki.getLinksOnPage(currentArticle))); //Creates ArrayList of wikipedia internal links on the page
				for(int i = 0; i < currentArticleStrings.size(); i++) { //Removes all non-articles
					if(currentArticleStrings.get(i).contains(":")) {
						currentArticleStrings.remove(i);
						i--;
					}
				}
				
				int rand = (int)(Math.random() * (currentArticleStrings.size()-1)); //Picks out a random article link
				
				if(!(wiki.getLinksOnPage(currentArticleStrings.get(rand)).length == 0)) { //Ensures there are actual links in the article
					currentArticle = currentArticleStrings.get(rand);
					currentIndex++;
				}
				
				System.out.println("Current Article - "+ currentArticle + "\nCurrent Index - " + currentIndex);
				
				if(currentArticle.equals(end)) { //Checks if we've reached the destination
					gate = false;
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}