/**
 * 
 */
package net.sf.cotelab.app.dupfilefinder.gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @author TEST
 *
 */
public class OKBrowserDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public OKBrowserDialog() {
		finishConstruction();
	}
	
	protected void finishConstruction() {
		// TODO set up the button and browser
		OKBrowserDialog thisDialog = this;
		JButton button = new JButton("OK");
        final JFXPanel fxPanel = new JFXPanel();
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thisDialog.dispose();
			}
		});
		
		add(button, BorderLayout.SOUTH);
		add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
        
        SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
	        	thisDialog.pack();
			}
        });
	}
	
	protected String url = null;

	protected void initFX(JFXPanel fxPanel) {
        // This method is invoked on JavaFX thread
        Scene scene = createScene();
        
        fxPanel.setScene(scene);
    }
	
	protected WebView myview = null;

	protected Scene createScene() {
		
		
    	//webview object creation
    	//web engine object creation
    	myview = new WebView();
    	// setting min height
    	myview.minHeight(1050);
    	// setting preferred width
    	myview.prefWidth(1950);
    	// setting pref height
    	myview.prefHeight(1070);
    	//setting min width
    	myview.minWidth(1050);
    	final WebEngine mywebEngine = myview.getEngine();
    	
    	if (url != null) {
    		mywebEngine.load(url);
    	}
    	
    	VBox mybox = new VBox(myview);
		 
		 
		Scene myscene = new Scene(mybox, 500, 500);
		
		return myscene;
	}

	/**
	 * @param owner
	 */
	public OKBrowserDialog(Frame owner) {
		super(owner);

		finishConstruction();
	}

	/**
	 * @param owner
	 */
	public OKBrowserDialog(Dialog owner) {
		super(owner);

		finishConstruction();
	}

	/**
	 * @param owner
	 */
	public OKBrowserDialog(Window owner) {
		super(owner);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param modal
	 */
	public OKBrowserDialog(Frame owner, boolean modal) {
		super(owner, modal);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 */
	public OKBrowserDialog(Frame owner, String title) {
		super(owner, title);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param modal
	 */
	public OKBrowserDialog(Dialog owner, boolean modal) {
		super(owner, modal);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 */
	public OKBrowserDialog(Dialog owner, String title) {
		super(owner, title);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param modalityType
	 */
	public OKBrowserDialog(Window owner, ModalityType modalityType) {
		super(owner, modalityType);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 */
	public OKBrowserDialog(Window owner, String title) {
		super(owner, title);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 */
	public OKBrowserDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 */
	public OKBrowserDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modalityType
	 */
	public OKBrowserDialog(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @param gc
	 */
	public OKBrowserDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @param gc
	 */
	public OKBrowserDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);

		finishConstruction();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modalityType
	 * @param gc
	 */
	public OKBrowserDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);

		finishConstruction();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		
//		System.out.println("Loading URL \"" + url + "\"");
//		
//		if (myview == null) {
//			System.out.println("OOPS! nyview is null.");
//		}
		
		if ((myview != null) && (url != null)) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					myview.getEngine().load(url);
				}
				
			});
		}
	}

}
