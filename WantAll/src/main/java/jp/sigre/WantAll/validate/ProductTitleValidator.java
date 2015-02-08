/**
 *
 */
package jp.sigre.WantAll.validate;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * @author sigre
 *
 */
public class ProductTitleValidator extends InputVerifier {

	/* (非 Javadoc)
	 * @see javax.swing.InputVerifier#verify(javax.swing.JComponent)
	 */
    @Override
    public boolean verify(JComponent input) {
    	boolean result = false;
        String text = ((JTextField) input).getText();
        if (text.length() >= 0) {
        	result = true;
        }

        return result;
    }

}
