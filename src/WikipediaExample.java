

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

//import fastily.jwiki.core.Wiki;
import org.wikipedia.*;

public class WikipediaExample {

	public static void main(String[] args) throws LoginException {
		Wiki wiki = new Wiki("en.wikipedia.org");
		try {
			wiki.login("alistairgray42", "ProClub");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String[] str = wiki.getLinksOnPage("Stack Overflow");
			System.out.println(str.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}