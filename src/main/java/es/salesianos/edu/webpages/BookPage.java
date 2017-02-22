package es.salesianos.edu.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DatetimePicker;
import es.salesianos.edu.model.Author;
import es.salesianos.edu.model.Book;

public class BookPage extends WebPage {
	public void BookPage (){
		Form form = new Form("formInsertBook", new CompoundPropertyModel(new Book()));
		form.add(new Label("tittleBookLabel", getString("book.tittle")));
		form.add(new Label("isbnBookLabel", getString("book.isbn")));
		form.add(new Label("IdAuthorBookLabel", getString("book.IdAuthor")));
		form.add(new RequiredTextField("book.tittle"));
		form.add(new RequiredTextField("book.isbn"));
		form.add(new RequiredTextField("book.IdAuthor"));
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
		
		add(form);
	}

}
