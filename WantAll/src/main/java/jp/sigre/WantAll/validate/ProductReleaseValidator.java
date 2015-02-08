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
public class ProductReleaseValidator extends InputVerifier {

	/* (非 Javadoc)
	 * @see javax.swing.InputVerifier#verify(javax.swing.JComponent)
	 */
    @Override
    public boolean verify(JComponent input) {
    	boolean result = false;
        String text = ((JTextField) input).getText();
        if (text.length() != 8) {
        	result = false;
        } else {
	        try {
	            int value = Integer.parseInt(text);
	            result = true;
	        } catch (NumberFormatException e) {
	            result = false;
	        }
        }

        return result;
    }

}
