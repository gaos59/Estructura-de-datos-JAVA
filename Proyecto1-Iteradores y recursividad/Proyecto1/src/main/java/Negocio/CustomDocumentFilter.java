/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Gorte
 */

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CustomDocumentFilter extends DocumentFilter {

    private final TextValidator validator;

    public CustomDocumentFilter(TextValidator validator) {
        this.validator = validator;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, string);
        
        if (validator.isValid(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text);
        
        if (validator.isValid(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.delete(offset, offset + length);
        
        if (validator.isValid(sb.toString())) {
            super.remove(fb, offset, length);
        }
    }
}