package es.salesianos.edu.webpages;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.salesianos.edu.model.Author;
import es.salesianos.edu.model.Book;
import es.salesianos.edu.service.BookService;

public class ListBookPage  extends WebPage  {
	private static final long serialVersionUID = -1935854748907274886L;

	@SpringBean
	BookService service;

	private static final Logger logger = LogManager.getLogger(ListBookPage.class.getName());

	private String currentNameSearch = null;

	private List listBook = Collections.emptyList();

	public ListBookPage(PageParameters parameters) {
		currentNameSearch = parameters.get("currentSearchTerm").toString();
		logger.debug("Cargando la pagina con el parametro " + currentNameSearch);
		initComponents();
	}

	public ListBookPage() {
		initComponents();
	}

	private void initComponents() {
		addForm();
		addFeedBackPanel();
		addListBookView();
	}

	private void addForm() {
		Form form = new Form("formListBook", new CompoundPropertyModel(new Book())) {
			
		};
		Button okButton = new Button("okbutton") {
			public void onSubmit() {
				listBook.clear();
				info("OK was pressed!");
				Book book1 = new Book();
				book1.setTittle("tittle");
				book1.setIsbn("isbn");
				book1.setAuthor("author");
				
				listBook.add(book1);
				
			}
		};
		Button cancelButton = new Button("cancelbutton") {
			public void onSubmit() {
				listBook.clear();
				info("cancel was pressed!");
				Book book1 = new Book();
				book1.setTittle("tittle");
				book1.setIsbn("isbn");
				book1.setAuthor("author");
				
				listBook.add(book1);
			
			}
		};
		form.add(okButton);
		form.add(cancelButton);

		form.add(new TextField("tittle"));
		add(form);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addListBookView() {
		Book book = new Book();// service.newEntity()
		book.setTittle(currentNameSearch);
		listBook = service.BookService(book);
		ListView listview = new ListView("book-group", listBook) {
			@Override
			protected void populateItem(ListItem item) {
				Book book = (Book) item.getModelObject();
				item.add(new Label("tittle", book.getTittle()));
				item.add(new Label("isbn", book.getIsbn()));
				item.add(new Label("author",book.getAuthor()));
			}
		};
		add(listview);
	}

}
