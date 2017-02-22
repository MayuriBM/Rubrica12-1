package es.salesianos.edu.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {
	
	public HomePage(){
		
		BookmarkablePageLink bookmarkablePageLink1 = new BookmarkablePageLink("linkAuthorForm", AuthorPage.class);
		BookmarkablePageLink bookmarkablePageLink2 = new BookmarkablePageLink("linkListAuthor",
				ListAuthorPage.class);
		add(bookmarkablePageLink1);
		add(bookmarkablePageLink2);
	}
}
